package seleniumWrapper.Page;

import seleniumWrapper.Browser;
import seleniumWrapper.Config;
import seleniumWrapper.WebElement.Button;
import seleniumWrapper.WebElement.TextBox;

public class SearchPage implements Page{
	
	String searchBarXpath;
	String submitButton;
	String url = "https://www.google.com";
	Browser myBrowser = new Browser(Config.chrome);

	
	public SearchPage(String searchBarXpath, String submitButton)
	{
		this.searchBarXpath = searchBarXpath;
		this.submitButton = submitButton;
	}
	
	@Override
	public void testPage() {
		try
		{
			myBrowser.get(url);
	    	Thread.sleep(2000);
	    	TextBox searchBar = new TextBox(searchBarXpath, myBrowser);
			Button submit = new Button(submitButton, myBrowser);
			searchBar.sendKeys("hello world");
			submit.click();
		}
		catch(Exception e)
		{
			myBrowser.errorHandler(e);
		}
	}

}
