<%@ page language="java" contentType="text/html; charset=BIG5"
    pageEncoding="BIG5"
    import="Dao.memberDao"
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="BIG5">
<title>Insert title here</title>
</head>
<body>
<table border=1 align=center width=600>
<tr> <td>id <td>name <td>username <td>password
<%
out.println(new memberDao().queryAll());
%>
</table>
</body>
</html>