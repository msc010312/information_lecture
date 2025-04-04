<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<%
	if(session.getAttribute("isAuth")!=null){
		response.sendRedirect("main.jsp");
	}
%>	
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
	input {
	display: block;
	}
	
	.save {
		position: relative;
		display: flex;
	}
	
	a{
		text-decoration: none;
		color: #333;
	}
</style>
</head>
<body>

	<h1>
	<a href="login_form.jsp">
	LOGIN FORM
	</a>
	</h1>
	<form action="${pageContext.request.contextPath}/ch07/3/login.jsp" method="post">
		<div>
			<label for="">아이디</label>
			<span>${idmsg }</span>
			<span>${id_msg }</span>
			<input type="text" name="username" value="${cookie.id != null?cookie.id.value:'' }"/>
		</div>
		<div>
			<label>패스워드</label>
			<span>${pwmsg }</span>
			<span>${pass_msg }</span>
			<input type="password" name="password" value="${cookie.pw !=null?cookie.pw.value:'' }"/>
		</div>
		<div class="save">
			<input type="checkbox" id="idSave" name="idSave" ${cookie.idchk!=null?'checked':'' }/>
			<label for="">ID저장</label>
			
			<input type="checkbox" id="pwSave" name="pwSave"/>
			<label for="">PASSWORD저장</label>
		</div>
		<button>로그인</button>
	</form>

</body>
</html>