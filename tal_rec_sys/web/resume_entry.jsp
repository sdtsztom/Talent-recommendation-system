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
    <title>被推荐人信息录入</title>
    <link rel="stylesheet" href="https://cdn.bootcss.com/twitter-bootstrap/4.1.3/css/bootstrap.css"/>
</head>
<body>
<c:set var="httpmethod" value="${pageContext.request.method}"/>
<% session.setAttribute("user",new LoginUser("1","1","1","1")); //测试用session %>
<sql:setDataSource var="dev" driver="com.microsoft.sqlserver.jdbc.SQLServerDriver" url="jdbc:sqlserver://localhost:1433;DatabaseName=tal_rec_sys" user="u_dev" password="12345678a"/>
<sql:setDataSource var="stuff" driver="com.microsoft.sqlserver.jdbc.SQLServerDriver" url="jdbc:sqlserver://localhost:1433;DatabaseName=tal_rec_sys" user="u_stuff" password="12345678a"/>
<c:set var="rec_recstu_id" value="${user.id}"/>
<c:if test="${ httpmethod eq 'GET' }">
    <sql:query dataSource="${stuff}" var="degree">select * from degree;</sql:query>
    <sql:query dataSource="${stuff}" var="university">select * from university;</sql:query>
    <sql:query dataSource="${stuff}" var="job">select * from job;</sql:query>
    <div class="row">
        <div class="col-md-2"></div>
        <div class="col-md-8">
            <form method="post" action="resume_entry.jsp">
                <div class="form-group">
                    <label for="name">姓名</label>
                    <input type="text" class="form-control" id="name" name="name" placeholder="name">
                </div>
                <div class="form-group">
                    <label for="age">年龄</label>
                    <input type="text" class="form-control" id="age" name="age" placeholder="age">
                </div>
                <div class="form-group">
                    <label for="tel">电话</label>
                    <input type="text" class="form-control" id="tel" name="tel" placeholder="tel">
                </div>
                <div class="form-group">
                    <label for="email">邮箱</label>
                    <input type="email" class="form-control" id="email" name="email" placeholder="email">
                </div>
                <div class="form-group">
                    <label for="grt">毕业时间</label>
                    <input type="date" class="form-control" name="grt" id="grt">
                </div>
                <div class="form-group">
                    <label for="major">专业</label>
                    <input type="text" class="form-control" id="major" name="major" placeholder="major">
                </div>
                <div class="form-group">
                    <label for="abi">专业技能</label>
                    <input type="text" class="form-control" id="abi" name="abi" placeholder="abi">
                </div>
                <div class="form-group">
                    <label for="path">简历路径</label>
                    <input type="text" class="form-control" id="path" name="path" placeholder="path">
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
                <button type="submit" class="btn btn-default">Submit</button>
            </form>
        </div>
        <div class="col-md-2"></div>
    </div>
</c:if>

<c:if test="${ httpmethod eq 'POST' }">
    <% request.setCharacterEncoding("UTF-8"); %>
    <sql:update dataSource="${stuff}" var="recommend_person">
        INSERT INTO recommend_people VALUES (${param.deg_id},${param.uni_id},'${param.name}','${param.sex}','${param.age}','${param.tel}','${param.email}','${param.stu}','${param.grt}','${param.major}','${param.abi}','${param.path}','是',${param.jb_id});
    </sql:update>
    <c:out value="插入成功"/>
</c:if>
</table>
</body>
</html>