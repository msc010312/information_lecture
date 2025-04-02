<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    String un = request.getParameter("username");
    String pw = request.getParameter("password");
    String Page02Val = (String)request.getAttribute("02Page");
    String hobby = request.getParameter("hobby");
    System.out.println("-------------03page-------------");
    System.out.println("user name : " + un);
    System.out.println("password : " + pw);
    System.out.println("page02val : " + Page02Val);
    System.out.println(hobby);
    System.out.println("--------------------------------");
    
    response.sendRedirect("./04Result.jsp");
    
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>03Page</h1>
</body>
</html>