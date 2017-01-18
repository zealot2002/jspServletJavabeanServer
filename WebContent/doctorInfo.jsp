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
   <tipe>医生管理->医生列表->医生基本信息</tipe>
</head>

<body>
<table border="1">
<tr>
<td>姓名</td>
<td>性别</td>
<td>医院</td>
<td>科室</td>
<td>职称</td>
<td>职务</td>
<td>擅长及个人简介</td>
<td>手机号码</td>
<td>医生执业证(正面)</td>
<td>医生执业证(背面)</td>
<td>二维码图片</td>
<td>认证状态</td>


</tr>
<%
	DoctorBean bean = new DoctorBean();  
	String id = (String) session.getAttribute("id");
	DoctorBO bo = bean.getObjById(id);
	List<String> list = bo.getSmallImgList();
%>
<tr>
<td><%=bo.getName() %></td>
<td><%=bo.getSex() %></td>
<td><%=bo.getHospital()%></td>
<td><%=bo.getDepartment()%></td>
<td><%=bo.getJobTitle()%></td>
<td><%=bo.getJobDuty()%></td>
<td><%=bo.getExpertise()%></td>
<td><%=bo.getPhone()%></td>

<td>
<!-- 工作证 -->
<%
String smallImgUri = "";
if(list.size()>0){
	smallImgUri = list.get(0);
}
String bigImgUri="";
if(bo.getBigImgList().size()>0){
	bigImgUri = bo.getBigImgList().get(0);
}

%>
<a href="ShowImgServlet.do?method=showImg&imgUri=<%=bigImgUri%>">
<img src="<%=smallImgUri%>" width="100" height="100"/>  
</a>

</td>

<td>
<!-- 执业证-->
<%
String smallImgUri2 = "";
String bigImgUri2 = "";

if(list.size()>1){
	smallImgUri2 = list.get(1);
}
if(bo.getBigImgList().size()>1){
	bigImgUri2 = bo.getBigImgList().get(1);
}


%>
<a href="ShowImgServlet.do?method=showImg&imgUri=<%=bigImgUri2%>">
<img src="<%=smallImgUri2%>" width="100" height="100""/>  
</a>

</td>
<td>
<a href="ShowImgServlet.do?method=showQrcode&content=<%=bo.getBarCode()%>">
<img src="CodeServlet.do?method=showQrcode&content=<%=bo.getBarCode()%>" width="100px" height="100px""/>  
</a>
</td>

<td><%=bo.getState()%></td>

</tr>
</table>
</body>
</html>
