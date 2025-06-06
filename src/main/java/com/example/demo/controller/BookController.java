package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.BookingReqDto;
import com.example.demo.model.BookingResult;
import com.example.demo.model.FlightSearchResult;
import com.example.demo.model.PassengerParam;
import com.example.demo.service.BookingService;
import com.example.demo.util.ResultEntity;

import jakarta.annotation.Resource;

@RequestMapping("/api/booking")
@CrossOrigin(origins = "http://localhost:5173") // 允许React前端跨域访问
@RestController
public class BookController {

    
    @Resource 
    private  BookingService bookingService;
    
    @PostMapping("/book")
    public ResultEntity book(@RequestBody BookingReqDto request) {
    	
    	System.out.println("航班提交模块");
        // 处理请求
        FlightSearchResult selectedDeparture = request.getSelectedDeparture();
        FlightSearchResult selectedReturn = request.getSelectedReturn();
        List<PassengerParam> passengers = request.getPassengers();
        String user = request.getStoredUser();
        try {
        	bookingService.setBooking(selectedDeparture, selectedReturn, passengers, user);
        }
        catch(Exception e) {
            return ResultEntity.error().message(e.toString());
        }
        return ResultEntity.ok();
        
    }
    
    @PostMapping("/getBookings")
    public ResultEntity getBookings(@RequestBody String storedUser) {
    	List<BookingResult> resultData = new ArrayList<BookingResult> ();
        try {
        	resultData = bookingService.getBookings(storedUser);
        }
        catch(Exception e) {
            return ResultEntity.error().message(e.toString());
        }
        return ResultEntity.ok().data("result", resultData);
        
    }
}