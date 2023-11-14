package dev.ronin_engineer.re_web_demo.dto;


import lombok.Data;


@Data
public class UpdateHotelRequest {

    private String hotelName;

    private boolean status;
}
