package seleniumWrapper.Page;


import seleniumWrapper.Browser;
import seleniumWrapper.Config;
import seleniumWrapper.WebElement.Button;
import seleniumWrapper.WebElement.TextBox;
public class LoginPage implements Page
{
	private String url;
	private String usernameXpath;
	private String paswordXpath;
	private String submitButton;
	Browser myBrowser = new Browser(Config.chrome);
	ConcreteUser user;

	public LoginPage(String usernameXpath, String paswordXpath, String submitButton) 
	{
		url = "https://www.facebook.com/?stype=lo&jlou=Afe3LTKY9wMMPDeuhoMupdZq1rRtykGVVKEK4H3zjxXLczrk1ikN2JlMUHa7ZZxUDmQxYkZERmEqcJL9KReRt-BScx2qwLkWa901rA6QKxbkag&smuh=9211&lh=Ac_4cCfhZ6w2ek2m";
		try
		{
			this.usernameXpath = usernameXpath;
			this.paswordXpath = paswordXpath;
			this.submitButton = submitButton;
			user = new ConcreteUser("Adam", "Copeland", "lol", "lolo");
		}
		catch(Exception printstacktrace)
		{
			System.out.print(printstacktrace);
		}
	}
	
	public void setUser(ConcreteUser user)
	{
		this.user = user;
	}

	@Override
	public void testPage() {
		try 
		{
			
			myBrowser.get(url);
	    	Thread.sleep(2000);
	    	TextBox uname = new TextBox(usernameXpath, myBrowser);
	    	TextBox pword = new TextBox(paswordXpath, myBrowser);
			Button submit = new Button(submitButton, myBrowser);
			uname.sendKeys(user.getUserName());
			pword.sendKeys(user.getPassword());
			submit.click();
		}
		catch(Exception e) 
		{
			myBrowser.errorHandler(e);  
		} 
	}
}

