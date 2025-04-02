<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.*,ch03.SimpleDTO" %>
<%
	Scanner sc = new Scanner(System.in);
	
	SimpleDTO sd = new SimpleDTO("aaa",123,"bbb");
	System.out.println(sd);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
name : <%=sd.getName() %><br>
age : <%=sd.getAge() %><br>
addr : <%=sd.getAddr() %>
</body>
</html>