<%@page import="java.nio.charset.Charset"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%-- <%
/* Request 내장객체 - 요청정보값 저장 */

/* 문자셋 설정 */
request.setCharacterEncoding("UTF-8");
response.setContentType("text/html Charset=UTF-8");

String username = request.getParameter("username");
String password = request.getParameter("password");
String bgColor = request.getParameter("bgcolor");
System.out.printf("%s, %s, %s", username,password,bgColor);
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>

<body style="background-color: <%= bgColor%>">
	username : <%=username %>
<hr>
password : <%=password %>
<hr>
bgColor : <%=bgColor %>
</body>
<body bgcolor=<%=bgColor.equals("")?"#ccc":bgColor %>>

username : <%=username %>
<hr>
password : <%=password %>
<hr>
bgColor : <%=bgColor %>

</body>
</html> --%>

<!-- EL표현식 -->
<%
/* 문자셋 설정 */
request.setCharacterEncoding("UTF-8");
response.setContentType("text/html Charset=UTF-8");
%>
<!doctype html>
<html lang="en">
<head>
<meta charset="UTF-8" />
<title>Document</title>
</head>
<body style="background: ${param.bgcolor}">
	EL_USERNAME : ${param.username }
	<br> EL_PASSWORD : ${param.username }
	<br> EL_COLOR : ${param.bgcolor }
	<br>
</body>
</html>