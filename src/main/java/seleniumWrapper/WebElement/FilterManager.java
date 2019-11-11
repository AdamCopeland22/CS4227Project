package seleniumWrapper.WebElement;

import org.openqa.selenium.WebElement;

import seleniumWrapper.Browser;

public class FilterManager {

	FilterChain filterChain;
	

	   public FilterManager(WebElement target,Browser browser){
	      filterChain = new FilterChain(browser);
	      filterChain.setTarget(target);
	   }
	   
	   
	   /**
		 *@name setKeys(String keys)
		 *@author Cian
		 *@param String keys
		 *@return void
		 *@desc - Sets the keys that will be used for the sendKeysCommand
		*/
	   public void setKeys(String keys) {
		   filterChain.setKeys(keys);
	   }
	   
	   
	   /**
		 *@name setFilter(Filter)
		 *@author Cian
		 *@param Filter
		 *@return void
		 *@desc - Adds a filter to the chain
		*/
	   public void setFilter(Filter filter){
	      filterChain.addFilter(filter);
	   }

	   
	   /**
		 *@name filterRequest(String request)
		 *@author Cian
		 *@param String request
		 *@return void
		 *@desc - Executes the request
		*/
	   public void filterRequest(String request){
	      filterChain.execute(request);
	   }
}
