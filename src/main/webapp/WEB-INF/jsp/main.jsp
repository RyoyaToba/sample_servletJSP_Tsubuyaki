<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="model.User" %>
<%
	User loginUser = (User) session.getAttribute("loginUser");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>sample</title>
</head>
<body>
<h1>つぶやきメインページ</h1>
<p>
<%= loginUser.getName() %>さん、ログイン中
<a href="/sampleTsubu/Logout">ログアウト</a>
</p>
</body>
</html>