<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>accordion</title>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath }/js/easyui/themes/default/easyui.css">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath }/js/easyui/themes/icon.css">
<script type="text/javascript"
	src="${pageContext.request.contextPath }/js/jquery-1.8.3.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath }/js/easyui/jquery.easyui.min.js"></script>

</head>
<body class="easyui-layout">
	<!-- 使用div元素描述每个区域 -->
	<div title="XXX管理系统" style="height: 100px"
		data-options="region:'north'">北部区域</div>
	<div title="系统菜单" style="width: 200px" data-options="region:'west'">
		<!-- 面板 -->
		<div class="easyui-accordion" data-options="fit:true">
			<div title="面板一">
				<a id="but1" class="easyui-linkbutton">添加一个面板</a>
				<!-- 绑定事件 -->
				<script type="text/javascript">
					$(function() {
						//页面加载完成后绑定单击事件
						$("#but1").click(function() {
                          //判断选项卡是否已经存在
                          var e=$("#mytabs").tabs("exists","系统管理");
                          if(e){
                        	  $("#mytabs").tabs("select","系统管理"); 
                        	  
                          }else{
							//调用tabs的add方法动态添加一个选项卡
							$("#mytabs").tabs("add", {
								title : '系统管理',
								iconCls : 'icon-edit',
								closebale : true,
								content : '<iframe frameborder="0" height="100%" width="100%" src="https://www.baidu.com"></iframe>'

							});}
						});

					});
				</script>
			</div>
			<div title="面板二">2</div>
			<div title="面板三">3</div>
		</div>
	</div>
	<div  data-options="region:'center'">
		<!-- 选项卡区域 -->
		<div class="easyui-tabs" id="mytabs" data-options="fit:true">
		</div>

	</div>
	<div style="width: 100px" data-options="region:'east'">东部区域</div>
	<div style="height: 50px" data-options="region:'south'">南部区域</div>
</body>
</html>