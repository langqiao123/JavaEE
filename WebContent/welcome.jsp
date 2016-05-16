<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>欢迎您，光临廊桥的世界</title>
</head>
<body>
	welcome to the world of langqiao!</br>
	本站访问次数为：${applicationScope.counter }</br>
	${sessionScope.user },您已经登录!</br>
	${requestScope.tip }
	<s:debug></s:debug>
</body>
</html>