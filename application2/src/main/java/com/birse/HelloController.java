package com.birse;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @Value("${message}")
    private String message;

    @RequestMapping("/hello")
    public String sayHello() {
        return "Hello from " + message;
    }
}
