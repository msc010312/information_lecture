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

ul,
ol {
    list-style: none;
}

a {
    color: #333;
    text-decoration: none;
}

img {
    border: 0;
    vertical-align: middle;
}

html {
    /*font-size: 10px;*/
    user-select: none;
}

body {
    /* font-family: 'IBM Plex Serif', serif; */
    overflow-x: hidden;
}

.nav {
	position: relative;
	width: 100%;
	height: 100px;
}
</style>
</head>
<body>
	<div class="nav">
		<ul style="${param.style}">
			<li><a href="05ReqNavStyle.html">${param.col1 }</a></li>
			<li><a>${param.col2 }</a></li>
			<li><a>${param.col3 }</a></li>
			<li><a>${param.col4 }</a></li>
		</ul>
	</div>
</body>
</html>