package seleniumWrapper.Page;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import seleniumWrapper.Browser;
import seleniumWrapper.Config;
import seleniumWrapper.WebElement.Button;
import seleniumWrapper.WebElement.TextBox;
public class LoginPage implements Page
{
	private String username;
	private String password;
	private String url;
	private TextBox uname;
	private TextBox pword;
	private Button submit;
	Browser myBrowser = new Browser(Config.chrome);

	public LoginPage(String uname, String pword) 
	{
		this.username = uname;
		this.password = pword;
		this.url = "https://www.facebook.com/?stype=lo&jlou=Afe3LTKY9wMMPDeuhoMupdZq1rRtykGVVKEK4H3zjxXLczrk1ikN2JlMUHa7ZZxUDmQxYkZERmEqcJL9KReRt-BScx2qwLkWa901rA6QKxbkag&smuh=9211&lh=Ac_4cCfhZ6w2ek2m";
	}
		
	public void setLoginFeilds(String usernameXpath, String paswordXpath, String submitButton)
	{
		uname = new TextBox(usernameXpath, myBrowser);
		pword = new TextBox(paswordXpath, myBrowser);
		submit = new Button(submitButton, myBrowser);
	}

	@Override
	public void testPage() {
		try 
		{
			myBrowser.get(url);
			uname.sendKeys(this.username);
			uname.sendKeys(this.password);
			submit.click();
		}
		catch(Exception e) 
		{
			myBrowser.errorHandler(e);  
		} 
	}
}

