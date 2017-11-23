package com.pkg.rest.rocketcinemas.db;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static com.pkg.rest.rocketcinemas.enums.Audience.MALE;
import static com.pkg.rest.rocketcinemas.enums.SeatType.EXECUTIVE;
import static com.pkg.rest.rocketcinemas.enums.SeatType.PREMIUM;
import com.pkg.rest.rocketcinemas.models.Seat;

public class ReservationDataBase {

	public static HashMap<Integer, Seat> reservationDB = new HashMap<>();

	public ReservationDataBase() {
		int row = 1;
		for (int i = 1; i <= 100; i++) {
			Seat seat = new Seat();
			seat.setSeatNumber(i);
			seat.setOccupiedBy(MALE);
			seat.setRow((i % 10) == 0 ? row++:row );
			seat.setSeatAvailable(true);
			seat.setSeatType(row > 8 ? PREMIUM : EXECUTIVE);
			reservationDB.put(i, seat);
		}
	}

	public List<Seat> getAllSeats() {
		List<Seat> allSeats = new ArrayList<>(reservationDB.values());
		return allSeats;
	}

	public List<Seat> updateSeats(List<Seat> seatsToUpdate) {
		
		List<Seat> modifiedSeats = new ArrayList<>();
		for (Seat seat : seatsToUpdate) {
			reservationDB.put(seat.getSeatNumber(), seat);
		}	
		modifiedSeats.addAll(seatsToUpdate);
		
		return modifiedSeats;
	}
}
