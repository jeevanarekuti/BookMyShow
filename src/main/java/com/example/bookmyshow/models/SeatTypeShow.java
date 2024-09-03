package com.example.bookmyshow.models;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.ManyToOne;
import jdk.jfr.Enabled;
import lombok.Data;

@Data
@Entity
public class SeatTypeShow extends BaseModel{
    @ManyToOne
    private Show show;

    @Enumerated(value = EnumType.ORDINAL)
    private SeatType seatType;
    private double price;
}
