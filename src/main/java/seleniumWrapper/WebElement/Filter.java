package seleniumWrapper.WebElement;

import org.openqa.selenium.WebElement;

import seleniumWrapper.Browser;

public interface Filter {
	/**
	 *@name execute(WebElement e,Browser b,String request)
	 *@author Cian
	 *@param None
	 *@return void
	 *@desc - Logs a passed test case	
	*/
	public boolean execute(WebElement e,Browser b,String request); 

}
