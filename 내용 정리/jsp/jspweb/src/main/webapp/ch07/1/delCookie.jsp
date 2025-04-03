<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String cookieName = request.getParameter("cookieName");
	if(cookieName !=null) {
		Cookie cookie = new Cookie(cookieName, ""); // 빈 value의 쿠키생성
		cookie.setMaxAge(0); // 쿠키유지시간을 0으로 적용시켜 만료시킨다
		cookie.setPath("/"); // 쿠키적용 URI 설정
		response.addCookie(cookie); // 만료처리 전달
	}
	
	out.println("<script>alert('쿠기삭제완료!'); location.href='getCookie.jsp';</script>");
	
	
%>