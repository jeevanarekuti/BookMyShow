package com.example.bookmyshow.controllers;

import com.example.bookmyshow.dtos.SignUpUserRequestDTO;
import com.example.bookmyshow.dtos.SignUpUserResponseDTO;
import com.example.bookmyshow.models.User;
import com.example.bookmyshow.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UserController {
    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(path = "/signup")
    public SignUpUserResponseDTO signUpUser(SignUpUserRequestDTO requestDTO) {
        User user = userService.signUp(requestDTO.getName(), requestDTO.getEmail(), requestDTO.getPassword());
        return SignUpUserResponseDTO.SignUpSuccessDTO(user);
    }



}
