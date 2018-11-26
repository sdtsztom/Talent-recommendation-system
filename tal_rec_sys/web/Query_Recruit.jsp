<%@ page import="util.CommonConnection" %>
<%@ page import="ienum.ConnectUser" %>
<%@ page import="bean.LoginUser" %>
<%@ page import="java.sql.ResultSet" %>
<%@ page import="ienum.eErrorPage" %><%--
  Created by IntelliJ IDEA.
  User: 10442
  Date: 2018/11/1
  Time: 19:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>$Title$</title>
    <script src="https://cdn.staticfile.org/jquery/1.10.2/jquery.min.js"></script>
    <script>
        $(document).ready(function(){
            $("tr:#light").css("background-color","");
        });
    </script>
    <style>

        body {
            width: 600px;
            margin: 40px auto;
            font-family: 'trebuchet MS', 'Lucida sans', Arial;
            font-size: 14px;
            color: #444;
        }

        table {
            *border-collapse: collapse; /* IE7 and lower */
            border-spacing: 0;
            width: 100%;
        }

        .bordered {
            border: solid #ccc 1px;
            -moz-border-radius: 6px;
            -webkit-border-radius: 6px;
            border-radius: 6px;
            -webkit-box-shadow: 0 1px 1px #ccc;
            -moz-box-shadow: 0 1px 1px #ccc;
            box-shadow: 0 1px 1px #ccc;
        }

        .bordered tr:hover {
            background: #fbf8e9;
            -o-transition: all 0.1s ease-in-out;
            -webkit-transition: all 0.1s ease-in-out;
            -moz-transition: all 0.1s ease-in-out;
            -ms-transition: all 0.1s ease-in-out;
            transition: all 0.1s ease-in-out;
        }

        .bordered td, .bordered th {
            border-left: 1px solid #ccc;
            border-top: 1px solid #ccc;
            padding: 10px;
            text-align: left;
        }

        .bordered th {
            background-color: #dce9f9;
            background-image: -webkit-gradient(linear, left top, left bottom, from(#ebf3fc), to(#dce9f9));
            background-image: -webkit-linear-gradient(top, #ebf3fc, #dce9f9);
            background-image: -moz-linear-gradient(top, #ebf3fc, #dce9f9);
            background-image: -ms-linear-gradient(top, #ebf3fc, #dce9f9);
            background-image: -o-linear-gradient(top, #ebf3fc, #dce9f9);
            background-image: linear-gradient(top, #ebf3fc, #dce9f9);
            -webkit-box-shadow: 0 1px 0 rgba(255,255,255,.8) inset;
            -moz-box-shadow:0 1px 0 rgba(255,255,255,.8) inset;
            box-shadow: 0 1px 0 rgba(255,255,255,.8) inset;
            border-top: none;
            text-shadow: 0 1px 0 rgba(255,255,255,.5);
        }

        .bordered td:first-child, .bordered th:first-child {
            border-left: none;
        }

        .bordered th:first-child {
            -moz-border-radius: 6px 0 0 0;
            -webkit-border-radius: 6px 0 0 0;
            border-radius: 6px 0 0 0;
        }

        .bordered th:last-child {
            -moz-border-radius: 0 6px 0 0;
            -webkit-border-radius: 0 6px 0 0;
            border-radius: 0 6px 0 0;
        }

        .bordered th:only-child{
            -moz-border-radius: 6px 6px 0 0;
            -webkit-border-radius: 6px 6px 0 0;
            border-radius: 6px 6px 0 0;
        }

        .bordered tr:last-child td:first-child {
            -moz-border-radius: 0 0 0 6px;
            -webkit-border-radius: 0 0 0 6px;
            border-radius: 0 0 0 6px;
        }

        .bordered tr:last-child td:last-child {
            -moz-border-radius: 0 0 6px 0;
            -webkit-border-radius: 0 0 6px 0;
            border-radius: 0 0 6px 0;
        }

    </style>
</head>
<body>
<table class="bordered">
    <thead>

    <tr>
        <th>工作地点</th>
        <th>招聘人数</th>
        <th>截止日期</th>
        <th>#</th>
    </tr>
    </thead>
    <%
        LoginUser user=(LoginUser)session.getAttribute("user");
        if(user==null){
            response.sendRedirect(eErrorPage.PERMISSIONDENY.toString());
            return;
        }
        String jb_name = user.getJob_type().trim();
        if(jb_name.equals("开发人员")) {
            CommonConnection.setConnectUser(ConnectUser.ADMIN);
        }else if(jb_name.equals("人事人员")){
            CommonConnection.setConnectUser(ConnectUser.STUFF);
        }else if(jb_name.equals("管理人员")){
            CommonConnection.setConnectUser(ConnectUser.HR);
        }
        ResultSet rs = CommonConnection.makeQuery("select rr_id,wp_name,rr_num,rr_el,rr_ed_id from " +
                "recruitment_requirements left join work_place on rr_wp_id = wp_id");
        while(rs.next()){
    %>
    <tr <% if (rs.getInt("rr_ed_id") == 1){%>id="light"<%}%>>
        <td><%=rs.getString("wp_name")%></td>
        <td><%=rs.getInt("rr_num")%></td>
        <td><%=rs.getString("rr_el")%></td>
        <td><a onclick="window.location.href = 'Recruit_Detail.jsp?rr_id=<%=rs.getInt("rr_id") %>'">查看详情</a></td>
    </tr>
    <%
        }
        CommonConnection.closeConnection();
    %>
</table>
</body>
</html>
