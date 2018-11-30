<%@ page import="bean.LoginUser" %>
<%@ page import="javax.mail.Session" %>
<%@ page import="ienum.eErrorPage" %><%--
  Created by IntelliJ IDEA.
  User: 10442
  Date: 2018/10/20
  Time: 10:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>功能选择</title>
    <%
        LoginUser user=(LoginUser)session.getAttribute("user");
        if(user==null){
            response.sendRedirect(eErrorPage.PERMISSIONDENY.toString());
            return;
        }
    %>
</head>
<body>
    <div>
        <a href="Query_Recruit.jsp">查询所有需求</a><br/>
        <a href="" >权限管理</a><br/>
        <a href="" >查看所有推荐人</a>
    </div>
</body>
</html>
