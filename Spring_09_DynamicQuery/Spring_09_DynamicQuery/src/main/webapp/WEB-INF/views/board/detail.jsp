<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글 상세보기</title>
<%@ include file="../common/bootstrap.jsp" %>
</head>
<body>
	<div class="container">
		<h2>글 상세보기</h2>
		<hr>
		<div class="card">
			<div class="card-body">
				<h5 class="card-title">${board.title}
					<span class="badge bg-danger">${board.viewCnt}</span>
				</h5>
				<div class="d-flex justify-content-between">
					<div class="card-subtitle">${board.writer}</div>
					<div class="card-subtitle">${board.regDate}</div>
				</div>
				<p class="card-text">${board.content}</p>
				<div>
					<a href="delete?id=${board.id}" class="btn btn-info">삭제</a>
					<a href="updateform?id=${board.id}" class="btn btn-success">수정</a>
					<a href="list" class="btn btn-warning">목록</a>
				</div>

				<hr>
				<%-- TODO 32 (완성본 제공)
				  메인 실습 2 — 트랜잭션 롤백 시연 버튼입니다.
				  아래 포인트를 코드에서 직접 확인하세요.

				  ① 두 개의 링크: fail=false / fail=true
				     → BoardController 의 /readTx 와 매핑됨 (TODO_31)
				  ② 시연 방법:
				     · 현재 조회수 메모
				     · '정상 호출' 클릭 → 조회수 +1 (commit)
				     · '예외 호출' 클릭 → 조회수 그대로! (rollback)
				  ③ 결과 확인 후 BoardServiceImpl 의 @Transactional 을 잠시 주석 처리해보면
				     '예외 호출' 시 조회수가 진짜로 +1 되어버리는 (rollback 실패!) 차이를 볼 수 있음
				--%>
				<div>
					<h6>트랜잭션 동작 확인 (실습용)</h6>
					<a href="readTx?id=${board.id}&fail=false" class="btn btn-outline-primary btn-sm">
						정상 호출 (조회수 +1)
					</a>
					<a href="readTx?id=${board.id}&fail=true" class="btn btn-outline-danger btn-sm">
						예외 호출 (롤백 시연)
					</a>
					<small class="text-muted d-block mt-2">
						※ '예외 호출' 버튼을 눌러도 조회수가 그대로면 @Transactional 이 정상 작동하는 것!
					</small>
				</div>
			</div>
		</div>
	</div>
</body>
</html>
