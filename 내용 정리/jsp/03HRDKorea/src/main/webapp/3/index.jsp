<%@page import="java.util.Locale"%>
<%@page import="java.text.NumberFormat"%>
<%@page import="java.util.List"%>
<%@page import="java.time.Period"%>
<%@page import="java.util.Calendar"%>
<%@page import="java.time.format.DateTimeFormatter"%>
<%@page import="java.time.LocalDate"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="utils.*"%>
<%
List<GmemberDTO> list = DBUtils.getInstance().selectAllGmember();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="${pageContext.request.contextPath }/style.css?after"
	rel="stylesheet" />
<link href="${pageContext.request.contextPath }/3/voteChk.css?after"
	rel="stylesheet" />
</head>
<body>
	<div class="wrapper">
		<%@include file="/layout/header.jsp"%>
		<%@include file="/layout/nav.jsp"%>
		<main>
			<section>
				<table>
					<caption>회원정보조회</caption>
					<tr>
						<th>수강월</th>
						<th>회원번호</th>
						<th>회원명</th>
						<th>강의명</th>
						<th>강의장소</th>
						<th>수강료</th>
						<th>등급</th>
					</tr>
					<%
					for (GmemberDTO gd : list) {
					%>
					<tr>
						<%
						out.println("<td>" + LocalDate.parse(gd.getRegist_month().trim() + "01", DateTimeFormatter.ofPattern("yyyyMMdd"))
						.format(DateTimeFormatter.ofPattern("yyyy년 MM월")) + "</td>");
						%>
						<td><%=gd.getC_no()%></td>
						<td><%=gd.getC_name()%></td>
						<td><%=gd.getClass_name()%></td>
						<td><%=gd.getClass_area()%></td>
						<td><%=NumberFormat.getCurrencyInstance(Locale.KOREA).format(gd.getClass_price())%></td>
						<td><%=gd.getGrade()%></td>
					</tr>
					<%
					}
					%>
				</table>
			</section>
		</main>
		<%@include file="/layout/footer.jsp"%>
	</div>
</body>
</html>