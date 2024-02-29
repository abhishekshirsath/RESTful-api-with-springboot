package com.digitate.example.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

import com.digitate.example.model.Booking;

public interface BookingRepository extends JpaRepository<Booking,Integer>{

	
	
}
