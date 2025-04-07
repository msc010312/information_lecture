<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="ch04.UserDto"%>
<%@ page import="ch09.*"%>

<%
List<OrderDTO3> list = DBUtils.getInstance().selectAddrOrder();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>지역 + 날짜별 구매총액</h1>
	<table>
		<tr>
			<th>지역</th>
			<th>날짜</th>
			<th>총액</th>
		
		<%for(OrderDTO3 od : list){ %>
		</tr>
			<td><%=od.getAddr() %></td>
			<td><%=od.getOrderDate() %></td>
			<td><%=od.getTotalAmount() %></td>
		<tr>
		<%} %>
	</table>
	<a href="selectAll.jsp">select1</a>
</body>
</html>