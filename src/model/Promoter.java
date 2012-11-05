package model;

public class Promoter
{
	private int code;
	private String name;
	private String address;
	private String telephone;
	private String account;
	private String bank;
	private int comission;
	private String username;
	
	public Promoter()
	{
	}
	
	public Promoter(int code, String name, String address, String telephone, String account, String bank, int comission, String username)
	{
		this.code=code;
		this.name=name;
		this.address=address;
		this.telephone=telephone;
		this.account=account;
		this.bank=bank;
		this.comission=comission;
		this.username=username;
	}
	
	public Promoter(Promoter promoterDTO)
	{
		this.code=promoterDTO.getCode();
		this.name=promoterDTO.getName();
		this.address=promoterDTO.getAddress();
		this.telephone=promoterDTO.getTelephone();
		this.account=promoterDTO.getAccount();
		this.bank=promoterDTO.getBank();
		this.comission=promoterDTO.getComission();
		this.username=promoterDTO.getUsername();
	}
	
	public void setCode(int x)
	{
		this.code=x;
	}
	
	public int getCode()
	{
		return this.code;
	}
	
	public void setName(String x)
	{
		this.name=x;
	}
	
	public String getName()
	{
		return this.name;
	}
	public void setAddress(String x)
	{
		this.address=x;
	}
	
	public String getAddress()
	{
		return this.address;
	}
	public void setTelephone(String x)
	{
		this.telephone=x;
	}
	
	public String getTelephone()
	{
		return this.telephone;
	}
	public void setAccount(String x)
	{
		this.account=x;
	}
	
	public String getAccount()
	{
		return this.account;
	}
	public void setBank(String x)
	{
		this.bank=x;
	}
	
	public String getBank()
	{
		return this.bank;
	}
	public void setComission(int x)
	{
		this.comission=x;
	}
	
	public int getComission()
	{
		return this.comission;
	}
	public void setUsername(String x)
	{
		this.username=x;
	}
	
	public String getUsername()
	{
		return this.username;
	}
}