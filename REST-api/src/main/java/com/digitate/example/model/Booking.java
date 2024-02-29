package com.digitate.example.model;

import java.time.LocalDate;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

@Entity(name = "booking_details")
public class Booking {
	
	@Id
	@GeneratedValue
	@Column(name = "booking_number")
	private Integer bookingNumber;
	
	@NotEmpty(message = "Bus Number should not be empty.")
	@Column(name = "bus_number")
	private String busNumber;
    
    @FutureOrPresent(message = "Booking date should be in PRESENT or FUTURE.")
    @Column(name = "booking_date")
    private LocalDate bookingDate;
    
    @NotEmpty(message = "Source should not be empty.")
    private String source;
    
    @NotEmpty(message = "Destination should not be empty.")
    private String destination;
    
    @Column(name = "number_of_seats")
    private Integer numberOfSeats;
    
    private String status;
    
    @OneToMany(mappedBy = "booking")
    @JsonIgnore
    private List<Passenger> passenger;
    
    public Booking() {
    	
    }
    
	public Booking(Integer bookingNumber, String busNumber, LocalDate bookingDate, String source, String destination,
			Integer numberOfSeats, String status) {
		super();
		this.bookingNumber = bookingNumber;
		this.busNumber = busNumber;
		this.bookingDate = bookingDate;
		this.source = source;
		this.destination = destination;
		this.numberOfSeats = numberOfSeats;
		this.status = status;
	}


	public Integer getBookingNumber() {
		return bookingNumber;
	}


	public void setBookingNumber(Integer bookingNumber) {
		this.bookingNumber = bookingNumber;
	}


	public String getBusNumber() {
		return busNumber;
	}


	public void setBusNumber(String busNumber) {
		this.busNumber = busNumber;
	}


	public LocalDate getBookingDate() {
		return bookingDate;
	}


	public void setBookingDate(LocalDate bookingDate) {
		this.bookingDate = bookingDate;
	}


	public String getSource() {
		return source;
	}


	public void setSource(String source) {
		this.source = source;
	}


	public String getDestination() {
		return destination;
	}


	public void setDestination(String destination) {
		this.destination = destination;
	}


	public Integer getNumberOfSeats() {
		return numberOfSeats;
	}


	public void setNumberOfSeats(Integer numberOfSeats) {
		this.numberOfSeats = numberOfSeats;
	}


	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}


	public List<Passenger> getPassenger() {
		return passenger;
	}

	public void setPassenger(List<Passenger> passenger) {
		this.passenger = passenger;
	}

	@Override
	public String toString() {
		return "Booking [bookingNumber=" + bookingNumber + ", busNumber=" + busNumber + ", bookingDate=" + bookingDate
				+ ", source=" + source + ", destination=" + destination + ", numberOfSeats=" + numberOfSeats
				+ ", status=" + status + "]";
	}
    
	
    
    

}
