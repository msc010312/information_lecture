<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
java.util.Scanner sc = new java.util.Scanner(System.in);
System.out.print("단입력 : ");
int dan = sc.nextInt();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<table>
	<tbody>
	<%for(int i=1; i<=dan; i++){
		%>
		<tr>
			<%
			for(int j=0; j<=9; j++){
				%>
				<td><%=i+"x"+j+"="+i*j %></td>
				<%
			}
			%>
		</tr>
		<% 
	}%>
	</tbody>
</table>
</body>
</html>