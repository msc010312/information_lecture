<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" errorPage="error.jsp"%>
<%@ page import="ch04.UserDto"%>

<%
//request로부터 전달받은 파라미터 꺼내서 System.out 확인
//받은 username,password 값이 null인지여부를 체크(String API trim()  + isEmpty() 이용)
//에러 발생 시 처리되는 페이지로 전달(error.jsp)
//에러 미 발생 시 dbutils.jsp로 해당 내용 포워딩

String url = (String) request.getAttribute("url");
Integer serviceNum = (Integer) request.getAttribute("serviceNum");

if (url.contains("/join")) {
	//join
	UserDto ud = (UserDto) request.getAttribute("userDto");
	isValid(ud);
} else if (url.contains("/myInfo")) {
	String userid = request.getParameter("userid");
	isValid(userid);
}

request.getRequestDispatcher("dbutils.jsp").forward(request, response);
%>

<%!void isValid(UserDto ud) throws Exception {
		System.out.println(ud);
		if (ud == null)
			throw new Exception("UserDto가 null 입니다");
		if (ud.getUserid().trim().isEmpty())
			throw new Exception("ID를 입력하세요");
		if (ud.getPassword().trim().isEmpty())
			throw new Exception("password를 입력하세요");
	}

	void isValid(String userid) throws Exception{
		if (userid.trim().isEmpty())
			throw new Exception("UserDto가 null 입니다");
	}%>