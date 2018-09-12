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
			$('#dashboard').dashboard({draggable: true});
			alert("启动jquery");
			
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
 <div id="dashboard" class="dashboard dashboard-draggable" data-height="300">
	<section class="row">
		<div class="panel" data-id="5" data-url="<%=basePath %>/abc">
	        <div class="panel-heading">
	          <i class="icon icon-globe"></i>
	          <span class="title">加载远程内容</span>
	          <div class="panel-actions">
	            <button type="button" class="btn refresh-panel" data-toggle="tooltip" title="重新从远程获取内容"><i class="icon-refresh"></i></button>
	          </div>
	        </div>
	        <div class="panel-body">等待加载远程内容。</div>
		 </div>
	 </section>
</div>
</div>



	</body>
</html>