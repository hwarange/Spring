package com.ssafy.mvc;

import com.ssafy.mvc.model.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class UserController implements Controller {

    @Override
    public String service(HttpServletRequest request, HttpServletResponse response) {

        List<User> users = new ArrayList<>();
        users.add(new User("user1", "홍길동"));
        users.add(new User("user2", "김철수"));
        users.add(new User("user3", "이영희"));

        request.setAttribute("users", users);

        return "/WEB-INF/views/user/list.jsp";
    }
}
