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

<html lang="en">
<head>

    <!-- start: Meta -->
    <meta charset="utf-8" />
    <title>新员工注册</title>
    <meta name="description" content="SimpliQ - Flat & Responsive Bootstrap Admin Template." />
    <meta name="author" content="Łukasz Holeczek" />
    <meta name="keyword" content="SimpliQ, Dashboard, Bootstrap, Admin, Template, Theme, Responsive, Fluid, Retina" />
    <!-- end: Meta -->

    <!-- start: Mobile Specific -->
    <meta name="viewport" content="width=device-width, initial-scale=1" />
    <!-- end: Mobile Specific -->

    <!-- start: CSS -->
    <link href="/css/css/bootstrap.min.css" rel="stylesheet" />
    <link href="/css/css/bootstrap-responsive.min.css" rel="stylesheet" />
    <link href="/css/css/style.min.css" rel="stylesheet" />
    <link href="/css/css/style-responsive.min.css" rel="stylesheet" />
    <link href="/css/css/retina.css" rel="stylesheet" />
    <!-- end: CSS -->


    <!-- The HTML5 shim, for IE6-8 support of HTML5 elements -->
    <!--[if lt IE 9]>
    <script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
    <link id="ie-style" href="/css/css/ie.css" rel="stylesheet">
    <![endif]-->

    <!--[if IE 9]>
    <link id="ie9style" href="/css/css/ie9.css" rel="stylesheet">
    <![endif]-->

    <!-- start: Favicon and Touch Icons -->
    <link rel="apple-touch-icon-precomposed" sizes="144x144" href="/css/ico/apple-touch-icon-144-precomposed.png" />
    <link rel="apple-touch-icon-precomposed" sizes="114x114" href="/css/ico/apple-touch-icon-114-precomposed.png" />
    <link rel="apple-touch-icon-precomposed" sizes="72x72" href="/css/ico/apple-touch-icon-72-precomposed.png" />
    <link rel="apple-touch-icon-precomposed" href="/css/ico/apple-touch-icon-57-precomposed.png" />
    <link rel="shortcut icon" href="/css/ico/favicon.png" />
    <!-- end: Favicon and Touch Icons -->

    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
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
<%  ConfirmUser user=(ConfirmUser) session.getAttribute("confirm_user");
    if(user==null){
        response.sendRedirect(eErrorPage.PERMISSIONDENY.toString());
        return;
    };
%>
<body>
<div class="container-fluid-full">
    <div class="row-fluid">

        <div class="row-fluid">
            <div class="login-box">
                <h2>新用户注册</h2>
                <form class="form-horizontal" id="login_form" action="<%=WF_Servlets.OC%>?type=confirm" method="post" onsubmit="return check_pwd(this)" role="form"/>
                <fieldset>

                    <input class="input-large span12" name="username" id="username" type="text" placeholder="请输入用户名" />

                    <div rec_id="warning" style="display:none;color:red">此用户名已被注册过，请重新选择用户名!</div>

                    <input class="input-large span12" name="pwd" id="password" type="password" placeholder="请输入密码" />

                    <input class="input-large span12" name="pwd" id="password_checck" type="password" placeholder="请重新输入密码" />

                    <button type="submit" class="btn btn-primary span12">注册</button>
                </fieldset>

                </form>
            </div>
        </div>

    </div>

</div>

<script src="/css/js/jquery-1.10.2.min.js"></script>
<script src="/css/js/jquery-migrate-1.2.1.min.js"></script>
<script src="/css/js/jquery-ui-1.10.3.custom.min.js"></script>
<script src="/css/js/jquery.ui.touch-punch.js"></script>
<script src="/css/js/modernizr.js"></script>
<script src="/css/js/bootstrap.min.js"></script>
<script src="/css/js/jquery.cookie.js"></script>
<script src='/css/js/fullcalendar.min.js'></script>
<script src='/css/js/jquery.dataTables.min.js'></script>
<script src="/css/js/excanvas.js"></script>
<script src="/css/js/jquery.flot.js"></script>
<script src="/css/js/jquery.flot.pie.js"></script>
<script src="/css/js/jquery.flot.stack.js"></script>
<script src="/css/js/jquery.flot.resize.min.js"></script>
<script src="/css/js/jquery.flot.time.js"></script>
<script src="/css/js/jquery.chosen.min.js"></script>
<script src="/css/js/jquery.uniform.min.js"></script>
<script src="/css/js/jquery.cleditor.min.js"></script>
<script src="/css/js/jquery.noty.js"></script>
<script src="/css/js/jquery.elfinder.min.js"></script>
<script src="/css/js/jquery.raty.min.js"></script>
<script src="/css/js/jquery.iphone.toggle.js"></script>
<script src="/css/js/jquery.uploadify-3.1.min.js"></script>
<script src="/css/js/jquery.gritter.min.js"></script>
<script src="/css/js/jquery.imagesloaded.js"></script>
<script src="/css/js/jquery.masonry.min.js"></script>
<script src="/css/js/jquery.knob.modified.js"></script>
<script src="/css/js/jquery.sparkline.min.js"></script>
<script src="/css/js/counter.min.js"></script>
<script src="/css/js/raphael.2.1.0.min.js"></script>
<script src="/css/js/justgage.1.0.1.min.js"></script>
<script src="/css/js/jquery.autosize.min.js"></script>
<script src="/css/js/retina.js"></script>
<script src="/css/js/jquery.placeholder.min.js"></script>
<script src="/css/js/wizard.min.js"></script>
<script src="/css/js/core.min.js"></script>
<script src="/css/js/charts.min.js"></script>
<script src="/css/js/custom.min.js"></script>


</body>
</html>