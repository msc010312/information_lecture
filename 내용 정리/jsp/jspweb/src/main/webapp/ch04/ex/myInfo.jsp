<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
Boolean isConfirm = (request.getAttribute("isConfirm")!=null)?(Boolean)request.getAttribute("isConfirm"):null;
if(isConfirm ){
	
}else {
	request.setAttribute("url", "/myinfo"); // DB요청처리
	request.setAttribute("serviceNum", 2); // C : 1, R : 2, U : 3, D : 4
	request.getRequestDispatcher("validationCheck.jsp").forward(request, response);
	return;
}
%>
<!doctype html>
<html lang="ko">
<head>
	<meta charset="UTF-8" />
	<title>Document</title>
</head>
<body>
	<h1>Myinfo확인</h1>
</body>
</html>