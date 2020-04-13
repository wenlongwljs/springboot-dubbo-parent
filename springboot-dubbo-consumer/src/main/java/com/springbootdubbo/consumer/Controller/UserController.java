package com.springbootdubbo.consumer.Controller;

import com.springbootdubbo.api.model.User;
import com.springbootdubbo.api.service.UserService;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @Reference(version = "1.0.0", url = "dubbo://127.0.0.1:12345")
    private UserService userService;

    @GetMapping("/getUser")
    public User getUser() {
        return userService.getUser();
    }

    @GetMapping("/sayHello")
    public String sayHello(String name) {
        return userService.sayHello(name);
    }
}
