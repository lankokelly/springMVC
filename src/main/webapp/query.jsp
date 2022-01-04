<%@ page language="java" contentType="text/html; charset=BIG5"
    pageEncoding="BIG5"
    import="Dao.memberDao"%>
    
 <%
 String Show=new memberDao().queryAll();
 
 
 
 %>   
<!DOCTYPE html>
<html>
<head>
<meta charset="BIG5">
<title>Insert title here</title>
</head>
<body>
<form action="">
	<table width=500 align=center border=0>
		<tr>
			<td>name<input type="text" size=5 name="name">
			<td>id<input type="text" size=5 id="id">
			<td><input type="submit" value="ok">
		
	</table>
</form>
<hr>
	<table width=500 align=center border=1>
	<tr>
		<td>id
		<td>name
		<td>username
		<td>password
		
	<%=Show%>
	</table>
</table>
	
</body>
</html>