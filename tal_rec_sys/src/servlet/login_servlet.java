package servlet;

import bean.LoginUser;
import ienum.ConnectUser;
import ienum.JobType;
import util.CommonConnection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "login_servlet")
public class login_servlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String pwd = request.getParameter("pwd").replaceAll(" ", "");

        boolean right = CommonConnection.existQuery("select * from stuff where stf_username = '" + username + "' and stf_pwd='" + pwd + "'",ConnectUser.SYS);
        if (!right) {
            response.sendRedirect("/Login/login.html?error=true");
            return;
        }
        String user_id = CommonConnection.singleResultQuery("select stf_id from stuff where stf_username='" + username + "'",ConnectUser.SYS);
        String jt_name=CommonConnection.singleResultQuery("select stf_jt_name from stuff_job_type where stf_id="+user_id,ConnectUser.SYS);
        JobType jt_type=null;
        String redirect_path=null;

        for(JobType i:JobType.values()){
            if(jt_name.equals(i.toString())){
                jt_type=i;
                break;
            }
        }

        switch (jt_type){
            case HR:redirect_path="HR.html";break;
            case ADMIN:redirect_path="Admin.html";break;
            case STUFF:redirect_path="Stuff.html";break;
        }

        LoginUser user = new LoginUser(user_id,username, jt_type);
        request.getSession().setAttribute("user", user);
        response.sendRedirect(redirect_path);
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }
}
