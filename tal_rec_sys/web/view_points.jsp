<%@ page import="util.CommonConnection" %>
<%@ page import="util.ConnectUser" %>
<%@ page import="java.sql.ResultSet" %><%--
  Created by IntelliJ IDEA.
  User: sdtsz
  Date: 2018/10/28
  Time: 17:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>积分查询页面</title>
</head>
<body>
    <%  //int stuff_id=0;   //for test
        int stuff_id=Integer.valueOf(request.getParameter("stuff_id"));
        CommonConnection.setConnectUser(ConnectUser.DEV);
        ResultSet rs=CommonConnection.makeQuery("select stf_name,stf_pts from stuff where stf_id="+stuff_id);
        rs.next();
        String name=rs.getString("stf_name");
        int points=rs.getInt("stf_pts");
        rs.close();
    %>
    员工名称：<%=name%><br/>
    累计积分：<%=""+points%>
</body>
</html>
