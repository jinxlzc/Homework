<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
String submitUrl=basePath+"pages/LoginServlet";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  	<head>
   	 <base href="<%=basePath%>">
		<title>Login</title>
		<link rel="stylesheet" type="text/css" href="css/Login.css"/>
	</head>
<body>
   <div id="login">
   	  <h1>Login</h1>
   	  <form action="<%=submitUrl%>" method="post">
   	  		<tr>
   	  			<td><input type="text"  required="required"  placeholder="用户名" id="username" name="username"></td>
   	  			<td><font color="red" size="2">${usermsg}</font> </td>
   	  		</tr>
   	  		<tr>
   	  			<td><input type="password"  required="required"  placeholder="密码" id="password" name="password"></td>
   	  			<td><font color="red" size="2">${passmsg}</font> </td>
   	  		</tr>	 
   	  	  <tr>
   	  		    <td><button class="but" type="submit">登录</button></td>
   	  	</tr>
   	  	<tr>
   	  		  <td><button class="but" type="button" onclick="location.href='pages/regis.jsp' ">注册</button></td>
   	  	</tr>
   	  </form>
   </div>
		
		
</body>
</html>
