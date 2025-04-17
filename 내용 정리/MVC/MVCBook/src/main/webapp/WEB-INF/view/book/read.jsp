<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*, domain.DTO.*"%>
<!DOCTYPE html>
<html>
<head>
	<!-- link -->
	<%@include file="/resources/layouts/link.jsp" %>
	
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div class="wrapper">
		<header>
			<!-- topHeader -->
			<%@include file="/resources/layouts/topHeader.jsp" %>
			<!-- nav -->
			<%@include file="/resources/layouts/nav.jsp" %>
		</header>
		<main class="layout">
				<h1>read</h1>
				<form action="${pageContext.request.contextPath }/book/update" method="post">
				<div>
					<label for="">book code : </label><span>${bookCode }</span><br>
					<input type="text" name="bookCode" placeholder=bookCode value="${bookDto.bookCode }"/>
				</div>
				<div>
					<label for="">book name : </label><span>${bookName }</span><br>
					<input type="text" name="bookName" placeholder=bookName value="${bookDto.bookName }"/>
				</div>
				<div>
					<label for="">publisher : </label> <span>${publisher }</span><br>
					<input type="text" name="publisher" placeholder=publisher value="${bookDto.publisher }"/>
				</div>
				<div>
					<label for="">isbn : </label><span>${isbn }</span><br>
					<input type="text" name="isbn" placeholder=isbn value="${bookDto.isbn }"/>
				</div>
				<div>
					<button>도서수정</button>
					<a href="${pageContext.request.contextPath }/book/delete?bookCode=${bookDto.bookCode}&pageno=${pageno}">도서삭제</a>
				</div>
			</form>
		</main>
		
		
		<!-- footer -->
		<%@include file="/resources/layouts/footer.jsp" %>
	</div>

	
</body>
</html>