package com.ssafy.mvc;

import com.ssafy.mvc.controller.HelloController;
import com.ssafy.mvc.controller.UserController;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class DispatcherServlet extends HttpServlet {

    private Map<String, Controller> handlerMappings;
    private ViewResolver viewResolver;

    @Override
    public void init() throws ServletException {
        handlerMappings = new HashMap<>();
        handlerMappings.put("/hello", new HelloController());
        handlerMappings.put("/user",  new UserController());

        // TODO 3-04: viewResolver 필드를 추가하고 여기서 new ViewResolver("/WEB-INF/views", ".jsp")로 초기화
        viewResolver = new ViewResolver("/WEB-INF/views/", "jsp");
    }

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String path = extractPath(request);

        Controller controller = handlerMappings.get(path);

        if (controller != null) {
            String viewName = controller.service(request, response);

            // TODO 3-05: viewName을 viewResolver.resolve()로 물리 경로로 변환한 뒤 forward
            
            // 논리적인 뷰이름 -> 물리적인 경로
            viewResolver.resolve(viewName);
            request.getRequestDispatcher(viewName).forward(request, response);
        } else {
            response.sendError(HttpServletResponse.SC_NOT_FOUND, "No mapping for " + path);
        }
    }

    private String extractPath(HttpServletRequest request) {
        String uri = request.getRequestURI();
        String contextPath = request.getContextPath();
        return uri.substring(contextPath.length());
    }
}
