<%@ page language="java" contentType="text/html; charset=BIG5"
    pageEncoding="BIG5"
    import="Dao.memberDao"
    %>
<%
String show= new memberDao().queryAll();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="BIG5">
<title>Insert title here</title>
</head>
<body>

<table align="center" width=500>
	<tr>
		<td>id:<input type="text" name="id">
		<td>name:<input type="text" name="name">
		<td><input type="submit" value="ok">
</table>
<hr>
<table border=1 align=center width=600>
	<tr> 
		<td>id <td>name <td>username <td>password
	<%=show%>
</table>
</body>
</html>