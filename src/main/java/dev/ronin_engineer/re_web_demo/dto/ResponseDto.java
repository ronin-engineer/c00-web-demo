package dev.ronin_engineer.re_web_demo.dto;


import lombok.AllArgsConstructor;
import lombok.Data;


@Data
@AllArgsConstructor
public class ResponseDto {  // Data Transfer Object
    private boolean status;
    private String message;


//    public DeleteHotelResponse() {
//    }
//
//    public DeleteHotelResponse(boolean status, String message) {
//        this.status = status;
//        this.message = message;
//    }
//
//    public boolean isStatus() {
//        return status;
//    }
//
//    public void setStatus(boolean status) {
//        this.status = status;
//    }
}
