package com.ssafy.mvc;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

public interface Controller {
    // TODO 2-01: Controller 인터페이스 정의 — service(request, response)가 View 경로(String)를 반환하도록 메서드 시그니처 작성
	// View 경로(String)를 반환하도록 메서드 시그니처 작성
	
	public String service(HttpServletRequest request, HttpServletResponse response);
	
}
