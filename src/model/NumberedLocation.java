package model;

import java.io.Serializable;

public class NumberedLocation implements Serializable
{
	private int locationNumber;
	private int ticketId;
	
	public NumberedLocation()
	{
	}
	
	public NumberedLocation(int locationNumber, int ticketId)
	{
		this.locationNumber=locationNumber;
		this.ticketId=ticketId;
	}
	
	public NumberedLocation(NumberedLocation numberedLocationDTO)
	{
		this.locationNumber=numberedLocationDTO.getLocationNumber();
		this.ticketId=numberedLocationDTO.getTicketId();
	}
	
	public int getLocationNumber()
	{
		return this.locationNumber;
	}
	
	public void setLocationNumber(int x)
	{
		this.locationNumber=x;
	}
	
	public int getTicketId()
	{
		return this.ticketId;
	}
	
	public void setTicketId(int x)
	{
		this.ticketId=x;
	}
}