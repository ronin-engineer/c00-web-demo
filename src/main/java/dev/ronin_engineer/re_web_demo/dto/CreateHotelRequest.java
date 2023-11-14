package dev.ronin_engineer.re_web_demo.dto;


import lombok.Data;


@Data
public class CreateHotelRequest {

    private String hotelId;

    private String hotelName;
}
