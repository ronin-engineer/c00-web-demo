package dev.ronin_engineer.re_web_demo.controller;


import dev.ronin_engineer.re_web_demo.dto.CreateHotelRequest;
import dev.ronin_engineer.re_web_demo.dto.UpdateHotelRequest;
import dev.ronin_engineer.re_web_demo.entity.Hotel;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1/hotels")
public class HotelController {

    private static List<Hotel> hotels = new ArrayList<Hotel>();

    // 1. Tạo hotel
    // Method: POST
    // Path: /api/v1/hotels
    @PostMapping("/")
    public Hotel createHotel(@RequestBody CreateHotelRequest request) {
        Hotel hotel = new Hotel();

        hotel.setHotelId(request.getHotelId());
        hotel.setHotelName(request.getHotelName());

        hotels.add(hotel);

        return hotel;
    }


    // 2. Lấy danh sách hotel
    // Method: GET
    // Path: /api/v1/hotels
    @GetMapping("/")
    public List<Hotel> getHotels() {
        return hotels;
    }


    // 3. Lấy thông tin của 1 hotel
    // Method: GET
    // Path: /api/v1/hotels/<hotel_id>
    @GetMapping("/{hotelId}")
    public Hotel getHotel(@PathVariable String hotelId) {
        return findHotelById(hotelId);
    }

    // 4. Cập nhật thông tin 1 hotel
    // Method: PUT
    // Path: /api/v1/hotels/<hotel_id>
    @PutMapping("/{hotelId}")
    public Hotel updateHotel(@PathVariable String hotelId,
                             @RequestBody UpdateHotelRequest request) {
        Hotel hotel = findHotelById(hotelId);
        if (hotel == null) {
            return null;
        }

        hotel.setHotelName(request.getHotelName());
        hotel.setStatus(request.isStatus());

        return hotel;
    }


    // 5. Vô hiệu hoá 1 hotel
    // Method: DELETE
    // Path: /api/v1/hotels/<hotel_id>
    // @DeleteMapping
    // TODO


    private Hotel findHotelById(String hotelId) {
        for (Hotel hotel: hotels) {
            if (hotel.getHotelId().equals(hotelId)) {
                return hotel;
            }
        }

        return null;
    }
}
