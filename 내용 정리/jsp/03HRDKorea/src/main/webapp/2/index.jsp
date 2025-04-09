<%@page import="utils.*"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
List<MemberDTO> list = DBUtils.getInstance().selectAllMember();
List<TeacherDTO> list2 = DBUtils.getInstance().selectAllTeacher();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="${pageContext.request.contextPath }/style.css?after"
	rel="stylesheet" />
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

tr>td:first-child {
	text-align: center;
}

th, td {
	border: 1px solid #333;
	padding: 20px 10px;
}

.tbl-input {
	position: relative;
}

.tbl-input>input {
	height: 25px;
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
		<%@include file="/layout/header.jsp"%>
		<%@include file="/layout/nav.jsp"%>
		<main>
			<section>
				<form class="class-form" action="create.jsp" method="post"
					onsubmit="return false" name="classForm">
					<table>
						<caption>수강신청</caption>
						<tr>
							<td>수강월</td>
							<td class="tbl-input"><input type="text" name="c_reg" /> <span>예)
									2022년 03월 → 202203</span></td>
						</tr>
						<tr>
							<td>회원명</td>
							<td class="tbl-input"><select name="c_name">
									<option hidden>회원명</option>
									<%
									for (MemberDTO md : list) {
									%>
									<option data-no=<%=md.getC_no()%> value=<%=md.getC_name()%>><%=md.getC_name()%></option>
									<%
									}
									%>
							</select></td>
						</tr>
						<tr>
							<td>회원번호</td>
							<td class="tbl-input"><input type="text" name="c_no" /> <span>예)
									10001</span></td>
						</tr>
						<tr>
							<td>강의장소</td>
							<td class="tbl-input"><input type="text" name="c_area" /></td>
						</tr>
						<tr>
							<td>강의명</td>
							<td class="tbl-input"><select name="class_name">
									<option hidden>강의신청</option>
									<%
									for (TeacherDTO td : list2) {
									%>
									<option data-price=<%=td.getClass_price()%>
										value=<%=td.getClass_name()%>><%=td.getClass_name()%></option>
									<%
									}
									%>
							</select></td>
						</tr>
						<tr>
							<td>수강료</td>
							<td class="tbl-input"><input type="text" name="cost" /> <span>원</span>
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
		<%@include file="/layout/footer.jsp"%>
	</div>
	<script type="text/javascript">
		const form = document.classForm;
		let cno;
		let price;
		form.c_name.addEventListener('change', function(e) {
			const selectEl = e.target;
			const seletedOption = selectEl.options[selectEl.selectedIndex];
			cno = seletedOption.getAttribute("data-no");
			form.c_no.value = cno;
			if (price != null || price != undefined) {
				if (cno < 20000)
					form.cost.value = price;
				else
					form.cost.value = (price / 2);
			}
		});

		form.class_name.addEventListener('change', function(e) {
			const selectEl = e.target;
			const seletedOption = selectEl.options[selectEl.selectedIndex];
			price = seletedOption.getAttribute("data-price");

			if (cno < 20000)
				form.cost.value = price;
			else
				form.cost.value = (price / 2);
		});
		function isValid() {
			//유효성 검사
			if (form.c_reg.value === "") {
				alert("수강월이 입력되지 않았습니다");
				form.c_reg.focus();
				return;
			}
			if (form.c_name.value === "") {
				alert("회원명이 선택되지 않았습니다");
				form.c_name.focus();
				return;
			}
			if (form.c_no.value === "") {
				alert("회원번호가 입력되지 않았습니다");
				form.c_no.focus();
				return;
			}
			if (form.c_area.value === "") {
				alert("강의장소가 입력되지 않았습니다");
				form.c_area.focus();
				return;
			}
			if (form.teacher_code.value === "") {
				alert("강의명이 입력되지 않았습니다");
				form.teacher_code.focus();
				return;
			}
			if (form.cost.value === "") {
				alert("수강료가 입력되지 않았습니다");
				form.cost.focus();
				return;
			}
			//submit처리
			form.submit();
		}
	</script>
</body>
</html>