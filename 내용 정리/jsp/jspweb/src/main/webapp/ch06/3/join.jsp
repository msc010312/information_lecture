<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@page import="ch06.*" %>
<%-- <%
String url = "jdbc:oracle:thin:@localhost:1521:xe";
String id = "system";
String password = "1234";

Connection conn = null;
PreparedStatement pstmt = null;
ResultSet rs = null;

try{
Class.forName("oracle.jdbc.driver.OracleDriver");
//오라클 DB 서버 연결
conn = DriverManager.getConnection(url, id, password);

private int select(UserDTO userdto) throws Exception{
	pstmt = conn.prepareStatement("select * from join_tbl where userid=? ");
	pstmt.setString(1, userdto.getUserid());
	rs = pstmt.executeQuery();
	if(rs.next()){
		return 1;
	}
	return -1;
}
} catch(Exception e){
	e.printStackTrace();
} finally {
	if(rs != null)
		rs.close();
	if(pstmt != null)
		pstmt.close();
}
	String id = request.getParameter("id");
	String pw = request.getParameter("pass");
	
	if(id.isEmpty()) {
		request.setAttribute("idEmpty", "id를 입력하세요");
	}
	if(pw.isEmpty()) {
		request.setAttribute("pwEmpty", "패스워드를 입력하세요");
	}
	if(id.isEmpty() || pw.isEmpty()){
		request.getRequestDispatcher("join_form.jsp").forward(request, response);
		return;
	}
	
	if(select(ud)==1){
		request.setAttribute("id_msg", "이미존재하는 ID입니다");
		request.getRequestDispatcher("join_form.jsp").forward(request, response);
		return;
	};
%> --%>