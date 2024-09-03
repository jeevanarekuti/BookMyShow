package com.example.bookmyshow.models;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Transient;
import lombok.Data;
import lombok.Getter;

@Data
@Entity

public class Seat extends BaseModel {
    private String name;
    private SeatStatus status;
    private SeatType type;
    int topLeftX;
    int topLeftY;
    int bottomRightX;
    int bottomRightY;
    @ManyToOne
    Screen screen;
}
