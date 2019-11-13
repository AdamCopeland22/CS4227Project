package seleniumWrapper.LoginPage;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import seleniumWrapper.Browser;
import seleniumWrapper.Config;
import seleniumWrapper.WebElement.Button;
import seleniumWrapper.WebElement.TextBox;
public class FacebookLoginPage implements LoginPage
{
	String username;
	String password;
	String url;
		
	public FacebookLoginPage(String uname, String pword) 
	{
		this.username = uname;
		this.password = pword;
		this.url = "https://www.facebook.com/?stype=lo&jlou=Afe3LTKY9wMMPDeuhoMupdZq1rRtykGVVKEK4H3zjxXLczrk1ikN2JlMUHa7ZZxUDmQxYkZERmEqcJL9KReRt-BScx2qwLkWa901rA6QKxbkag&smuh=9211&lh=Ac_4cCfhZ6w2ek2m";
	}
		
	@Override	
	public void loginWithXpaths(String usernameXpath, String paswordXpath, String submitButton)
	{
		Browser myBrowser = new Browser(Config.chrome);
		try 
		{
			myBrowser.get(url);
			TextBox uname = new TextBox(usernameXpath, myBrowser);
			TextBox pword = new TextBox(paswordXpath, myBrowser);
			uname.sendKeys(this.username);
			uname.sendKeys(this.password);
			
			Button submit = new Button(submitButton, myBrowser);
			submit.click();
		}
		catch(Exception e) 
		{
			myBrowser.errorHandler(e);  
		} 
		
	}

	@Override
	public void loginWithIDs(String unameID, String pwordID, String submitButton)
	{
		// TODO Auto-generated method stub
		
	}
}

