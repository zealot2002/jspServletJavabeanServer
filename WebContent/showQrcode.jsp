<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@page import="com.rain.javabean.OSSSignature"%>
<html>
<head>
<%@ include  file="tab.jsp"%>
</head>
<body>
<% 
String content = (String) session.getAttribute("content");

%>
<div style="text-align:center; width:220x; height:220;">
<img src="CodeServlet.do?method=showQrcode&content=<%=content%>" style="vertical-align:middle;" width="200" height="200" />
</div>


</body>
</html>
