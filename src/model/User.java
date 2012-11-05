package model;

public class User
{
	private String username;
	private String password;
	
	public User()
	{
	}
	
	public User(String username, String password)
	{
		this.username=username;
		this.password=password;
	}
	
	public User(User userDTO)
	{
		this.username=userDTO.getUsername();
		this.password=userDTO.getPassword();
	}
	
	public void setUsername(String x)
	{
		this.username=x;
	}
	public String getUsername()
	{
		return this.username;
	}
	
	public void setPassword(String x)
	{
		this.password=x;
	}
	public String getPassword()
	{
		return this.password;
	}
}