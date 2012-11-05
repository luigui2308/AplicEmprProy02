package model;

public class Event
{
	private int code;
	private String name;
	private int eventTypeCode;
	private String artists;
	private String date;
	private String place;
	private int promoterId;
	
	public Event()
	{
		
	}
	
	public Event(int code, String name, int eventTypeCode, String artists, String date, String place, int promoterId)
	{
		this.code=code;
		this.name=name;
		this.eventTypeCode=eventTypeCode;
		this.artists=artists;
		this.date=date;
		this.place=place;
		this.promoterId=promoterId;
	}
	
	public Event(Event eventDTO)
	{
		this.code=eventDTO.getCode();
		this.name=eventDTO.getName();
		this.eventTypeCode=eventDTO.getEventTypeCode();
		this.artists=eventDTO.getArtists();
		this.date=eventDTO.getDate();
		this.place=eventDTO.getPlace();
		this.promoterId=eventDTO.getPromoterId();
	}
	
	public int getCode()
	{
		return this.code;
	}
	public void setCode(int x)
	{
		this.code=x;
	}
	public String getName()
	{
		return this.name;
	}
	public void setName(String x)
	{
		this.name=x;
	}
	public int getEventTypeCode()
	{
		return this.eventTypeCode;
	}
	public void setEventTypeCode(int x)
	{
		this.eventTypeCode=x;
	}
	public String getArtists()
	{
		return this.artists;
	}
	public void setArtists(String x)
	{
		this.artists=x;
	}
	public String getDate()
	{
		return this.date;
	}
	public void setDate(String x)
	{
		this.date=x;
	}
	public String getPlace()
	{
		return this.place;
	}
	public void setPlace(String x)
	{
		this.place=x;
	}
	public int getPromoterId()
	{
		return this.promoterId;
	}
	public void setPromoterId(int x)
	{
		this.promoterId=x;
	}
}