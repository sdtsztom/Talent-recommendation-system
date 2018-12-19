<%@ page import="util.CommonConnection" %>
<%@ page import="ienum.ConnectUser" %>
<%@ page import="java.sql.ResultSet" %>
<%@ page import="bean.LoginUser" %>
<%@ page import="ienum.eErrorPage" %><%--
  Created by IntelliJ IDEA.
  User: sdtsz
  Date: 2018/10/28
  Time: 17:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>积分查询</title>
</head>
<body>
    <%
        LoginUser user=(LoginUser)session.getAttribute("user");
        if(user==null){
            response.sendRedirect(eErrorPage.PERMISSIONDENY.toString());
            return;
        }
        String user_id =user.getId()+"";
        String []rs=CommonConnection.singleLineQuery("select stf_name,stf_pts from stuff where stf_id="+ user_id,2,ConnectUser.STUFF);
        String name=rs[0];
        int points=Integer.parseInt(rs[1]);
    %>
    员工名称：<%=name%><br/>
    累计积分：<%=""+points%>
</body>
</html>
