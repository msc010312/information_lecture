<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="ch04.UserDto" %>
<%@ page import="ch09.DBUtils" %>   
    
<%
	String userid = request.getParameter("userid");
	DBUtils dbutils = DBUtils.getInstance();
	UserDto result = dbutils.selectOneUser(userid);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!--  
		1. dbutils에서 selectOneUser(String userid) 를 받아 단건 조회가 되도록 코드 생성
		2. selectOneUser함수를 이용해서 해당 사용자 정보 받아와서 form>input에 각각 표시
		3. dbutils에서 updateUser(UserDto userDto)를 생성 -> Update 처리코드
		4. update_form.jsp 에서 수정요청 버튼 클릭하면 ./update.jsp에서 업데이트 처리
		5. 처리완료이후 selectAll.jsp 이동
		
	-->

	<h1>USER UPDATE</h1>
	<form action="./update.jsp">
		<input type="text" name="userid" value="<%= result.getUserid()%> " readonly/> <br/>
		<input type="text" name="password" value="<%=result.getPassword()%>"/> <br/>
		<button>수정요청</button>
		<a href="javascript:history.go(-1)">이전으로</a>
	</form>
	
</body>
</html>
