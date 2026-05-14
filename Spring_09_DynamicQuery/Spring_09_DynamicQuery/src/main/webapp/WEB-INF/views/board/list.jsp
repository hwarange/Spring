<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>전체목록</title>
<%@ include file="../common/bootstrap.jsp" %>
</head>
<body>
	<div class="container">
		<h2>게시글 목록</h2>
		<hr>

		<%-- TODO 23 (완성본 제공)
		  메인 실습 1의 마지막 단계 — searchForm.jsp 를 화면에 포함시키는 줄입니다.
		  → 검색 폼(TODO_01) 이 list.jsp 위쪽에 노출됨.
		--%>
		<%@ include file="../common/searchForm.jsp"%>

		<%-- TODO 11 (완성본 제공)
		  미니 실습 ③ — 다건 삭제 폼으로 테이블 전체를 감쌌습니다.
		  아래 포인트를 코드에서 직접 확인하세요.

		  ① <form action="deleteMany" method="POST"> — 삭제는 POST! (부수효과 있음)
		     → BoardController 의 /deleteMany 와 매핑됨 (TODO_10)
		  ② 각 행의 <input type="checkbox" name="ids" value="${board.id}">
		     → 같은 name 으로 여러 값 전송 → 컨트롤러에서 List<Integer> 로 받음
		  ③ 헤더의 마스터 체크박스 + toggleAll() JS 함수 — 흔한 UX 패턴
		  ④ confirm() 으로 실수 방지
		--%>
		<form action="deleteMany" method="POST">
			<table class="table">
				<tr>
					<th><input type="checkbox" onclick="toggleAll(this)"></th>
					<th>글번호</th>
					<th>글제목</th>
					<th>글쓰니</th>
					<th>조회수</th>
					<th>작성일</th>
				</tr>
				<c:forEach items="${boardList}" var="board">
					<tr>
						<td><input type="checkbox" name="ids" value="${board.id}"></td>
						<td>${board.id}</td>
						<td><a href="/detail?id=${board.id}">${board.title}</a></td>
						<td>${board.writer}</td>
						<td>${board.viewCnt}</td>
						<td>${board.regDate}</td>
					</tr>
				</c:forEach>
			</table>
			<button type="submit" class="btn btn-danger"
				onclick="return confirm('선택한 게시글을 모두 삭제하시겠습니까?')">선택 삭제</button>
			<a href="writeform" class="btn btn-primary">글쓰기</a>

			<%-- TODO 18 (완성본 제공)
			  미니 실습 ⑤ — 인기 게시글 진입 링크입니다.
			  → /popular?min=15 로 이동 → BoardController 의 /popular 와 매핑됨 (TODO_17)
			  → 조회수가 15 이상인 게시글만 필터링되어 보임 (매퍼의 CDATA 부등호)
			--%>
			<a href="popular?min=15" class="btn btn-info">인기글 (조회수 15 이상)</a>
		</form>

	</div>

	<script>
		// 헤더 체크박스로 전체 토글
		function toggleAll(masterCheckbox) {
			const checkboxes = document.querySelectorAll('input[name="ids"]');
			checkboxes.forEach(cb => cb.checked = masterCheckbox.checked);
		}
	</script>
</body>
</html>
