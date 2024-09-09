package com.example.bookmyshow.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
public class City extends BaseModel{


    private String name;
    @OneToMany(mappedBy = "city")
    private List<Theatre>theatres;
}
