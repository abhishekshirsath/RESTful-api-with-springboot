package com.digitate.example.model;

import java.net.URI;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.http.ResponseEntity.BodyBuilder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import jakarta.validation.Valid;

@RestController
public class BookingResource {
		
	private BookingDaoService service;
	
	public BookingResource(BookingDaoService service) {
		this.service = service;
	}
	
	@GetMapping("/bookings")
	public List<Booking> allBookings(){
		return service.findAll();
	}
	
	@GetMapping("/bookings/{id}")
	public Booking retrieveBooking(@PathVariable int id) {
		Booking booking = service.findOne(id);
		if(booking == null)
			throw new BookingNotFoundException("BookingNumber: "+id);
		return booking;
	}
	
	@PostMapping("/bookings")
	public ResponseEntity<Object> doBooking(@Valid @RequestBody Booking booking) {
		Booking savedBooking = service.save(booking);
		
		URI location = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}")
				.buildAndExpand(savedBooking.getBookingNumber())
				.toUri();
		return ResponseEntity.created(location ).build();
	}
	
	@DeleteMapping("/bookings/{id}")
	public void deleteBooking(@PathVariable int id) {
		service.deleteById(id);
		
	}
}
