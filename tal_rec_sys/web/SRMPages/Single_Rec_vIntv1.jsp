<%@ page import="bean.LoginUser" %>
<%@ page import="ienum.RrStage" %>
<%@ page import="table.Table_for_SRM_vI1" %>
<%@ page import="ienum.ConnectUser" %>
<%@ page import="ienum.WF_Servlets" %><%--
  Created by IntelliJ IDEA.
  User: sdtsz
  Date: 2018/11/27
  Time: 18:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<%  String rrid=request.getParameter("rrid");
    LoginUser user=(LoginUser)session.getAttribute("user");
    String name=user.getUsername();
%>
<head>
    <title>需求(id:<%=rrid%>)的管理页面(状态：<%=RrStage.W_I1%>)</title>
    <link href="https://cdn.bootcss.com/twitter-bootstrap/4.1.3/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<p>登录人：<%=name%></p>
<p>需求号：<%=rrid%></p>
<a href="/function/Recruit_Detail.html?rr_id=<%=rrid%>">需求详情</a>
<a href="/function/Query_Recruit_HR.html">返回</a>
<form action="<%=WF_Servlets.INTV1%>" method="post">
    <%
        Table_for_SRM_vI1 table=new Table_for_SRM_vI1 ("select rec_id,rec_rp_id,rec_rp_name,rec_stf_name,rec_from_desc from SRM_INTV1 where rec_rr_id="+rrid, ConnectUser.HR,rrid);
        String []head={"推荐id","被推荐人id","被推荐人","推荐人","推荐来源","详细信息","面试结果选项","需求号"};
        out.print(table.genHTML(head));
    %>
    <input type="hidden" name="rrid" value="<%=rrid%>">
    <input type="submit" value="保存">
</form>
</body>
</html>
