<%@ page import="ienum.eErrorPage" %>
<%@ page import="bean.ConfirmUser" %>
<%@ page import="ienum.UtilServerFunctionType" %>
<%@ page import="ienum.WF_Servlets" %><%--
  Created by IntelliJ IDEA.
  User: sdtsz
  Date: 2018/10/30
  Time: 14:44
  To change this template use File | Settings | File Templates.

--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>新员工注册</title>
    <link href="https://cdn.bootcss.com/twitter-bootstrap/4.1.3/css/bootstrap.min.css" rel="stylesheet">
    <script>
        function check_dup(un){
            var username=un.value;
            if(username=="")return;
            var xmlhttp=new XMLHttpRequest();
            xmlhttp.onreadystatechange=function(){
                if(xmlhttp.readyState==4&&xmlhttp.status==200)document.getElementById("warning").style.display="block";
                else if(xmlhttp.readyState==4&&xmlhttp.status==404)document.getElementById("warning").style.display="none";
            }
            xmlhttp.open("POST","/util_server",true);
            xmlhttp.setRequestHeader("Content-type","application/x-www-form-urlencoded");
            xmlhttp.send("type=<%=UtilServerFunctionType.CHECKDUPUSERNAME.toString()%>&username="+username);
            //******************************code to use ajax to check duplicate username*****************************
        }

        function check_pwd(form) {
            var pwd=form.password.value;
            var pwd2=form.password.value;
            if(pwd!==pwd2){
                window.alert("两次输入密码不一致!");
                return false;
            }else return true;
        }
    </script>
</head>
<body>
<%  ConfirmUser user=(ConfirmUser) session.getAttribute("confirm_user");
    if(user==null){
        response.sendRedirect(eErrorPage.PERMISSIONDENY.toString());
        return;
    }%>

<div class="jumbotron">
    <h1 class="display-4">注册</h1>
</div>

<div style="width:340px;margin:0 auto">
<form action="<%=WF_Servlets.OC%>?type=confirm" method="post" onsubmit="return check_pwd(this)">
    <div class="form-group">
        <label for="username">用户名</label>
        <input type="text" class="form-control" id="username" aria-describedby="emailHelp" placeholder="Username" name="username" onblur="check_dup(this)">
        <small id="warning" class="form-text text-muted" style="display:none;color:red">此用户名已被注册过，请重新选择用户名!</small>
    </div>
    <div class="form-group">
        <label for="password">密码</label>
        <input type="password" class="form-control" id="password" placeholder="Password" name="pwd">
    </div>
    <div class="form-group">
        <label for="password_check">确认密码</label>
        <input type="password" class="form-control" id="password_check" placeholder="Password" name="pwd_check">
    </div>
    <button type="submit" class="btn btn-primary">提交</button>
</form>
</div>

</body>
</html>
