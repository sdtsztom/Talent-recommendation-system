package servlet;

import bean.LoginUser;
import ienum.ConnectUser;
import util.CommonConnection;

import java.io.IOException;
import java.sql.ResultSet;

public class login_servlet extends javax.servlet.http.HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        String name = request.getParameter("log_name");
        String passwd = request.getParameter("log_passwd").replaceAll(" ","");

        try{
            CommonConnection.setConnectUser(ConnectUser.DEV);
            ResultSet rs = CommonConnection.makeQuery("select * from stuff where stf_username = '" + name + "'");
            if(rs.next()){
                String Tpasswd = rs.getString("stf_pwd");
                Tpasswd = Tpasswd.trim();
                if(!passwd.equals(Tpasswd)){
                    request.setAttribute("Login_message",-2);
                    response.sendRedirect("/Login/login.jsp");
                }else {
                    int stf_id = rs.getInt("stf_id");
                    String []values= CommonConnection.singleLineQuery("select stf_id,stf_username,stf_pwd from stuff where stf_username='"+ name+"'",4);
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

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {

    }
}
