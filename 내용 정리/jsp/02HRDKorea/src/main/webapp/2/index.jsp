<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="${pageContext.request.contextPath }/style.css" rel="stylesheet" />
</head>
<body>
	<div clss="wrapper">
		<%@include file="/layout/header.jsp" %>
		<%@include file="/layout/nav.jsp" %>
		<main>
			<section>
			<h2>투표하기</h2>
			<form action="">
				<div>
					<label for="">주민번호</label>
					<input type="text" />
					<span>예 : 8906153154726</span>
				</div>
				<div>
					<label for="">성명</label>
					<input type="text" />
				</div>
				<div>
					<label for="">투표번호</label>
					<select name="">
						<option value="1">1</option>
						<option value="2">2</option>
						<option value="3">3</option>
					</select>
					
				</div>
				<div>
					<label for="">투표시간</label>
					<input type="text" />
				</div>
				<div>
					<label for="">투표장소</label>
					<input type="text" />
				</div>
				<div>
					<label for="">유권자확인</label>
					<input type="radio" name="interest">
       				<label for="">확인</label>
					<input type="radio" name="interest">
       				<label for="">미확인</label>
				</div>
			</form>
			</section>
		</main>
		<%@include file="/layout/footer.jsp" %>
	</div>
</body>
</html>