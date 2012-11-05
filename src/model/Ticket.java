package model;

public class Ticket
{
	private int code;
	private int locationTypeId;
	private int eventId;
	private String customerId;
	private String date;
	private int quantity;
	private int amount;
	
	public Ticket()
	{
	}
	
	public Ticket(int code, int locationTypeId, int eventId, String customerId, String date, int quantity, int amount)
	{
		this.code=code;
		this.locationTypeId=locationTypeId;
		this.eventId=eventId;
		this.customerId=customerId;
		this.date=date;
		this.quantity=quantity;
		this.amount=amount;
	}
	
	public Ticket(Ticket ticketDTO)
	{
		this.code=ticketDTO.getCode();
		this.locationTypeId=ticketDTO.getLocationTypeId();
		this.eventId=ticketDTO.getEventId();
		this.customerId=ticketDTO.getCustomerId();
		this.date=ticketDTO.getDate();
		this.quantity=ticketDTO.getQuantity();
		this.amount=ticketDTO.getAmount();
	}
	
	public int getCode()
	{
		return this.code;
	}
	public void setCode(int x)
	{
		this.code=x;
	}
	public int getLocationTypeId()
	{
		return this.locationTypeId;
	}
	public void setLocationTypeId(int x)
	{
		this.locationTypeId=x;
	}
	public int getEventId()
	{
		return this.eventId;
	}
	public void setEventId(int x)
	{
		this.eventId=x;
	}
	public String getCustomerId()
	{
		return this.customerId;
	}
	public void setCustomerId(String x)
	{
		this.customerId=x;
	}
	public String getDate()
	{
		return this.date;
	}
	public void setDate(String x)
	{
		this.date=x;
	}
	public int getQuantity()
	{
		return this.quantity;
	}
	public void setQuantity(int x)
	{
		this.quantity=x;
	}
	public int getAmount()
	{
		return this.amount;
	}
	public void setAmount(int x)
	{
		this.amount=x;
	}
}