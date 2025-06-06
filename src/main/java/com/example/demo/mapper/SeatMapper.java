package com.example.demo.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo.model.Seat;

@Mapper
public interface SeatMapper {
    int deleteByPrimaryKey(Long flightId);

    int insert(Seat row);

    int insertSelective(Seat row);

    Seat selectByPrimaryKey(Long flightId);

    int updateByPrimaryKeySelective(Seat row);

    int updateByPrimaryKey(Seat row);
}