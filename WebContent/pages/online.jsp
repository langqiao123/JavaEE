<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>在线用户</title>
</head>
<body>
在线用户：
<table style="width:400px;border:1">
<%
Map<String,String> online = (Map<String,String>)application.getAttribute("online");
for(String sessionId:online.keySet()){
%>
<tr>
<td><%= sessionId %></td>
<td><%= online.get(sessionId) %></td>
</tr>
<%}%>
</table>
</body>
</html>