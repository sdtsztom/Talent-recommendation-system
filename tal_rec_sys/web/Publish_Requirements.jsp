<%@ page import="bean.LoginUser" %>
<%@ page import="ienum.eErrorPage" %>
<%@ page import="util.CommonConnection" %>
<%@ page import="ienum.ConnectUser" %>
<%@ page import="java.sql.ResultSet" %>
<%--
  Created by IntelliJ IDEA.
  User: 10442
  Date: 2018/11/5
  Time: 15:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

<head>
    <title>岗位信息选择</title>
    <style>
        @import "css/table.css";
    </style>
</head>
<body>
<table class="bordered">
    <tr>
        <td>职位名称</td>
        <td>职能名称</td>
        <td>工资</td>
        <td>部门名称</td>
        <td>点此创建</td>
    </tr>
<%
    LoginUser user=(LoginUser)session.getAttribute("user");
    if(!user.getJob_type().toString().equals("人事人员")){
        response.sendRedirect(eErrorPage.PERMISSIONDENY.toString());
        return;
    }

    CommonConnection.setConnectUser(ConnectUser.HR);
    ResultSet rs = CommonConnection.makeQuery("select * from requirement_info_view");
    while(rs.next()){
%>
    <tr>
        <td><%=rs.getString("jb_name")%></td>
        <td><%=rs.getString("jt_name")%></td>
        <td><%=rs.getString("jb_sal")%></td>
        <td><%=rs.getString("dp_name")%></td>
        <td><a onclick="window.location.href = 'Publish_Details.jsp?ri_id=<%=rs.getString("ri_id")%>'">选择此条信息</a></td>
    </tr>
<%
    }
    CommonConnection.closeConnection();
%>
</body>
</html>
