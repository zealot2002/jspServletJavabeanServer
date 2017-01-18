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
   <tipe>患者管理->患者列表</tipe>
</head>

<body>
<table border="1">
<tr>
<td>编号</td>
<td>姓名</td>
<td>手机号</td>
<td>身份证号</td>
<td>所在地区</td>
<td>注册时间</td>
<td>操作</td>

</tr>
<%
	PatientBean patientBean=new PatientBean();
List<PatientBO> list = patientBean.getList();   
for(PatientBO bo:list)
{
%>
<tr>
<td><%=bo.getId() %></td>
<td><%=bo.getName() %></td>
<td><%=bo.getPhone() %></td>
<td><%=bo.getIdCard() %></td>
<td><%=bo.getCity() %></td>
<td><%=bo.getRegisterTime() %></td>
<td><a href="PatientServlet.do?method=showInfo&id=<%=bo.getId()%>">基本信息</a>  
<a href="MedicalRecordServlet.do?method=getList&id=<%=bo.getId()%>">病例</a>


</td>
</tr>
<%}
%>
</table>
</body>
</html>
