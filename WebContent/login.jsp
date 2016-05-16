<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>登录页面</title>
</head>
<body>
	<s:form action="/jaction/login.action">
		<s:textfield type="text" name="user.username" key="用户名"/>
		<s:textfield type="password" name="user.password" key="密码"/>
		<s:submit key="登录"></s:submit>
		<s:debug></s:debug>
	</s:form>
</body>
</html>