package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.mapper.FlightMapper;
import com.example.demo.model.Flight;
import com.example.demo.model.FlightSearchParam;
import com.example.demo.model.FlightSearchResult;

@Service
public class FlightService {
    @Autowired
    private FlightMapper flightMapper;
    
    
    public Flight getOneflight(Long flightId) {
        return flightMapper.selectByPrimaryKey(flightId);
    }
    
    public List<FlightSearchResult> getFlightSearchResult(FlightSearchParam row) {
        return flightMapper.selectByTrip(row);
    }

}
