package com.monman.login.controller;

import com.monman.login.model.User;
import com.monman.login.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
public class LoginController {

    @Autowired
    private LoginService loginService;

    @PostMapping(value = "/register", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    private User register(@RequestBody User user) {
        return loginService.register(user);
    }

    @GetMapping(value = "/login", produces = MediaType.APPLICATION_JSON_VALUE)
    private User login(@RequestParam String username, @RequestParam String password) {
        return loginService.login(username, password);
    }

}
