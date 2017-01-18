<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@page import="com.rain.javabean.ConsultBean"%>
<%@page import="com.rain.pojo.ConsultBO"%>


<%
	String path = request.getContextPath();
 String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
 
 <!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
 <html>
<head>
<%@ include  file="tab.jsp"%>
   <title>在线咨询</title>
</head>

<body>
<table border="1">
<tr>
<td>编号</td>
<td>第一个人</td>
<td>第一个人手机号</td>
<td>第二个人</td>
<td>第二个人手机号</td>
<td>状态</td>
<td>加好友的时间</td>

</tr>
<%
	ConsultBean bean=new ConsultBean();
List<ConsultBO> list =bean.getList();    
for(ConsultBO bo:list)
{
%>
<tr>
<td><%=bo.getId() %></td>
<td><%=bo.getFirstPersonName() %></td>
<td><%=bo.getFirstPersonPhone()%></td>
<td><%=bo.getSecondPersonName() %></td>
<td><%=bo.getSecondPersonPhone() %></td>
<td><%=bo.getState() %></td>
<td><%=bo.getCreateTime() %></td>

</tr>
<%}
%>
</table>
</body>
</html>
