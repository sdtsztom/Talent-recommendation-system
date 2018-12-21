<%@ page import="util.CommonConnection" %>
<%@ page import="ienum.ConnectUser" %>
<%@ page import="bean.LoginUser" %>
<%@ page import="ienum.eErrorPage" %>
<%@ page import="table.TableBase" %>
<%@ page import="bean.RP_Details" %><%--
  Created by IntelliJ IDEA.
  User: sdtsz
  Date: 2018/11/15
  Time: 16:37
  To change this template use File | Settings | File Templates.
  TODO:
    1. 打开简历
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Rcommend Person Detais</title>
    <link href="https://cdn.bootcss.com/twitter-bootstrap/4.1.3/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<%
    String rpid=request.getParameter("rpid");
    RP_Details rp_details=CommonConnection.<RP_Details>beanQuery("select * from recommend_person_details where rp_id="+rpid,new RP_Details(),ConnectUser.HR);
    String [][]table_content={rp_details.Convert2LineContent()};
    TableBase table=new TableBase(table_content);
    String []head=new String []{"rp_id","名字","年龄","性别","电话","email","职位","学位","毕业学校","是否在读","毕业时间","主修专业","专业技能"};;
    out.print(table.genVerticalHTML(head,"class=\"table table-sm\""));
%>
</body>
</html>
