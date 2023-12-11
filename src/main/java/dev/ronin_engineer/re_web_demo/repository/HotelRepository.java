package dev.ronin_engineer.re_web_demo.repository;

import dev.ronin_engineer.re_web_demo.entity.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface HotelRepository extends JpaRepository<Hotel, Long> {

    Hotel findByHotelId(Long hotelId);

    Hotel findByHotelName(String hotelName);

}