package com.digitate.example.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import org.springframework.stereotype.Component;

@Component
public class BookingDaoService {

	private static List<Booking> bookings = new ArrayList<>();
	
	private static int count = 0;
	static {
		bookings.add(new Booking(++count, "MH2002", LocalDate.now().minusYears(10), "Khed", "Pune", 25, "Yes"));
		bookings.add(new Booking(++count, "MH4002", LocalDate.now().minusYears(60), "Khed1", "Pune1", 25, "No"));
	}
	
	public List<Booking> findAll(){
		return bookings;
	}
	
	public Booking save(Booking booking) {
		booking.setBookingNumber(++count);
		bookings.add(booking);
		return booking;
		}

	public Booking findOne(int id) {
		// TODO Auto-generated method stub
		Predicate<? super Booking> predicate = booking -> booking.getBookingNumber().equals(id);
		return bookings.stream().filter(predicate).findFirst().orElse(null);
	}
	
	public void deleteById(int id) {
		// TODO Auto-generated method stub
		Predicate<? super Booking> predicate = booking -> booking.getBookingNumber().equals(id);
		bookings.removeIf(predicate);
	}
}
