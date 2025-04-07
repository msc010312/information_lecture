<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="utils.*,java.util.*" %>
<% List<MemberDTO> list = DBUtils.getInstance().selectAllMember(); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="${pageContext.request.contextPath }/style.css" rel="stylesheet" />
</head>
<body>
	<div clss="wrapper">
		<%@include file="/layout/header.jsp" %>
		<%@include file="/layout/nav.jsp" %>
		<main>
			<section>
			<table>
			<caption>후보조회</caption>
			<tr>
				<th>후보번호</th>
				<th>성명</th>
				<th>소속정당</th>
				<th>학력</th>
				<th>주민번호</th>
				<th>지역구</th>
				<th>대표전화</th>
			</tr>
			<%for(MemberDTO md : list){ %>
			<tr>
				<td><%=md.getM_no() %></td>
				<td><%=md.getM_name() %></td>
				<td><%=md.getP_name() %></td>
				<%String school = md.getP_school();
					switch(school)
					{
					case "1":
						out.print("<td>고졸</td>");
						break;
					case "2":
						out.print("<td>학사</td>");
						break;
					case "3":
						out.print("<td>박사</td>");
						break;
					case "4":
						out.print("<td>석사</td>");
						break;
					}
				%>
				<td><%=md.getM_jumin() %></td>
				<td><%=md.getM_city() %></td>
				<td><%=md.getP_tel1() %>-<%=md.getP_tel2() %>-<%=md.getP_tel3() %></td>
			</tr>
			<%} %>
			</table>
			</section>
		</main>
		<%@include file="/layout/footer.jsp" %>
	</div>
</body>
</html>