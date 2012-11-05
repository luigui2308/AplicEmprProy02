package model;

import java.io.Serializable;

public class RoleByUser implements Serializable
{
	private String username;
	private int roleCode;
	
	public RoleByUser()
	{
	}
	
	public RoleByUser(String username, int roleCode)
	{
		this.username = username;
		this.roleCode = roleCode;
	}
	
	public RoleByUser(RoleByUser roleByUser)
	{
		this.username = roleByUser.getUsername();
		this.roleCode = roleByUser.getRoleCode();
	}
	
	public String getUsername()
	{
		return this.username;
	}
	public void setUsername(String username)
	{
		this.username = username;
	}
	
	public int getRoleCode()
	{
		return this.roleCode;
	}
	public void setRoleCode(int roleCode)
	{
		this.roleCode = roleCode;
	}
}