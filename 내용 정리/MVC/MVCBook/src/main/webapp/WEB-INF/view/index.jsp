<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<!-- link -->
	<%@include file="/resources/layouts/link.jsp" %>
	
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<div class="wrapper">
		<header>
			<!-- topHeader -->
			<%@include file="/resources/layouts/topHeader.jsp" %>
			<!-- nav -->
			<%@include file="/resources/layouts/nav.jsp" %>
		</header>
		<main class="layout">
				<h1>HOME</h1>
		</main>

		<!-- footer -->
		<%@include file="/resources/layouts/footer.jsp" %>
	</div>
	<%
		String msg = request.getParameter("message");
		if(msg!=null)
			out.print("<script> alert("+msg+"); </script>");
	%>

	<script>
		const message = '<%=request.getParameter("message")!=null ? request.getParameter("message") : "" %>';
		if(message != "");
		alert(message);
	</script>
</body>
</html>