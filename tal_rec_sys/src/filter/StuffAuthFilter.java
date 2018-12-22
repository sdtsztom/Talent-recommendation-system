/**
 * @Created: xsy
 * @Data: 2018.11.20
 * @description: 判断是否有Stuff及以上权限 若为否则返回之前页面
 * */
package filter;

import bean.LoginUser;
import ienum.JobType;
import ienum.eErrorPage;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class StuffAuthFilter implements Filter{
    public void init(FilterConfig config) throws ServletException {

    }

    public void  doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws java.io.IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) res;
        //request.getSession().setAttribute("user",new LoginUser("u","p","1","admin")); //test
        LoginUser stf = (LoginUser) request.getSession().getAttribute("user");
        if(stf==null){
            response.sendRedirect("/Login/login.html");
            return;
        }

        // 不允许权限低于Stuff的人访问
        if(stf.getJob_type()!= JobType.STUFF&&stf.getJob_type()!=JobType.HR&&stf.getJob_type()!=JobType.ADMIN) {
            response.sendRedirect(eErrorPage.PERMISSIONDENY.toString());
            return;
        }
        chain.doFilter(request,response);
    }

    public void destroy()  {

    }

}
