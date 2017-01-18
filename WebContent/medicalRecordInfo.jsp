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
   <tipe>患者管理->患者列表->患者病例->查看</tipe>
</script>
</head>

<body>
<table border="1">
<tr>
<td>所在医院</td>
<td>所在科室</td>
<td>就诊时间</td>
<td>疾病名称</td>
<td>病情描述</td>
<td>诊断信息</td>
<td>用药情况</td>
<td>检查资料</td>
</tr>
<%
MedicalRecordBean bean = new MedicalRecordBean();  
String id = (String) session.getAttribute("id");
MedicalRecordBO bo = bean.getObjById(id);
List<String> list = bo.getSmallImgList();
%>
<tr>
<td><%=bo.getHospital() %></td>
<td><%=bo.getDepartment()%></td>
<td><%=bo.getVisitTime() %></td>
<td><%=bo.getDiseaseName() %></td>
<td><%=bo.getDescription()%></td>
<td><%=bo.getDeagnosticInfo()%></td>
<td><%=bo.getMedication()%></td>
<td>
<%
for(int i=0;i<list.size();i++){
String smallImgUri = list.get(i);
String bigImgUri = bo.getBigImgList().get(i);
System.out.println("medicalRecordInfo.jsp :  smallImgUri : "+smallImgUri);
System.out.println("medicalRecordInfo.jsp :  bigImgUri : "+bigImgUri);
%>
<a href="ShowImgServlet.do?method=showImg&imgUri=<%=bigImgUri%>">
<img src="<%=smallImgUri%>" width="50" height="50""/>  
</a>
<%
}
%>
</td>

</tr>
</table>
</body>


<script language="javascript" type="text/javascript"> 
function showImg() 
{ 
	alert("1");
	alert(imgUri);
	
	var url = "showImg.jsp?imgUri="+imgUri;
	window.open(url)
	

	
	/* $.post("showImg.jsp"); */
	/* 
    var url="MedicalRecordServlet.do?";
	url+="?id="+id+"index="+index;
	window.location=url;//访问servlet */
} 
</script>


</html>






