<%@page import="java.text.NumberFormat"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="utils.*,java.util.*" %>
<% List<CostDTO> list = DBUtils.getInstance().selectAllcost(); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="${pageContext.request.contextPath }/style.css?after" rel="stylesheet" />
<link href="${pageContext.request.contextPath }/4/rank.css?after" rel="stylesheet" />
</head>
<body>
	<div clss="wrapper">
		<%@include file="/layout/header.jsp" %>
		<%@include file="/layout/nav.jsp" %>
		<main>
			<section>
				<table>
					<caption>강사매출 현황</caption>
					<tr>
						<th>강사코드</th>
						<th>강의명</th>
						<th>강사명</th>
						<th>총매출</th>
					</tr>
					<%for(CostDTO cd : list){ %>
					<tr class="c-list">
						<td><%=cd.getTeacher_code() %></td>
						<td><%=cd.getClass_name() %></td>
						<td><%=cd.getTeacher_name() %></td>
						<td><%=NumberFormat.getCurrencyInstance(Locale.KOREA).format(cd.getSum())%></td>
					</tr>
					<%} %>
				</table>
			</section>
		</main>
		<%@include file="/layout/footer.jsp" %>
	</div>
</body>
</html>