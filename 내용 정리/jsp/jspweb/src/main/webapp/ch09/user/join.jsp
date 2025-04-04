<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="ch04.UserDto" %>
<%@ page import="ch09.DBUtils" %>

<%
	String userid = request.getParameter("userid");
	String pw = request.getParameter("password");
	
	// 입력값 검증
	
	// 서비스 실행
	DBUtils dbutils = DBUtils.getInstance();
	int result = dbutils.insertUser(new UserDto(userid,pw));
	
	// 이동
	if(result>0)
	response.sendRedirect("../index.jsp");
	else
	response.sendRedirect("user/joinForm.jsp");
%>