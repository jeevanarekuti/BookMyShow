package com.example.bookmyshow.dtos;

import com.example.bookmyshow.models.User;
import lombok.Data;

@Data
public class SignUpUserResponseDTO {
    private Response response;
    private String name;
    private String email;

    public static SignUpUserResponseDTO SignUpSuccessDTO(User user) {
        SignUpUserResponseDTO dto = new SignUpUserResponseDTO();
        Response response1 = new Response();
        response1.setStatus(ResponseStatus.SUCCESS);
        response1.setMessage("Sign up successful");
        dto.setResponse(response1);
        dto.setName(user.getName());
        dto.setEmail(user.getEmail());
        return dto;
    }
}
