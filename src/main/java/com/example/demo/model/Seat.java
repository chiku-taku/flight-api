package com.example.demo.model;

public class Seat {
    private Long flightId;

    private Integer firstClassCount;

    private Integer businessClassCount;

    private Integer economyClassCount;

    public Long getFlightId() {
        return flightId;
    }

    public void setFlightId(Long flightId) {
        this.flightId = flightId;
    }

    public Integer getFirstClassCount() {
        return firstClassCount;
    }

    public void setFirstClassCount(Integer firstClassCount) {
        this.firstClassCount = firstClassCount;
    }

    public Integer getBusinessClassCount() {
        return businessClassCount;
    }

    public void setBusinessClassCount(Integer businessClassCount) {
        this.businessClassCount = businessClassCount;
    }

    public Integer getEconomyClassCount() {
        return economyClassCount;
    }

    public void setEconomyClassCount(Integer economyClassCount) {
        this.economyClassCount = economyClassCount;
    }
}