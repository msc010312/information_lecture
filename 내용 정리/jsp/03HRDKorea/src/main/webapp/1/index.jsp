<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.text.DateFormat"%>
<%@page import="java.text.NumberFormat"%>
<%@page import="java.time.LocalDate"%>
<%@page import="java.time.format.DateTimeFormatter"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="utils.*,java.util.*" %>
<% List<TeacherDTO> list = DBUtils.getInstance().selectAllTeacher(); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="${pageContext.request.contextPath }/style.css?after" rel="stylesheet" />
<link href="${pageContext.request.contextPath }/1/member.css?after" rel="stylesheet" />
</head>
<body>
	<div class="wrapper">
		<%@include file="/layout/header.jsp" %>
		<%@include file="/layout/nav.jsp" %>
		<main>
			<section>
			<table>
			<caption>강사조회</caption>
			<tr>
				<th>강사코드</th>
				<th>강사명</th>
				<th>강의명</th>
				<th>수강료</th>
				<th>강사자격취득일</th>
			</tr>
			<%for(TeacherDTO td : list){ %>
			<tr>
				<td><%=td.getTeacher_code() %></td>
				<td><%=td.getTeacher_name() %></td>
				<td><%=td.getClass_name() %></td>
				<td><%=NumberFormat.getCurrencyInstance(Locale.KOREA).format(td.getClass_price()) %></td>
				<%
				out.println("<td>" + LocalDate.parse(td.getTeacher_regist_date().trim(), DateTimeFormatter.ofPattern("yyyyMMdd"))
                .format(DateTimeFormatter.ofPattern("yyyy년 MM월 dd일")) + "</td>");
				%>
				
			</tr>
			<%} %>
			</table>
			</section>
		</main>
		<%@include file="/layout/footer.jsp" %>
	</div>
</body>
</html>