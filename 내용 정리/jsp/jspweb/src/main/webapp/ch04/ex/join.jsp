<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ page import="ch04.UserDto"%>

<!--  
		UserDto객체에 전달받은 파라미터(username,password)를 저장
		request에  setAttribute로 userDto 저장("userDto",userDto);
		02ValidationCheck.jsp 로 forwarding
-->
<%
String userid = request.getParameter("userid");
String password = request.getParameter("password");
UserDto ud = new UserDto(userid,password);
request.setAttribute("userDto", ud);
request.setAttribute("url", "/join"); // DB요청처리
request.setAttribute("serviceNum", 1); // C : 1, R : 2, U : 3, D : 4
request.getRequestDispatcher("validationCheck.jsp").forward(request, response);
%>