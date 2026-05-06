package com.ssafy.mvc;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class HelloServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String message = "안녕, 서블릿!";

        request.setAttribute("message", message);

        request.getRequestDispatcher("/WEB-INF/views/hello.jsp")
               .forward(request, response);
    }
}
