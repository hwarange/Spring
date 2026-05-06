package com.ssafy.mvc;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

public interface Controller {
    String service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException;
}
