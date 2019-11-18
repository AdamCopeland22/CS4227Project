package seleniumWrapper.Page;


import seleniumWrapper.Browser;
import seleniumWrapper.Config;
import seleniumWrapper.WebElement.Button;
import seleniumWrapper.WebElement.TextBox;
public class LoginPage implements Page
{
	private String username;
	private String password;
	private String url;
	private String usernameXpath;
	private String paswordXpath;
	private String submitButton;
	Browser myBrowser = new Browser(Config.chrome);

	public LoginPage(String usernameXpath, String paswordXpath, String submitButton) 
	{
		username = "adam";
		password = "copeland";
		url = "https://www.facebook.com/?stype=lo&jlou=Afe3LTKY9wMMPDeuhoMupdZq1rRtykGVVKEK4H3zjxXLczrk1ikN2JlMUHa7ZZxUDmQxYkZERmEqcJL9KReRt-BScx2qwLkWa901rA6QKxbkag&smuh=9211&lh=Ac_4cCfhZ6w2ek2m";
		try
		{
			this.usernameXpath = usernameXpath;
			this.paswordXpath = paswordXpath;
			this.submitButton = submitButton;
		}
		catch(Exception printstacktrace)
		{
			System.out.print(printstacktrace);
		}
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
			uname.sendKeys(this.username);
			pword.sendKeys(this.password);
			submit.click();
		}
		catch(Exception e) 
		{
			myBrowser.errorHandler(e);  
		} 
	}
}

