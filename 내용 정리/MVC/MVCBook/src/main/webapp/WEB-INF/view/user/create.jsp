<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<!-- link -->
<%@include file="/resources/layouts/link.jsp"%>

<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<div class="wrapper">
		<header>
			<!-- topHeader -->
			<%@include file="/resources/layouts/topHeader.jsp"%>
			<!-- nav -->
			<%@include file="/resources/layouts/nav.jsp"%>
		</header>
		<main class="layout">
			<h1>회원가입</h1>
			<form action="${pageContext.request.contextPath }/user/create"
				method="post">
				<input type="text" name="username" /> <input type="text"
					name="password" />
				<button>회원가입</button>
			</form>
			<div>${username_err }</div>
		</main>


		<!-- footer -->
		<%@include file="/resources/layouts/footer.jsp"%>
	</div>


</body>
</html>


