<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<!DOCTYPE html>
<!--[if lt IE 7]>      <html class="no-js lt-ie9 lt-ie8 lt-ie7"> <![endif]-->
<!--[if IE 7]>         <html class="no-js lt-ie9 lt-ie8"> <![endif]-->
<!--[if IE 8]>         <html class="no-js lt-ie9"> <![endif]-->
<!--[if gt IE 8]><!--> <html class="no-js"> <!--<![endif]-->
	<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<title>宿舍后台管理系统</title>
	<base href=" <%=basePath%>"/>
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<meta name="description" content="Free HTML5 Template by FreeHTML5.co" />
	<meta name="keywords" content="free html5, free template, free bootstrap, html5, css3, mobile first, responsive" />

  	<!-- Facebook and Twitter integration -->
	<meta property="og:title" content=""/>
	<meta property="og:image" content=""/>
	<meta property="og:url" content=""/>
	<meta property="og:site_name" content=""/>
	<meta property="og:description" content=""/>
	<meta name="twitter:title" content="" />
	<meta name="twitter:image" content="" />
	<meta name="twitter:url" content="" />
	<meta name="twitter:card" content="" />

	<!-- Place favicon.ico and apple-touch-icon.png in the root directory -->
	<link rel="shortcut icon" href="favicon.ico">

	<link href='https://fonts.googleapis.com/css?family=Open+Sans:400,700,300' rel='stylesheet' type='text/css'>
	
	<link rel="stylesheet" href="css/bootstrap.min.css">
	<link rel="stylesheet" href="css/animate.css">
	<link rel="stylesheet" href="css/style.css">


	<!-- Modernizr JS -->
	<script src="js/modernizr-2.6.2.min.js"></script>
	<!-- FOR IE9 below -->
	<!--[if lt IE 9]>
	<script src="js/respond.min.js"></script>
	<![endif]-->
	<script src="js/jquery.min.js"></script>
	<script src="js/log.js"></script>
	</head>
	<body class="style-2">
		<div class="container">
			<div class="row">
				<div class="col-md-12 text-center">
					<h1>宿舍后台管理系统</h1>
				</div>
			</div>
			<div class="row">
				<div class="col-md-4">
					

					<!-- Start Sign In Form -->
					<form action="" method="post" class="fh5co-form animate-box" data-animate-effect="fadeInLeft" id="form1">
						<h2>Sign In</h2>
						<div id="logintip" style="font-size: 12px;color:#33cccc;height: 18px" >
							<%
								String log = (String)request.getAttribute("state");
								if (log != null && log.equals("failed")) {
									out.print("用户名或密码错误，请重新登录.");
								}
							%>							
						</div>
						<div class="form-group">
							<label for="username" class="sr-only">Username</label>
							<input type="text" name="id" class="form-control" id="username" placeholder="Username" autocomplete="off">
						</div>
						<div class="form-group">
							<label for="password" class="sr-only">Password</label>
							<input type="password" name="password" class="form-control" id="password" placeholder="Password" autocomplete="off">
						</div>
						<!-- <div class="form-group">
							<label for="remember"><input type="checkbox" id="remember"> Remember Me</label>
						</div> -->
						<div class="form-group">
							<label for="type"><input type="radio"  name="type" value="student"> Student</label>
							<label for="type"><input type="radio"  name="type" value="admin" style="margin-left: 10px;"> Admin</label>
							<label for="type"><input type="radio"  name="type" value="staff" style="margin-left: 10px;"> Staff</label>
						</div>
						<div class="form-group">
							<input type="submit" value="Sign In" class="btn btn-primary" onclick="getUserType()">
						</div>
					</form>
					<!-- END Sign In Form -->

				</div>
			</div>
			<div class="row" style="padding-top: 60px; clear: both;">
				<div class="col-md-12 text-center"><p><small>Zhejiang University of Science and Technology</small></p></div>
			</div>
		</div>
	
	<!-- jQuery -->
	<script src="js/jquery.min.js"></script>
	<!-- Bootstrap -->
	<script src="js/bootstrap.min.js"></script>
	<!-- Placeholder -->
	<script src="js/jquery.placeholder.min.js"></script>
	<!-- Waypoints -->
	<script src="js/jquery.waypoints.min.js"></script>
	<!-- Main JS -->
	<script src="js/main.js"></script>

	<!-- 判断用户类型 -->
	<script type="text/javascript">
		function getUserType(){
			var form=$("#form1");
			var type=$("input[name='type']:checked").val();
			var id=$("").val();
			var pwd=$("").val();
			if(type=="student"){
				form.action="/stu/login";
		        $("#form1").attr("action",form.action);
			}else if(type=="admin"){
				form.action="/admin/login";
				alert(form.action);
				$("#form1").attr("action",form.action);
			}else if(type=="staff"){
				form.action="/staff/login";
				alert(form.action);
				$("#form1").attr("action",form.action);
			}
		}
	</script>
	</body>
</html>




