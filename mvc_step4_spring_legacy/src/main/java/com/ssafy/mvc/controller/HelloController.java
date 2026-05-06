package com.ssafy.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * [4단계] HelloController — Spring Legacy Web @Controller
 *
 * 3단계와의 비교:
 *  - [우리 코드] implements Controller                    → [Spring] @Controller 어노테이션
 *  - [우리 코드] public String service(request, response) → [Spring] @GetMapping 메서드
 *  - [우리 코드] request.setAttribute()                   → [Spring] model.addAttribute()
 *
 * Spring이 ComponentScan으로 이 클래스를 찾아서 빈으로 등록하고,
 * HandlerMapping에 자동으로 "/hello" URL과 연결합니다.
 */
@Controller // 컨트롤러 구현이 아닌 어노테이션으로 컨트롤러임을 명시 (+ Bean등록)
public class HelloController {

    @GetMapping("/hello") // GET 요청을 처리하는 메서드 매핑
    public String hello(Model model) { // 데이터를 담는 그릇인 Model을 인자로 알아서 주입해줌
        // model.addAttribute() = request.setAttribute()와 동일한 역할
        model.addAttribute("message", "안녕, Spring Legacy!");
        return "hello";
    }
}
