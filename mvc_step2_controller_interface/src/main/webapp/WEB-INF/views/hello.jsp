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
    <h2>[2단계] Controller 인터페이스 — Hello 페이지</h2>
    <div class="message">${message}</div>
    <p class="info">
        DispatcherServlet → HelloController → <strong>hello.jsp</strong><br>
        (DispatcherServlet이 forward를 처리합니다)
    </p>
    <p><a href="../user">사용자 목록 보기 →</a></p>
</body>
</html>
