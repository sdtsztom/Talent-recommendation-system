<%@ page import="bean.LoginUser" %>
<%@ page import="util.CommonConnection" %>
<%@ page import="ienum.ConnectUser" %>
<%@ page import="java.sql.ResultSet" %>
<%@ page import="ienum.eErrorPage" %>
<%@ page import="ienum.JobType" %>
<%@ page import="java.sql.SQLException" %><%--
  Created by IntelliJ IDEA.
  User: 10442
  Date: 2018/11/4
  Time: 21:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>需求详情</title>
    <style>
        @import url("css/table.css");
    </style>
</head>
<%
    //验证用户
    LoginUser user = (LoginUser) session.getAttribute("user");
    if(user==null){
        response.sendRedirect(eErrorPage.PERMISSIONDENY.toString());
        return;
    }

    //获取招聘id
    String rr_id = request.getParameter("rr_id");

    //职能判断
    JobType jb_type = user.getJob_type();
    ConnectUser connect_user=null;
    switch (jb_type){
        case HR:{connect_user=ConnectUser.HR;break;}
        case ADMIN:{connect_user=ConnectUser.HR;break;}
        case STUFF:{connect_user=ConnectUser.STUFF;break;}
    }
    CommonConnection.setConnectUser(connect_user);

    //招聘详情查询及判断
    ResultSet rs = CommonConnection.makeQuery("select * from requirement_details \n" +
            "where rr_id = '" + rr_id + "'");
    try{
        if(!rs.next()){
            response.sendRedirect(eErrorPage.NOTHISREQUIREMENT.toString());
            return;
        }
        rs.next();
    }catch (SQLException e){
        e.printStackTrace();
    }
%>
<body>
<table class="bordered">

    <tr>
        <td>需求id</td>
        <td><%=rr_id%></td>
        <td>招聘人数</td>
        <td><%=rs.getInt("rr_num")%></td>
        <td>紧急度</td>
        <td><%=rs.getString("ed_name")%></td>
    </tr>

    <tr>
        <td>员工类型名</td>
        <td><%=rs.getString("st_name")%></td>
        <td>类型描述</td>
        <td colspan="3"  ><%=rs.getString("st_desc")%></td>
    </tr>

    <tr>
        <td>工作地点</td>
        <td><%=rs.getString("wp_name")%></td>
        <td>详细地点</td>
        <td colspan="3"><%=rs.getString("wp_detail")%></td>
    </tr>

    <tr>
        <td>职位名称</td>
        <td><%=rs.getString("jb_name")%></td>
        <td rowspan="2">职位描述</td>
        <td rowspan="2" colspan="3"><%=rs.getString("jb_desc")%></td>
    </tr>

    <tr>
        <td>职位工资</td>
        <td><%=rs.getInt("jb_sal")%></td>
    </tr>

    <tr>
        <td>职能类别</td>
        <td><%=rs.getString("jt_name")%></td>
        <td>类别描述</td>
        <td colspan="3"><%=rs.getString("jt_desc")%></td>
    </tr>

    <tr>
        <td>部门名称</td>
        <td colspan="2"><%=rs.getString("dp_name")%></td>
        <td>联系人</td>
        <td colspan="2"><%=rs.getString("dp_contact")%></td>
    </tr>

    <tr>
        <td >特殊要求</td>
        <td colspan="5"><%=rs.getString("rr_spreq")%></td>
    </tr>

</table>
<%
    if(user.getJob_type().toString().equals("人事人员")){
%>
<a href="" >关闭需求</a>
<a href="" >更新需求</a>
<a href="" >处理需求</a>
<%
    }else if(user.getJob_type().toString().equals("管理人员")){
%>
<a href="" >处理需求</a><br/>
<%
    }else if(user.getJob_type().toString().equals("开发人员")){
%>
<a href="" >提交推荐人</a><br/>
<%
    }
    CommonConnection.closeConnection();
%>
</body>
</html>

