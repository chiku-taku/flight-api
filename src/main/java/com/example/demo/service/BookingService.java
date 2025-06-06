package com.example.demo.service;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ObjectUtils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.example.demo.mapper.BookingMapper;
import com.example.demo.mapper.PassengerMapper;
import com.example.demo.mapper.SeatMapper;
import com.example.demo.model.Booking;
import com.example.demo.model.BookingPassengers;
import com.example.demo.model.BookingResult;
import com.example.demo.model.FlightSearchResult;
import com.example.demo.model.Passenger;
import com.example.demo.model.PassengerParam;
import com.example.demo.model.Seat;

@Transactional
@Service
public class BookingService {
	@Autowired
	private BookingMapper bookingMapper;

	@Autowired
	private PassengerMapper passengerMapper;

	@Autowired
	private SeatMapper seatMapper;

	public List<BookingResult> getBookings(String result) {
		JSONObject jsonObjectStoredUser = JSON.parseObject(result);
		String storedUser = (String) jsonObjectStoredUser.get("storedUser");
		JSONObject jsonObjectUser = JSON.parseObject(storedUser);
		String userId = (String) jsonObjectUser.get("userId");

		List<BookingResult> bookings = bookingMapper.selectBookings(userId);
		for (BookingResult booking : bookings) {
			String bookingId = booking.getBookingId();
			List<BookingPassengers> passengers = passengerMapper.selectBookingPassenger(bookingId);
			booking.setPassengers(passengers);

			if (booking.isHasRoundTrip()) {
				String returnBookingId = booking.getReturnbookingId();
				List<BookingPassengers> returnPassengers = passengerMapper.selectBookingPassenger(returnBookingId);
				booking.setReturnpassengers(returnPassengers);
			}
		}
		return bookings;
	}

