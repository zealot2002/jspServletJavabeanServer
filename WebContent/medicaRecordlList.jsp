<%@page import="com.rain.pojo.MedicalRecordBO"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@page import="com.rain.javabean.MedicalRecordBean"%>
<%@page import="com.rain.pojo.MedicalRecordBO"%>


<%
 String path = request.getContextPath();
 String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
 %>
 
 <!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
 <html>
<head>
<%@ include  file="tab.jsp"%>
   <tipe>患者管理->患者列表->患者病例列表</tipe>
</head>

<body>
<table border="1">
<tr>
<td>编号</td>
<td>疾病名称</td>
<td>所在医院</td>
<td>所在科室</td>
<td>就诊时间</td>
<td>操作</td>

</tr>
<%
MedicalRecordBean medicalRecordBean=new MedicalRecordBean();
String id = (String) session.getAttribute("id");
List<MedicalRecordBO> list = medicalRecordBean.getList(id);   
for(MedicalRecordBO bo:list)
{%>
<tr>
<td><%=bo.getId() %></td>
<td><%=bo.getDiseaseName() %></td>
<td><%=bo.getHospital()%></td>
<td><%=bo.getDepartment() %></td>
<td><%=bo.getVisitTime()%></td>
<td><a href="MedicalRecordServlet.do?method=showInfo&id=<%=bo.getId()%>">查看</a>  


</td>
</tr>
<%}
%>
</table>
</body>
</html>
