package model;

public class Customer
{
	private String id;
	private String name;
	private String address;
	private String telephone;
	private String cardNumber;
	private String cardType;
	
	public Customer()
	{
	}
	
	public Customer(String id, String name, String address, String telephone, String cardNumber, String cardType)
	{
		this.id=id;
		this.name=name;
		this.address=address;
		this.telephone=telephone;
		this.cardNumber=cardNumber;
		this.cardType=cardType;
	}
	
	public Customer(Customer customerDTO)
	{
		this.id=customerDTO.getId();
		this.address=customerDTO.getAddress();
		this.telephone=customerDTO.getTelephone();
		this.cardNumber=customerDTO.getCardNumber();
		this.cardType=customerDTO.getCardType();
	}
	
	public String getId()
	{
		return this.id;
	}
	public void setId(String x)
	{
		this.id=x;
	}
	
	public String getName()
	{
		return this.name;
	}
	public void setName(String name)
	{
		this.name=name;
	}
	
	public String getAddress()
	{
		return this.address;
	}
	public void setAddress(String x)
	{
		this.address=x;
	}
	
	public String getTelephone()
	{
		return this.telephone;
	}
	public void setTelephone(String x)
	{
		this.telephone=x;
	}
	
	public String getCardNumber()
	{
		return this.cardNumber;
	}
	public void setCardNumber(String x)
	{
		this.cardNumber=x;
	}
	
	public String getCardType()
	{
		return this.cardType;
	}
	public void setCardType(String x)
	{
		this.cardType=x;
	}
}