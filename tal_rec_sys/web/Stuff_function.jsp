<%@ page import="ienum.eErrorPage" %>
<%@ page import="bean.LoginUser" %><%--
  Created by IntelliJ IDEA.
  User: 10442
  Date: 2018/10/29
  Time: 14:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    LoginUser user=(LoginUser)session.getAttribute("user");
    if(user==null){
        response.sendRedirect(eErrorPage.PERMISSIONDENY.toString());
        return;
    }
%>
    <a onclick="window.location.href = ''" >提交推荐人</a><br/>
    <a onclick="window.location.href = 'Query_Recruit.jsp'" >查询所有需求</a><br/>
    <a onclick="window.location.href = ''" >查询历史推荐</a><br/>
    <a onclick="window.location.href = ''" >查询积分</a><br/>
</body>
</html>
