<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
/* Request 내장객체 - 요청정보값 저장  */
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
<body bgcolor=<%=bgColor.equals("")?"#ccc":bgColor %>>

username : <%=username %>
<hr>
password : <%=password %>
<hr>
bgColor : <%=bgColor %>

</body>
</html>