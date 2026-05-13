<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판 목록</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css">
</head>
<body>
<div class="container mt-4">
    <h2 class="mb-3">게시판 목록</h2>
    <table class="table table-bordered table-hover">
        <thead class="table-dark">
            <tr>
                <th>번호</th>
                <th>제목</th>
                <th>작성자</th>
                <th>등록일</th>
                <th>조회수</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="board" items="${boards}">
                <tr>
                    <td>${board.id}</td>
                    <td><a href="detail?id=${board.id}">${board.title}</a></td>
                    <td>${board.writer}</td>
                    <td>${board.regDate}</td>
                    <td>${board.viewCnt}</td>
                </tr>
            </c:forEach>
            <c:if test="${empty boards}">
                <tr><td colspan="5" class="text-center">등록된 게시글이 없습니다.</td></tr>
            </c:if>
        </tbody>
    </table>
    <a href="writeform" class="btn btn-primary">글쓰기</a>
</div>
</body>
</html>
