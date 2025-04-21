<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*,java.io.*" %>
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
				<h1>File List</h1>
				<%
					Map<String,List<File>> map = request.getAttribute("list")!=null?(Map<String,List<File>>)request.getAttribute("list"):null;
				
					if(map!=null){
						for(String folder : map.keySet()) {
							%>
							<h3><%=folder %></h3>
							<%
							List<File> list = map.get(folder);
							for(File file : list) {
								%>
								<a href="javascript:void(0)"><%=file.getName() %></a>
								<%
							}
							out.println("<hr>");
						}
					}
				%>
				
				
		</main>
		
		
		<!-- footer -->
		<%@include file="/resources/layouts/footer.jsp" %>
	</div>

	
</body>
</html>