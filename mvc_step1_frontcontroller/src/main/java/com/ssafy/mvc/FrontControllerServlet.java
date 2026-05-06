package com.ssafy.mvc;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class FrontControllerServlet extends HttpServlet {

    // TODO 1-01: HandlerMapping 변수 선언 (Map<String, HttpServlet>)
	Map<String, HttpServlet> handlerMapping;

    @Override
    public void init() throws ServletException {
        // TODO 1-02: HandlerMapping 초기화 — new HashMap<>(), put("/hello", new HelloServlet()), put("/user", new UserServlet()), 각 Servlet의 init(getServletConfig()) 호출
    	handlerMapping = new HashMap<>();
    	
    	//경로들도 map에 미리 넣어주자
    	handlerMapping.put("/hello", new HelloServlet());
    	handlerMapping.put("/user", new UserServlet());
    }

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String path = extractPath(request);

       // TODO 1-04: HandlerMapping에서 path로 Servlet을 찾아 servlet.service(request, response)로 위임 실행
        HttpServlet servlet = handlerMapping.get(path);
        if(servlet != null) servlet.service(request, response);
        else response.sendError(HttpServletResponse.SC_BAD_REQUEST);
       // TODO 1-05: 매핑된 Servlet이 없으면 response.sendError(HttpServletResponse.SC_NOT_FOUND, ...)로 404 처리
   }

    private String extractPath(HttpServletRequest request) {
       // TODO 1-03: request.getRequestURI()에서 request.getContextPath()를 제거한 실제 경로 반환 (예: "/mvc-step1/hello" → "/hello")
       // 전체 요청의 경로를 가져와야 한다
		String uri = request.getRequestURI();
		//contextPath에 대한 경로만 가져오도록 한다
		String contextPath = request.getContextPath();
		//contextPath 만큼 uri 문자열의 앞의 문자열을 빼버리자
		String path = uri.substring(contextPath.length());
		return null;
   }
}
