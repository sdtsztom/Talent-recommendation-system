<%@ page import="util.CommonConnection" %>
<%@ page import="ienum.ConnectUser" %>
<%@ page import="java.sql.ResultSet" %>
<%@ page import="bean.LoginUser" %>
<%@ page import="ienum.eErrorPage" %>
<%@ page import="table.TableBase" %><%--
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
        String user_id =user.getId()+"";
        String [] values =CommonConnection.singleLineQuery("select stf_name,stf_pts from stuff where stf_id="+ user_id,2,ConnectUser.STUFF);
        String name= values[0];
        int points=Integer.parseInt(values[1]);
    %>
    员工名称：<%=name%><br/>
    累计积分：<%=""+points%>

<%
    TableBase table=new TableBase("select pch_change,pch_desc,pch_time from points_change_details",ConnectUser.SYS);
    String head[]={"积分变化","变化原因","变化时间"};
    table.genHTML(head);
%>

</body>
</html>
