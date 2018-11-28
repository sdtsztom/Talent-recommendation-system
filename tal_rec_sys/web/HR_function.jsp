<%@ page import="bean.LoginUser" %>
<%@ page import="ienum.eErrorPage" %>
<%--
  Created by IntelliJ IDEA.
  User: 10442
  Date: 2018/10/29
  Time: 14:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>HR 功能页面</title>
    <%
        LoginUser user=(LoginUser)session.getAttribute("user");
        if(user==null){
            response.sendRedirect(eErrorPage.PERMISSIONDENY.toString());
            return;
        }
    %>
</head>
<body>
    <a href="Publish_Requirements.jsp" >发布需求</a><br/>
    <a href="Query_Recruit_HR.jsp" >查询所有需求</a><br/>
    <a href="Query_Recruit_HR.jsp" >查询已发布需求</a>
</body>
</html>
