package filter;

import bean.ConfirmUser;
import util.CommonConnection;
import ienum.ConnectUser;
import util.MD5;
import ienum.RecStage;
import ienum.eErrorPage;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/*
 * TO-DO
 *  1. 允许HR结束需求，届时所有还在等待确认入职状态的推荐都会被关闭
 */


@WebFilter(filterName = "ConfirmOfferFilter")
public class ConfirmOfferFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) resp;
        String id=request.getParameter("u");
        String info_md5=request.getParameter("v");
        String []res=CommonConnection.singleLineQuery("select rp_name,rp_sex,rp_tel_num,rp_vali from recommend_people where rp_id="+id,2,ConnectUser.SYS);
        //验证是否存在此人
        if(res==null){
            response.sendRedirect(eErrorPage.NOCORRESPONDINGRECORD.toString());
            return;
        }
        // 验证被推荐人是否有效
        if(res[3].equals("否")){
            response.sendRedirect(eErrorPage.RECOMMENDEDPERSONNOTVALID.toString());
            return;
        }
        // 验证验证信息的正确性
        String tel_num=res[2];
        String tel_num_md5= MD5.encrypt(tel_num);
        if(!info_md5.equals(tel_num_md5)){
            response.sendRedirect(eErrorPage.PERMISSIONDENY.toString());
            return;
        }
        // 验证是否有其对应推荐是否是等待入职状态(可能由于时间过期等原因，将推荐关闭)
        boolean exist=CommonConnection.existQuery("select rec_id where rec_rp_id='"+id+"' and rec_recsta_id="+ RecStage.W_OC.toId(),ConnectUser.SYS);
        if(!exist){
            response.sendRedirect(eErrorPage.PERMISSIONDENY.toString());
            return;
        }
        // put session
        String name=res[0];
        String sex=res[1]=="男"?"先生":"女士";
        HttpSession session=request.getSession();
        ConfirmUser user=new ConfirmUser(id,name,sex);
        session.setAttribute("confirm_user",user);
        chain.doFilter(req, resp);
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
