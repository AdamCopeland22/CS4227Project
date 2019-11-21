package seleniumWrapper.Page;

import seleniumWrapper.Browser;
import seleniumWrapper.Config;
import seleniumWrapper.WebElement.Button;

public class ButtonOnPage implements Page
{

	String button;
	Browser myBrowser = new Browser(Config.chrome);
	ConcreteUser user;
	String url;
	
	public ButtonOnPage(String button, String url)
	{
		this.button = button;
		this.url = url;
		user = new ConcreteUser();
	}
	
	/**
	 *@name setUser()
	 *@author Adam
	 *@param Pass a Conctete user 
	 *@return void
	 *@desc - Method for setting user of website
	*/
	@Override
	public void setUser(ConcreteUser user) {
		// TODO Auto-generated method stub
		this.user = user;
	}

	/**
	 *@name testPage()
	 *@author Adam
	 *@param none 
	 *@return void
	 *@desc - Method for testing website taken from the interface Page
	*/
	@Override
	public void testPage() {
		// TODO Auto-generated method stub
		try
		{
	
			myBrowser.get(url);
			Thread.sleep(2000);
			Button submit = new Button(button, myBrowser);
			submit.click();
			myBrowser.passedTest();
		}
		catch(Exception e) 
		{
			myBrowser.errorHandler(e);  
		}
    	
	}
	

}
