package seleniumWrapper.WebElement;

import seleniumWrapper.Browser;

public class FilterManager {

	FilterChain filterChain;
	

	   public FilterManager(ElementHandler target,Browser browser){
	      filterChain = new FilterChain(browser);
	      filterChain.setTarget(target);
	   }
	   
	   public void setKeys(String keys) {
		   filterChain.setKeys(keys);
	   }
	   public void setFilter(Filter filter){
	      filterChain.addFilter(filter);
	   }

	   public void filterRequest(String request){
	      filterChain.execute(request);
	   }
}
