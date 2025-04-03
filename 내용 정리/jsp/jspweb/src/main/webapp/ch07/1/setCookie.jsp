<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- 
	Cookie
	문자열 데이터만 저장가능
	4kbyte 이하의 공간을 차지
	여러개의 쿠기 설정가능(최대 300개)
	도메인당 20개까지 저장가능
	저장한도를 초과하면 최근에 사용되지 않는 쿠키부터 자동삭제
 -->
 <%
 	Cookie ck1 = new Cookie("myCookie1","myCookie1Value");
 	ck1.setMaxAge(30); // 쿠키유지시간(기본값 -1 : 파일생성x, 브라우저가 종료될때까지 쿠키저장)
 
 	Cookie ck2 = new Cookie("myCookie2","myCookie2Value");
 	ck2.setMaxAge(60*5);
 	
 	response.addCookie(ck1);
 	response.addCookie(ck2);
 %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<a href="getCookie.jsp">쿠키확인하기</a>

</body>
</html>