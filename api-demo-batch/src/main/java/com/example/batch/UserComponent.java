package com.example.batch;

import org.springframework.stereotype.Component;

import com.example.domain.model.User;
import com.example.domain.service.UserService;
import java.util.List;

@Component
public class UserComponent {

    private final UserService userService;

    public UserComponent(UserService userService) {
        this.userService = userService;
    }

    public void run() {
        List<User> users = userService.findAll();
        for (User user : users) {
            System.out.println(user);
        }
    }

}
