package com.ssafy.mvc;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class HelloController implements Controller {

    @Override
    public String service(HttpServletRequest request, HttpServletResponse response){

        String message = "안녕, 서블릿!";

        request.setAttribute("message", message);

        return "/WEB-INF/views/hello.jsp";

    }
}
