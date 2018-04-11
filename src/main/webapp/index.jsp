<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">

<!-- Bootstrap -->
<link href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
<script src="https://cdn.bootcss.com/jquery/1.12.4/jquery.min.js"></script>
<script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

<link href="signin.css" rel="stylesheet">

<title>Login</title>
</head>
<body>
	<div class="container" >

		<form class="form-signin"  method="post"  action="check-account">
			<h2 class="form-signin-heading">图书管理系统</h2>
			<label for="inputUsername" class="sr-only">用户名</label> 
			<input type="text"  id="inputUsername"  name="username"  class="form-control"  placeholder="用户名"  required autofocus> 
			<label for="inputPassword" class="sr-only">密码</label> 
			<input type="password"  id="inputPassword"  name="password"  class="form-control"  placeholder="密码"  required>
			
			<button class="btn btn-lg btn-primary btn-block"  type="submit">登录</button>
			
			<%
				String err=(String)session.getAttribute("err");
				if(err!=null){
					out.print("<br><front size='6' style='color:red;'>"+err+"</front>");
				}%>
		</form>
	</div>
	<!-- /container -->

</body>
</html>