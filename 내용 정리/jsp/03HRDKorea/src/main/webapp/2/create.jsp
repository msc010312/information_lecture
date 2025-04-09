<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="utils.*" %>   

<!-- 파라미터 받기 (액션태그)-->
<jsp:useBean id="classDto2" class="utils.ClassDTO" scope="request"></jsp:useBean>
<jsp:setProperty property="*" name="classDto2"/>

<% 
	int result = DBUtils.getInstance().insertClass(classDto2);
	System.out.println(classDto2);
	if(result > 0){
	out.print("<script>alert('수강신청이 정상적으로 완료되었습니다.')</script>");
	response.sendRedirect("../index.jsp");
	}
	else
	response.sendRedirect("./index.jsp");
	
%>