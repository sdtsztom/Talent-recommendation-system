<%
    /**
     * @Created: xsy
     * @Date: 2018.11.20
     */
%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<c:set var="myvar" value="sss"/>
<c:out value="${myvar}"/>
<sql:setDataSource var="myMSSQL" driver="com.microsoft.sqlserver.jdbc.SQLServerDriver" url="jdbc:sqlserver://localhost:1433;DatabaseName=tal_rec_sys" user="SA" password="12345678"/>
<sql:query dataSource="${myMSSQL}" var="result">
    SELECT * from ;
</sql:query>

<table border="1" width="100%">
    <tr>
        <th>role_id</th>
        <th>role_desc</th>
    </tr>
    <c:forEach var="row" items="${result.rows}">
        <tr>
            <td><c:out value="${row.role_id}"/></td>
            <td><c:out value="${row.role_desc}"/></td>
        </tr>
    </c:forEach>
</table>
</body>
</html>