<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>쿠키확인</h1>
	<%
	Cookie[] cookies = request.getCookies();
	if(cookies != null) {
		for(Cookie cookie: cookies){
			System.out.println(cookie.getName() + " : " + cookie.getValue());
			%>
			<div>
			<a href="delCookie.jsp?cookieName=<%=cookie.getName()%>">
				<%= cookie.getName() %> : <%=cookie.getValue() %>
			</a>
			</div>
			<% 
		}
	}
	%>
	<hr>
	<h1>쿠키확인 el</h1>
	<%-- <div>cookie1 : ${cookie.myCookie1.value }</div>
	<div>cookie2 : ${cookie.myCookie2.value }</div> --%>
</body>
</html>