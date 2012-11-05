package model;

import java.io.Serializable;

public class Location implements Serializable
{
	private int locationTypeId;
	private int event;
	private int price;
	private int quantity;
	private boolean numbered;
	
	public Location()
	{
	}
	
	public Location(int locationTypeId, int event, int price, int quantity, boolean numbered)
	{
		this.locationTypeId=locationTypeId;
		this.event=event;
		this.price=price;
		this.quantity=quantity;
		this.numbered=numbered;
	}
	
	public Location(Location locationDTO)
	{
		this.locationTypeId=locationDTO.getLocationTypeId();
		this.event=locationDTO.getEvent();
		this.price=locationDTO.getPrice();
		this.quantity=locationDTO.getQuantity();
		this.numbered=locationDTO.getNumbered();
	}
	
	public int getLocationTypeId()
	{
		return this.locationTypeId;
	}
	
	public void setLocationTypeId(int x)
	{
		this.locationTypeId=x;
	}
	
	public int getEvent()
	{
		return this.event;
	}
	
	public void setEvent(int x)
	{
		this.event=x;
	}
	
	public int getPrice()
	{
		return this.price;
	}
	
	public void setPrice(int x)
	{
		this.price=x;
	}
	
	public int getQuantity()
	{
		return this.quantity;
	}
	
	public void setQuantity(int x)
	{
		this.quantity=x;
	}
	
	public boolean getNumbered()
	{
		return this.numbered;
	}
	
	public void setNumbered(boolean x)
	{
		this.numbered=x;
	}
}