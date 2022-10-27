<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="model.User" %>
<%@ page import="model.Mutter" %>
<%@ page import="java.util.List" %>
<%
	User loginUser = (User) session.getAttribute("loginUser");
	List<Mutter> mutterList = (List<Mutter>) application.getAttribute("mutterList");
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
<p><a href="/sampleTsubu/Main">更新</a></p>
<form action="/sampleTsubu/Main" method="post">
	<input type="text" name="text">
	<input type="submit" value="つぶやく">
</form>
<% for(Mutter mutter : mutterList){ %>
	<p><%= mutter.getUserName() %>:<%= mutter.getText() %></p>
<% } %>
</body>
</html>