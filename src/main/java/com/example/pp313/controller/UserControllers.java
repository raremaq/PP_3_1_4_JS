package com.example.pp313.controller;

import com.example.pp313.model.User;
import com.example.pp313.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
@AllArgsConstructor
public class UserControllers {

    private final UserService userService;

    @GetMapping("/authorizedUser")
    public ResponseEntity<?> getAuthorizedUser() {
        User user = userService.getAuthenticatedUser();
        return ResponseEntity.ok().body(user);
    }
}
