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
   <tipe>加号管理->加号列表</tipe>
</head>

<body>
<table border="1">
<tr>
<td>编号</td>
<td>医生</td>
<td>患者</td>
<td>患者手机号</td>
<td>状态</td>
<td>下单时间</td>
<td>操作</td>

</tr>
<%
AdditionalRegisterBean bean=new AdditionalRegisterBean();
List<AdditionalRegisterBO> list = bean.getList();   
for(AdditionalRegisterBO bo:list)
{%>
<tr>
<td><%=bo.getId() %></td>
<td><%=bo.getDoctor() %></td>
<td><%=bo.getPatient() %></td>
<td><%=bo.getPatientPhone() %></td>
<td><%=bo.getState()%></td>
<td><%=bo.getCreateTime()%></td>
<td><a href="AdditionalRegisterServlet.do?method=showInfo&id=<%=bo.getId()%>">详情</a>  
<a href="MedicalRecordServlet.do?method=showInfo&id=<%=bo.getMedicalRecordId()%>">病例</a>


</td>
</tr>
<%}
%>
</table>
</body>
</html>
