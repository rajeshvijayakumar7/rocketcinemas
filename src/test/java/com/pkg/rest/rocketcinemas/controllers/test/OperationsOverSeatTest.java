package com.pkg.rest.rocketcinemas.controllers.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;

import com.pkg.rest.rocketcinemas.controllers.OperationsOverSeat;
import com.pkg.rest.rocketcinemas.models.Seat;

public class OperationsOverSeatTest {

	@Test
	public void listSeatsTest() {
		OperationsOverSeat opr = new OperationsOverSeat();
		List<Seat> actualSeats = opr.listAllSeats();
		List<Seat> expectedSeats = new ArrayList<>();
		assertEquals(actualSeats, expectedSeats);	
	}
	
	@Test
	public void listSeatsNullTest() {
		OperationsOverSeat opr = new OperationsOverSeat();
		List<Seat> seats = opr.listAllSeats();
		assertNotNull(seats);	
	}
	
}
