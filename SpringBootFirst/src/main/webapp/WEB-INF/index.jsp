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
	
	<script type="text/javascript">
		$(function(){
			$('#dashboard').dashboard({draggable: true});
			alert("启动jquery");
			
		});
	
	</script>
</head>
<body>
	<div id="dashboard" class="dashboard dashboard-draggable" data-height="300">
  <section class="row">
    <div class="col-md-4 col-sm-6">
      <div class="panel" data-id="1">
        <div class="panel-heading">
          <i class="icon icon-list"></i>
          <span class="title">面板标题</span>
        </div>
        <div class="panel-body">
          <p>面板内容。</p>
        </div>
      </div>
    </div>
    <div class="col-md-4 col-sm-6">
      <div class="panel" data-id="2">
        <div class="panel-heading">
          <i class="icon icon-list"></i>
          <span class="title">包含列表组</span>
        </div>
        <div class="panel-body no-padding">
          <div class="list-group">
            ...
          </div>
        </div>
      </div>
    </div>
    <div class="col-md-4 col-sm-6">
      <div class="panel" data-id="3">
        <div class="panel-heading">
          <i class="icon icon-table"></i>
          <span class="title">包含表格</span>
        </div>
        <div class="panel-body no-padding">
          <table class="table">
            heheda
          </table>
        </div>
      </div>
    </div>
    <div class="col-md-6">
      <div class="panel" data-id="4">
        <div class="panel-heading">
          <i class="icon icon-bolt"></i>
          <span class="title">包含操作按钮</span>
          <div class="panel-actions">
            <a href="###" data-toggle="tooltip" title="编辑"><i class="icon-pencil"></i></a>
            <button type="button" class="btn" data-toggle="tooltip" title="收藏"><i class="icon-heart-empty"></i></button>
            <div class="dropdown" data-toggle="tooltip" title="更多操作">
              <button class="btn" data-toggle="dropdown" type="button"><i class="icon icon-ellipsis-v"></i></button>
              <ul class="dropdown-menu pull-right">
                <li><a href="###"><i class="icon icon-ok"></i> 确认</a></li>
                <li><a href="###"><i class="icon icon-thumbs-o-up"></i> 自定义操作</a></li>
              </ul>
            </div>
          </div>
        </div>
        <div class="panel-body">
          <p>在面板头部（<code>.panel-heading</code>）包含链接和按钮来自定义操作。</p>
        </div>
      </div>
    </div>
    <div class="col-md-6">
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
    </div>
    <div class="col-md-4 col-sm-6">
      <div class="panel" data-id="6">
        <div class="panel-heading">
          <div class="title">可移除的面板</div>
          <div class="panel-actions">
            <button type="button" class="btn remove-panel" data-toggle="tooltip" title="移除面板"><i class="icon-remove"></i></button>
          </div>
        </div>
        <div class="panel-body">
          <p>点击顶部右侧的 <i class="icon icon-remove"></i> 按钮来移除该面板。</p>
        </div>
      </div>
    </div>
    <div class="col-md-8 col-sm-6">
      <div class="panel panel-loading" data-id="6">
        <div class="panel-heading"><code>.panel-loading</code></div>
        <div class="panel-body">
          <p>为 <code>.panel</code> 添加 <code>.panel-loading</code> 类即可实现正在加载的外观。</p>
        </div>
      </div>
    </div>
  </section>
</div>

<a href="<%=basePath %>forword">点击跳转</a>

</body>
</html>
