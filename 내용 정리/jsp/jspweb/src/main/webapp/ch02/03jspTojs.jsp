<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    String msg1 = "hello1";
    String msg2 = "hello2";
    String msg3 = "hello3";
    String msg4 = "hello4";
    request.setAttribute("message", "test");
    request.setAttribute("message2", "test");
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<script>
<%-- const message1 = '<%= msg1%>';
const message2 = '<%= msg2%>';
const message3 = '<%= msg3%>';
const message4 = '<%= msg4%>'; --%>
const message1 = '${message}'; // EL
const message2 = '${message2}'; // EL
const message3 = `${message3}`; // 보간법(jsp의 message값을 리터럴 형태로 변환)
console.log(message1);
console.log(message2);
console.log(message3);
</script>
</body>
</html>