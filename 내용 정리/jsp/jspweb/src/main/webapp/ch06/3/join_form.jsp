<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
<h1>join</h1>
<hr>
<form action="${pageContext.request.contextPath }/ch06/3/join.jsp" method="post">
		<span>아이디</span>
		<span>${idEmpty }</span>
		<span>${id_msg }</span>
		<input type="text" name="id"/>
		<span>비밀번호</span>
		<span>${pwEmpty }</span>
		<input type="text" name="pass"/>
		<button>회원가입</button>
	</form>
</body>
</html>