package com.ssafy.mvc;

import com.ssafy.mvc.model.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class UserServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        List<User> users = new ArrayList<>();
        users.add(new User("user1", "홍길동"));
        users.add(new User("user2", "김철수"));
        users.add(new User("user3", "이영희"));

        request.setAttribute("users", users);

        request.getRequestDispatcher("/WEB-INF/views/user/list.jsp")
               .forward(request, response);
    }
}
