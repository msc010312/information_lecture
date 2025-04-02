<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%> 
    <%
    String un = request.getParameter("username");
    String pw = request.getParameter("password");
    String Page02Val = (String)request.getAttribute("02Page");
    String Page03Val = (String)request.getAttribute("03Page");
    System.out.println("-------------result-------------");
    System.out.println("user name : " + un);
    System.out.println("password : " + pw);
    System.out.println("page02val : " + Page02Val);
    System.out.println("page03val : " + Page03Val);    
    System.out.println("--------------------------------");
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>result</h1>
	<div>user name : <%=un %></div>
	<div>password : <%=pw %></div>
	<div>Page02Val : <%=Page02Val %></div>
	<div>Page03Val : <%=Page03Val %></div>
</body>
</html>