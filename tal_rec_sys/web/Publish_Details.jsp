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
    <link rel="stylesheet" href="/script/themes/default/default.css" />
    <link rel="stylesheet" href="/script/plugins/code/prettify.css" />
    <script charset="utf-8" src="/script/kindeditor-all.js"></script>
    <script charset="utf-8" src="/script/lang/zh-CN.js"></script>
    <script charset="utf-8" src="/script/plugins/code/prettify.js"></script>
    <script>
        KindEditor.ready(function(K) {
            var editor1 = K.create('textarea[name="content1"]', {
                cssPath : '/script/plugins/code/prettify.css',
                uploadJson : '/script/upload_json.jsp',
                fileManagerJson : '/script/file_manager_json.jsp',
                allowFileManager : true,
                afterCreate : function() {
                    var self = this;
                    K.ctrl(document, 13, function() {
                        self.sync();
                        document.forms['example'].submit();
                    });
                    K.ctrl(self.edit.doc, 13, function() {
                        self.sync();
                        document.forms['example'].submit();
                    });
                }
            });
            prettyPrint();
        });
    </script>
    <%
        LoginUser user = (LoginUser) session.getAttribute("user");
        int ri_id = Integer.parseInt(request.getParameter("ri_id"));
        request.setAttribute("ri_id",ri_id);
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
<div>
    <form id="login_form" action="/publish_requirement">
        招聘人数<input type="number" name="rr_num" id="rr_num"><br/>
        工作地点<select id="rr_wp_id" name="rr_wp_id">
        <%
            while(workplace.next()){
        %>
        <option value="<%=workplace.getString("wp_id")%>"><%=workplace.getString("wp_name")%></option>
        <%
            }
        %>
        </select><br/>
        员工类型<select id="rr_st_id" name="rr_st_id">
        <%
            while(stuff_type.next()){
        %>
        <option value="<%=stuff_type.getString("st_id")%>"><%=stuff_type.getString("st_name")%></option>
        <%
            }
        %>
        </select><br/>
        截止日期<input type="datetime-local" id="rr_el" name="rr_el"><br/>
        工作年限<input type="number" name="rr_ept" id="rr_ept"><br/>
        紧急度<select id="rr_ed_id" name="rr_ed_id">
        <%
            while(emergency.next()){
        %>
        <option value="<%=emergency.getString("ed_id")%>"><%=emergency.getString("ed_name")%></option>
        <%
            }
        %>
        </select><br/>
        特殊要求<textarea name="rr_spreq" cols="100" rows="8" style="width:700px;height:200px;visibility:hidden;"></textarea><br/>
        <input type="submit" value="提交" ><input type="reset" value="清空">
    </form>
    <br/>
    <a href="Publish_Requirements.jsp">返回</a>
</div>
</body>
</html>
