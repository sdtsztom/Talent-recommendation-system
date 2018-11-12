<%--
  Created by IntelliJ IDEA.
  User: 10442
  Date: 2018/10/29
  Time: 10:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ page import="util.CommonConnection" %>
<%@ page import="java.sql.ResultSet" %>
<%@ page import="util.ConnectUser" %>
<%

    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
<head>
    <base href="<%=basePath%>">
    <title>正在验证</title>
</head>
<body>
    <%
        String name = request.getParameter("log_name");
        String passwd = request.getParameter("log_passwd");

        CommonConnection.setConnectUser(ConnectUser.DEV);
        ResultSet rs = CommonConnection.makeQuery("select * from stuff where stf_username = '" + name + "'");
        rs.next();
        String Tpasswd = rs.getString("stf_pwd");

        if(passwd != Tpasswd){
            response.sendRedirect("./index.jsp");
        }

        int job_id = rs.getInt("stf_job_id");
        int stf_id = rs.getInt("stf_id");

        switch (job_id){
            case 0: {
                response.sendRedirect("./Admin_function");
            }
            case 1: {
                session.setAttribute("stf_id",stf_id);
                response.sendRedirect("./HR_function");
            }
            case 2: {
                session.setAttribute("stf_id",stf_id);
                response.sendRedirect("./Stuff_function");
            }
        }

//        try{
//            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
//        }catch (Exception e){
//            e.printStackTrace();
//        }
//
//        try{
//            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:1433/tal_rec_sys",name,passwd);
//            Statement stat = conn.createStatement();
//            ResultSet rs = stat.executeQuery("select role_id from stuff");
//
//        }catch (SQLException e){
//            e.printStackTrace();
//        }


    %>
</body>
</html>
