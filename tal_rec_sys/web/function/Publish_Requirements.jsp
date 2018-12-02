<%@ page import="bean.LoginUser" %>
<%@ page import="ienum.eErrorPage" %>
<%@ page import="util.CommonConnection" %>
<%@ page import="ienum.ConnectUser" %>
<%@ page import="java.sql.ResultSet" %>
<%--
  Created by IntelliJ IDEA.
  User: 10442
  Date: 2018/11/5
  Time: 15:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

<head>
    <title>岗位信息选择</title>
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
    <script src="https://oss.maxcdn.com/libs/respond.js/1.3.0/respond.min.js"></script>
</head>
<body>
<div class="container">
    <div class="row clearfix">
        <div class="col-md-12 column">
            <br/><br/>
            <table class="table table-hover">
                <thead>
                <tr>
                    <td>职位名称</td>
                    <td>职能名称</td>
                    <td>工资</td>
                    <td>部门名称</td>
                    <td>点此创建</td>
                </tr>
                </thead>
                <tbody>
                <%
                    LoginUser user=(LoginUser)session.getAttribute("user");
                    if(!user.getJob_type().toString().equals("人事人员")){
                        response.sendRedirect(eErrorPage.PERMISSIONDENY.toString());
                        return;
                    }

                    ResultSet rs = CommonConnection.makeQuery("select * from requirement_info_view",ConnectUser.HR);
                    while(rs.next()){
                %>
                <tr>
                    <td><%=rs.getString("jb_name")%></td>
                    <td><%=rs.getString("jt_name")%></td>
                    <td><%=rs.getString("jb_sal")%></td>
                    <td><%=rs.getString("dp_name")%></td>
                    <td><a onclick="window.location.href = 'Publish_Details.jsp?ri_id=<%=rs.getString("ri_id")%>'" target="right">选择此条信息</a></td>
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
