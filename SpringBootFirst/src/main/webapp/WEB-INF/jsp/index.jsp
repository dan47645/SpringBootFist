<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";

%>

<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<title>SpringBoot</title>
	<script type="text/javascript" src="<%=basePath%>js/jquery.js"></script>
	<script type="text/javascript" src="<%=basePath%>js/zui.js"></script>
	<script type="text/javascript" src="<%=basePath%>js/zuiDashboard.js"></script>
	<link rel="stylesheet" type="text/css" media="screen" href="<%=basePath %>css/zui.css" />
	<link rel="stylesheet" type="text/css" media="screen" href="<%=basePath %>css/zuiDashboard.css" />
	
</head>
<body>

<div>
	<form action="/upload" method="post" enctype="multipart/form-data">
		上传文件名称<input type="text" name="name" id="name"><br/>
		上传文件路径<input type="file" name="file" id="file"><br/>
		<button type="submit">确认上传</button>
	</form>
</div>

</body>
</html>
