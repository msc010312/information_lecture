<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="utils.*" %>

<!-- 파라미터 받기 -->
<%
	request.setCharacterEncoding("UTF-8");
	response.setCharacterEncoding("UTF-8");
	response.setContentType("text/html; charset=UTF-8");
	
	String jumin = request.getParameter("v_jumin");
	String name = request.getParameter("v_name");
	String num = request.getParameter("m_num");
	String time = request.getParameter("v_time");
	String area = request.getParameter("v_area");
	String confirm = request.getParameter("v_confirm");
	
	VoteDTO vd = new VoteDTO(jumin,name,num,time,area,confirm);
%>    

<!-- 파라미터 받기 (액션태그)-->
<jsp:useBean id="voteDto2" class="utils.VoteDTO" scope="request"></jsp:useBean>
<jsp:setProperty property="*" name="voteDto2"/>

<% 
	int result = DBUtils.getInstance().insertVote(voteDto2);
	System.out.println(voteDto2);
	if(result > 0)
	request.getRequestDispatcher("./read.jsp").forward(request, response);
	else
	request.getRequestDispatcher("./index.jsp").forward(request, response);
	
%>