<%@ page import="bean.ConfirmUser" %>
<%@ page import="ienum.WF_Servlets" %><%--
  Created by IntelliJ IDEA.
  User: sdtsz
  Date: 2018/10/29
  Time: 14:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>履职确认</title>
    <link href="https://cdn.bootcss.com/twitter-bootstrap/4.1.3/css/bootstrap.min.css" rel="stylesheet">
    <script>
        /*
        function choice_confirm(){
            var choice=window.confirm("确定履行此决定?");
            return choice;
        }
        */
    </script>
</head>
<body>
<%  //由于这个网站有过滤器的确保，因此不用检验session存不存在
    ConfirmUser user=(ConfirmUser)session.getAttribute("confirm_user");
    String name=user.getName();
    String sex=user.getSex();
    %>
<p><%=name+sex%>，恭喜您，您已被我公司聘用!请选择您是否接受我们为您提供的offer。
    点击下方的接受按钮接受我们的offer并注册员工账号，点击拒绝按钮拒绝我们的offer.</p>
<button class="btn btn-light"><a href="/Login/register.jsp">接受</a></button>
<button class="btn btn-light"><a href="<%=WF_Servlets.OC%>?type=refuse">拒绝</a></button>
</body>
</html>
