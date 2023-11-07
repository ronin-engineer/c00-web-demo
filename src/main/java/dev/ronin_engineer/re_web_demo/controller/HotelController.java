package dev.ronin_engineer.re_web_demo.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HotelController {


    @GetMapping("/hello")
    public String hello() {
        return "hello";
    }

    @GetMapping("/rooms")
    public String rooms(){
        return "rooms";
    }

}
