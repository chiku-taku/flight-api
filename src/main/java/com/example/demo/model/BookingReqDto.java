package com.example.demo.model;

import java.util.List;

public class BookingReqDto {
    private FlightSearchResult selectedDeparture;
    private FlightSearchResult selectedReturn;
    private List<PassengerParam> passengers;
    private String storedUser;
	public FlightSearchResult getSelectedDeparture() {
		return selectedDeparture;
	}
	public void setSelectedDeparture(FlightSearchResult selectedDeparture) {
		this.selectedDeparture = selectedDeparture;
	}
	public FlightSearchResult getSelectedReturn() {
		return selectedReturn;
	}
	public void setSelectedReturn(FlightSearchResult selectedReturn) {
		this.selectedReturn = selectedReturn;
	}
	public List<PassengerParam> getPassengers() {
		return passengers;
	}
	public void setPassengers(List<PassengerParam> passengers) {
		this.passengers = passengers;
	}
	public String getStoredUser() {
		return storedUser;
	}
	public void setStoredUser(String storedUser) {
		this.storedUser = storedUser;
	}

	

    
}