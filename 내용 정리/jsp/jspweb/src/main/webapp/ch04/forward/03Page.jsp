<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    String un = request.getParameter("username");
    String pw = request.getParameter("password");
    String Page02Val = (String)request.getAttribute("02Page");
    System.out.println("-------------03page-------------");
    System.out.println("user name : " + un);
    System.out.println("password : " + pw);
    System.out.println("page02val : " + Page02Val);
    System.out.println("--------------------------------");
    
    request.setAttribute("03Page", "03PageValue");
    request.getRequestDispatcher("04Result.jsp").forward(request, response);
    
    %>