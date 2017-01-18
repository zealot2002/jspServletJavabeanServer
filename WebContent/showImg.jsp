<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@page import="com.rain.javabean.OSSSignature"%>
<html>
<head>
<%@ include  file="tab.jsp"%>
</head>
<body>
<% 
String imgUri = (String) session.getAttribute("imgUri");
String uri = OSSSignature.getSignature(imgUri);

%>
<img src="<%=uri %>" width="100%" height="100%"/>

</body>
</html>
