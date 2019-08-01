package com.rcg.com.dto;

import java.util.List;

public class DataDto 
{
	private long bookingId;
    private List<GuestListDto> guestList;
    
	public long getBookingId() {
		return bookingId;
	}
	public void setBookingId(long bookingId) {
		this.bookingId = bookingId;
	}
	public List<GuestListDto> getGuestList() {
		return guestList;
	}
	public void setGuestList(List<GuestListDto> guestList) {
		this.guestList = guestList;
	}
    
    
}
