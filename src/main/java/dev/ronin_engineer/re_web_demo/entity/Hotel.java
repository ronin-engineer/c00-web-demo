package dev.ronin_engineer.re_web_demo.entity;

import lombok.Data;


@Data
public class Hotel {

    private String hotelId;

    private String hotelName;

    private Integer rate;   // 1 - 5 star(s)

    private boolean status = true;
}


// Service Layer

// Repository (DB) Layer
//
// DB
