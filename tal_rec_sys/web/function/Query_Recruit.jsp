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
    <script>
        $(document).ready(function(){
            $("tr:#light").css("background-color","red");
        });
    </script>
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
    <script src="https://oss.maxcdn.com/libs/respond.js/1.3.0/respond.min.js"></script>
    <script src="https://cdn.staticfile.org/jquery/1.10.2/jquery.min.js"></script>
    <script src="https://cdn.staticfile.org/jquery/1.10.2/jquery.min.js"></script>
</head>

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
   ResultSet rs = CommonConnection.makeQuery(sql.toString(),connect_user);

%>

<body>

<div class="container">
    <div class="row clearfix">
        <div class="col-md-12 column">
            <br/><br/>
            <div class="btn-group">
                <button class="btn btn-default" type="button" onclick="window.location.href='Query_Recruit.jsp?sort=3'"><em class="glyphicon glyphicon-align-left"></em> 默认排序</button>
                <button class="btn btn-default" type="button" onclick="window.location.href='Query_Recruit.jsp?sort=2'"><em class="glyphicon glyphicon-align-center"></em> 按时间排序</button>
                <button class="btn btn-default" type="button" onclick="window.location.href='Query_Recruit.jsp?sort=1'"><em class="glyphicon glyphicon-align-right"></em> 按紧急度排序</button>

            </div>
            <table class="table table-hover">
                <thead>
                <tr>
                    <th>工作地点</th>
                    <th>招聘人数</th>
                    <th>截止日期</th>
                    <th>紧急度</th>
                    <th>#</th>
                </tr>
                </thead>
                <tbody>
                <%
                    //打印招聘信息
                    while(rs.next()){
                %>
                <tr <% if (rs.getString("ed_name").equals("一级")){%>id="light"<%}%>>
                    <td><%=rs.getString("wp_name")%></td>
                    <td><%=rs.getInt("rr_num")%></td>
                    <td><%=rs.getString("rr_el")%></td>
                    <td><%=rs.getString("ed_name")%></td>
                    <td><a href="Recruit_Detail.jsp?rr_id=<%=rs.getInt("rr_id") %>" target="right">查看详情</a></td>
                </tr>
                <%
                    }
                %>
                </tbody>
            </table>
            <ul class="pagination">
                <li><a href="#">Prev</a></li>
                <li><a href="#">1</a></li>
                <li><a href="#">2</a></li>
                <li><a href="#">3</a></li>
                <li><a href="#">4</a></li>
                <li><a href="#">5</a></li>
                <li><a href="#">Next</a></li>
            </ul>
        </div>
    </div>
</div>
</body>
</html>
