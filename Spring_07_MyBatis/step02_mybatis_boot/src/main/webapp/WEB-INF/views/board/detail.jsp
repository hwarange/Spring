<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글 상세</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css">
</head>
<body>
<div class="container mt-4">
    <div class="card">
        <div class="card-header d-flex justify-content-between align-items-center">
            <h4 class="mb-0">${board.title}</h4>
            <small class="text-muted">조회수 ${board.viewCnt}</small>
        </div>
        <div class="card-body">
            <p class="text-muted">작성자: ${board.writer} &nbsp;|&nbsp; 등록일: ${board.regDate}</p>
            <hr>
            <p style="white-space: pre-wrap;">${board.content}</p>
        </div>
        <div class="card-footer">
            <a href="updateform?id=${board.id}" class="btn btn-warning">수정</a>
            <a href="delete?id=${board.id}" class="btn btn-danger"
               onclick="return confirm('삭제하시겠습니까?')">삭제</a>
            <a href="list" class="btn btn-secondary">목록으로</a>
        </div>
    </div>
</div>
</body>
</html>
