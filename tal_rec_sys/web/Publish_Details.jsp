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
    <title>Title</title>
    <%
        LoginUser user = (LoginUser) session.getAttribute("user");
        int ri_id = Integer.parseInt(request.getParameter("ri_id"));
        request.setAttribute("ri_id",ri_id);
        if(!user.getJob_type().toString().equals("人事人员")){
            response.sendRedirect(eErrorPage.PERMISSIONDENY.toString());
            return;
        }
        CommonConnection.setConnectUser(ConnectUser.HR);
    %>
</head>
<body>
<div>
    <form id="login_form" action="publish_requirement">
        招聘人数<input type="number" name="rr_num" id="rr_num"><br/>
        工作地点<select id="rr_wp_id" name="rr_wp_id">
        <%
            ResultSet workplace = CommonConnection.makeQuery("select wp_id,wp_name from work_place");
            while(workplace.next()){
        %>
        <option value="<%=workplace.getString("wp_id")%>"><%=workplace.getString("wp_name")%></option>
        <%
            }
        %>
        </select><br/>
        员工类型<select id="rr_st_id" name="rr_st_id">
        <%
            ResultSet stuff_type = CommonConnection.makeQuery("select st_id,st_name from stuff_type");
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
            ResultSet emergecy = CommonConnection.makeQuery("select ed_id,ed_name from emergency_degree");
            while(emergecy.next()){
        %>
        <option value="<%=emergecy.getString("ed_id")%>"><%=emergecy.getString("ed_name")%></option>
        <%
            }
        %>
        </select><br/>
        特殊要求<input type="text" name="rr_spreq" id="rr_spreq"><br/>
        <input type="submit" value="提交" ><input type="reset" value="清空">
    </form>
    <br/>
    <a href="Publish_Requirements.jsp"></a>
</div>
</body>
</html>
