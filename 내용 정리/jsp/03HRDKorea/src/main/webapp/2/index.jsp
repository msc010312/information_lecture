<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="${pageContext.request.contextPath }/style.css?after" rel="stylesheet" />
<%-- <link href="${pageContext.request.contextPath }/2/vote.css?after" rel="stylesheet" /> --%>
<style type="text/css">
section {
	position: relative;
	display: flex;
	flex-direction: column;
	justify-content: center;
	align-items: center;
	height: 100%;
}

table {
	position: relative;
	width: 50vw;
	height: 50%;
	border-collapse: collapse;
}

caption {
	font-size: 1.5rem;
	font-weight: 900;
	margin-bottom: 20px;
}

th,td{
	border: 1px solid #333;
	padding: 20px 10px;
}

.tbl-input {
	position: relative;
}

.tbl-btn {
	text-align: center;
}

.tbl-btn>button: {
	margin: 0 20px;
}

</style>
</head>
<body>
	<div class="wrapper">
		<%@include file="/layout/header.jsp" %>
		<%@include file="/layout/nav.jsp" %>
		<main>
			<section>
				<form class="class-form" action="create.jsp" method="post" onsubmit="return false" name="classForm">
					<table>
						<caption>수강신청</caption>
						<tr>
							<td>수강월</td>
							<td class="tbl-input">
								<input type="text" />
								<span>예) 2022년 03월 → 202203</span>
							</td>
						</tr>
						<tr>
							<td>회원명</td>
							<td class="tbl-input">
								<input type="text" />
							</td>
						</tr>
						<tr>
							<td>회원번호</td>
							<td class="tbl-input">
								<input type="text" />
								<span>예) 10001</span>
							</td>
						</tr>
						<tr>
							<td>강의장소</td>
							<td class="tbl-input">
								<input type="text" />
							</td>
						</tr>
						<tr>
							<td>강의명</td>
							<td class="tbl-input">
								<input type="text" />
							</td>
						</tr>
						<tr>
							<td>수강료</td>
							<td class="tbl-input">
								<input type="text" />
								<span>원</span>
							</td>
						</tr>
						<tr>
							<td colspan="2" class="tbl-btn">
								<button type="submit" onclick="isValid()">수강신청</button>
								<button type="reset">다시쓰기</button>
							</td>
						</tr>
					</table>
				</form>
			</section>
		</main>
		<%@include file="/layout/footer.jsp" %>
	</div>
	<script type="text/javascript">
		function isValid() {
			//form 요소 찾기
			const voteForm = document.voteForm;
			//유효성 검사
			if(voteForm.v_jumin.value === ""){
				alert("주민번호가 입력되지 않았습니다");
				voteForm.v_jumin.focus();
				return;
			}
			if(voteForm.v_name.value === ""){
				alert("성명이 입력되지 않았습니다");
				voteForm.v_name.focus();
				return;
			}
			if(voteForm.m_num.value === ""){
				alert("후보번호가 선택되지 않았습니다");
				voteForm.m_num.focus();
				return;
			}
			if(voteForm.v_time.value === ""){
				alert("투표시간이 입력되지 않았습니다");
				voteForm.v_time.focus();
				return;
			}
			if(voteForm.v_area.value === ""){
				alert("투표장소가 입력되지 않았습니다");
				voteForm.v_area.focus();
				return;
			}
			if(voteForm.v_confirm.value === ""){
				alert("유권자확인이 선택되지않았습니다");
				voteForm.v_confirm.focus();
				return;
			}
			//submit처리
			voteForm.submit();
		}
	</script>
</body>
</html>