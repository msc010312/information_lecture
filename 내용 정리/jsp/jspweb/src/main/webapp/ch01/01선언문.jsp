<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- 선언문(서블릿으로 변환되는 자바파일의 속성/기능을 추가) -->
	<%!//서블릿 파일의 맴버변수(속성)
	String name = "hong";

	//서블릿 파일의 맴버 함수(기능)
	public String testFunc() {
		System.out.println("선언문 테스트");
		return name;
	}%>
	<!-- 표현식(Servelet 파일(java파일)안의 값을 프론트앤드에 전달 표현할때 사용-->
	Name :
	<%=name%><br /> 
	TestFunc() :<%=testFunc()%><br />

</body>
</html>