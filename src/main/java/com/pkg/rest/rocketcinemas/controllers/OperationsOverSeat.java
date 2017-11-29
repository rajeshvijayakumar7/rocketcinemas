package com.pkg.rest.rocketcinemas.controllers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

import com.pkg.rest.rocketcinemas.db.ReservationDataBase;
import com.pkg.rest.rocketcinemas.models.Seat;


@Path("/seats")
public class OperationsOverSeat {

	public static ReservationDataBase reservationDB = new ReservationDataBase();
	
	@GET
	@Path("all")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Seat> listAllSeats() {
		return reservationDB.getAllSeats();
	}
	
	@GET
	@Path("availableseats")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Seat> listAvailableSeats(){
		List<Seat> availableSeats = new ArrayList<>();
		for(Seat seat:reservationDB.getAllSeats()) {
			if(seat.isSeatAvailable()) {
				availableSeats.add(seat);
			}
		}
		return availableSeats;
	}
	
	@PUT
	@Path("resSeats")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public List<Seat> reserveSeats(List<Seat> seatsToReserve, @Context HttpServletResponse response){	

		List<Seat> bookedSeats = reservationDB.updateSeats(seatsToReserve);
		response.setStatus(HttpServletResponse.SC_ACCEPTED);
		try {
			response.flushBuffer();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return bookedSeats;
	}
	
	@PUT
	@Path("unResSeats")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public List<Seat> unReserveSeats(List<Seat> seatsToUnReserve){	
		List<Seat> freeSeats = reservationDB.updateSeats(seatsToUnReserve);
		return freeSeats;
	}
}
