<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>manager</h1>
	<p>PRINCIPAL : <sec:authentication property="principal"/></p>
	<p>USERDTO : <sec:authentication property="principal.userDto"/></p>
	<p>Principal로 꺼낸 ID : <sec:authentication property="principal.userDto.username"/></p>
	<p>사용자의 이름 : <sec:authentication property="principal.userDto.username"/></p>
	<p>사용자의 비밀번호 : <sec:authentication property="principal.userDto.password"/></p>
	<p>사용자의 권한목록 : <sec:authentication property="principal.userDto.role"/></p>
	<sec:authorize access="isAuthenticated()">
		<p>로그인 사용자입니다.</p>
	</sec:authorize>
	<sec:authorize access="isAnonymous()">
		<p>비로그인 사용자입니다. 로그인해주세요.</p>
	</sec:authorize>
	<a href="${pageContext.request.contextPath }/logout">logout</a>
</body>
</html>