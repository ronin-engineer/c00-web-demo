package dev.ronin_engineer.re_web_demo.entity;

import jakarta.persistence.*;
import lombok.Data;


@Entity
@Table(name = "hotel")
@Data   // No-arg constructor
public class Hotel {

    // 1. @Id - primary
    // 2. No-arg constructor
//    public Hotel() {
//    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long hotelId;

    @Column(name = "name")
    private String hotelName;

    @Column(name = "status")
    private boolean status;

    @Transient  // dont persist
    private int rate;
}

