package seleniumWrapper.Page;

public class ConcreteUser extends PrototypeUser
{
	public ConcreteUser()
	{
		this.firstName = "";
		this.lastName = ""; 
		this.userName = "";
		this.password = "";
	}
	
	public ConcreteUser(String userName, String password)
	{
		this.firstName = "";
		this.lastName = ""; 
		this.userName = userName;
		this.password = password;
	}
	
	public ConcreteUser(String firstName, String lastName, String userName, String password)
	{
		this.firstName = firstName;
		this.lastName = lastName; 
		this.userName = userName;
		this.password = password;
	}
	
	public String getFirstName()
	{
		return firstName;
	}
	
	public String getLastName()
	{
		return lastName;
	}
	
	public String getUserName()
	{
		return userName;
	}
	
	public String getPassword()
	{
		return password;
	}
	
	public void setFirstName(String firstName)
	{
		this.firstName = firstName;
	}
	
	public void setLastName(String lastName)
	{
		this.lastName = lastName;
	}
	
	public void setUserName(String username)
	{
		this.userName = username;
	}
	
	public void setPassword(String password)
	{
		this.password = password;
	}
	
	@Override
	public Object clone() {
		return new ConcreteUser(this.firstName, this.lastName, this.userName, this.password);
	}

}
