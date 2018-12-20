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
    String user_id =user.getId();
    String name=user.getName();
    String sex=user.getSex();
    %>
<%=name+sex%>，恭喜您，您已被我公司提供了一份offer.请选择您是否接收我们的offer并按时履职。
点击下方的接收按钮接收我们的offer并注册员工账号，点击决绝按钮拒绝我们的offer.
<button ><a href="/Login/register.jsp">接受</a></button>
<button ><a href="<%=WF_Servlets.OC%>?type=refuse">拒绝</a></button>
</body>
</html>
