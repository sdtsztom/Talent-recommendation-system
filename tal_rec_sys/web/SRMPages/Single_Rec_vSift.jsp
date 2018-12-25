<%@ page import="bean.LoginUser" %>
<%@ page import="table.Table_for_SRM_vSift" %>
<%@ page import="ienum.ConnectUser" %>
<%@ page import="ienum.RrStage" %>
<%@ page import="ienum.WF_Servlets" %>
<%@ page import="util.CommonConnection" %>
<%@ page import="ienum.eErrorPage" %><%--
  Created by IntelliJ IDEA.
  User: sdtsz
  Date: 2018/11/27
  Time: 18:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<%  String rrid=request.getParameter("rrid");
    LoginUser user=(LoginUser)session.getAttribute("user");
    String name=user.getUsername();
%>
<head>
    <title>需求(id:<%=rrid%>)的管理页面(状态：<%=RrStage.W_SIFT%>)</title>
    <link href="https://cdn.bootcss.com/twitter-bootstrap/4.1.3/css/bootstrap.min.css" rel="stylesheet">
</head>
<body><div class="container"><div style="height:50px;"></div>
<p>登录人：<%=name%></p>
<p>需求号：<%=rrid%></p>
<a href="/function/Recruit_Detail.html?rr_id=<%=rrid%>">需求详情</a>
<a href="/function/Query_Recruit_HR.html">返回</a>
<form action="<%=WF_Servlets.SIFT%>" method="post">
    <%
        Table_for_SRM_vSift table=new Table_for_SRM_vSift("select rec_id,rec_rp_id,rec_rp_name,rec_stf_name,rec_from_desc from SRM_OPEN_SIFT where rec_rr_id="+rrid, ConnectUser.HR);
        String []head={"推荐id","被推荐人id","被推荐人","推荐人","推荐来源","详细信息","筛选选项"};
        out.print(table.genHTML(head));
    %>
    <input type="hidden" name="rrid" value="<%=rrid%>">
    <button class="btn btn-light" type="submit">保存</button>
</form>
</div></body>
</html>