	public void setBooking(FlightSearchResult selectedDeparture, FlightSearchResult selectedReturn,
			List<PassengerParam> passengers, String storedUser) {
		Booking bookingDep = new Booking();
		Booking bookingReturn = new Booking();

		UUID uuid = UUID.randomUUID();
		String bookingId = uuid.toString();

		JSONObject jsonObject = JSON.parseObject(storedUser);
		String userId = (String) jsonObject.get("userId");

		Long bookingIdDep = selectedDeparture.getFlightId();
		bookingDep.setBookingId(bookingId);
		bookingDep.setUserId(userId);
		bookingDep.setFlightId(bookingIdDep);
		bookingDep.setReference("is null");
		bookingDep.setStatus("1");
		bookingDep.setBookingTime(new Date());

		BigDecimal total = BigDecimal.ZERO;

		Integer ecNum = 0;
		Integer bcNum = 0;
		Integer fcNum = 0;

		for (PassengerParam passenger : passengers) {
			Passenger passengerIns = new Passenger();
			UUID uuidp = UUID.randomUUID();
			String passengerId = uuidp.toString();

			String seatClass = passenger.getSeatType();
			passengerIns.setPassengerId(passengerId);
			passengerIns.setBookingId(bookingId);
			passengerIns.setEmail(passenger.getEmail());
			passengerIns.setFirstName(passenger.getFirstName());
			passengerIns.setLastName(passenger.getLastName());
			passengerIns.setPhone(passenger.getPhone());
			passengerIns.setIdNo(passenger.getIdNo());
			passengerIns.setSeatClass(seatClass);
			passengerIns.setSeat(null);
			passengerIns.setGate(null);
			passengerMapper.insert(passengerIns);
			switch (seatClass) {
			case "economy":
				total = total.add(selectedDeparture.getEconomyPrice());
				ecNum = ecNum + 1;
				break;
			case "business":
				total = total.add(selectedDeparture.getBusinessPrice());
				bcNum = bcNum + 1;
				break;
			case "firstClass":
				total = total.add(selectedDeparture.getFirstClassPrice());
				fcNum = fcNum + 1;
				break;
			default:
				break;
			}
		}
		bookingDep.setTotalPrice(total);

		Seat seat = seatMapper.selectByPrimaryKey(bookingIdDep);
		if (ObjectUtils.isEmpty(seat)) {
			Seat seatIns = new Seat();
			seatIns.setFlightId(bookingIdDep);
			seatIns.setBusinessClassCount(bcNum);
			seatIns.setEconomyClassCount(ecNum);
			seatIns.setFirstClassCount(fcNum);
			seatMapper.insert(seatIns);
		} else {
			Seat seatIns = new Seat();
			seatIns.setFlightId(bookingIdDep);
			seatIns.setBusinessClassCount(bcNum + seat.getBusinessClassCount());
			seatIns.setEconomyClassCount(ecNum + seat.getEconomyClassCount());
			seatIns.setFirstClassCount(fcNum + seat.getFirstClassCount());
			seatMapper.updateByPrimaryKey(seatIns);
		}
		if (ObjectUtils.isEmpty(selectedReturn)) {
			bookingDep.setBackBookingId(null);

		} else {

			UUID uuidR = UUID.randomUUID();
			String bookingIdR = uuidR.toString();

			Long bookingIdReturn = selectedReturn.getFlightId();
			bookingDep.setBackBookingId(bookingIdR);
			bookingReturn.setBookingId(bookingIdR);
			bookingReturn.setUserId(userId);
			bookingReturn.setFlightId(bookingIdReturn);
			bookingReturn.setReference("is null");
			bookingReturn.setStatus("1");
			bookingReturn.setBookingTime(new Date());
			bookingReturn.setBackBookingId(null);

			BigDecimal totalRet = BigDecimal.ZERO;

			Integer ecNumRet = 0;
			Integer bcNumRet = 0;
			Integer fcNumRet = 0;

			for (PassengerParam passenger : passengers) {
				Passenger passengerIns = new Passenger();
				UUID uuidp = UUID.randomUUID();
				String passengerId = uuidp.toString();

				String seatClass = passenger.getSeatTypeReturn();
				passengerIns.setPassengerId(passengerId);
				passengerIns.setBookingId(bookingIdR);
				passengerIns.setEmail(passenger.getEmail());
				passengerIns.setFirstName(passenger.getFirstName());
				passengerIns.setLastName(passenger.getLastName());
				passengerIns.setPhone(passenger.getPhone());
				passengerIns.setIdNo(passenger.getIdNo());
				passengerIns.setSeatClass(seatClass);
				passengerIns.setSeat(null);
				passengerIns.setGate(null);
				passengerMapper.insert(passengerIns);
				switch (seatClass) {
				case "economy":
					totalRet = totalRet.add(selectedReturn.getEconomyPrice());
					ecNumRet = ecNumRet + 1;
					break;
				case "business":
					totalRet = totalRet.add(selectedReturn.getBusinessPrice());
					bcNumRet = bcNumRet + 1;
					break;
				case "firstClass":
					totalRet = totalRet.add(selectedReturn.getFirstClassPrice());
					fcNumRet = fcNumRet + 1;
					break;
				default:
					break;
				}
			}
			bookingReturn.setTotalPrice(totalRet);

			bookingMapper.insert(bookingReturn);

			seat = seatMapper.selectByPrimaryKey(bookingIdReturn);
			if (ObjectUtils.isEmpty(seat)) {
				Seat seatIns = new Seat();
				seatIns.setFlightId(bookingIdReturn);
				seatIns.setBusinessClassCount(bcNumRet);
				seatIns.setEconomyClassCount(ecNumRet);
				seatIns.setFirstClassCount(fcNumRet);
				seatMapper.insert(seatIns);
			} else {
				Seat seatIns = new Seat();
				seatIns.setFlightId(bookingIdReturn);
				seatIns.setBusinessClassCount(bcNumRet + seat.getBusinessClassCount());
				seatIns.setEconomyClassCount(ecNumRet + seat.getEconomyClassCount());
				seatIns.setFirstClassCount(fcNumRet + seat.getFirstClassCount());
				seatMapper.updateByPrimaryKey(seatIns);
			}
		}
		bookingMapper.insert(bookingDep);
	}

}
