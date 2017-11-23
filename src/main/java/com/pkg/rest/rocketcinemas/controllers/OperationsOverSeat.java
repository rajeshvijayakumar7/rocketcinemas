package com.pkg.rest.rocketcinemas.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.pkg.rest.rocketcinemas.db.ReservationDataBase;
import com.pkg.rest.rocketcinemas.models.Seat;


@Path("/seats")
public class OperationsOverSeat {

	public static ReservationDataBase reservationDB = new ReservationDataBase();
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Seat> listSeats() {
		return reservationDB.getAllSeats();
	}
	
	@PUT  
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public List<Seat> reserveSeats(List<Seat> seatsToReserve){
		List<Seat> modifiedSeats = new ArrayList<>();
		
		for(Seat seat : seatsToReserve) {
			seat.setSeatAvailable(false);
			//seat.setRow(seat.getSeatNumber()% 10) == 0 ? row++:row);
			modifiedSeats.add(seat);
		}
		List<Seat> bookedSeats = reservationDB.updateSeats(modifiedSeats);
		return bookedSeats;
	}
	
}
