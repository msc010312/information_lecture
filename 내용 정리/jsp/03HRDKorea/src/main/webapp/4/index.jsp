<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="utils.*,java.util.*" %>
<% List<RankDTO> list = DBUtils.getInstance().selectAllRank(); %>
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
					<caption>후보자 등수</caption>
					<tr>
						<th>후보번호</th>
						<th>성명</th>
						<th>총투표건수</th>
					</tr>
					<%for(RankDTO rd : list){ %>
					<tr>
						<th><%=rd.getM_no() %></th>
						<th><%=rd.getM_name() %></th>
						<th><%=rd.getCount() %></th>
					</tr>
					<%} %>
				</table>
			</section>
		</main>
		<%@include file="/layout/footer.jsp" %>
	</div>
</body>
</html>