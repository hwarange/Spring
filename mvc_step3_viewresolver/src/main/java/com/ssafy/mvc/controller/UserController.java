package com.ssafy.mvc.controller;

import com.ssafy.mvc.Controller;
import com.ssafy.mvc.model.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class UserController implements Controller {

    @Override
    public String service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<User> users = new ArrayList<>();
        users.add(new User("user1", "홍길동"));
        users.add(new User("user2", "김철수"));
        users.add(new User("user3", "이영희"));

        request.setAttribute("users", users);

        // TODO 3-06: 물리 경로 대신 논리적 View 이름("user/list")만 반환하도록 변경
        return "list";
    }
}
