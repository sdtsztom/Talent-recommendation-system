<%@ page import="bean.LoginUser" %>
<%
    /**
     * @Created: xsy
     * @Date: 2018.11.20
     */
%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <title>被推荐人信息查询</title>
    <link rel="stylesheet" href="https://cdn.bootcss.com/twitter-bootstrap/4.1.3/css/bootstrap.css"/>
</head>
<body>
<c:set var="httpmethod" value="${pageContext.request.method}"/>
<% session.setAttribute("user",new LoginUser("1","1","1","1")); //测试用session %>
<sql:setDataSource var="dev" driver="com.microsoft.sqlserver.jdbc.SQLServerDriver" url="jdbc:sqlserver://localhost:1433;DatabaseName=tal_rec_sys" user="u_dev" password="12345678a"/>
<sql:setDataSource var="admin" driver="com.microsoft.sqlserver.jdbc.SQLServerDriver" url="jdbc:sqlserver://localhost:1433;DatabaseName=tal_rec_sys" user="u_admin" password="12345678a"/>
<c:set var="rec_recstu_id" value="${user.id}"/>
<c:set var="sql" value="select rp_id,
degree.deg_name,
university.uni_name,
rp_name,rp_sex,rp_age,rp_tel_num,rp_email,rp_stu,rp_grt,rp_maj,rp_abi,rp_res_path,rp_vali,
job.jb_name
from recommend_people
inner join degree on degree.deg_id = rp_deg
inner join university on rp_uni = university.uni_id
inner join job on rp_job = job.jb_id
where rp_vali = '是'"/>
<sql:query var="recommend_people" dataSource="${admin}">${sql}</sql:query>
<sql:query dataSource="${admin}" var="degree">select deg_id,deg_name from degree;</sql:query>
<sql:query dataSource="${admin}" var="university">select uni_id,uni_name from university;</sql:query>
<sql:query dataSource="${admin}" var="job">select jb_id,jb_name from job;</sql:query>
<div class="row">
    <div class="col-md-1"></div>
    <div class="col-md-10">
        <c:if test="${ httpmethod eq 'GET' }">
            <table class="table">
                <tr>
                    <th>被推荐人id</th>
                    <th>学位</th>
                    <th>学校</th>
                    <th>姓名</th>
                    <th>性别</th>
                    <th>年龄</th>
                    <th>电话号码</th>
                    <th>邮箱</th>
                    <th>是否在读</th>
                    <th>毕业时间</th>
                    <th>专业</th>
                    <th>能力</th>
                    <th>简历路径</th>
                    <th>工作名称</th>
                </tr>
                <c:forEach var="row" items="${recommend_people.rows}">
                    <td><c:out value="${row.rp_id}"/></td>
                    <td><c:out value="${row.deg_name}"/></td>
                    <td><c:out value="${row.uni_name}"/></td>
                    <td><c:out value="${row.rp_name}"/></td>
                    <td><c:out value="${row.rp_sex}"/></td>
                    <td><c:out value="${row.rp_age}"/></td>
                    <td><c:out value="${row.rp_tel_num}"/></td>
                    <td><c:out value="${row.rp_email}"/></td>
                    <td><c:out value="${row.rp_stu}"/></td>
                    <td><c:out value="${row.rp_grt}"/></td>
                    <td><c:out value="${row.rp_maj}"/></td>
                    <td><c:out value="${row.rp_abi}"/></td>
                    <td><c:out value="${row.rp_res_path}"/></td>
                    <td><c:out value="${row.jb_name}"/></td>
                </tr>
                </c:forEach>
            </table>
        </c:if>

        <c:if test="${ httpmethod eq 'POST' }">
            <% request.setCharacterEncoding("UTF-8"); %>
        </c:if>
        <form method="post" action="RP_Detail.jsp">
            <div class="form-group">
                <label for="name">姓名</label>
                <input type="text" class="form-control" id="name" name="name" placeholder="name">
            </div>
            <div class="form-group">
                <label for="major">专业</label>
                <input type="text" class="form-control" id="major" name="major" placeholder="major">
            </div>
            <div class="form-group">
                <label for="abi">专业技能</label>
                <input type="text" class="form-control" id="abi" name="abi" placeholder="abi">
            </div>
            <label>性别</label>
            <select class="form-control" name="sex">
                <option value="男">男</option>
                <option value="女">女</option>
            </select>
            <label>是否在读</label>
            <select class="form-control" name="stu">
                <option value="是">是</option>
                <option value="否">否</option>
            </select>
            <label>学历</label>
            <select class="form-control" name="deg_id">
                <c:forEach var="row" items="${degree.rows}">
                    <option value="${row.deg_id}">${row.deg_name}</option>
                </c:forEach>
            </select>
            <label>大学</label>
            <select class="form-control" name="uni_id">
                <c:forEach var="row" items="${university.rows}">
                    <option value="${row.uni_id}">${row.uni_name}</option>
                </c:forEach>
            </select>
            <label>职业</label>
            <select class="form-control" name="jb_id">
                <c:forEach var="row" items="${job.rows}">
                    <option value="${row.jb_id}">${row.jb_name}</option>
                </c:forEach>
            </select>
            <button type="submit" class="btn btn-default">查询</button>
        </form>
    </div>
    <div class="col-md-1"></div>
</div>
</body>
</html>