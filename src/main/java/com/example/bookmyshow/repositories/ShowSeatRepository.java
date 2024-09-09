package com.example.bookmyshow.repositories;

import com.example.bookmyshow.models.SeatStatus;
import com.example.bookmyshow.models.Show;
import com.example.bookmyshow.models.ShowSeat;
import jakarta.persistence.LockModeType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface ShowSeatRepository extends JpaRepository<ShowSeat, Integer> {
    //select * from show_seats where show_id = {show_id} and seat_id in [seat_ids] for update to lock the rows

    @Lock(value = LockModeType.PESSIMISTIC_READ)
    //TODO learn about Qyery Annotation
    @Query("SELECT ss FROM ShowSeat ss WHERE ss.show = :show AND ss.seat.id IN :seatIds")
    List<ShowSeat> findShowSeatByShowAndSeatIds(Show show, List<Integer> seatIds);

    @Query("UPDATE ShowSeat ss SET ss.seatStatus = :seatStatus WHERE ss IN :showSeats")
    void UpdateSeatStatusToBooked(List<ShowSeat>showSeats, SeatStatus seatStatus);
}
