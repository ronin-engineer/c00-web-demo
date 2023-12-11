package dev.ronin_engineer.re_web_demo.controller;


import dev.ronin_engineer.re_web_demo.dto.CreateHotelRequest;
import dev.ronin_engineer.re_web_demo.dto.ResponseDto;
import dev.ronin_engineer.re_web_demo.dto.UpdateHotelRequest;
import dev.ronin_engineer.re_web_demo.entity.Hotel;
import dev.ronin_engineer.re_web_demo.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

@RestController
@RequestMapping("/api/v1/hotels")
public class HotelController {

    private static List<Hotel> hotels = new ArrayList<Hotel>();

    @Autowired
    HotelService hotelService;


    // 1. Tạo hotel
    // Method: POST
    // Path: /api/v1/hotels
    @PostMapping
    public Hotel createHotel(@RequestBody CreateHotelRequest request) {
        return hotelService.createHotel(request);
    }


    // 2. Lấy danh sách hotel
    // Method: GET
    // Path: /api/v1/hotels
    @GetMapping
    public List<Hotel> getHotels(@RequestParam(required = false) Integer rate,
                                 @RequestParam(required = false) Boolean status) {  // nullable
        return hotelService.getAll();
    }

    // 3. Lấy thông tin của 1 hotel
    // Method: GET
    // Path: /api/v1/hotels/<hotel_id>
    @GetMapping("/{hotelId}")
    public Hotel getHotel(@PathVariable Long hotelId) {
        return hotelService.getHotelById(hotelId);
    }


    List<Hotel> findHotelsByRate(Integer rate) {
        List<Hotel> result = new LinkedList<>();

        for (Hotel hotel: hotels) {
            if (hotel.getRate() == rate) {
                result.add(hotel);
            }
        }

        return result;
    }

    List<Hotel> findHotelsByStatus(Boolean status) {
        List<Hotel> result = new LinkedList<>();

        for (Hotel hotel: hotels) {
            if (hotel.isStatus() == status) {
                result.add(hotel);
            }
        }

        return result;
    }

    List<Hotel> findHotelsByStatusAndRate(Boolean status, Integer rate) {
        List<Hotel> result = new LinkedList<>();

        for (Hotel hotel: hotels) {
            if (hotel.isStatus() == status && hotel.getRate() == rate) {
                result.add(hotel);
            }
        }

        return result;
    }



    // 4. Cập nhật thông tin 1 hotel
    // Method: PUT
    // Path: /api/v1/hotels/<hotel_id>
    @PutMapping("/{hotelId}")
    public Hotel updateHotel(@PathVariable Long hotelId,
                             @RequestBody UpdateHotelRequest request) {
        return hotelService.updateHotel(hotelId, request);
    }


    // 5. Vô hiệu hoá 1 hotel
    // Method: DELETE
    // Path: /api/v1/hotels/<hotel_id>
    // @DeleteMapping
    @DeleteMapping("/{hotelId}")
    public ResponseDto disableHotel(@PathVariable Long hotelId) {
        return hotelService.disableHotel(hotelId);
    }


    private Hotel findHotelById(String hotelId) {
        for (Hotel hotel: hotels) {
            if (hotel.getHotelId().equals(hotelId)) {
                return hotel;
            }
        }

        return null;
    }
}
