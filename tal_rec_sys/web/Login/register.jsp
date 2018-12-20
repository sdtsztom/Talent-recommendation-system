<%@ page import="ienum.eErrorPage" %>
<%@ page import="bean.ConfirmUser" %>
<%@ page import="ienum.UtilServerFunctionType" %>
<%@ page import="ienum.WF_Servlets" %><%--
  Created by IntelliJ IDEA.
  User: sdtsz
  Date: 2018/10/30
  Time: 14:44
  To change this template use File | Settings | File Templates.

  TO-DO:
    1. javascript检验表单
    2.[Done] 检测用户名是否被用过并动态提醒
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>新员工注册</title>
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
    </script>
</head>
<body>
<%  ConfirmUser user=(ConfirmUser) session.getAttribute("confirm_user");
    if(user==null){
        response.sendRedirect(eErrorPage.PERMISSIONDENY.toString());
        return;
    }
    String user_id =user.getId();
    String name=user.getName();
    String sex=user.getSex();%>

<%=name+sex+"，请完善您的注册信息："%>
<form action="<%=WF_Servlets.OC%>?type=confirm" method="post">
    <input type="text" name="username" onblur="check_dup(this)"><br/>
    <div rec_id="warning" style="display:none;color:red">此用户名已被注册过，请重新选择用户名!</div>
    <input type="password" name="pwd">
    <input type="submit" value="提交">
</form>
</body>
</html>
