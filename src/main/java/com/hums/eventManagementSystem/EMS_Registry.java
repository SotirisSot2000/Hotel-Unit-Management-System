package com.hums.eventManagementSystem;

import java.io.Serializable;

public class EMS_Registry implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private static EMS_Registry registryInstance = null;
	
	private EMS_Registry() {
		this.eventReservationList = new EventReservationList();
		this.hallList = new HallList();
	}
	
	public static EMS_Registry getInstance() {
		
		if(registryInstance == null) {
			registryInstance = new EMS_Registry();
		}
		
		return registryInstance;
		
	}
	
	public static void setInstance(EMS_Registry instance) {
		registryInstance = instance;
	}
	
	public static void resetInstance() {
		registryInstance = new EMS_Registry();
	}
	
	private EventReservationList eventReservationList;
	private HallList hallList;
	
	
	public EventReservationList getEventReservationList() {
		return eventReservationList;
	}
	public HallList getHallList() {
		return hallList;
	}
	
	public void setEventReservationList(EventReservationList eventReservationList) {
		this.eventReservationList = eventReservationList;
	}
	public void setHallList(HallList hallList) {
		this.hallList = hallList;
	}
	
	
	
	
	
	
}