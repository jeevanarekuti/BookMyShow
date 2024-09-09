package com.example.bookmyshow;

import com.example.bookmyshow.controllers.UserController;
import com.example.bookmyshow.dtos.SignUpUserRequestDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BookMyShowApplication implements CommandLineRunner {

    private UserController userController;

    @Autowired
    public BookMyShowApplication(UserController userController) {
        this.userController = userController;
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Inserting user");
        SignUpUserRequestDTO signUpUserRequestDTO = new SignUpUserRequestDTO();
        signUpUserRequestDTO.setName("john");
        signUpUserRequestDTO.setEmail("john@gmail.com");
        signUpUserRequestDTO.setPassword("password");
        userController.signUpUser(signUpUserRequestDTO);
        System.out.println("User has been created");
    }

    public static void main(String[] args) {

        SpringApplication.run(BookMyShowApplication.class, args);
    }

}
