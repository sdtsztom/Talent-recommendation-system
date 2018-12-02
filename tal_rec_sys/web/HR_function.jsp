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
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <!-- 引入 Bootstrap -->
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">

    <!-- HTML5 Shiv 和 Respond.js 用于让 IE8 支持 HTML5元素和媒体查询 -->
    <!-- 注意： 如果通过 file://  引入 Respond.js 文件，则该文件无法起效果 -->
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
    <script src="https://oss.maxcdn.com/libs/respond.js/1.3.0/respond.min.js"></script>
    <![endif]-->
</head>
<br/><br/>
<div class="container">
    <div class="row clearfix">
        <div class="col-md-12 column">
            <ul class="nav nav-stacked nav-pills">
                <li class="active">
                    <a href="Query_Recruit_HR.jsp?all=true" target="right">查看所有需求</a>
                </li>
                <li>
                    <a href="Query_Recruit_HR.jsp" target="right">管理已发布的需求</a>
                </li>
                <li>
                    <a href="Publish_Requirements.jsp" target="right">发布需求</a>
                </li>
            </ul>
        </div>
    </div>
</div>
<%--<body>--%>
    <%--<a href="Publish_Requirements.jsp" >发布需求</a><br/>--%>
    <%--<a href="Query_Recruit_hr.jsp?all=true" >查询所有需求</a><br/>--%>
    <%--<a href="Query_Recruit_HR.jsp" >管理已发布的需求</a>--%>
<%--</body>--%>
</html>
