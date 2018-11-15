package filter;

import bean.LoginUser;
import util.CommonConnection;
import ienum.*;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/*
 * TO-DO:
 *  1. 应该还要对权限授予表中的项目做出反应
 */

@WebFilter(filterName = "SingleRecManagementFilter")
public class SingleRecManagementFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) resp;
        //验证登录身份,并且其身份必须为HR
        HttpSession session=request.getSession();
        LoginUser user=(LoginUser) session.getAttribute("user");
        if(user==null||user.getJob_type()!=JobType.HR.toString()){
            response.sendRedirect(eErrorPage.PERMISSIONDENY.toString());
            return;
        }
        String rrid=request.getParameter("rrid");
        CommonConnection.setConnectUser(ConnectUser.SYS);
        String []result_set=CommonConnection.singleLineQuery("select rr_hr_id,rr_st,id from recruitment_requirements where rr_id="+
                rrid+"'",2);
        //判断是否有此rrid
        if(result_set==null){
            response.sendRedirect(eErrorPage.NOCORRESPONDINGRECORD.toString());
            return;
        }
        String hrid=result_set[0];
        String stage_id=result_set[1];
        // 判断此需求id是否由此HR提出
        String hrid_of_requester=""+user.getId();
        if(!hrid.equals(hrid_of_requester)){
            response.sendRedirect(eErrorPage.PERMISSIONDENY.toString());
            return;
        }
        //判断请求的页面是否符合当前阶段，否则不予访问
        String stage= CommonConnection.singleResultQuery("select rec_sta_desc from recommend_stage where rec_sta_id="
                +"(select rr_sta_id from recruitment_requirements where rr_id='"+rrid+"'");
        RrStage enum_stage=RrStage.fromStr(stage);
        String url=request.getRequestURI();
        Single_Rec_Management_Page corr_page=Single_Rec_Management_Page.convert(enum_stage);
        if(corr_page==null||!url.endsWith(corr_page.toString())){
            response.sendRedirect(eErrorPage.NOTMATCHEDSTAGE.toString());
            return;
        }
        else chain.doFilter(req, resp);
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
