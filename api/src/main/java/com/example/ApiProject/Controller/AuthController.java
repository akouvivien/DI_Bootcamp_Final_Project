package com.example.ApiProject.Controller;

import com.example.ApiProject.Dto.LoginDto;
import com.example.ApiProject.Dto.SiginUpDto;
import com.example.ApiProject.Model.Users;
import com.example.ApiProject.Service.UsersDetailsService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@Validated
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    UsersDetailsService usersDetailsService;

    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@RequestBody SiginUpDto siginUpDto) {

        usersDetailsService.registerUsers(siginUpDto);

        return new ResponseEntity<>("User registered successfully", HttpStatus.OK);
    }

    @PostMapping("/login")

    public ResponseEntity<Users> LoginUser(@RequestBody LoginDto loginDto) {

        return ResponseEntity.ok(usersDetailsService.authenticateUser(loginDto));

    }

    @PostMapping("/logout")

    private void LogoutUser(@RequestBody LoginDto loginDto) {


    }

}
