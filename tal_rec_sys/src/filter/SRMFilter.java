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
 * TODO:
 *  1. 应该还要对权限授予表中的项目做出反应
 */

@WebFilter(filterName = "SRMFilter")
public class SRMFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) resp;

        HttpSession session=request.getSession();
        LoginUser user=(LoginUser) session.getAttribute("user");

        //判断是否有此rrid
        String rrid=request.getParameter("rrid");
        String []result_set=CommonConnection.singleLineQuery("select rr_hr_id,rr_sta_id from recruitment_requirements where rr_id="+
                rrid,2,ConnectUser.SYS);
        if(result_set==null){
            response.sendRedirect(eErrorPage.NOCORRESPONDINGRECORD.toString());
            return;
        }

        // 判断此需求id是否由此HR提出
        String hrid=result_set[0];
        String stage_id=result_set[1];
        if(!hrid.equals(user.getId())){
            response.sendRedirect(eErrorPage.PERMISSIONDENY.toString());
            return;
        }

        //判断请求的页面是否符合当前阶段，否则不予访问
        RrStage stage=null;
        int stage_id_int=Integer.parseInt(stage_id);
        for(RrStage i:RrStage.values()){
            if(stage_id_int==i.toId())stage=i;
        }
        if(stage==null){
            response.sendRedirect(eErrorPage.NOTMATCHEDSTAGE.toString());
            return;
        }
        String url=request.getRequestURI(); //会略去参数
        SRM_Page corr_page= SRM_Page.convert(stage);
        if(corr_page==null||!url.equals(corr_page.toString())){
            response.sendRedirect(eErrorPage.NOTMATCHEDSTAGE.toString());
            return;
        }

        chain.doFilter(req, resp);
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
