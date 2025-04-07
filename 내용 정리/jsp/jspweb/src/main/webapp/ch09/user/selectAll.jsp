<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="ch04.UserDto" %>
<%@ page import="ch09.DBUtils" %>

<%

DBUtils dbutils = DBUtils.getInstance();
List<UserDto> list = dbutils.selectAllUser();


%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
a {
	text-decoration: none;
	color: #333;
}
</style>
</head>
<body>
<div>총인원 <%=list.size() %></div>
<table>
<tr>
<th>ID</th>
<th>password</th>
<th>수정</th>
<th>삭제</th>
</tr>
<%
	for(UserDto dto : list) {
%>
	<tr>
		<td><%=dto.getUserid() %></td>
		<td><%=dto.getPassword() %></td>
		<td><a href="update_form.jsp?userid=<%=dto.getUserid()%>">수정</a></td>
		<td><a href="delete.jsp?userid=<%=dto.getUserid()%>">삭제</a></td>
	</tr>
<%
	}
%>
	
</table>
	<a href="joinForm.jsp">가입창 연결</a>
	<a href="../order/selectAll.jsp">상품</a>
</body>
</html>