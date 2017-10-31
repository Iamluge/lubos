<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>ztree</title>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath }/js/easyui/themes/default/easyui.css">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath }/js/easyui/themes/icon.css">
<script type="text/javascript"
	src="${pageContext.request.contextPath }/js/jquery-1.8.3.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath }/js/easyui/jquery.easyui.min.js"></script>
<link rel="stylesheet"
	href="${pageContext.request.contextPath }/js/ztree/zTreeStyle.css"
	type="text/css">
<script type="text/javascript"
	src="${pageContext.request.contextPath }/js/ztree/jquery.ztree.all-3.5.js"></script>
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
						$("#but1")
								.click(
										function() {
											//判断选项卡是否已经存在
											var e = $("#mytabs").tabs("exists",
													"系统管理");
											if (e) {
												$("#mytabs").tabs("select",
														"系统管理");

											} else {
												//调用tabs的add方法动态添加一个选项卡
												$("#mytabs")
														.tabs(
																"add",
																{
																	title : '系统管理',
																	iconCls : 'icon-edit',
																	closebale : true,
																	content : '<iframe frameborder="0" height="100%" width="100%" src="https://www.baidu.com"></iframe>'

																});
											}
										});

					});
				</script>
			</div>
			<div title="面板二">
				<!-- 展示ztree   使用标准json构造ztree-->
				<ul id="ztree1" calss="ztree"></ul>
				<script type="text/javascript">
					$(function() {
						var setting = {};
						//构造节点数据
						var znodes = [ {
							"name" : "节点一",
							"chidren" : [ {
								"name" : "节点一"
							}, {
								"name" : "节点二"
							}, {
								"name" : "节点三"
							} ]
						},//每个json对象表示一个节点数据
						{
							"name" : "节点二"
						}, {
							"name" : "节点三"
						} ];
						//调用API初始化ztree
						$.fn.zTree.init($("#ztree1"), setting, znodes);
					});
				</script>

			</div>
			<div title="面板三">
				<!-- 简单json构造ztree，默认不支持需修改setting属性 -->

				<ul id="ztree2" calss="ztree"></ul>
				<script type="text/javascript">
					$(function() {
						var setting2 = {

							data : {
								simpleData : {
									enable : true
								//使用简单json数据构造ztree节点
								}
							}
						};
						//构造节点数据
						var znodes2 = [ {
							"id" : "1",
							"pId" : "2",
							"name" : "节点一"
						},//每个json对象表示一个节点数据
						{
							"id" : "2",
							"pId" : "3",
							"name" : "节点二"
						}, {
							"id" : "3",
							"pId" : "0",
							"name" : "节点三"
						} ];
						//调用API初始化ztree
						$.fn.zTree.init($("#ztree2"), setting2, znodes2);
					});
				</script>

			</div>
			<div title="面板四">


				<ul id="ztree3" calss="ztree"></ul>
				<script type="text/javascript">
					$(function() {
						var setting3 = {

							data : {
								simpleData : {
									enable : true
								//使用简单json数据构造ztree节点
								}
							}
						};

						// 发送ajax请求来获取json数据 ，ajax、get、post、等等
						var url = "${pageContext.request.contextPath}/json/menu.json";
						$.post(url, {}, function(data) {
							//调用API初始化ztree
							$.fn.zTree.init($("#ztree3"), setting3, data);

						}, 'json');

					});
				</script>

			</div>
			<div title="面板五">
				<!-- 展示ztree效果 :发送ajax请求获取简单json数据构造ztree-->
				<ul id="ztree3" class="ztree"></ul>
				<script type="text/javascript">
					$(function() {
						//页面加载完成后，执行这段代码----动态创建ztree
						var setting3 = {
							data : {
								simpleData : {
									enable : true
								//使用简单json数据构造ztree节点
								}
							},
							callback : {
								//为ztree节点绑定单击事件
								onClick : function(event, treeId, treeNode) {
									if (treeNode.page != undefined) {
										//判断选项卡是否已经存在
										var e = $("#mytabs").tabs("exists",
												treeNode.name);
										if (e) {
											//已经存在，选中
											$("#mytabs").tabs("select",
													treeNode.name);
										} else {
											//动态添加一个选项卡
											$("#mytabs")
													.tabs(
															"add",
															{
																title : treeNode.name,
																closable : true,
																content : '<iframe frameborder="0" height="100%" width="100%" src="'
																		+ treeNode.page
																		+ '"></iframe>'
															});
										}
									}
								}
							}
						};

						//发送ajax请求，获取json数据
						//jQuery提供 的ajax方法：ajax、post、get、load、getJSON、getScript
						var url = "${pageContext.request.contextPath}/json/menu.json";
						$.post(url, {}, function(data) {
							//调用API初始化ztree
							$.fn.zTree.init($("#ztree3"), setting3, data);
						}, 'json');
					});
				</script>
			</div>
			<div title="面板六">6</div>
		</div>
	</div>
	<div data-options="region:'center'">
		<!-- 选项卡区域 -->
		<div class="easyui-tabs" id="mytabs" data-options="fit:true"></div>

	</div>
	<div style="width: 100px" data-options="region:'east'">东部区域</div>
	<div style="height: 50px" data-options="region:'south'">南部区域</div>
</body>
</html>