package model;

public class LocationType
{
	private int code;
	private String description;
	
	public LocationType()
	{
	}
	
	public LocationType(int code, String description)
	{
		this.code=code;
		this.description=description;
	}
	
	public LocationType(LocationType locationType)
	{
		this.code = locationType.getCode();
		this.description = locationType.getDescription();
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