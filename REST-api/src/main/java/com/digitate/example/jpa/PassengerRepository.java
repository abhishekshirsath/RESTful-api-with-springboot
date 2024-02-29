package com.digitate.example.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

import com.digitate.example.model.Booking;
import com.digitate.example.model.Passenger;

public interface PassengerRepository extends JpaRepository<Passenger,Integer>{

	
	
}
