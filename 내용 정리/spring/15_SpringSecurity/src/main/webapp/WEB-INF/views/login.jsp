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
	<form action="${pageContext.request.contextPath }/login" method="post">
		<div>
			<label>username : </label>
			<input name="username"/>
		</div>
		<div>
			<label>password : </label>
			<input name="password" type="password"/>
		</div>
		<div>
			<label for="rememberMe">날 기억해줘</label>
			<input id="rememberMe" type="checkbox" name="remember-me"/>
		</div>
		<button>로그인</button>
		<%-- <input type="hidden" name="_csrf" value="${_csrf.token }"/> --%>
	</form>
	${message }
	${param.error }
</body>
</html>