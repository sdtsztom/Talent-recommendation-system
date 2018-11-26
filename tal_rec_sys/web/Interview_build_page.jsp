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
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt" %>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <title>面试建立页面</title>
    <link rel="stylesheet" href="https://cdn.bootcss.com/twitter-bootstrap/4.1.3/css/bootstrap.css"/>
</head>
<body>
<c:set var="httpmethod" value="${pageContext.request.method}"/>
<%
    session.setAttribute("user",new LoginUser("1","1","1","1")); //测试用session
%>
<sql:setDataSource var="dev" driver="com.microsoft.sqlserver.jdbc.SQLServerDriver" url="jdbc:sqlserver://localhost:1433;DatabaseName=tal_rec_sys" user="u_dev" password="12345678a"/>
<sql:setDataSource var="hr" driver="com.microsoft.sqlserver.jdbc.SQLServerDriver" url="jdbc:sqlserver://localhost:1433;DatabaseName=tal_rec_sys" user="u_hr" password="12345678a"/>
<c:set var="rec_recstu_id" value="${user.id}"/>
<c:if test="${ httpmethod eq 'GET' }">
    <sql:query dataSource="${hr}" var="interview_place">select ip_id,ip_detail from interview_place;</sql:query>
    <sql:query dataSource="${hr}" var="recommend_people">select rp_id,rp_name from recommend_people where rp_vali='是';</sql:query>
    <sql:query dataSource="${hr}" var="stuff">select stf_id,stf_name from stuff;</sql:query>
    <sql:query dataSource="${hr}" var="recruitment_requirements">select rr_id from recruitment_requirements where rr_st_id != 1;</sql:query>

    <div class="row">
        <div class="col-md-2"></div>
        <div class="col-md-8">
            <form method="post" action="Interview_build_page.jsp">
                <label>面试地点</label>
                <select class="form-control" name="ip_id">
                    <c:forEach var="row" items="${interview_place.rows}">
                        <option value="${row.ip_id}">${row.ip_detail}</option>
                    </c:forEach>
                </select>
                <label>被推荐人</label>
                <select class="form-control" name="rp_id">
                    <c:forEach var="row" items="${recommend_people.rows}">
                        <option value="${row.rp_id}">${row.rp_name}</option>
                    </c:forEach>
                </select>
                <label>处理HR</label>
                <select class="form-control" name="dealHR_id">
                    <c:forEach var="row" items="${stuff.rows}">
                        <option value="${row.stf_id}">${row.stf_name}</option>
                    </c:forEach>
                </select>
                <label>需求id</label>
                <select class="form-control" name="rr_id">
                    <c:forEach var="row" items="${recruitment_requirements.rows}">
                        <option value="${row.rr_id}">${row.rr_id}</option>
                    </c:forEach>
                </select>
                <div class="form-group">
                    <label for="itv_time">面试时间</label>
                    <input type="datetime-local" class="form-control" id="itv_time" name="itv_time">
                </div>
                <label>面试官</label>
                <select class="form-control" name="exmer_id">
                    <c:forEach var="row" items="${stuff.rows}">
                        <option value="${row.stf_id}">${row.stf_name}</option>
                    </c:forEach>
                </select>
                <div class="form-group">
                    <label for="itv_detail">面试细节</label>
                    <input type="text" class="form-control" id="itv_detail" name="itv_detail">
                </div>
                <button type="submit" class="btn btn-default">Submit</button>
            </form>
        </div>
        <div class="col-md-2"></div>
    </div>
</c:if>

<c:if test="${ httpmethod eq 'POST' }">
    <fmt:parseDate value="${param.itv_time}" var="parsedEmpDate" pattern="yyyy-MM-dd'T'HH:mm" />
    <fmt:formatDate var="parsed_itv_time" pattern="yyyy-MM-dd HH:mm:ss.SSS" value="${parsedEmpDate}" />
    <sql:update dataSource="${hr}" var="recommend">
        INSERT INTO interview VALUES(${param.ip_id},7,${param.rp_id},${param.dealHR_id},${param.rr_id},1,'${parsed_itv_time}',${param.exmer_id},'${param.itv_detail}')
    </sql:update>
    <c:out value="插入成功"/>
</c:if>
</body>
</html>