<%@page import="java.util.List"%>
<%@page import="java.time.Period"%>
<%@page import="java.util.Calendar"%>
<%@page import="java.time.format.DateTimeFormatter"%>
<%@page import="java.time.LocalDate"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="utils.*"%>
<% List<VoteDTO> list = DBUtils.getInstance().selectAllVote(); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="${pageContext.request.contextPath }/style.css?after" rel="stylesheet" />
<link href="${pageContext.request.contextPath }/3/voteChk.css?after" rel="stylesheet" />
</head>
<body>
	<div class="wrapper">
		<%@include file="/layout/header.jsp"%>
		<%@include file="/layout/nav.jsp"%>
		<main>
			<section>
				<table>
					<caption>투표검수조회</caption>
					<tr>
						<th>성명</th>
						<th>생년월일</th>
						<th>나이</th>
						<th>성별</th>
						<th>후보번호</th>
						<th>투표시간</th>
						<th>유권자확인</th>
					</tr>
					<%for(VoteDTO vd : list) { %>
					<tr>
						<td><%=vd.getV_name() %></td>
						<%
						String age = vd.getV_jumin().substring(0,6);//19 + 860918
						int yy = Integer.parseInt(age.substring(0,2));
						if(yy>0 && yy<=7){
							age = "20" + age;
						} else {
							age = "19" + age;
						}
						DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd");
						LocalDate date = LocalDate.parse(age,formatter);
						DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("yyyy년 MM월 dd일생");
						String formattedDate = date.format(formatter2);
						out.println("<td>"+formattedDate+"</td>");
						//현재 날짜
						LocalDate today = LocalDate.now();
						
						int manAge = Period.between(date,today).getYears();
						out.println("<td>만 "+manAge+"세</td>");
						%>
						<%
							char gender = vd.getV_jumin().charAt(6);
							if(gender%2 == 0)
								out.print("<td>여</td>");
							else
								out.print("<td>남</td>");
						%>
						<td><%=vd.getM_num() %></td>
						<%
						String time = vd.getV_time().substring(0,2);
						String bTime = vd.getV_time().substring(2);
						time = time + ":" + bTime;
						out.println("<td>"+time+"</td>");
						%>
						<% String confirm = vd.getV_confirm();
							switch(confirm){
							case "Y":
								out.print("<td>확인</td>");
								break;
							case "N":
								out.print("<td>미확인</td>");
								break;
							}
						
						%>
					</tr>
					<%} %>
				</table>
			</section>
		</main>
		<%@include file="/layout/footer.jsp"%>
	</div>
</body>
</html>