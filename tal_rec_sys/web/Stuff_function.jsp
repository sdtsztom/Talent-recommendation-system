<%--
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
        int stf_id = (int) session.getAttribute("stf_id");
        session.setAttribute("stf_id",stf_id);
    %>
    <a href="" >功能1</a><br/>
    <a href="" >功能2</a><br/>
    <a href="" >功能3</a>
</body>
</html>
