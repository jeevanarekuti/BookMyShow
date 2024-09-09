package com.example.bookmyshow.repositories;

import com.example.bookmyshow.models.Seat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface SeatRepository extends JpaRepository<Seat, Integer> {
    //List<Seat>findAllByIds(List<Integer> seatIds);

    @Override
    List<Seat> findAllById(Iterable<Integer> seatIds);
}
