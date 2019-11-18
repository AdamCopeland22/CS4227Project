package seleniumWrapper.Page;

import seleniumWrapper.Browser;
import seleniumWrapper.Config;
import seleniumWrapper.WebElement.Button;
import seleniumWrapper.WebElement.TextBox;

public class GoogleSignUpPage implements Page{
	
	String firstNameXpath;
	String lastNameXpath;
	String usernameXpath;
	String passwordXpath;
	String confirmPWXpath;
	String submitButton;
	String url = "https://accounts.google.com/signup/v2/webcreateaccount?flowName=GlifWebSignIn&flowEntry=SignUp";
	Browser myBrowser = new Browser(Config.chrome);
	
	public GoogleSignUpPage(String firstNameXpath, String lastNameXpath, String usernameXpath, String passwordXpath, String confirmPWXpath, String submitButton) 
	{
		this.firstNameXpath = firstNameXpath;
		this.lastNameXpath = lastNameXpath;
		this.usernameXpath = usernameXpath;
		this.passwordXpath = passwordXpath;
		this.confirmPWXpath = confirmPWXpath;
		this.submitButton = submitButton;
	}
	
	@Override
	public void testPage() {
		// TODO Auto-generated method stub
		try
		{
			myBrowser.get(url);
	    	Thread.sleep(2000);
	    	
			TextBox firstName = new TextBox(firstNameXpath, myBrowser);
			TextBox lastName = new TextBox(lastNameXpath, myBrowser);
			TextBox username = new TextBox(usernameXpath, myBrowser);
			TextBox password = new TextBox(passwordXpath, myBrowser);
			TextBox confirmPassword = new TextBox(confirmPWXpath, myBrowser);
			Button submit = new Button(submitButton, myBrowser);
	
			firstName.sendKeys("Adam");
			lastName.sendKeys("Adam");
			username.sendKeys("Adam");
			password.sendKeys("Adam");
			confirmPassword.sendKeys("Adam");
			
			submit.click();
		}
		catch(Exception e) 
		{
			myBrowser.errorHandler(e);  
		} 
	}

}
