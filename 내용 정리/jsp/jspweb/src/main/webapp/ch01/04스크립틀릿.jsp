<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
java.util.Scanner sc = new java.util.Scanner(System.in);
System.out.print("행 열 입력 : ");
int row = sc.nextInt();
int col = sc.nextInt();
System.out.printf("행 : %d, 열 : %d", row, col);
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
			<%
			for (int i = 0; i < row; i++) {
				%>
				<tr> 
				<% for(int j = 0; j<col; i++){
					%>
					<td><%=i+" : "+j %></td>
					<%
				}
				%>
				</tr>
				<% 
			}
			%>
		</tbody>
	</table>
</body>
</html>