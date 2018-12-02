<%@ page import="util.CommonConnection" %>
<%@ page import="ienum.ConnectUser" %>
<%@ page import="bean.LoginUser" %>
<%@ page import="java.sql.ResultSet" %>
<%@ page import="java.lang.String" %>
<%@ page import="ienum.eErrorPage" %>
<%@ page import="ienum.JobType" %>
<%@ page import="bean.Recruit" %>
<%@ page import="java.sql.SQLException" %>
<%@ page import="java.text.DateFormat" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.util.Date" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: 10442
  Date: 2018/11/1
  Time: 19:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>需求大厅</title>
    <script src="https://cdn.staticfile.org/jquery/1.10.2/jquery.min.js"></script>
    <script>
        $(document).ready(function(){
            $("tr:#light").css("background-color","red");
        });
    </script>
    <style>
        @import url("css/table.css");
    </style>
</head>
<body>
<table class="bordered">
    <thead>
    <tr>
        <th>工作地点</th>
        <th>招聘人数</th>
        <th>截止日期</th>
        <th>紧急度</th>
        <th>#</th>
    </tr>
    </thead>
    <%
        //用户验证
        LoginUser user=(LoginUser)session.getAttribute("user");
        if(user==null){
            response.sendRedirect(eErrorPage.PERMISSIONDENY.toString());
            return;
        }

        //职能判断
        JobType jb_type = user.getJob_type();
        ConnectUser connect_user=null;
        switch (jb_type){
            case HR:{connect_user=ConnectUser.HR;break;}
            case ADMIN:{connect_user=ConnectUser.HR;break;}
            case STUFF:{connect_user=ConnectUser.STUFF;break;}
        }
        CommonConnection.setConnectUser(connect_user);

        ArrayList<Recruit> Recruit_list = new ArrayList<>();

        //招聘信息查询以及相关排序
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        StringBuilder sql = new StringBuilder("select rr_id,wp_name,rr_num,rr_el,ed_name from " +
                "recruitment_requirements join work_place on rr_wp_id = wp_id join emergency_degree on rr_ed_id = ed_id " +
                "where rr_el > '" + df.format(new Date()) + "'");
        if(request.getParameter("sort")!=null){
            switch (Integer.parseInt(request.getParameter("sort"))){
                case 1:{
                    sql.append("order by rr_el desc");
                    break;
                }
                case 2:{
                    sql.append("order by rr_ed_id asc");
                    break;
                }
                case 3:{
                    sql.append("order by rr_el asc, rr_ed_id desc");
                }
            }
        }
        ResultSet rs = CommonConnection.makeQuery(sql.toString());

        //招聘信息存入ArrayList
        try{
            while(rs.next()) {
                Recruit_list.add(new Recruit(rs.getInt("rr_id"),rs.getString("ed_name"),
                        rs.getInt("rr_num"),rs.getString("wp_name"),rs.getString("rr_el")));
            }
            rs.close();
        }catch(SQLException e){
            e.printStackTrace();
        }

        //打印招聘信息
        for(Recruit recruit:Recruit_list){
    %>
    <tr <% if (recruit.getEd_name().equals("一级")){%>id="light"<%}%>>
        <td><%=recruit.getWp_name()%></td>
        <td><%=recruit.getRr_num()%></td>
        <td><%=recruit.getRr_el()%></td>
        <td><%=recruit.getEd_name()%></td>
        <td><a href="Recruit_Detail.jsp?rr_id=<%=recruit.getRr_id() %>">查看详情</a></td>
    </tr>
    <%
        }
    %>
</table>
</body>
</html>
