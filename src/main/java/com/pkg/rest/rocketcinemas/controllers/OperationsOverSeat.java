package com.pkg.rest.rocketcinemas.controllers;

import java.util.ArrayList;
import java.util.List;

import com.pkg.rest.rocketcinemas.models.Seat;

public class OperationsOverSeat {

	public List<Seat> listSeats() {
		List<Seat> seats = new ArrayList<>();
		
		return seats;
	}

	public boolean reserveSeat(Seat reservedSeat) {
		boolean reservationResult = false;
		
		return reservationResult;
	}
	
	public void unreserveSeat(Seat unreservedSeat) {
		
	}
}
