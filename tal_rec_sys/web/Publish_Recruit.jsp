<%--
  Created by IntelliJ IDEA.
  User: 10442
  Date: 2018/10/29
  Time: 14:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<%
    request.getSession();
    int stf_id = (int) session.getAttribute("stf_id");
    CommonConnection.setConnectUser("develop");
%>
<head>
    <title>Title</title>
    <script>
        function submit_button() {

        }
    </script>
</head>
<body>
    <form>
        工作地点<

        <button onclick="submit_button()">提交</button>
    </form>
</body>
</html>
