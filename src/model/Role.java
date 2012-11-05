package model;

public class Role
{
	private int code;
	private String description;
	
	public Role()
	{
	}
	
	public Role(int code, String description)
	{
		this.code=code;
		this.description=description;
	}
	
	public Role(Role roleDTO)
	{
		this.code=roleDTO.getCode();
		this.description=roleDTO.getDescription();
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