<%@ page import="java.sql.ResultSet" %>
<%@ page import="util.CommonConnection" %>
<%@ page import="ienum.ConnectUser" %>
<%@ page import="bean.LoginUser" %>
<%@ page import="ienum.eErrorPage" %>
<%@ page import="util.iutil" %>
<%@ page import="table.TableBase" %><%--
  Created by IntelliJ IDEA.
  User: sdtsz
  Date: 2018/11/15
  Time: 16:37
  To change this template use File | Settings | File Templates.
  TODO:
    1. 打开简历
    2. 待精简
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Rcommend Person Detais</title>
    <link href="https://cdn.bootcss.com/twitter-bootstrap/4.1.3/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<%
    //验证身份
    LoginUser user=(LoginUser)session.getAttribute("user");
    if(user==null){
        response.sendRedirect(eErrorPage.PERMISSIONDENY.toString());
        return;
    }
    String rpid=request.getParameter("rpid");
    ResultSet rs= CommonConnection.makeQuery("select * from recommend_person_details where rp_id="+rpid,ConnectUser.HR);
    TableBase table=null;
    String []head=null;
    try{
        rs.next();
        String name=rs.getString("rp_name");
        String age=rs.getString("rp_age");
        String sex=rs.getString("rp_sex");
        String tel_num=rs.getString("rp_tel_num");
        String email=rs.getString("rp_email");
        String job=rs.getString("rp_job");
        String deg=rs.getString("rp_deg_name");
        String uni=rs.getString("rp_uni_name");
        String stu=rs.getString("rp_stu");
        String grt=rs.getString("rp_grt");
        String maj=rs.getString("rp_maj");
        String abi=rs.getString("rp_abi");
        String cv_path=rs.getString("rp_res_path");
        rs.close();
        head=new String []{"rec_id","名字","年龄","性别","电话","email","职位","学位","毕业学校","是否在读","毕业时间","主修专业","专业技能"};
        String []content={rpid,name,age,sex,tel_num,email,job,deg,uni,stu,grt,maj,abi};
        String [][]table_content={content};
        table=new TableBase(table_content);
    }catch(Exception e){
        e.printStackTrace();
    }
%>
<%=table.genVerticalHTML(head,"class=\"table table-sm\"")%>
</body>
</html>
