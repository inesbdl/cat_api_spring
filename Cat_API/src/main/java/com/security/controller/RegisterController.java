package com.security.controller;

import com.security.entity.User;
import com.security.repository.UserRepository;
import com.security.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/users/register")
public class RegisterController {

    private final UserService userService;
    private final UserRepository userRepository;

    @Autowired
    public RegisterController(UserService userService, UserRepository userRepository) {
        this.userService = userService;
        this.userRepository = userRepository;
    }

    @PostMapping("/crud")
    public ResponseEntity<?> registerCRUD(@RequestBody User user) {
        try {
            userService.registerNewUserAccount(user);
            userRepository.linkUserRoles(user.getId(),1L);
            return ResponseEntity.ok("User registered successfully");
        }
        catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }

    }

    @PostMapping("/boing")
    public ResponseEntity<?> registerBoing(@RequestBody User user) {
        try {
            userService.registerNewUserAccount(user);
            userRepository.linkUserRoles(user.getId(),2L);

            return ResponseEntity.ok("User registered successfully");
        }
        catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }

    }

    @PostMapping("/scrap")
    public ResponseEntity<?> registerScrap(@RequestBody User user) {
        try {
            userService.registerNewUserAccount(user);
            userRepository.linkUserRoles(user.getId(),3L);

            return ResponseEntity.ok("User registered successfully");
        }
        catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }

    }

}