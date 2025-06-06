package com.example.demo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo.model.Flight;
import com.example.demo.model.FlightSearchParam;
import com.example.demo.model.FlightSearchResult;

@Mapper
public interface FlightMapper {
    int deleteByPrimaryKey(Long flightId);

    int insert(Flight row);

    int insertSelective(Flight row);

    Flight selectByPrimaryKey(Long flightId);

    int updateByPrimaryKeySelective(Flight row);

    int updateByPrimaryKey(Flight row);
    
    List<FlightSearchResult> selectByTrip(FlightSearchParam row);
}