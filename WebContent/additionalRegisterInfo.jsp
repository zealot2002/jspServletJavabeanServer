<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@page import="com.rain.javabean.AdditionalRegisterBean"%>
<%@page import="com.rain.pojo.AdditionalRegisterBO"%>

<%
 String path = request.getContextPath();
 String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
 %>
 
 <!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<%@ include  file="tab.jsp"%>
   <tipe>患者管理->患者列表->患者病例->查看</tipe>
</head>

<body>

<table border="1">
<tr>
<td>医生姓名</td>
<td>医生手机号</td>
<td>所在医院</td>
<td>所在科室</td>
<td>职称</td>
<td>患者姓名</td>
<td>患者手机号</td>
<td>加号时间</td>
<td>状态</td>
<td>操作</td>

</tr>
<%
AdditionalRegisterBean bean = new AdditionalRegisterBean();  
String id = (String) session.getAttribute("id");
AdditionalRegisterBO bo = bean.getObjById(id);
%>
<tr>
<td><%=bo.getDoctor()%></td>
<td><%=bo.getDoctorPhone()%></td>
<td><%=bo.getDoctorHospital()%></td>
<td><%=bo.getDoctorDepartment()%></td>
<td><%=bo.getDoctorJobTitle()%></td>
<td><%=bo.getPatient()%></td>
<td><%=bo.getPatientPhone()%></td>
<td><%=bo.getCreateTime()%></td>
<td><%=bo.getState()%></td>


</table>
</body>

</html>






