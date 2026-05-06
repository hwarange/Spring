package com.ssafy.mvc.controller;

import com.ssafy.mvc.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

/**
 * [4단계] UserController — Spring Legacy Web @Controller
 */
@Controller
public class UserController {

    @GetMapping("/user")
    public String userList(Model model) {
        List<User> users = new ArrayList<>();
        users.add(new User("user1", "홍길동"));
        users.add(new User("user2", "김철수"));
        users.add(new User("user3", "이영희"));

        model.addAttribute("users", users);
        // 3단계와 동일한 논리 이름 반환!
        return "user/list";
    }
}
