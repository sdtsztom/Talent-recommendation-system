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
<c:set var="httpmethod" value="${pageContext.request.method}"/>
<% session.setAttribute("user",new LoginUser("1","1","1","1")); //测试用session %>
<sql:setDataSource var="dev" driver="com.microsoft.sqlserver.jdbc.SQLServerDriver" url="jdbc:sqlserver://localhost:1433;DatabaseName=tal_rec_sys" user="u_dev" password="12345678a"/>
<sql:setDataSource var="stuff" driver="com.microsoft.sqlserver.jdbc.SQLServerDriver" url="jdbc:sqlserver://localhost:1433;DatabaseName=tal_rec_sys" user="u_stuff" password="12345678a"/>
<c:set var="rec_recstu_id" value="${user.id}"/>
<c:set var="selectAll" value="select * from"/>
<sql:query dataSource="${stuff}" var="recruitment_requirements">${selectAll} recruitment_requirements;</sql:query>
<sql:query dataSource="${stuff}" var="work_place">${selectAll} work_place;</sql:query>
<sql:query dataSource="${stuff}" var="stuff_type">${selectAll} stuff_type;</sql:query>
<sql:query dataSource="${stuff}" var="requirements_common_info">select ri_id,ri_desc,ri_req,departments.dp_name from requirements_common_info inner join departments on ri_dpt_id = departments.dp_id;</sql:query>
<sql:query dataSource="${stuff}" var="emergency_degree">${selectAll} emergency_degree;</sql:query>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <title>修改招聘需求</title>
    <link rel="stylesheet" href="https://cdn.bootcss.com/twitter-bootstrap/4.1.3/css/bootstrap.css"/>
    <script src="https://cdn.bootcss.com/jquery/3.3.1/jquery.min.js"></script>
    <script>
        /* 根据选择的rr_id自动更新表单内容 */
        <c:forEach var="row" items="${recruitment_requirements.rows}">
            var v${row.rr_id} = ["${row.rr_num}","${row.rr_wp_id}","${row.rr_st_id}","${row.rr_el}","${row.rr_ept}","${row.rr_ri_id}","${row.rr_ed_id}","${row.rr_spreq}"];
        </c:forEach>
        function getValue(rr_id,i) {
            return (eval("v"+rr_id)[i]);
        };
        $(document).ready(function(){
            $("#rr_num").val(getValue(1,0));
            $("#wp_id").val(getValue(1,1));
            $("#st_id").val(getValue(1,2));
            $("#rr_el").val(getValue(1,3));
            $("#rr_ept").val(getValue(1,4));
            $("#ri_id").val(getValue(1,5));
            $("#ed_id").val(getValue(1,6));
            $("#rr_spreq").val(getValue(1,7));
            $("#rr_id").change(function(){
                var rr_id = $("#rr_id").val();
                $("#rr_num").val(getValue(rr_id,0));
                $("#wp_id").val(getValue(rr_id,1));
                $("#st_id").val(getValue(rr_id,2));
                $("#rr_el").val(getValue(rr_id,3));
                $("#rr_ept").val(getValue(rr_id,4));
                $("#ri_id").val(getValue(rr_id,5));
                $("#ed_id").val(getValue(rr_id,6));
                $("#rr_spreq").val(getValue(rr_id,7));
            });
        });
    </script>
</head>
<body>
<c:if test="${ httpmethod eq 'GET' }">
    <div class="row">
        <div class="col-md-2"></div>
        <div class="col-md-8">
            <form method="post" action="Republish_Demand.jsp.jsp">
                <label>序号</label>
                <select class="form-control" name="rr_id" id="rr_id">
                    <c:forEach var="row" items="${recruitment_requirements.rows}">
                        <option value="${row.rr_id}">${row.rr_id}</option>
                    </c:forEach>
                </select>
                <div class="form-group">
                    <label for="rr_num">招聘人数</label>
                    <input type="text" class="form-control" id="rr_num" name="rr_num" placeholder="招聘人数">
                </div>
                <label>工作地点</label>
                <select class="form-control" name="wp_id" id="wp_id">
                    <c:forEach var="row" items="${work_place.rows}">
                        <option value="${row.wp_id}">${row.wp_name}</option>
                    </c:forEach>
                </select>
                <label>员工类型</label>
                <select class="form-control" name="jt_id" id="jt_id">
                    <c:forEach var="row" items="${stuff_type.rows}">
                        <option value="${row.st_id}">${row.st_name} : ${row.st_desc}</option>
                    </c:forEach>
                </select>
                <div class="form-group">
                    <label for="rr_el">截止日期</label>
                    <input type="text" class="form-control" id="rr_el" name="rr_el" placeholder="截止日期">
                </div>
                <div class="form-group">
                    <label for="rr_num">工作年限</label>
                    <input type="text" class="form-control" id="rr_ept" name="rr_ept" placeholder="工作年限">
                </div>
                <label>岗位招聘信息</label>
                <select class="form-control" name="ri_id" id="ri_id">
                    <c:forEach var="row" items="${requirements_common_info.rows}">
                        <option value="${row.ri_id}">${row.ri_desc} : ${row.ri_req} - ${row.dp_name}</option>
                    </c:forEach>
                </select>
                <label>紧急度</label>
                <select class="form-control" name="ed_id" id="ed_id">
                    <c:forEach var="row" items="${emergency_degree.rows}">
                        <option value="${row.ed_id}">${row.ed_name}</option>
                    </c:forEach>
                </select>
                <div class="form-group">
                    <label for="rr_num">额外需求</label>
                    <input type="text" class="form-control" id="rr_spreq" name="rr_spreq" placeholder="额外需求">
                </div>
                <button type="submit" class="btn btn-default">Submit</button>
            </form>
        </div>
        <div class="col-md-2"></div>
    </div>
</c:if>

<c:if test="${ httpmethod eq 'POST' }">
    <% request.setCharacterEncoding("UTF-8"); %>
    <%--<sql:update dataSource="${stuff}" var="recommend_person">
        INSERT INTO recommend_people VALUES (${param.deg_id},${param.uni_id},'${param.name}','${param.sex}','${param.age}','${param.tel}','${param.email}','${param.stu}','${param.grt}','${param.major}','${param.abi}','${param.path}','是',${param.jb_id});
    </sql:update>--%>
    <c:out value="插入成功"/>
</c:if>
</table>
</body>
</html>