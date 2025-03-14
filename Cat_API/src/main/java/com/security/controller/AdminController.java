package com.security.controller;

import com.security.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AdminController {

    private final UserService userService;

    public AdminController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/page/admin")
    public ResponseEntity<?> test() {
        //if (userService.getUserRoles().contains("ROLE_ADMIN")){
            return ResponseEntity.ok().body("coucou mon chaton c est la page admin");
       // }
       // else {
           // return ResponseEntity.notFound().build();
        //}
    }
}
