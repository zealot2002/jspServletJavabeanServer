<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@page import="com.rain.javabean.DoctorBean"%>
<%@page import="com.rain.pojo.DoctorBO"%>


<%
	String path = request.getContextPath();
 String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
 
 <!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
 <html>
<head>
<%@ include  file="tab.jsp"%>
   <tipe>医生管理->医生列表</tipe>
</head>

<body>

<table border="1">
<tr>
<td>编号</td>
<td>姓名</td>
<td>手机号</td>
<td>医院</td>
<td>科室</td>
<td>注册时间</td>
<td>认证状态</td>
<td>操作</td>

</tr>
<%
DoctorBean doctorBean=new DoctorBean();
List<DoctorBO> list =doctorBean.getList();
for(DoctorBO bo:list)
{
%>
<tr>
<td><%=bo.getId() %></td>
<td><%=bo.getName() %></td>
<td><%=bo.getPhone() %></td>
<td><%=bo.getHospital() %></td>
<td><%=bo.getDepartment() %></td>
<td><%=bo.getRegisterTime() %></td>
<td><%=bo.getState() %></td>
<td><a href="DoctorServlet.do?method=showInfo&id=<%=bo.getId()%>">基本信息</a>  
</td>
</tr>
<%}
%>
</table>
</body>
</html>
