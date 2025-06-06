package com.example.demo.model;

import java.math.BigDecimal;
import java.util.Date;

public class Flight {
    private Long flightId;

    private Long departureAirportId;

    private Long destinationAirportId;

    private Date departureDate;

    private Date departureTime;

    private Date destinationDate;

    private Date destinationTime;

    private String statue;

    private BigDecimal firstClassPrice;

    private BigDecimal businessClassPrice;

    private BigDecimal economyClassPrice;

    private Integer firstClassNum;

    private Integer businessClassNum;

    private Integer economyClassNum;

    private String airline;

    private String flightNumber;

    private String amenities;
    




	public Long getFlightId() {
        return flightId;
    }

    public void setFlightId(Long flightId) {
        this.flightId = flightId;
    }

    public Long getDepartureAirportId() {
        return departureAirportId;
    }

    public void setDepartureAirportId(Long departureAirportId) {
        this.departureAirportId = departureAirportId;
    }

    public Long getDestinationAirportId() {
        return destinationAirportId;
    }

    public void setDestinationAirportId(Long destinationAirportId) {
        this.destinationAirportId = destinationAirportId;
    }

    public Date getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(Date departureDate) {
        this.departureDate = departureDate;
    }

    public Date getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(Date departureTime) {
        this.departureTime = departureTime;
    }

    public Date getDestinationDate() {
        return destinationDate;
    }

    public void setDestinationDate(Date destinationDate) {
        this.destinationDate = destinationDate;
    }

    public Date getDestinationTime() {
        return destinationTime;
    }

    public void setDestinationTime(Date destinationTime) {
        this.destinationTime = destinationTime;
    }

    public String getStatue() {
        return statue;
    }

    public void setStatue(String statue) {
        this.statue = statue == null ? null : statue.trim();
    }

    public BigDecimal getFirstClassPrice() {
        return firstClassPrice;
    }

    public void setFirstClassPrice(BigDecimal firstClassPrice) {
        this.firstClassPrice = firstClassPrice;
    }

    public BigDecimal getBusinessClassPrice() {
        return businessClassPrice;
    }

    public void setBusinessClassPrice(BigDecimal businessClassPrice) {
        this.businessClassPrice = businessClassPrice;
    }

    public BigDecimal getEconomyClassPrice() {
        return economyClassPrice;
    }

    public void setEconomyClassPrice(BigDecimal economyClassPrice) {
        this.economyClassPrice = economyClassPrice;
    }

    public Integer getFirstClassNum() {
        return firstClassNum;
    }

    public void setFirstClassNum(Integer firstClassNum) {
        this.firstClassNum = firstClassNum;
    }

    public Integer getBusinessClassNum() {
        return businessClassNum;
    }

    public void setBusinessClassNum(Integer businessClassNum) {
        this.businessClassNum = businessClassNum;
    }

    public Integer getEconomyClassNum() {
        return economyClassNum;
    }

    public void setEconomyClassNum(Integer economyClassNum) {
        this.economyClassNum = economyClassNum;
    }

    public String getAirline() {
        return airline;
    }

    public void setAirline(String airline) {
        this.airline = airline == null ? null : airline.trim();
    }

    public String getFlightNumber() {
        return flightNumber;
    }

    public void setFlightNumber(String flightNumber) {
        this.flightNumber = flightNumber == null ? null : flightNumber.trim();
    }

    public String getAmenities() {
        return amenities;
    }

    public void setAmenities(String amenities) {
        this.amenities = amenities == null ? null : amenities.trim();
    }
    

}