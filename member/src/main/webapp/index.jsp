<%@ page language="java" contentType="text/html; charset=BIG5"
    pageEncoding="BIG5"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="BIG5">
<title>Insert title here</title>
</head>
<body>
<form action="LoginController" method="post">
	<table width=400 align=center border=1>
		<tr>
			<td colspan=2 align=center><h3>會員登入</h3>
		<tr>
			<td width=100 align=center>帳號
			<td><input type="text" name="username">
		<tr>
			<td width=100 align=center>密碼
			<td><input type="password" name="password">
		<tr>
			<td colspan=2 align=center>
			<input type="submit" value="登入">
			<a href="addMember.jsp">註冊</a>
			
	</table>

</form>
</body>
</html>