<%@page import="java.util.List"%>
<%@page import="java.time.Period"%>
<%@page import="java.util.Calendar"%>
<%@page import="java.time.format.DateTimeFormatter"%>
<%@page import="java.time.LocalDate"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="utils.*"%>
<%
request.setCharacterEncoding("UTF-8");
response.setCharacterEncoding("UTF-8");
response.setContentType("text/html; charset=UTF-8");

String jumin = request.getParameter("v_jumin");
String name = request.getParameter("v_name");
String num = request.getParameter("m_num");
String time = request.getParameter("v_time");
String area = request.getParameter("v_area");
String confirm = request.getParameter("v_confirm");

VoteDTO vd = new VoteDTO(jumin,name,num,time,area,confirm);
%>

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
					<tr>
						<td><%=vd.getV_name() %></td>
						<td><%=vd.getV_jumin() %></td>
						<%
						String age = vd.getV_jumin().substring(0,6);//19 + 860918
						System.out.println("age :" + age);
						int yy = Integer.parseInt(age.substring(0,2));
						if(yy>0 && yy<=7){
							age = "20" + age;
						} else {
							age = "19" + age;
						}
						DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd");
						LocalDate date = LocalDate.parse(age,formatter);
						System.out.println("date : " + date);
						
						//현재 날짜
						LocalDate today = LocalDate.now();
						
						int manAge = Period.between(date,today).getYears();
						out.println("<td>만 "+manAge+"세</td>");
						%>				
						<%
							char gender = vd.getV_jumin().charAt(6);
							if(gender%2 == 0)
								out.print("<td>여자</td>");
							else
								out.print("<td>남자</td>");
						%>
						<td><%=vd.getM_num() %></td>
						<td><%=vd.getV_time() %></td>
						<td><%=vd.getV_confirm() %></td>
					</tr>
				</table>
			</section>
		</main>
		<%@include file="/layout/footer.jsp"%>
	</div>
</body>
</html>