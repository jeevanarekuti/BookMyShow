package com.example.bookmyshow.services;

import com.example.bookmyshow.exceptions.InvalidSeatIdException;
import com.example.bookmyshow.exceptions.NoShowPresentException;
import com.example.bookmyshow.exceptions.SeatNotAvailableException;
import com.example.bookmyshow.models.*;
import com.example.bookmyshow.repositories.SeatRepository;
import com.example.bookmyshow.repositories.ShowRepository;
import com.example.bookmyshow.repositories.ShowSeatRepository;
import com.example.bookmyshow.repositories.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;


import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class TicketService {

    private ShowRepository showRepository;
    private ShowSeatRepository showSeatRepository;
    private SeatRepository seatRepository;
    private TicketRepository ticketRepository;

    @Autowired
    public TicketService(ShowRepository showRepository, ShowSeatRepository showSeatRepository, SeatRepository seatRepository, TicketRepository ticketRepository) {
        this.showRepository = showRepository;
        this.showSeatRepository = showSeatRepository;
        this.seatRepository = seatRepository;
        this.ticketRepository = ticketRepository;
    }

    @Transactional(isolation = Isolation.SERIALIZABLE)
    public Ticket bookTicket(int showId, List<Integer> seatIds, int userId) throws NoShowPresentException,InvalidSeatIdException,SeatNotAvailableException {
        Optional<Show> showOptional = showRepository.findById(showId);

        if(!showOptional.isPresent()){
            throw new NoShowPresentException("Show doesn't exists");
        }

        Show show = showOptional.get();


        List<Seat>seats = seatRepository.findAllById(seatIds);
        if(seats.size()!=seatIds.size()){
            throw new InvalidSeatIdException("Invalid SeatId's selected");
        }


        List<ShowSeat>showSeats =
                showSeatRepository.findShowSeatByShowAndSeatIds(show, seatIds);

        for(ShowSeat showSeat : showSeats){
            if(!showSeat.getSeatStatus().equals(SeatStatus.AVAILABLE)){
                throw new SeatNotAvailableException("Seat " + showSeat.getId() + " is not available");
            }
        }

        //TODO Update seat status
        showSeatRepository.UpdateSeatStatusToBooked(showSeats, SeatStatus.BOOKED);

        Ticket ticket = new Ticket();
        ticket.setSeats(seats);
        ticket.setShow(show);
        ticket.setTimeOfBooking(new Date());

        return ticketRepository.save(ticket);

       // return null;

    }
}
