package com.pkg.rest.rocketcinemas.models;

import com.pkg.rest.rocketcinemas.enums.Audience;
import com.pkg.rest.rocketcinemas.enums.SeatType;

public class Seat {

	private int seatNumber;
	private SeatType seatType;
	private int row;
	private boolean seatAvailable;
	private Audience occupiedBy;
	
	public int getSeatNumber() {
		return seatNumber;
	}
	public void setSeatNumber(int seatNumber) {
		this.seatNumber = seatNumber;
	}
	public SeatType getSeatType() {
		return seatType;
	}
	public void setSeatType(SeatType seatType) {
		this.seatType = seatType;
	}
	public int getRow() {
		return row;
	}
	public void setRow(int row) {
		this.row = row;
	}
	public boolean isSeatAvailable() {
		return seatAvailable;
	}
	public void setSeatAvailable(boolean seatAvailability) {
		this.seatAvailable = seatAvailability;
	}
	public Audience getOccupiedBy() {
		return occupiedBy;
	}
	public void setOccupiedBy(Audience occupiedBy) {
		this.occupiedBy = occupiedBy;
	}
	

}
