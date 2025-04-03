<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<%
	if(session.getAttribute("isAuth")!=null){
		response.sendRedirect("main.jsp");
	}
%>	
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
	input {
	display: block;
	}
</style>
</head>
<body>

	<h1>LOGIN FORM</h1>
	<div>${message }</div>
	<form action="${pageContext.request.contextPath}/ch06/2/login.jsp" method="post">
		<div>
			<label for="">아이디</label>
			<span>${idmsg }</span>
			<span>${id_msg }</span>
			<input type="text" name="username" />
		</div>
		<div>
			<label>패스워드</label>
			<span>${pwmsg }</span>
			<span>${pass_msg }</span>
			<input type="text" name="password" />
		</div>
		<button>로그인</button>
	</form>

</body>
</html>