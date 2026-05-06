<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Hello Page</title>
    <style>
        body { font-family: Arial, sans-serif; max-width: 600px; margin: 50px auto; }
        .message { font-size: 2em; color: #2c3e50; padding: 20px; background: #ecf0f1; border-radius: 8px; }
        .info { color: #7f8c8d; font-size: 0.9em; margin-top: 20px; }
        a { color: #3498db; }
    </style>
</head>
<body>
    <h2>[1단계] FrontController 패턴 — Hello 페이지</h2>
    <div class="message">${message}</div>
    <p class="info">
        FrontControllerServlet → HelloServlet → <strong>hello.jsp</strong>
    </p>
    <p><a href="../user">사용자 목록 보기 →</a></p>
</body>
</html>
