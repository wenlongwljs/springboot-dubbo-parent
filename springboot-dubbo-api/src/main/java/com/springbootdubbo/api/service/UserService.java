package com.springbootdubbo.api.service;

import com.springbootdubbo.api.model.User;

public interface UserService {
    public User getUser();

    public String sayHello(String name);
}
