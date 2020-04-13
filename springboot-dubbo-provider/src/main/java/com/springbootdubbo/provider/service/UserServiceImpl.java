package com.springbootdubbo.provider.service;

import com.springbootdubbo.api.model.User;
import com.springbootdubbo.api.service.UserService;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Value;

/**
 * 服务提供者，实现服务接口
 */
@Service(version = "1.0.0")
public class UserServiceImpl implements UserService {

    @Value("${dubbo.application.name}")
    private String serviceName;

    @Override
    public User getUser() {
        User user = new User();
        user.setUserName("毛文龙");
        user.setPassword("123456");
        user.setAge(31);
        return user;
    }

    @Override
    public String sayHello(String name) {
        return String.format("Hello,%s. ServiceName is %s", name, serviceName);
    }
}
