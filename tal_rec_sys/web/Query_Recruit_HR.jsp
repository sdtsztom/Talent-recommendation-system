<%@ page import="util.CommonConnection" %>
<%@ page import="bean.LoginUser" %>
<%@ page import="bean.Recruit" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="util.iutil" %>
<%@ page import="bean.RrSortOrder" %>
<%@ page import="ienum.*" %>
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
    <title>已发布的招聘(HR)</title>
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
    LoginUser user=(LoginUser)session.getAttribute("user");

    // 排序处理
    String order_sql=null;
    String reverse_column =request.getParameter("order");
    RrSortOrder last_order=(RrSortOrder)session.getAttribute("order_state");
    if(reverse_column ==null){
        reverse_column="";
        if(last_order==null)session.setAttribute("order_state",new RrSortOrder());
        else last_order.setDefault();
        order_sql="order by rr_el desc,rr_ed_id asc";
    } else{
        if(reverse_column.equals("time")){
            reverse_column="&order=time";
            last_order.reverse_time();
            order_sql="order by rr_el "+last_order.getTime_order()+",rr_ed_id "+last_order.getEmergency_degree_order();
        }
        else if(reverse_column.equals("ed")){
            reverse_column="&order=ed";
            last_order.reverse_ed();
            order_sql="order by rr_ed_id "+last_order.getEmergency_degree_order()+",rr_el "+last_order.getTime_order();
        }
    }

    // 查询范围确定
    String select_state =request.getParameter("all");
    String select_scope=" and rr_sta_id>"+RrStage.FINISH.toId();
    if(select_state==null) {
        select_state = "";
    }else if(select_state.equals("true")){
        select_state="&all=true";
        select_scope="";
    }

    // 查询招聘信息
    String sql = "select rr_id,jb_name,rr_num,wp_name,rr_el,rr_ed_id,ed_name,rr_sta_id from requirement_list" +
            " where rr_hr_id =" + user.getId() + select_scope+" and rr_el>'" + iutil.getDate() + "' "+ order_sql;

    ArrayList<Recruit> Recruit_list = CommonConnection.<Recruit>listQuery(sql,new Recruit(),ConnectUser.HR);
%>

<body>
<div>
    <% if(select_state.equals("")){%>
    <a href="Query_Recruit_HR.jsp?all=true<%=reverse_column%>">显示全部</a>&nbsp;&nbsp;&nbsp;
    <%}else{%><a href="Query_Recruit_HR.jsp?<%=reverse_column%>">隐藏已完成需求</a>&nbsp;&nbsp;&nbsp;
    <%}%>
    <a href="Query_Recruit_HR.jsp?order=time<%=select_state%>">按时间排序</a>&nbsp;&nbsp;&nbsp;
    <a href="Query_Recruit_HR.jsp?order=ed<%=select_state%>">按紧急度排序</a>&nbsp;&nbsp;&nbsp;
    <a href="Query_Recruit_HR.jsp<%=select_state.equals("")?"":"?all=true"%>">默认排序</a>
</div>
<table class="bordered">
    <tr>
        <th>需求号</th>
        <th>招聘职位</th>
        <th>招聘人数</th>
        <th>工作地点</th>
        <th>截止日期</th>
        <th>紧急度</th>
        <th>当前状态</th>
        <th>查看详情</th>
        <th>管理链接</th>
    </tr>

    <%for(Recruit recruit:Recruit_list){
        RrStage stage=recruit.getRrStage();
    %>
    <tr <% if (recruit.getEd_name().equals("一级")){%>id="light"<%}%>>
        <td><%=recruit.getRr_id()%></td>
        <td><%=recruit.getJb_name()%></td>
        <td><%=recruit.getRr_num()%></td>
        <td><%=recruit.getWp_name()%></td>
        <td><%=iutil.formattedDate(recruit.getRr_el())%></td>
        <td><%=recruit.getEd_name()%></td>
        <td><%=stage%></td>
        <td><a href="Recruit_Detail.jsp?rr_id=<%=recruit.getRr_id() %>">查看详情</a></td>
        <td>
            <%if(stage.toId()>RrStage.FINISH.toId()){%>
            <a href="<%=SRM_Page.convert(stage)%>?rrid=<%=recruit.getRr_id() %>">管理</a>
            <%}else{%>------<%}%>
        </td>
    </tr>
    <%}%>

</table>
</body>
</html>
