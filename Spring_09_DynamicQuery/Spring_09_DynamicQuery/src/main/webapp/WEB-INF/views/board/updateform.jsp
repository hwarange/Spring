<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>게시글 수정</title>
	<%@ include file="../common/bootstrap.jsp" %>
</head>
<body>
	<div class="container">
		<h2>글수정</h2>

		<!-- 기본 수정 (전체 필드 갱신) -->
		<form action="update" method="POST">
			<input type="hidden" name="id" value="${board.id}">
			<div class="mb-3">
				<label for="title" class="form-label">글제목</label>
				<input type="text" class="form-control" id="title" name="title" value="${board.title}">
			</div>
			<div class="mb-3">
				<label for="writer" class="form-label">글쓴이</label>
				<input type="text" class="form-control" id="writer" name="writer" readonly value="${board.writer}">
			</div>
			<div class="mb-3">
				<label for="content" class="form-label">글내용</label>
				<textarea class="form-control" rows="10" cols="10" id="content"
					name="content">${board.content}</textarea>
			</div>
			<button class="btn btn-primary">전체 수정</button>
		</form>

		<hr>

		<%-- TODO 06 (완성본 제공)
		  미니 실습 ②의 부분 수정 폼입니다. 시간 절약을 위해 미리 작성되어 있습니다.
		  아래 포인트를 코드에서 직접 확인하세요.

		  ① form action="updateDynamic" method="GET"
		     → BoardController 의 @GetMapping("/updateDynamic") 와 매핑됨 (TODO_05)
		  ② hidden input 의 name="id" 가 어떻게 Board.id 로 들어가는지
		  ③ title / content 가 빈 문자열로 전송되면, 매퍼의 <if test="... != ''"> 가
		     false 가 되어 SET 절에서 빠지는 흐름!
		  ④ 직접 테스트: 제목만 입력 → 내용은 그대로 유지되는지 확인
		--%>
		<h5>부분 수정 (set 태그 시연)</h5>
		<small class="text-muted">
			비워둔 필드는 갱신되지 않습니다.
		</small>
		<form action="updateDynamic" method="GET" class="mt-2">
			<input type="hidden" name="id" value="${board.id}">
			<div class="mb-3">
				<label for="title2" class="form-label">제목만 수정</label>
				<input type="text" class="form-control" id="title2" name="title">
			</div>
			<div class="mb-3">
				<label for="content2" class="form-label">내용만 수정</label>
				<textarea class="form-control" rows="3" id="content2" name="content"></textarea>
			</div>
			<button class="btn btn-success">부분 수정</button>
		</form>
	</div>
</body>
</html>
