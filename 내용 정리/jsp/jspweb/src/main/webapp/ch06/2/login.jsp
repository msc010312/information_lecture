<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>


<%
	String name = request.getParameter("username");
	String pw = request.getParameter("password");
	// 파라미터 유효성 체크
	if(name.isEmpty()){
		out.println("<script>alert('username을 입력하세요');location.href='./login_form.jsp'</script>");
				
	}
	if(pw.isEmpty()){
		out.println("<script>alert('password을 입력하세요');location.href='./login_form.jsp'</script>");

	}	
	
	//01 ID 확인(DB 조회 - 생략)
	//02 PW 확인(일치여부 확인)
	//03 사용자 상태정보(인증됨)를 Session 저장
	//04 로그인 처리후 MAIN PAGE REDIRECT
	session.setAttribute("username", name);
	session.setAttribute("password", pw);
	
	request.getRequestDispatcher("main.jsp");
%>