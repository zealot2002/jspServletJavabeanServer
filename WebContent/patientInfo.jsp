<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@page import="com.rain.javabean.PatientBean"%>
<%@page import="com.rain.pojo.PatientBO"%>


<%
	String path = request.getContextPath();
 String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
 
 <!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
 <html>
<head>
<%@ include  file="tab.jsp"%>
   <tipe>患者管理->患者列表->患者基本信息</tipe>
</head>

<body>
<table border="1">
<tr>
<td>姓名</td>
<td>性别</td>
<td>生日</td>
<td>所在省份</td>
<td>所在城市</td>
<td>身份证号</td>
<td>手机号码</td>

</tr>
<%
	PatientBean patientBean = new PatientBean();  
String id = (String) session.getAttribute("id");
PatientBO info = patientBean.getObjById(id);
%>
<tr>
<td><%=info.getName() %></td>
<td><%=info.getSex() %></td>
<td><%=info.getBirthday() %></td>
<td><%=info.getProvince() %></td>
<td><%=info.getCity() %></td>
<td><%=info.getIdCard() %></td>
<td><%=info.getPhone() %></td>

</tr>
</table>
</body>
</html>
