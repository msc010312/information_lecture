<%@page import="java.net.URLEncoder"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%
    String un = request.getParameter("username");
    String pw = request.getParameter("password");
    System.out.println("-------------02page-------------");
    System.out.println("user name : " + un);
    System.out.println("password : " + pw);
    System.out.println("--------------------------------");
    
    request.setAttribute("02Page", "02PageValue");
    /* Redirect */
    response.sendRedirect("03Page.jsp?hobby="+URLEncoder.encode("등산","UTF-8"));
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>02page</h1>
<div>user name : <%=un %></div>
<div>password : <%=pw %></div>
</body>
</html>