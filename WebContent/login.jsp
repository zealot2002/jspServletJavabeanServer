<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<form name="form1" action="EmployeeServlet.do?method=login" method="post"> 
<table width="200" border="1"> 
    <tr> 
        <td colspan="2">登录窗口</td> 
    <tr> 
        <td>账号</td> 
        <td><input type="text" name="account" size="10"></td> 
    </tr> 
    <tr> 
        <td>密码</td> 
        <td><input type="password" name="password" size="10"></td>
    </tr> 
    <tr> 
        <td colspan="2"><input type="submit"
 		name="submit" value="登录"> </td> 
    </tr> 
</table> 
</form> 

