package com.example.bookmyshow.dtos;

import lombok.Data;

@Data
public class SignUpUserRequestDTO {
    String name;
    String email;
    String password;
}
