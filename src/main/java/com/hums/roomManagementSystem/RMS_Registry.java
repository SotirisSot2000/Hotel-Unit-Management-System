package com.hums.roomManagementSystem;

import java.io.Serializable;


public class RMS_Registry implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	private static RMS_Registry registryInstance=null;
	
	
	private RoomList roomList;
	private CustomerList customerList;
	private RoomReservationList reservationList;
	

	private RMS_Registry() {
		this.roomList = new RoomList();
		this.reservationList = new RoomReservationList();
		this.customerList = new CustomerList();
	}
	
	public synchronized static RMS_Registry getInstance() {
		
		if(registryInstance == null) {
			registryInstance = new RMS_Registry();
		}
		
		return registryInstance;
	}

	public RoomList getRoomList() {
		return roomList;
	}
	
	public void setRoomList(RoomList roomsList) {
		this.roomList = roomsList;
	}
	
	public CustomerList getCustomerList() {
		return customerList;
	}
	
	public void setCustomerList(CustomerList customerList) {
		this.customerList = customerList;
	}
	
	public RoomReservationList getReservationList() {
		return reservationList;
	}
	
	public void setReservationList(RoomReservationList roomReservationList) {
		this.reservationList = roomReservationList;
	}
	
	
	
	
	

}
