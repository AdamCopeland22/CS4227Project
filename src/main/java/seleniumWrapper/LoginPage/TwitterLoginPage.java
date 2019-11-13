package seleniumWrapper.LoginPage;

import seleniumWrapper.Browser;
import seleniumWrapper.Config;
import seleniumWrapper.WebElement.Button;
import seleniumWrapper.WebElement.TextBox;

public class TwitterLoginPage implements LoginPage{
	String username;
	String password;
	String url;
	
	public TwitterLoginPage(String username, String password){
		this.username = username;
		this.password = password;
		this.url = "https://twitter.com/login";
	}

	@Override
	public void loginWithXpaths(String usernameXpath, String PaswordXpath, String submitButton) {
		// TODO Auto-generated method stub
		Browser myBrowser = new Browser(Config.chrome);
		try 
		{
			myBrowser.get(url);
			TextBox uname = new TextBox(usernameXpath, myBrowser);
			TextBox pword = new TextBox(PaswordXpath, myBrowser);
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
	public void loginWithIDs(String unameID, String pwordID, String submitButton) {
		// TODO Auto-generated method stub
		
	}
	

}
