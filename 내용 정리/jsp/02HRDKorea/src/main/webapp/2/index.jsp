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

h2 {
	margin-bottom: 20px;
}

.vote-div{
	display: flex;
	justify-content:center;
	align-items: center;
	flex-direction: column;
	width:100%;
	height:100%;
}
.vote-form {
	position: relative;
	display: flex;
	flex-direction: column;
	gap: 15px;
	width : 50%;
	height: 50%;
	padding: 25px 25px;
}

.vote-form>div>input {
	margin-left: 10px;
}
</style>
</head>
<body>
	<div class="wrapper">
		<%@include file="/layout/header.jsp" %>
		<%@include file="/layout/nav.jsp" %>
		<main>
			<section>
			
			<div class="vote-div">
			<h2>투표하기</h2>
			<form class="vote-form" action="create.jsp" method="post" onsubmit="return false" name="voteForm">
				<div>
					<label>주민번호</label>
					<input type="text" name="v_jumin"/>
					<span>예 : 8906153154726</span>
				</div>
				<div>
					<label>성명</label>
					<input type="text" name="v_name"/>
				</div>
				<div>
					<label>후보번호</label>
					<select name="m_num">
						<option hidden></option>
						<option value="1">1</option>
						<option value="2">2</option>
						<option value="3">3</option>
						<option value="4">4</option>
					</select>
				</div>
				<div>
					<label>투표시간</label>
					<input type="text" name="v_time"/>
				</div>
				<div>
					<label>투표장소</label>
					<input type="text" name="v_area"/>
				</div>
				<div>
					<label>유권자확인</label>
					<input type="radio" name="v_confirm" value="Y">
       				<label>확인</label>
					<input type="radio" name="v_confirm" value="N">
       				<label>미확인</label>
				</div>
				<div class="btn">
					<button type="submit" onclick="isValid()">투표하기</button>
					<button type="reset">다시하기</button>
				</div>
			</form>
			</div>
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