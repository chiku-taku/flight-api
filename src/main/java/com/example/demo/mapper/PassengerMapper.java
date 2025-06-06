package com.example.demo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo.model.BookingPassengers;
import com.example.demo.model.Passenger;

@Mapper
public interface PassengerMapper {
    int deleteByPrimaryKey(String passengerId);

    int insert(Passenger row);

    int insertSelective(Passenger row);

    Passenger selectByPrimaryKey(String passengerId);

    int updateByPrimaryKeySelective(Passenger row);

    int updateByPrimaryKey(Passenger row);
    
    List<BookingPassengers> selectBookingPassenger(String bookingId);
}