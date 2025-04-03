<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>


<%
	String name = request.getParameter("username");
	String pw = request.getParameter("password");
	// 파라미터 유효성 체크
	if(name.isEmpty()){
		// out.println("<script>alert('username을 입력하세요');location.href='./login_form.jsp'</script>");
		request.setAttribute("idmsg", "아이디를 입력하세요");	
	}
	if(pw.isEmpty()){
		//out.println("<script>alert('password을 입력하세요');location.href='./login_form.jsp'</script>");
		request.setAttribute("pwmsg", "패스워드를 입력하세요");
	}
	
	if(name.isEmpty() || pw.isEmpty()) {
		request.getRequestDispatcher("login_form.jsp").forward(request, response);
		return;
	}
	
	//01 ID 확인(DB 조회 - 생략)
	if(!name.equals("admin")){
		request.setAttribute("id_msg", "해당id는 존재하지 않습니다");
		request.getRequestDispatcher("login_form.jsp").forward(request, response);
		return;
	}
	//02 PW 확인(일치여부 확인)
	if(!pw.equals("1234")){
		request.setAttribute("pass_msg", "패스워드가 일치하지 않습니다");
		request.getRequestDispatcher("login_form.jsp").forward(request, response);
		return;
	}
	
	//03 사용자 상태정보(인증됨)를 Session 저장
	session.setAttribute("isAuth", true);
	session.setAttribute("role", "role_admin");
	session.setMaxInactiveInterval(30);
	
	//04 로그인 처리후 MAIN PAGE REDIRECT
	
	response.sendRedirect("main.jsp");
%>