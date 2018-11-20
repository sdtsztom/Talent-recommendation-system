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
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <title>员工推荐追踪</title>
    <link rel="stylesheet" href="https://cdn.bootcss.com/twitter-bootstrap/4.1.3/css/bootstrap.css"/>
</head>
<body>
<%
    session.setAttribute("user",new LoginUser("1","1","1","1")); //测试用session
%>
<sql:setDataSource var="dev" driver="com.microsoft.sqlserver.jdbc.SQLServerDriver" url="jdbc:sqlserver://localhost:1433;DatabaseName=tal_rec_sys" user="u_dev" password="12345678a"/>
<sql:setDataSource var="stuff" driver="com.microsoft.sqlserver.jdbc.SQLServerDriver" url="jdbc:sqlserver://localhost:1433;DatabaseName=tal_rec_sys" user="u_stuff" password="12345678a"/>
<c:set var="rec_recstu_id" value="${user.id}"/>
<c:set var="sql" value="select rec_id,
rec_rr_id,
stuff.stf_name,
recommend_people.rp_name,
recommend_from.recf_desc,
recommend_stage.rec_sta_desc,
recommend_results.rec_desc
from recommend
inner join stuff on stuff.stf_id = recommend.rec_recstu_id
inner join recommend_people on recommend_people.rp_id = recommend.rec_rp_id
inner join recommend_from on recommend_from.recf_id = recommend.rec_from_id
inner join recommend_stage on recommend_stage.rec_sta_id = recommend.rec_recsta_id
inner join recommend_results on recommend_results.rec_res_id = recommend.rec_recres_id
where rec_recstu_id=${rec_recstu_id} and rec_sta_id != 1"/>
<sql:query dataSource="${stuff}" var="recommend">${sql}</sql:query>
<div class="row">
    <div class="col-md-2"></div>
    <div class="col-md-8">
            <table class="table">
                <tr>
                    <th>推荐id</th>
                    <th>需求id</th>
                    <th>员工姓名</th>
                    <th>被推荐人姓名</th>
                    <th>途径</th>
                    <th>阶段</th>
                    <th>结果</th>
                </tr>
                <c:set var="count" value="0"/>
                <c:forEach var="row" items="${recommend.rows}">
                    <tr>
                        <td><c:out value="${row.rec_id}"/></td>
                        <td><c:out value="${row.rec_rr_id}"/></td>
                        <td><c:out value="${row.stf_name}"/></td>
                        <td><c:out value="${row.rp_name}"/></td>
                        <td><c:out value="${row.recf_desc}"/></td>
                        <td><c:out value="${row.rec_sta_desc}"/></td>
                        <td><c:out value="${row.rec_desc}"/></td>
                    </tr>
                    <c:set var="count" value="${count+1}"/>
                </c:forEach>
                <c:if test="${count eq 0}"><h1 class="text-center">暂无推荐</h1></c:if>
        </table>
    </div>
    <div class="col-md-2"></div>
</div>

</table>
</body>
</html>