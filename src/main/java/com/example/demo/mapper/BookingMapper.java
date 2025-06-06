package com.example.demo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo.model.Booking;
import com.example.demo.model.BookingResult;

@Mapper
public interface BookingMapper {
    int deleteByPrimaryKey(String bookingId);

    int insert(Booking row);

    int insertSelective(Booking row);

    Booking selectByPrimaryKey(String bookingId);

    int updateByPrimaryKeySelective(Booking row);

    int updateByPrimaryKey(Booking row);
    
    List<BookingResult> selectBookings(String userId);
}