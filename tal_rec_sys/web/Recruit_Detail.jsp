<%@ page import="bean.LoginUser" %>
<%@ page import="util.CommonConnection" %>
<%@ page import="ienum.ConnectUser" %>
<%@ page import="java.sql.ResultSet" %><%--
  Created by IntelliJ IDEA.
  User: 10442
  Date: 2018/11/4
  Time: 21:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>$Title$</title>
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
<%
    LoginUser user = (LoginUser) session.getAttribute("user");
    String rr_id = request.getParameter("rr_id");

    if(user.getJob_type().equals("管理人员")){
        CommonConnection.setConnectUser(ConnectUser.ADMIN);
    }else if(user.getJob_type().equals("人事人员")){
        CommonConnection.setConnectUser(ConnectUser.HR);
    }else if(user.getJob_type().equals("开发人员")){
        CommonConnection.setConnectUser(ConnectUser.STUFF);
    }

    ResultSet rs = CommonConnection.makeQuery("select * from recruitment_requirements\n" +
            "left join work_place on rr_wp_id = wp_id\n" +
            "left join stuff_type on rr_st_id = st_id\n" +
            "left join requirements_common_info on rr_ri_id = ri_id\n" +
            "left join emergency_degree on rr_ed_id = ed_id\n" +
            "left join departments on ri_dpt_id = dp_id\n" +
            "left join job on ri_job_id = jb_id\n" +
            "left join job_type on jb_jt_id = jt_id\n" +
            "where rr_id = '" + rr_id + "'");
    rs.next();
//    ResultSet rs2 = CommonConnection.makeQuery("select stf_name from stuff where stf_id = '" + rs.getString("dp_contact") + "'");
//    rs2.next();
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
    <a onclick="window.location.href = ''" >提交推荐人</a><br/>
</body>
</html>
