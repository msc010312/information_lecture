<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
*{
	margin: 0;
	padding: 0;
	box-sizing: border-box;
	border-bottom: 1px solid #333;
}

a {
text-decoration: none;
color: #333;
}

ul {
list-style: none;
}

header {
min-height: 100px;
}

.top-header {
min-height: 25px;
}

nav {
min-height: 75px;
}

main {
position: relative;
height: 100vh;
}

section {
height: 100%;
}

footer {
min-height: 250px;
}


</style>
</head>
<body>
<div class="wrapper">
	<header>
	<%@ include file="layout/header.jsp" %>
	<%@ include file="layout/nav.jsp" %>
	</header>
	<main>
		<section>section</section>
	</main>
	<%@ include file="layout/footer.jsp" %>
</div>
</body>
</html>