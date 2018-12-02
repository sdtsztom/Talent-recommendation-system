<%@ page import="bean.LoginUser" %>
<%@ page import="ienum.eErrorPage" %>
<%@ page import="util.CommonConnection" %>
<%@ page import="ienum.ConnectUser" %>
<%@ page import="java.sql.ResultSet" %><%--
  Created by IntelliJ IDEA.
  User: 10442
  Date: 2018/11/26
  Time: 10:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>需求详情填写</title>
    <meta charset="utf-8" />
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
    <script src="https://oss.maxcdn.com/libs/respond.js/1.3.0/respond.min.js"></script>
    <script src="https://cdn.staticfile.org/jquery/1.10.2/jquery.min.js"></script>

    <link href="http://netdna.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.css" rel="stylesheet">
    <script src="http://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.js"></script>
    <script src="http://netdna.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.js"></script>
    <link href="http://cdnjs.cloudflare.com/ajax/libs/summernote/0.8.11/summernote.css" rel="stylesheet">
    <script src="http://cdnjs.cloudflare.com/ajax/libs/summernote/0.8.11/summernote.js"></script>

    <script>
        function checkForm(){
            var str= $('#summernote').summernote('code');
            document.getElementById("rr_spreq").value=str;
            document.getElementById("publish").submit();
        }
    </script>
    <%
        LoginUser user = (LoginUser) session.getAttribute("user");
        int ri_id = Integer.parseInt(request.getParameter("ri_id"));
        session.setAttribute("ri_id",ri_id);
        if(!user.getJob_type().toString().equals("人事人员")){
            response.sendRedirect(eErrorPage.PERMISSIONDENY.toString());
            return;
        }
        ResultSet workplace = CommonConnection.makeQuery("select wp_id,wp_name from work_place",ConnectUser.HR);
        ResultSet stuff_type = CommonConnection.makeQuery("select st_id,st_name from stuff_type",ConnectUser.HR);
        ResultSet emergency = CommonConnection.makeQuery("select ed_id,ed_name from emergency_degree",ConnectUser.HR);
    %>
</head>
<body>
<br/><br/><br/><br/>
<div class="container">
    <div class="row clearfix">
        <div class="col-md-12 column">
            <form id="publish" action="/publish_requirement"  method="post">
                <div class="form-group">
                    <label for="rr_num">招聘人数</label><input type="number" name="rr_num" id="rr_num" class="form-control"/>
                </div>
                <div class="form-group">
                    <label for="rr_wp_id">工作地点</label>
                    <select class="form-control" id="rr_wp_id" name="rr_wp_id">
                        <%
                            while(workplace.next()){
                        %>
                        <option value="<%=workplace.getString("wp_id")%>"><%=workplace.getString("wp_name")%></option>
                        <%
                            }
                        %>
                    </select>
                </div>
                <div class="form-group">
                    <label for="rr_wp_id">员工类型</label>
                    <select class="form-control" id="rr_st_id" name="rr_st_id">
                        <%
                            while(stuff_type.next()){
                        %>
                        <option value="<%=stuff_type.getString("st_id")%>"><%=stuff_type.getString("st_name")%></option>
                        <%
                            }
                        %>
                    </select>
                </div>
                <div class="form-group">
                    <label for="rr_el">截止日期</label><br/>
                    <input type="datetime-local" class="form-control" id="rr_el" name="rr_el"/>
                </div>
                <div class="form-group">
                    <label for="rr_ept">工作年限</label><input type="number"name="rr_ept" id="rr_ept" class="form-control"/>
                </div>
                <div class="form-group">
                    <label for="rr_ed_id">紧急度</label>
                    <select class="form-control" id="rr_ed_id" name="rr_ed_id">
                        <%
                            while(emergency.next()){
                        %>
                        <option value="<%=emergency.getString("ed_id")%>"><%=emergency.getString("ed_name")%></option>
                        <%
                            }
                        %>
                    </select>
                </div>
                <div class="form-group">
                    <label for="summernote">特殊要求</label>
                    <div id="summernote"><p></p></div>
                    <script>
                        $(document).ready(function() {
                            $('#summernote').summernote();
                        });
                    </script>
                </div>
                <div class="form-group">
                    <input type="hidden" name="rr_spreq" id="rr_spreq" class="form-control"/>
                </div>
                <button type="button" class="btn btn-default" onclick="checkForm()">提交</button>
            </form>
            <br><br><br><br>
        </div>
    </div>
</div>
</body>
</html>
