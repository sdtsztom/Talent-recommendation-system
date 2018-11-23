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
    <title>招聘需求大厅</title>
    <link rel="stylesheet" href="https://cdn.bootcss.com/twitter-bootstrap/4.1.3/css/bootstrap.css"/>
    <script src="https://cdn.bootcss.com/twitter-bootstrap/4.1.3/js/bootstrap.js"></script>
</head>
<body>
<%
    session.setAttribute("user",new LoginUser("1","1","1","1")); //测试用session
%>
<sql:setDataSource var="dev" driver="com.microsoft.sqlserver.jdbc.SQLServerDriver" url="jdbc:sqlserver://localhost:1433;DatabaseName=tal_rec_sys" user="u_dev" password="12345678a"/>
<sql:setDataSource var="stuff" driver="com.microsoft.sqlserver.jdbc.SQLServerDriver" url="jdbc:sqlserver://localhost:1433;DatabaseName=tal_rec_sys" user="u_stuff" password="12345678a"/>
<c:set var="rec_recstu_id" value="${user.id}"/>
<c:set var="sql" value="select rr_id,
work_place.wp_name,
emergency_degree.ed_name,emergency_degree.ed_desc,
stuff_type.st_name,stuff_type.st_desc,
stuff.stf_name,
job.jb_name,job.jb_desc,job.jb_sal,
requirements_common_info.ri_desc,requirements_common_info.ri_req,
recruitment_requirements_stage.rrs_desc,
rr_num,rr_el,rr_ept,rr_spreq
from recruitment_requirements
inner join work_place on work_place.wp_id = rr_wp_id
inner join emergency_degree on emergency_degree.ed_id = rr_ed_id
inner join stuff_type on stuff_type.st_id = rr_st_id
inner join stuff on stuff.stf_id = rr_hr_id
inner join requirements_common_info on requirements_common_info.ri_id = rr_ri_id
inner join job on requirements_common_info.ri_job_id = job.jb_id
inner join recruitment_requirements_stage on recruitment_requirements_stage.rrs_id = rr_sta_id
where rr_sta_id != 1"/>
<sql:query dataSource="${stuff}" var="recruitment_requirements">${sql}</sql:query>
<div class="row">
    <div class="col-md-1"></div>
    <div class="col-md-10">
        <table class="table">
            <tr>
                <th>需求id</th>
                <th>工作地点</th>
                <th>紧急度</th>
                <th>HR姓名</th>
                <th>职位信息</th>
                <th>岗位信息</th>
                <th>处理阶段</th>
                <th>招聘人数</th>
                <th>截止日期</th>
                <th>工作年限</th>
                <th>额外需求</th>
                <th>推荐人才</th>
            </tr>
            <c:forEach var="row" items="${recruitment_requirements.rows}">
                <tr>
                    <td>${row.rr_id}</td>
                    <td>${row.wp_name}</td>
                    <td>${row.ed_name} : ${row.ed_desc}</td>
                    <td>${row.stf_name}</td>
                    <td>职位:${row.jb_name}<br/>工作描述:${row.jb_desc}<br/>薪酬:￥${row.jb_sal}"</td>
                    <td>岗位描述:${row.ri_desc}<br/>岗位需求:${row.ri_req}</td>
                    <td>${row.rrs_desc}</td>
                    <td>${row.rr_num}</td>
                    <td>${row.rr_el}</td>
                    <td>${row.rr_ept}</td>
                    <td>${row.spreq}</td>
                    <td><a href="<c:url value="Stuff_Recommend_Page.jsp"/>">推荐人才</a></td>
                </tr>
            </c:forEach>
        </table>
    </div>
    <div class="col-md-1"></div>
</div>
<div class="row">
    <div class="col-md-4"></div>
    <div class="col-md-4">
        <ul class="pagination">
            <li class="page-item disabled"><a class="page-link" href="#"><<</a></li>
            <li class="page-item active"><a class="page-link" href="#">1</a></li>
            <li class="page-item"><a class="page-link" href="#">2</a></li>
            <li class="page-item"><a class="page-link" href="#">3</a></li>
            <li class="page-item"><a class="page-link" href="#">>></a></li>
        </ul>
    </div>
    <div class="col-md-4"></div>
</div>

</table>
</body>
</html>