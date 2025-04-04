<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="ch04.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	pageContext.setAttribute("pageName", "pageValue");
	request.setAttribute("requestName", "requestValue");
	session.setAttribute("sessionName", "sessionValue");
	application.setAttribute("appName", "appVal");
	
	pageContext.setAttribute("dup", "dupVal1");
	request.setAttribute("dup", "dupVal2");
%>
<!-- EL : param -->
<!-- request.getParameter()와 동일 -->
<div>username : ${param.userId }</div>
<div>password : ${param.password }</div>
<hr>
<!-- EL : Attribute -->
<!-- .getAttribute()와 동일 -->
<div>PageContext attr : ${pageName }</div>
<div>PageContext attr : ${pageScope.pageName }</div>
<hr>
<div>request attr : ${requestName }</div>
<div>request attr : ${requestScope.requestName }</div>
<hr>
<div>Session attr : ${sessionName }</div>
<div>Session attr : ${sessionScope.sessionName }</div>
<hr>
<div>application attr : ${appName }</div>
<div>application attr : ${applicationScope.appName }</div>
<hr>
<!-- 중복키 처리 -->
<!-- 키 값이 중복되면 좁은 범위의 키를 불러온다 -->
<div>Duplicated value : ${dup }</div>
<hr>
<!-- EL : Object -->
<%
UserDto ud = new UserDto("admin","1234");
request.setAttribute("ud", ud);
%>
<div>표현식 : <%=ud.getUserid() %></div>
<div>EL :  ${ud.userid}</div>
<hr>
<!-- EL : 연산자 -->
<div>표현식 : <%=1+1 %></div>
<div>EL : ${1+1 }</div> <!-- 문자열을 자동으로 int변환 해줌 -->
<hr>
<!-- Null Check -->
<div>Null : ${null }</div>
<div>empty Null : ${empty test }</div> <!-- 값이 비었으면 true 리턴 -->
<div>empty not null : ${!empty test }</div>
</body>
</html>