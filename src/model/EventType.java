package model;

public class EventType
{
	private int code;
	private String description;
	
	public EventType()
	{
	}
	
	public EventType(int code, String description)
	{
		this.code=code;
		this.description=description;
	}
	
	public EventType(EventType eventTypeDTO)
	{
		this.code=eventTypeDTO.getCode();
		this.description=eventTypeDTO.getDescription();
	}
	
	public int getCode()
	{
		return this.code;
	}
	public void setCode(int x)
	{
		this.code=x;
	}
	
	public String getDescription()
	{
		return this.description;
	}
	public void setDescription(String x)
	{
		this.description=x;
	}
}