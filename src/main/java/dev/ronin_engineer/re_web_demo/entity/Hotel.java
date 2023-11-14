package dev.ronin_engineer.re_web_demo.entity;

import lombok.Data;


@Data
public class Hotel {

    private String hotelId;

    private String hotelName;

    private boolean status = true;
}
