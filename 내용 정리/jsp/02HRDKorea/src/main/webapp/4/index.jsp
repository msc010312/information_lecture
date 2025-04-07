<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
* {
	margin: 0;
	padding: 0;
	box-sizing: border-box;
	outline-style: none;
}

ul {
	list-style: none;
}

a {
	text-decoration: none;
	color: #333;
}

img {
    border: 0;
    vertical-align: middle;
}

html {
    user-select: none;
}

body {
    overflow-x: hidden;
}

.wrapper {
	position:relative;
	height: 100vh;
}

header {
	position:relative;
	display: flex;
	justify-content: center;
	height: 150px;
	line-height: 150px;
	border-bottom: 1px solid #333;
	font-weight: 900;
}

nav {
	border-bottom: 1px solid #333;
}

.h-nav {
	position:relative;
	display: flex;
	gap: 50px;
	margin : 10px 0;
	padding : 0 15px;
}

main {
	position: relative;
	height: 64vh;
}

footer {
	position:relative;
	display: flex;
	justify-content: center;
	height: 150px;
	line-height: 150px;
	font-weight: 900;
	border-top: 1px solid #333;
}

</style>
</head>
<body>
	<div clss="wrapper">
		<%@include file="/layout/header.jsp" %>
		<%@include file="/layout/nav.jsp" %>
		<main>
			<section></section>
		</main>
		<%@include file="/layout/footer.jsp" %>
	</div>
</body>
</html>