<%@ page import="bean.LoginUser" %>
<%@ page import="util.CommonConnection" %>
<%--
  Created by IntelliJ IDEA.
  User: sdtsz
  Date: 2018/10/14
  Time: 11:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<style type="text/css">
    .divForm{
        position: absolute;/*绝对定位*/
        width: 300px;
        height: 200px;

        border: 1px solid red;
        text-align: center;/*(让div中的内容居中)*/
        top: 50%;
        left: 50%;
        margin-top: -200px;
        margin-left: -150px;
    }
</style>
<html>
<head>
    <title>$Title$</title>
</head>
    <%
        if(request.getAttribute("Log_message") == null){
        %>
<body>
<div id="login" class="divForm">
    <form id="login_form" method="post" action="/login_servlet">
        <br/><br/>
                    用户名<input type="text" name="log_name" id="log_name"><br/><br/>
                    密码&nbsp&nbsp&nbsp<input type="password" name="log_passwd" id="log_passwd"><br/><br/>
        <input type="submit" value="登陆"><input type="reset" value="清除">
    </form>
</div>
</body>
<%
        }else{
        int log_message = Integer.parseInt(request.getAttribute("Log_message").toString());
        %>
        message是：<%=log_message%>
        <%
        if(log_message > 0){
            String username = request.getAttribute("Login_name").toString();
        }
            int NO_USER = -1;
            int PASSWD_ERROR = -2;
            int ADMIN = 1;
            int HR = 2;
            int STUFF = 3;
        switch (log_message){
            case -1 :
                break;
            case -2:
                break;
            case 1:
                response.sendRedirect("Admin_function.jsp");
                break;
            case 2:
                response.sendRedirect("HR_function.jsp");
                break;
            case 3:
                response.sendRedirect("Stuff_function.jsp");
                break;
            }
        }
    %>
</html>