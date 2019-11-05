package seleniumWrapper.WebElement;

import seleniumWrapper.Browser;

public interface Filter {
	public boolean execute(ElementHandler e,Browser b,String request); 

}
