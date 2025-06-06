package com.example.demo.model;

import java.util.List;

public class FlightSearchRoundResult {
    private List<FlightSearchResult> departureFlights;
    private List<FlightSearchResult> returnFlights;
	public List<FlightSearchResult> getDepartureFlights() {
		return departureFlights;
	}
	public void setDepartureFlights(List<FlightSearchResult> departureFlights) {
		this.departureFlights = departureFlights;
	}
	public List<FlightSearchResult> getReturnFlights() {
		return returnFlights;
	}
	public void setReturnFlights(List<FlightSearchResult> returnFlights) {
		this.returnFlights = returnFlights;
	}
    
    
}