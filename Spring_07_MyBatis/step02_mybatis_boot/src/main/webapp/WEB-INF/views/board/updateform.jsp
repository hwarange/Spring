<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글 수정</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css">
</head>
<body>
<div class="container mt-4">
    <h2 class="mb-3">게시글 수정</h2>
    <form action="update" method="post">
        <input type="hidden" name="id" value="${board.id}">
        <div class="mb-3">
            <label class="form-label">제목</label>
            <input type="text" name="title" value="${board.title}" class="form-control" required>
        </div>
        <div class="mb-3">
            <label class="form-label">내용</label>
            <textarea name="content" class="form-control" rows="6" required>${board.content}</textarea>
        </div>
        <button type="submit" class="btn btn-warning">수정</button>
        <a href="list" class="btn btn-secondary">취소</a>
    </form>
</div>
</body>
</html>
