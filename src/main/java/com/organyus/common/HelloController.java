package com.organyus.common;

import org.springframework.web.bind.annotation.*;

@RestController
public class HelloController {

    @GetMapping("/")
    public String hello() {
        return "🚀 Hello from OrganyUs!";
    }
}
