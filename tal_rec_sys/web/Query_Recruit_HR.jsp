<%@ page import="util.CommonConnection" %>
<%@ page import="ienum.ConnectUser" %>
<%@ page import="bean.LoginUser" %>
<%@ page import="java.sql.ResultSet" %>
<%@ page import="ienum.eErrorPage" %>
<%@ page import="ienum.JobType" %>
<%@ page import="bean.Recruit" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.sql.SQLException" %>
<%@ page import="util.iutil" %>
<%@ page import="bean.RrSortOrder" %>
<%--
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
            $("tr#light").css("background-color","#FF6666");
        });
    </script>
    <style>

        body {
            width: 900px;
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
    //用户验证
    LoginUser user=(LoginUser)session.getAttribute("user");
    if(user==null||user.getJob_type()!=JobType.HR) {
        response.sendRedirect(eErrorPage.PERMISSIONDENY.toString());
        return;
    }

    // 排序处理
    String order_sql=null;
    String reverse_column =request.getParameter("reverse_column");
    if(reverse_column ==null){
        session.setAttribute("order",new RrSortOrder());
        order_sql="order by rr_el desc,rr_ed_id asc";
    } else{
        RrSortOrder last_order=(RrSortOrder)session.getAttribute("reverse_column");

        if(reverse_column.equals("time"))last_order.reverse_time();
        else if(reverse_column.equals("ed"))last_order.reverse_ed();

        order_sql="order by rr_el "+last_order.getTime_order()+",rr_ed_id "+last_order.getEmergency_degree_order();
    }

    // 查询招聘信息
    CommonConnection.setConnectUser(ConnectUser.HR);
    ArrayList<Recruit> Recruit_list = new ArrayList<Recruit>();

    String sql = "select rr_id,wp_name,rr_num,rr_el,ed_name from " +
            "recruitment_requirements join work_place on rr_wp_id = wp_id join emergency_degree on rr_ed_id = ed_id " +
            "where rr_hr_id =" + user.getId() + " and rr_el > '" + iutil.getDate() + "' "+order_sql;

    ResultSet rs = CommonConnection.makeQuery(sql);

    try{
        while(rs.next()) {
            Recruit_list.add(new Recruit(rs.getInt("rr_id"),rs.getString("ed_name").trim(),
                rs.getInt("rr_num"),rs.getString("wp_name").trim(),iutil.formattedDate(rs.getDate("rr_el"))));
        }
        rs.close();
    }catch(SQLException e){
        e.printStackTrace();
    }
%>

<body>
<div>
    <a href="Query_Recruit_HR.jsp?order=time">按时间排序</a>&nbsp;&nbsp;&nbsp;
    <a href="Query_Recruit_HR.jsp?order=ed">按紧急度排序</a>&nbsp;&nbsp;&nbsp;
    <a href="Query_Recruit_HR.jsp">默认排序</a>
</div>
<table class="bordered">
    <tr>
        <th>工作地点</th>
        <th>招聘人数</th>
        <th>截止日期</th>
        <th>紧急度</th>
        <th>查看详情</th>
        <th>管理链接</th>
    </tr>

    <%for(Recruit recruit:Recruit_list){%>
    <tr <% if (recruit.getEd_name().equals("一级")){%>id="light"<%}%>>
        <td><%=recruit.getWp_name()%></td>
        <td><%=recruit.getRr_num()%></td>
        <td><%=recruit.getRr_el()%></td>
        <td><%=recruit.getEd_name()%></td>
        <td><a href="Recruit_Detail.jsp?rr_id=<%=recruit.getRr_id() %>">查看详情</a></td>
        <td><a href="Recruit_Detail.jsp?rr_id=<%=recruit.getRr_id() %>">管理</a></td>
    </tr>
    <%}%>

</table>
</body>
</html>
