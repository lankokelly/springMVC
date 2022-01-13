<%@ page language="java" contentType="text/html; charset=BIG5"
    pageEncoding="BIG5"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="BIG5">
<title>Insert title here</title>
</head>
<body>
<form action="AddMemberController" method="post">
	<table width=400 align=center border=1>
		<tr>
			<td colspan=2 align=center><h3>註冊</h3>
		<tr>
			<td width=100 align=center>帳號
			<td><input type="text" name="username">
		<tr>
			<td width=100 align=center>密碼
			<td><input type="text" name="password">
		<tr>
			<td width=100 align=center>姓名
			<td><input type="text" name="name">
		<tr>
			<td width=100 align=center>地址
			<td><input type="text" name="address">
		<tr>
			<td width=100 align=center>家電
			<td><input type="text" name="phone">
		<tr>
			<td width=100 align=center>手機
			<td><input type="text" name="mobile">
		<tr>
			<td colspan=2 align=center>
			<input type="submit" value="新增">
			<a href="addMember.jsp"></a>
			
	</table>

</form>
</body>
</html>