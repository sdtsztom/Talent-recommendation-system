package servlet;

import util.CommonConnection;
import ienum.ConnectUser;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/*
 * Notice:
 *  1. be sure the type passed in is genenrated by enum class UtilServerFunctionType
 */

@WebServlet(name = "util_server")
public class util_server extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String type=request.getParameter("type");
        if(type.equals("check_dup_username")){
            String username=request.getParameter("username");
            boolean exist=CommonConnection.existQuery("select stf_id from stuff where stf_username='"+username+"'",ConnectUser.SYS);
            if(exist)response.setStatus(200);   //返回200OK意味着数据库中存在这样的数据
            else response.setStatus(404);   //返回404意味着数据库中不存在这样的数据
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
