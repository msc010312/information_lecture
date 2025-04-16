<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.*, domain.DTO.*" %>
<!DOCTYPE html>
<html>
<head>
<!-- link -->
<%@include file="/resources/layouts/link.jsp"%>

<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<div class="wrapper">
		<header>
			<!-- topHeader -->
			<%@include file="/resources/layouts/topHeader.jsp"%>
			<!-- nav -->
			<%@include file="/resources/layouts/nav.jsp"%>
		</header>
		<main class="layout">
			<h1>book list</h1>
			<!-- 게시물 필터(전체/이름/출판사/코드) -->
			<section></section>
			<!-- 게시물 표시 -->
			<section>
				<div>
					page : <span>1</span> / <span>100</span> (현재페이지/전체페이지)
				</div>
				<table class="table">
					<thead>
						<tr class="bg-dark text-light">
							<th>도서코드</th>
							<th>제목</th>
							<th>출판사</th>
							<th>분류코드</th>
						</tr>
					</thead>
					<tbody>
						<%
							List<BookDTO> list = request.getAttribute("list") != null? (List<BookDTO>)request.getAttribute("list"):null;
							if(list==null){
								out.println("<td colspan=4>조회 할 데이터가 없습니다</td>");
							} else{
								
								
							for(BookDTO book : list){
						%>
						<tr>
							<td><%=book.getBookCode() %></td>
							<td><%=book.getBookName() %></td>
							<td><%=book.getPublisher() %></td>
							<td><%=book.getIsbn() %></td>
						</tr>
						<%
								}
							}
						%>
					</tbody>
					<tfoot>
						<tr>
							<td colspan="3">
								<nav aria-label="Page navigation example">
									<ul class="pagination">
										<%
											PageDto pageDto = request.getAttribute("pageDto")!=null?(PageDto)request.getAttribute("pageDto"):null;
										%>
										<%
											if(pageDto!=null&&pageDto.isPrev())
											{
										%>
										<!-- 이전버튼 -->
										<li class="page-item">
											<a class="page-link" href="#" aria-label="Previous"> 
												<span aria-hidden="true">&laquo;</span>
											</a>
										</li>
										<%
											}
										%>
										<%
											if(pageDto!= null){
											int startNo = pageDto.getStartPage();
											int endNo = pageDto.getEndPage();
											for(int i = startNo; i<=endNo; i++){
										%>
										<li class="page-item"><a class="page-link" href="#"><%=i %></a></li>
										<%
											}
										}
										%>
										<%
											if(pageDto!=null&&pageDto.isNext())
											{
										%>
										<!-- 다음버튼 -->
										<li class="page-item">
											<a class="page-link" href="#" aria-label="Next"> 
												<span aria-hidden="true">&raquo;</span>
											</a>
										</li>
										<%
											}
										%>
									</ul>
								</nav>
							</td>
							<td>
								<!-- 글쓰기 --> 
								<a href="javascript:void(0)" class="btn btn-success">도서등록</a>
								<!-- 처음으로 -->
								<a href="javascript:void(0)" class="btn btn-secondary">도서등록</a>
							</td>
						</tr>
					</tfoot>
				</table>
			</section>
		</main>


		<!-- footer -->
		<%@include file="/resources/layouts/footer.jsp"%>
	</div>


</body>
</html>