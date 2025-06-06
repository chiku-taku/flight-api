package com.example.demo.model;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

public class FlightSearchResult {
    private Long flightId;
    private String departureArrCode;
    private String departureArrName;
    private String departureArrCity;
    private String destinationDesCode;
    private String destinationDesName;
    private String destinationDesCity;
    private String departureDatetime;
    private String destinationDatetime;
    private String duration;
    private String statue;
    private BigDecimal leasePrice;
    private Integer seatnum;
    private String airline;
    private String flightNumber;
    private String amenities;
    private List<String> amenitieslist;
    
    private Integer availablefirstClassSeats;
    private Integer availablebusinessSeats;
    private Integer availableeconomySeats;
    private BigDecimal economyPrice;     // 经济舱价格
    private BigDecimal businessPrice;   // 商务舱价格
    private BigDecimal firstClassPrice; // 头等舱价格
    
    public Integer getAvailablefirstClassSeats() {
		return availablefirstClassSeats;
	}
	public void setAvailablefirstClassSeats(Integer availablefirstClassSeats) {
		this.availablefirstClassSeats = availablefirstClassSeats;
	}
	public Integer getAvailablebusinessSeats() {
		return availablebusinessSeats;
	}
	public void setAvailablebusinessSeats(Integer availablebusinessSeats) {
		this.availablebusinessSeats = availablebusinessSeats;
	}
	public Integer getAvailableeconomySeats() {
		return availableeconomySeats;
	}
	public void setAvailableeconomySeats(Integer availableeconomySeats) {
		this.availableeconomySeats = availableeconomySeats;
	}
	public BigDecimal getEconomyPrice() {
		return economyPrice;
	}
	public void setEconomyPrice(BigDecimal economyPrice) {
		this.economyPrice = economyPrice;
	}
	public BigDecimal getBusinessPrice() {
		return businessPrice;
	}
	public void setBusinessPrice(BigDecimal businessPrice) {
		this.businessPrice = businessPrice;
	}
	public BigDecimal getFirstClassPrice() {
		return firstClassPrice;
	}
	public void setFirstClassPrice(BigDecimal firstClassPrice) {
		this.firstClassPrice = firstClassPrice;
	}
	private Integer stops = 0;
    
    
	public Long getFlightId() {
		return flightId;
	}
	public void setFlightId(Long flightId) {
		this.flightId = flightId;
	}
	public String getDepartureArrCode() {
		return departureArrCode;
	}
	public void setDepartureArrCode(String departureArrCode) {
		this.departureArrCode = departureArrCode;
	}
	public String getDepartureArrName() {
		return departureArrName;
	}
	public void setDepartureArrName(String departureArrName) {
		this.departureArrName = departureArrName;
	}
	public String getDepartureArrCity() {
		return departureArrCity;
	}
	public void setDepartureArrCity(String departureArrCity) {
		this.departureArrCity = departureArrCity;
	}
	public String getDestinationDesCode() {
		return destinationDesCode;
	}
	public void setDestinationDesCode(String destinationDesCode) {
		this.destinationDesCode = destinationDesCode;
	}
	public String getDestinationDesName() {
		return destinationDesName;
	}
	public void setDestinationDesName(String destinationDesName) {
		this.destinationDesName = destinationDesName;
	}
	public String getDestinationDesCity() {
		return destinationDesCity;
	}
	public void setDestinationDesCity(String destinationDesCity) {
		this.destinationDesCity = destinationDesCity;
	}
	public String getDepartureDatetime() {
		return departureDatetime;
	}
	public void setDepartureDatetime(String departureDatetime) {
		this.departureDatetime = departureDatetime;
	}
	public String getDestinationDatetime() {
		return destinationDatetime;
	}
	public void setDestinationDatetime(String destinationDatetime) {
		this.destinationDatetime = destinationDatetime;
	}
	public String getDuration() {
		return duration;
	}
	public void setDuration(String duration) {
		this.duration = duration;
	}
	public String getStatue() {
		return statue;
	}
	public void setStatue(String statue) {
		this.statue = statue;
	}
	public BigDecimal getLeasePrice() {
		return leasePrice;
	}
	public void setLeasePrice(BigDecimal leasePrice) {
		this.leasePrice = leasePrice;
	}
	public Integer getSeatnum() {
		return seatnum;
	}
	public void setSeatnum(Integer seatnum) {
		this.seatnum = seatnum;
	}
	public String getAirline() {
		return airline;
	}
	public void setAirline(String airline) {
		this.airline = airline;
	}
	public String getFlightNumber() {
		return flightNumber;
	}
	public void setFlightNumber(String flightNumber) {
		this.flightNumber = flightNumber;
	}
	public String getAmenities() {
		return amenities;
	}
	public void setAmenities(String amenities) {
		this.amenities = amenities == null ? null : amenities.trim();
        if(amenities!=null && !amenities.isEmpty()) {
        	this.amenitieslist = Arrays.asList(amenities.split(","));
        }
	}
    public List<String> getAmenitieslist() {
        if(this.amenities!=null && !this.amenities.isEmpty()) {
        	this.amenitieslist = Arrays.asList(this.amenities.split(","));
        }
		return amenitieslist;
	}

	public void setAmenitieslist(List<String> amenitieslist) {
		this.amenitieslist = amenitieslist;
	}
	public Integer getStops() {
		return stops;
	}
	public void setStops(Integer stops) {
		this.stops = stops;
	}
    

}