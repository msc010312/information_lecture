<%@page import="ch09.OrderDTO2"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ page import="ch04.UserDto"%>
<%@ page import="ch09.*"%>

<%
List<OrderDTO> list = DBUtils.getInstance().selectAllOrder();
List<OrderDTO2> list2 = DBUtils.getInstance().selectDateOrder();
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>총 구매금액</h1>
<table>
	<tr>
	<th>품목</th>
	<th>총합</th>
	</tr>
	<%
	for (OrderDTO orderDto : list) {
	%>

	<tr>
		<td><%=orderDto.getCategory()%></td>
		<td><%=orderDto.getSum()%></td>
	</tr>
	<%
	}
	%>
	</table>
<h1>날짜별 구매 총 평균</h1>
	<table>
	<tr>
		<th>날짜</th>
		<th>평균</th>
	</tr>
	<%
	for(OrderDTO2 od2 : list2) {
	%>
	<tr>
		<td><%= od2.getOrderDate() %></td>
		<td><%= od2.getSum() %></td>
	</tr>
	<%
	}
	%>
	</table>
<a href="../user/joinForm.jsp">회원가입</a>
<a href="selectAll2.jsp">select2</a>
</body>
</html>