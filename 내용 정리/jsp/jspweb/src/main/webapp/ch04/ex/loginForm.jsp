<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div class="wrapper">
		<header>
			<!-- top-header insert 지시자 이용해서 가져오기 -->
			<%@ include file="layout/header.jsp" %>
			<!-- nav Insert 지시자 이용해서 가져오기 -->
			<%@ include file="layout/nav.jsp" %>
		</header>
		<main>
			<section>
				<!--  
						form태그로 
						
						userid
						password
						join.jsp 로 회원가입 요청 처리
					
					-->
				<h1>login</h1>
				<form action="login.jsp" method="post">
					<input type="text" name="userid" /><br> 
					<input type="text"name="password" /><br> 
					<input type="submit" value="로그인" />
				</form>
			</section>

		</main>

		<footer>
			<!-- footer insert 지시자 이용해서 가져오기 -->
			<%@ include file="layout/footer.jsp" %>
		</footer>
	</div>
</body>
</html>