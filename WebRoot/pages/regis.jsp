<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
String submitUrl=basePath+"pages/regisServlet";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  	<head>
   	 <base href="<%=basePath%>">
		<title>Regis</title>
		<link rel="stylesheet" type="text/css" href="css/Login.css"/>
	</head>
<body>
   <div id="login">
   	  <h1>regis</h1>
   	  <form action="<%=submitUrl%>" method="post" name="regisform">
   	  		<tr>
   	  			<td><input type="text"  required="required"  placeholder="用户名" id="username" name="username"></td>
   	  			<td><font color="red" size="2">${cre_user_msg}</font></td>
   	  			<td><font color="red" size="2">${re_user_msg}</font></td>
   	  		</tr>
   	  		
   	  		<tr>
   	  			<td><input type="password"  required="required"  placeholder="密码" id="password" name="password"></td>
   	  			<td><font color="red" size="2">${re_pwd_msg}</font></td>
   	  		<tr>
   	  			<td><input type="password"  required="required"  placeholder="请再输入一遍" id="cpassword" name="cpassword" onchange="checkpwd()"></td>
   	  			<td><span id="worning" style="color:red;"></span></td>
   	  		</tr>
   	  		
   	  
   	  		
   	  	 	 <tr>
   	  		    <td><button class="but" type="submit">注册</button></td>
   	  		</tr>
   	  
   	  </form>
   </div>
		
		
</body>
<script type="text/javascript">
 function checkpwd(){
  var p1=document.regisform.password.value;//获取密码框的值
  var p2=document.regisform.cpassword.value;//获取重新输入的密码值
  if(p1==""){
   alert("请输入密码！");//检测到密码为空，提醒输入//
   document.regisform.password.focus();//焦点放到密码框
   return false;//退出检测函数
  }//如果允许空密码，可取消这个条件
  
  if(p1!=p2){//判断两次输入的值是否一致，不一致则显示错误信息
   document.getElementById("worning").innerHTML="两次输入密码不一致，请重新输入";//在div显示错误信息
   return false;
  }else{
   //密码一致，可以继续下一步操作 
  }
 }
</script>
</html>

