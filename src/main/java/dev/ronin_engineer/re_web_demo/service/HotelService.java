package dev.ronin_engineer.re_web_demo.service;

import dev.ronin_engineer.re_web_demo.dto.CreateHotelRequest;
import dev.ronin_engineer.re_web_demo.dto.ResponseDto;
import dev.ronin_engineer.re_web_demo.dto.UpdateHotelRequest;
import dev.ronin_engineer.re_web_demo.entity.Hotel;
import dev.ronin_engineer.re_web_demo.repository.HotelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class HotelService {

    @Autowired
    HotelRepository hotelRepository;

    public Hotel getHotelById(Long id) {
        return hotelRepository.findByHotelId(id);
    }

    public Hotel createHotel(CreateHotelRequest request) {
        Hotel hotel = new Hotel();
        hotel.setHotelName(request.getHotelName());
        hotel.setRate(request.getRate());

        hotel = hotelRepository.save(hotel);

        return hotel;
    }

    public List<Hotel> getAll() {
        return hotelRepository.findAll();
    }

    public Hotel updateHotel(Long hotelId, UpdateHotelRequest request) {
        Hotel hotel = hotelRepository.findByHotelId(hotelId);
        if (hotel == null) {
            return null;
        }

        hotel.setHotelName(request.getHotelName());
        hotel = hotelRepository.save(hotel);    // UPSERT

        return hotel;
    }

    public ResponseDto disableHotel(Long hotelId) {
        Hotel hotel = hotelRepository.findByHotelId(hotelId);
        if (hotel == null) {
            return new ResponseDto(false, "Hotel Not Found");
        }

        hotel.setStatus(false);
        hotel = hotelRepository.save(hotel);

        return new ResponseDto(true, "Successful");
    }
}