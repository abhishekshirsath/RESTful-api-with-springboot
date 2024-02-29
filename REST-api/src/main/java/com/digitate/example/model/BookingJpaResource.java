package com.digitate.example.model;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.http.ResponseEntity.BodyBuilder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.digitate.example.jpa.BookingRepository;
import com.digitate.example.jpa.PassengerRepository;

import jakarta.validation.Valid;

@RestController
public class BookingJpaResource {
	
	private BookingRepository bookingRepository;
	
	private PassengerRepository passengerRepository;
	
	public BookingJpaResource(BookingRepository bookingRepository, PassengerRepository passengerRepository) {
		this.bookingRepository = bookingRepository;
		this.passengerRepository = passengerRepository;
	}
	
	@GetMapping("/jpa/bookings")
	public List<Booking> allBookings(){
		return bookingRepository.findAll();
	}
	
	@GetMapping("/jpa/bookings/{id}")
	public Optional<Booking> retrieveBooking(@PathVariable int id) {
		Optional<Booking> booking = bookingRepository.findById(id);
		if(booking.isEmpty())
			throw new BookingNotFoundException("BookingNumber: "+id);
		
		return booking;
	}
	
	@PostMapping("/jpa/bookings")
	public ResponseEntity<Object> doBooking(@Valid @RequestBody Booking booking) {
		Booking savedBooking = bookingRepository.save(booking);
		
		URI location = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}")
				.buildAndExpand(savedBooking.getBookingNumber())
				.toUri();
		
		return ResponseEntity.created(location ).build();
	}
	
	@DeleteMapping("/jpa/bookings/{id}")
	public void deleteBooking(@PathVariable int id) {
		bookingRepository.deleteById(id);
		
	}
	
	// ++++++ For Passenger Entity ++++
	
	@GetMapping("/jpa/bookings/{id}/passenger")
	public List<Passenger> retrievePassengerForBooking(@PathVariable int id) {
		Optional<Booking> booking = bookingRepository.findById(id);
		if(booking.isEmpty())
			throw new BookingNotFoundException("BookingNumber: "+id);
		
		return booking.get().getPassenger();
		
	}
	
	@PostMapping("/jpa/bookings/{id}/passenger")
	public ResponseEntity<Object> addPassenger(@PathVariable int id, @Valid @RequestBody Passenger passenger) {
		Optional<Booking> booking = bookingRepository.findById(id);
		if(booking.isEmpty())
			throw new BookingNotFoundException("BookingNumber: "+id);
		
		passenger.setBooking(booking.get());
		
		Passenger savedPassenger = passengerRepository.save(passenger);
		
		URI location = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}")
				.buildAndExpand(savedPassenger.getId())
				.toUri();
		
		return ResponseEntity.created(location ).build();
		
	}
}
