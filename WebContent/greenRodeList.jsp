<%@page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@page import="com.rain.javabean.GreenRodeBean"%>
<%@page import="com.rain.pojo.GreenRodeBO"%>


<%
	String path = request.getContextPath();
 String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<%@ include  file="tab.jsp"%>
   <tipe>绿色通道管理->列表</tipe>
</head>

<body>
<table border="1">
<tr>
<td>编号</td>
<td>姓名</td>
<td>手机号</td>
<td>需要服务</td>
<td>提交时间</td>
<td>状态</td>

</tr>
<%
	GreenRodeBean greenRodeBean=new GreenRodeBean();
	List<GreenRodeBO> list = greenRodeBean.getList();
	for(GreenRodeBO bo:list)
	{
%>
		<tr>
		<td><%=bo.getId()%></td>
		<td><%=bo.getPatient()%></td>
		<td><%=bo.getPatientPhone()%></td>
		<td><%=bo.getNeedService()%></td>
		<td><%=bo.getCreateTime()%></td>
		<td><%=bo.getState()%></td>
		</tr>
		<%}
	%>
</table>
</body>
</html>
