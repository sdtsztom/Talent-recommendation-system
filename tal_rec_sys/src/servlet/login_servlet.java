package servlet;

import bean.LoginUser;
import ienum.ConnectUser;
import util.CommonConnection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.ResultSet;

@WebServlet(name = "login_servlet")
public class login_servlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String name = request.getParameter("log_name");
        String passwd = request.getParameter("log_passwd").replaceAll(" ","");

        try{
            CommonConnection.setConnectUser(ConnectUser.DEV);
            ResultSet rs = CommonConnection.makeQuery("select * from stuff where stf_username = '" + name + "'");
            if(rs.next()){
                String True_passwd = rs.getString("stf_pwd");
                True_passwd = True_passwd.trim();
                if(!passwd.equals(True_passwd)){
                    request.setAttribute("Login_message",-2);
                    response.sendRedirect("/Login/login.jsp");
                }else {
                    int stf_id = rs.getInt("stf_id");
                    String []values= CommonConnection.singleLineQuery("select stf_id,stf_username,stf_pwd from stuff where stf_username='"+ name+"'",3);
                    rs = CommonConnection.makeQuery("select * from stuff_job_type where stf_id = '" + stf_id + "'");
                    rs.next();
                    String jt_name = rs.getString("stf_jt_name").trim();
                    LoginUser user = new LoginUser(values[1],values[2],values[0],jt_name);
                    request.getSession().setAttribute("user",user);
                    if (jt_name.equals("开发人员")) {
                        response.sendRedirect("Admin_function.jsp");
                    } else if (jt_name.equals("人事人员")) {
                        response.sendRedirect("Stuff_function.jsp");
                    } else if (jt_name.equals("管理人员")) {
                        response.sendRedirect("HR_function.jsp");
                    }
                }
            }else{
                request.setAttribute("Login_message",-1);
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
