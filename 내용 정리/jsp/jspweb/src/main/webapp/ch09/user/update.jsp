<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="ch04.UserDto" %>
<%@ page import="ch09.DBUtils" %>

<%
	String userid = request.getParameter("userid");
	String pw = request.getParameter("password");

	DBUtils dbutils = DBUtils.getInstance();
	int result = dbutils.updateUser(new UserDto(userid,pw));
	
	if(result>0)
	response.sendRedirect("./selectAll.jsp");
	else
	response.sendRedirect("update_form.jsp");
%>
