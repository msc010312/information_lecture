<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="ch04.*"%>

<!-- 속성 기능 추가 -->
<%!private String url = "jdbc:oracle:thin:@localhost:1521:xe";
	private String id = "system";
	private String password = "1234";

	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;

	private void getConnection() throws Exception {
		if (conn == null) {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			//오라클 DB 서버 연결
			conn = DriverManager.getConnection(url, id, password);
		}
	};

	private int insert(UserDto userDto) throws Exception {
		pstmt = conn.prepareStatement("insert into tbl_user values(?,?)");
		pstmt.setString(1, userDto.getUserid());
		pstmt.setString(2, userDto.getPassword());
		int result = pstmt.executeUpdate();
		conn.commit();
		pstmt.close();
		return result;
	}

	private UserDto select(String userid) throws Exception {
		pstmt = conn.prepareStatement("select * from tbl_user where userid=? ");
		pstmt.setString(1, userid);
		rs = pstmt.executeQuery();
		UserDto userDto = null;
		if(rs!=null){
			if(rs.next()){
				userDto = new UserDto();
				userDto.setUserid(userid);
				userDto.setPassword(rs.getString("password"));
			}
		}
		rs.close();
		pstmt.close();
		return userDto;
	}%>
<!-- 함수 추가 -->
<%
String url = (String) request.getAttribute("url");
Integer serviceNum = (Integer) request.getAttribute("serviceNum");
System.out.println(url);
System.out.println(serviceNum);
	if (url.contains("/join")) {
		getConnection();
		UserDto ud = (UserDto) request.getAttribute("userDto");
		if (insert(ud) > 0) {
	response.sendRedirect("loginForm.jsp"); //Redirect 다수 사용시 return 필수
	return;
		}
	}
if(url.contains("/myInfo")){
	getConnection();
	String userid = request.getParameter("userid");
	UserDto userdto = select(userid);
	request.setAttribute("myInfoResult", userdto);
	request.setAttribute("isConfirm",true);
	if(userdto != null){
		request.getRequestDispatcher("").forward(request, response);
	}
	
}
%>