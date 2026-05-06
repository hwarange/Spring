package com.ssafy.mvc.controller;

import com.ssafy.mvc.Controller;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

public class HelloController implements Controller {

    @Override
    public String service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String message = "안녕, 서블릿!";

        request.setAttribute("message", message);

        // TODO 3-06: 물리 경로 대신 논리적 View 이름("hello")만 반환하도록 변경
        return "hello";
    }
}
