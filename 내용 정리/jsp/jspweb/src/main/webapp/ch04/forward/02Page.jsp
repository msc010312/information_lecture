<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%
    String un = request.getParameter("username");
    String pw = request.getParameter("password");
    System.out.println("-------------02page-------------");
    System.out.println("user name : " + un);
    System.out.println("password : " + pw);
    System.out.println("--------------------------------");
    
    request.setAttribute("02Page", "02PageValue");
    /* Forword */
    request.getRequestDispatcher("./03Page.jsp").forward(request, response);
    
    %>