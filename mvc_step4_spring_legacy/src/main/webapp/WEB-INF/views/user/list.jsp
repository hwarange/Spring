<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>사용자 목록</title>
    <style>
        body { font-family: Arial, sans-serif; max-width: 600px; margin: 50px auto; }
        table { width: 100%; border-collapse: collapse; }
        th, td { border: 1px solid #ddd; padding: 10px; text-align: left; }
        th { background: #e74c3c; color: white; }
        tr:nth-child(even) { background: #f2f2f2; }
        .info { color: #7f8c8d; font-size: 0.9em; margin-top: 20px; }
        a { color: #3498db; }
    </style>
</head>
<body>
    <h2>[4단계] Spring Legacy Web — 사용자 목록</h2>
    <table>
        <tr><th>ID</th><th>이름</th></tr>
        <c:forEach var="user" items="${users}">
            <tr>
                <td>${user.id}</td>
                <td>${user.name}</td>
            </tr>
        </c:forEach>
    </table>
    <p class="info">
        @Controller UserController → "user/list" → InternalResourceViewResolver
    </p>
    <p><a href="../hello">Hello 페이지로 ←</a></p>
</body>
</html>
