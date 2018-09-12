<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";

%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>SpringBoot</title>
	<script type="text/javascript" src="<%=basePath%>js/jquery.js"></script>
	<script type="text/javascript" src="<%=basePath%>js/zui.js"></script>
	<script type="text/javascript" src="<%=basePath%>js/zuiDashboard.js"></script>
	<link rel="stylesheet" type="text/css" media="screen" href="<%=basePath %>css/zui.css" />
	<link rel="stylesheet" type="text/css" media="screen" href="<%=basePath %>css/zuiDashboard.css" />
	
	<script type="text/javascript">
		$(function(){
			//--这个如果不加载，那div中的属性就不会起作用
			//$('#dashboard').dashboard({draggable: true});
			
		});
	
	</script>
</head>
<body>
<div style="background-color: #3280FC;">
	<nav class="navbar" role="navigation">
	  <div class="container">
	    <!-- 导航头部 -->
	    <div class="navbar-header">
	      <!-- 移动设备上的导航切换按钮 -->
	      <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse-example">
	        <span class="sr-only">切换导航</span>
	        <span class="icon-bar"></span>
	        <span class="icon-bar"></span>
	        <span class="icon-bar"></span>
	      </button>
	      <!-- 品牌名称或logo -->
	      <a class="navbar-brand" href="#">ZUI</a>
	    </div>
	    <!-- 导航项目 -->
	    <div class="collapse navbar-collapse navbar-collapse-example">
	      <!-- 一般导航项目 -->
	      <ul class="nav navbar-nav">
	        <li class="active"><a href="#">项目</a></li>
	        <li><a href="#">需求</a></li>
	        <!-- 导航中的下拉菜单 -->
	        <li class="dropdown">
	          <a class="dropdown-toggle" data-toggle="dropdown">管理 <b class="caret"></b></a>
	          <ul class="dropdown-menu" role="menu">
	            <li><a href="#">任务</a></li>
	            <li><a href="#">代办</a></li>
	            <li><a href="#">BUG</a></li>
	          </ul>
	        </li>
	      </ul>
	    </div><!-- END .navbar-collapse -->
	  </div>
	</nav>
</div>


<div class="container">
<h3 align="center">用户登录</h3>
<hr>
	 <form action="<%=basePath %>login" method="post">
	  <div class="form-group">
	    <label for="exampleInputAccount1">账号</label>
	    <input type="text" class="form-control" id="name" name="name" placeholder="电子邮件/手机号/用户名">
	  </div>
	  <div class="form-group">
	    <label for="exampleInputPassword1">密码</label>
	    <input type="password" class="form-control" id="password" name="password" placeholder="">
	  </div>

	  <button type="submit" class="btn btn-primary">提交</button>
	</form>
</div>



	</body>
</html>