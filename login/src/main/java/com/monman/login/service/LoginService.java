package com.monman.login.service;

import com.monman.login.exception.LoginException;
import com.monman.login.model.User;
import com.monman.login.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class LoginService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public User register(User user){
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }

    public User login(String username, String password) {
        User user = userRepository.findByEmailOrMobile(username);
        if(user != null && passwordEncoder.matches(password, user.getPassword()))
            return user;
        throw new LoginException("Username or password is not valid");
    }
}
