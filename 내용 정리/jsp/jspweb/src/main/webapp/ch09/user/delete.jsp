<%@page import="ch04.UserDto"%>
<%@page import="ch09.DBUtils"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%
String userid = request.getParameter("userid");

DBUtils du = DBUtils.getInstance();

int result = du.deleteUser(userid);

if (result > 0)
	response.sendRedirect("./selectAll.jsp");
else
	response.sendRedirect("delete.jsp");
%>