package com.ssafy.mvc;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

// TODO 2-03: 1단계 으로 클래스 명칭 DispatcherServlet 변경 (+ web.xml에서 클래스명 변경)
//          - HandlerMapping 타입을 Map<String, Controller>로
//          - init()에서 Controller 객체들을 등록 (HttpServlet 아니므로 init() 호출 불필요)
//          - service()에서 path로 Controller 조회 → controller.service() 호출 → 반환된 viewPath로 request.getRequestDispatcher(viewPath).forward(...) 처리
//          - 매핑 없으면 404 처리
//          - extractPath() 헬퍼 메서드도 직접 작성
public class FrontControllerServlet extends HttpServlet {

    private Map<String, Controller> handlerMappings;

    @Override
    public void init() throws ServletException {
        handlerMappings = new HashMap<>();
        handlerMappings.put("/hello", new HelloController());
        handlerMappings.put("/user",  new UserController());
    }

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String path = extractPath(request);

        Controller controller = handlerMappings.get(path);

        if (controller != null) {
        	//service 라는 메서드를 호출 -> View 경로를 반환
        	String viewPath = controller.service(request, response);
        	request.getRequestDispatcher(viewPath).forward(request, response);
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
