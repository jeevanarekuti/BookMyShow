package com.example.bookmyshow.dtos;

import com.example.bookmyshow.models.Ticket;
import lombok.Data;

@Data
public class BookTicketResponseDTO {
    Response response;
    Ticket ticket;

    public static BookTicketResponseDTO getFailureDTO(String message){
        BookTicketResponseDTO dto = new BookTicketResponseDTO();
        Response response1 = new Response();
        response1.setMessage(message);
        response1.setStatus(ResponseStatus.FAILURE);
        dto.setResponse(response1);
        return dto;
    }

    public static BookTicketResponseDTO getSuccessDTO(Ticket ticket){
        BookTicketResponseDTO dto = new BookTicketResponseDTO();
        Response response1 = new Response();
        response1.setMessage("Ticket has been created");
        response1.setStatus(ResponseStatus.SUCCESS);
        dto.setResponse(response1);
        dto.setTicket(ticket);
        return dto;
    }
}

