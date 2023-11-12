package com.example.batch;

import java.util.List;

import org.springframework.stereotype.Component;

import com.example.domain.model.User;
import com.example.domain.service.UserService;

@Component
public class UserComponent {

    private final UserService userService;

    public UserComponent(UserService userService) {
        this.userService = userService;
    }

    public void showUsers() {
        List<User> users = userService.findAll();
        for (User user : users) {
            System.out.println(user);
        }
    }

}
