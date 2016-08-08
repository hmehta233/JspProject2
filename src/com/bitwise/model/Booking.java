package com.bitwise.model;

public class Booking {
	private String customerName;
	private String address;
	private String contactNumber;
	private String movishow;
	private String date;
	private String noOfSeatsBooked;
	
	
	public String getCustName() {
		return customerName;
	}
	public void setCustName(String movieName) {
		this.customerName = movieName;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getContactNumber() {
		return contactNumber;
	}
	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}
	public String getMovishow() {
		return movishow;
	}
	public void setMovishow(String movishow) {
		this.movishow = movishow;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getNoOfSeatsBooked() {
		return noOfSeatsBooked;
	}
	public void setNoOfSeatsBooked(String noOfSeatsBooked) {
		this.noOfSeatsBooked = noOfSeatsBooked;
	}


}
