package com.example.bookmyshow.controllers;

import com.example.bookmyshow.dtos.BookTicketRequestDTO;
import com.example.bookmyshow.dtos.BookTicketResponseDTO;
import com.example.bookmyshow.exceptions.InvalidSeatIdException;
import com.example.bookmyshow.exceptions.NoShowPresentException;
import com.example.bookmyshow.exceptions.SeatNotAvailableException;
import com.example.bookmyshow.models.Ticket;
import com.example.bookmyshow.services.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class TicketController {

    private TicketService ticketService;

    @Autowired
    public TicketController(TicketService ticketService) {
        this.ticketService = ticketService;
    }
    public BookTicketResponseDTO bookTicket(BookTicketRequestDTO requestDTO) throws NoShowPresentException, SeatNotAvailableException, InvalidSeatIdException {
        Ticket ticket;
        try{
            ticket = ticketService.bookTicket(requestDTO.getShowId(),requestDTO.getSeatIds(), requestDTO.getUserId());
        }
        catch (Exception e){
            return BookTicketResponseDTO.getFailureDTO(e.getMessage());
        }

        return BookTicketResponseDTO.getSuccessDTO(ticket);
    }
}
