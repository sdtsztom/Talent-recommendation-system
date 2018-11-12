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
  <body>
    <div id="login" class="divForm">
        <form id="login_form" method="post" action="Trans.jsp">
            <br/><br/>
            用户名<input type="text" name="log_name" id="log_name"><br/><br/>
            密码&nbsp&nbsp&nbsp<input type="password" name="log_passwd" id="log_passwd"><br/><br/>
                <input type="submit" value="登陆"><input type="reset" value="清除">
        </form>
    </div>
  </body>
</html>
