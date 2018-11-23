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
    <title>员工推荐页面</title>
    <link rel="stylesheet" href="https://cdn.bootcss.com/twitter-bootstrap/4.1.3/css/bootstrap.css"/>
</head>
<body>
<c:set var="httpmethod" value="${pageContext.request.method}"/>
<%
    session.setAttribute("user",new LoginUser("1","1","1","1")); //测试用session
%>
<sql:setDataSource var="dev" driver="com.microsoft.sqlserver.jdbc.SQLServerDriver" url="jdbc:sqlserver://localhost:1433;DatabaseName=tal_rec_sys" user="u_dev" password="12345678a"/>
<sql:setDataSource var="stuff" driver="com.microsoft.sqlserver.jdbc.SQLServerDriver" url="jdbc:sqlserver://localhost:1433;DatabaseName=tal_rec_sys" user="u_stuff" password="12345678a"/>
<c:set var="rec_recstu_id" value="${user.id}"/>
<c:set var="rec_recsta_id" value="2"/><%-- 处理阶段为2:等待筛选 --%>
<c:set var="rec_recres_id" value="6"/><%-- 处理结果为6:暂无 --%>
<sql:query dataSource="${dev}" var="recommend_requirements">select * from recruitment_requirements;</sql:query>
<c:if test="${ httpmethod eq 'GET' }">
    <sql:query dataSource="${stuff}" var="recommend_check">select rec_recstu_id from recommend;</sql:query>
    <c:forEach var="row" items="${recommend_check.rows}">
        <c:if test="${ row.rec_recstu_id eq rec_recstu_id }" var="check">
            <h1 class="text-center">请勿重复推荐</h1>
        </c:if>
    </c:forEach>
    <c:if test="${not check}">
        <sql:query dataSource="${stuff}" var="recommend_people">select rp_id,rp_name from recommend_people where rp_vali='是';</sql:query>
        <sql:query dataSource="${stuff}" var="recommend_from">select recf_id,recf_desc from recommend_from;</sql:query>
        <div class="row">
            <div class="col-md-2"></div>
            <div class="col-md-8">
                <form method="post" action="Stuff_Recommend_Page.jsp">
                    <select class="form-control" name="rr_id">
                        <c:forEach var="row" items="${recommend_requirements.rows}">
                            <option value="${row.rr_id}">${row.rr_id}</option>
                        </c:forEach>
                    </select>
                    <br/>
                    <select class="form-control" name="rp_id">
                        <c:forEach var="row" items="${recommend_people.rows}">
                            <option value="${row.rp_id}">${row.rp_name}</option>
                        </c:forEach>
                    </select>
                    <br/>
                    <select class="form-control" name="recf_id">
                        <c:forEach var="row" items="${recommend_from.rows}">
                            <option value="${row.recf_id}">${row.recf_desc}</option>
                        </c:forEach>
                    </select>
                    <button type="submit" class="btn btn-default">Submit</button>
                </form>
            </div>
            <div class="col-md-2"></div>
        </div>
    </c:if>
</c:if>

<c:if test="${ httpmethod eq 'POST' }">
        <c:forEach var="row" items="${recommend_requirements.rows}">
            <c:if test="${ row.rr_id eq param.rr_id }">
                <c:set var="rr_hr_id" value="${row.rr_hr_id}"/>
            </c:if>
        </c:forEach>
        <sql:update dataSource="${stuff}" var="recommend">
            INSERT INTO recommend VALUES (${param.rp_id},${rec_recstu_id},${rec_recres_id},${rec_recsta_id},${param.rr_id},${rr_hr_id},${param.recf_id});
        </sql:update>
        <c:out value="插入成功"/>
</c:if>
</table>
</body>
</html>