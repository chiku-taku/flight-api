package com.example.demo.model;

import java.math.BigDecimal;
import java.util.List;

public class BookingResult {
	  private String bookingId;
	  private String flightNumber;
	  private String departureTime;
	  private String departureLocation;
	  private String arrivalTime;
	  private String arrivalLocation;
	  private BigDecimal amount;
	  private boolean hasRoundTrip;
	  private String returnbookingId;
	  private String returnflightNumber;
	  private String returndepartureTime;
	  private String returndepartureLocation;
	  private String returnarrivalTime;
	  private String returnarrivalLocation;
	  private String returnamount;
	  private List<BookingPassengers> passengers;
	  private List<BookingPassengers> returnpassengers;
	public String getBookingId() {
		return bookingId;
	}
	public void setBookingId(String bookingId) {
		this.bookingId = bookingId;
	}
	public String getFlightNumber() {
		return flightNumber;
	}
	public void setFlightNumber(String flightNumber) {
		this.flightNumber = flightNumber;
	}
	public String getDepartureTime() {
		return departureTime;
	}
	public void setDepartureTime(String departureTime) {
		this.departureTime = departureTime;
	}
	public String getDepartureLocation() {
		return departureLocation;
	}
	public void setDepartureLocation(String departureLocation) {
		this.departureLocation = departureLocation;
	}
	public String getArrivalTime() {
		return arrivalTime;
	}
	public void setArrivalTime(String arrivalTime) {
		this.arrivalTime = arrivalTime;
	}
	public String getArrivalLocation() {
		return arrivalLocation;
	}
	public void setArrivalLocation(String arrivalLocation) {
		this.arrivalLocation = arrivalLocation;
	}
	public BigDecimal getAmount() {
		return amount;
	}
	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}
	public boolean isHasRoundTrip() {
		return hasRoundTrip;
	}
	public void setHasRoundTrip(boolean hasRoundTrip) {
		this.hasRoundTrip = hasRoundTrip;
	}
	public String getReturnbookingId() {
		return returnbookingId;
	}
	public void setReturnbookingId(String returnbookingId) {
		this.returnbookingId = returnbookingId;
	}
	public String getReturnflightNumber() {
		return returnflightNumber;
	}
	public void setReturnflightNumber(String returnflightNumber) {
		this.returnflightNumber = returnflightNumber;
	}
	public String getReturndepartureTime() {
		return returndepartureTime;
	}
	public void setReturndepartureTime(String returndepartureTime) {
		this.returndepartureTime = returndepartureTime;
	}
	public String getReturndepartureLocation() {
		return returndepartureLocation;
	}
	public void setReturndepartureLocation(String returndepartureLocation) {
		this.returndepartureLocation = returndepartureLocation;
	}
	public String getReturnarrivalTime() {
		return returnarrivalTime;
	}
	public void setReturnarrivalTime(String returnarrivalTime) {
		this.returnarrivalTime = returnarrivalTime;
	}
	public String getReturnarrivalLocation() {
		return returnarrivalLocation;
	}
	public void setReturnarrivalLocation(String returnarrivalLocation) {
		this.returnarrivalLocation = returnarrivalLocation;
	}
	public String getReturnamount() {
		return returnamount;
	}
	public void setReturnamount(String returnamount) {
		this.returnamount = returnamount;
	}
	public List<BookingPassengers> getPassengers() {
		return passengers;
	}
	public void setPassengers(List<BookingPassengers> passengers) {
		this.passengers = passengers;
	}
	public List<BookingPassengers> getReturnpassengers() {
		return returnpassengers;
	}
	public void setReturnpassengers(List<BookingPassengers> returnpassengers) {
		this.returnpassengers = returnpassengers;
	}
	  
	  
	  

}