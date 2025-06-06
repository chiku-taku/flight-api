package com.example.demo.model;

import java.math.BigDecimal;
import java.util.Date;

public class Booking {
    private String bookingId;

    private String userId;

    private Long flightId;

    private String reference;

    private String status;

    private Date bookingTime;

    private BigDecimal totalPrice;

    private String backBookingId;

    public String getBookingId() {
        return bookingId;
    }

    public void setBookingId(String bookingId) {
        this.bookingId = bookingId == null ? null : bookingId.trim();
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    public Long getFlightId() {
        return flightId;
    }

    public void setFlightId(Long flightId) {
        this.flightId = flightId;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference == null ? null : reference.trim();
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    public Date getBookingTime() {
        return bookingTime;
    }

    public void setBookingTime(Date bookingTime) {
        this.bookingTime = bookingTime;
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getBackBookingId() {
        return backBookingId;
    }

    public void setBackBookingId(String backBookingId) {
        this.backBookingId = backBookingId == null ? null : backBookingId.trim();
    }
}