<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>login</h1>
	<form action="${pageContext.request.contextPath }/login.do" method="post">
		<input type="text" name="id"/>
		<input type="text" name="password"/>
		<button>회원가입</button>
	</form>
	<div>
		${username_msg }	
	</div>
	<div>
		${password_msg }
	</div>
	<a href="join.do">회원가입</a>
</body>
</html>