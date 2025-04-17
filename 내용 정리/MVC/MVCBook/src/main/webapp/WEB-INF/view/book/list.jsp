<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.*, domain.DTO.*"%>
<!DOCTYPE html>
<html>
<head>
<!-- link -->
<%@include file="/resources/layouts/link.jsp"%>

<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
	PageDto pageDto = request.getAttribute("pageDto") != null ? (PageDto) request.getAttribute("pageDto") : null;
	String type = null;
	String keyword = null;
	if(pageDto!=null) {
		type=pageDto.getCriteria().getType();
		keyword = pageDto.getCriteria().getKeyword();
	}
	%>
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
					total count : <span><%=pageDto.getTotalCount() %></span><br>
					page : <span><%=pageDto.getCriteria().getPageno() %></span> / <span><%=pageDto.getTotalpage() %></span> (현재페이지/전체페이지)
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
						List<BookDTO> list = request.getAttribute("list") != null ? (List<BookDTO>) request.getAttribute("list") : null;
						if (list == null) {
							out.println("<td colspan=4>조회 할 데이터가 없습니다</td>");
						} else {

							for (BookDTO book : list) {
						%>
						<tr>
							<td><%=book.getBookCode()%></td>
							<td><a href="${pageContext.request.contextPath }/book/read?bookCode=<%=book.getBookCode()%>&pageno=<%=pageDto.getCriteria().getPageno()%>"><%=book.getBookName()%></a></td>
							<td><%=book.getPublisher()%></td>
							<td><%=book.getIsbn()%></td>
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
										if (pageDto != null && pageDto.isPrev()) {
										%>
										<!-- 이전버튼 -->
										<li class="page-item">
										<a class="page-link" href="${pageContext.request.contextPath }/book/list?pageno=<%=pageDto.getStartPage()-pageDto.getPagePerBlock()%>" aria-label="Previous"> 
											<span aria-hidden="true">&laquo;</span>
										</a>
										</li>
										<%
										}
										%>
										<%
										if (pageDto != null) {
											int startNo = pageDto.getStartPage();
											int endNo = pageDto.getEndPage();
											
											String pageParam = request.getParameter("pageno");
										    int currentPage = 1;
										    if (pageParam != null) {
										    	try {
										   			currentPage = Integer.parseInt(pageParam);
										        }catch (NumberFormatException e) {
										           currentPage = 1;
										        }
										    }
											for (int i = startNo; i <= endNo; i++) {
												   String activeClass = (i == currentPage) ? "active" : "";
													if(type==null || type.isEmpty()) {
										%>
										<li class="page-item <%=activeClass %>">
											<a class="page-link" href="${pageContext.request.contextPath }/book/list?pageno=<%=i%>"><%=i%></a>
										</li>
										<%
												}
												else
												{
												%>
												<li class="page-item <%=activeClass %>">
													<a class="page-link" href="${pageContext.request.contextPath }/book/list?pageno=<%=i%>&type=<%=type%>&keyword=<%=keyword%>"><%=i%></a>
												</li>
												<%	
												}
											}
										}
										%>
										<%
										if (pageDto != null && pageDto.isNext()) {
										%>
										<!-- 다음버튼 -->
										<li class="page-item">
											<a class="page-link" href="${pageContext.request.contextPath }/book/list?pageno=<%=pageDto.getEndPage()+1 %>" aria-label="Next"> <span aria-hidden="true">&raquo;</span></a>
										</li>
										<%
										}
										%>
									</ul>
								</nav>
							</td>
							<td>
								<!-- 글쓰기 --> 
								<a href="${pageContext.request.contextPath }/book/create" class="btn btn-success">도서등록</a> 
								<!-- 처음으로 --> 
								<a href="javascript:void(0)" class="btn btn-secondary">처음으로</a>
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