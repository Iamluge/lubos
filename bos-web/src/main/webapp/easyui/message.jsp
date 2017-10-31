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
<script type="text/javascript">
	$(function() {
		//第一个标题2、内容 3、图标
		//因为按钮默认的是英文，用中文时需要引入相关文件
		$.message.alert("标题","内容","info");
		//确认框
		$.message.confirm("提示信息","你确定要删除吗？？",function(){});
		//show方法--欢迎框
		$.message.show({
			title:"标题",
			msg:"message",
			timeout:5000//五秒后消失
		});
		

	})
</script>
</html>