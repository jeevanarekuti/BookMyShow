package com.example.bookmyshow.dtos;


import lombok.Data;
//import org.springframework.web.bind.annotation.ResponseStatus;

@Data
public class Response {
    ResponseStatus status;
    String message;
}
