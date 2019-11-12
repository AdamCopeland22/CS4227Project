package seleniumWrapper;

import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebDriver.TargetLocator;

//Composite Pattern
public class BrowserManager implements BrowserInterface{
	private List<Browser> browserList;
	
	public BrowserManager() {
		browserList = new ArrayList<Browser>();
	}
	
	/**
	 * @author Cian
	 * @Desc - Add a browser to the list
	 * @param Browser b 
	 */
	public void addBrowser(Browser b) {
		browserList.add(b);
	}
	

	/**
	 * @author Cian
	 * @Desc - Returns browser at specified index
	 * @param Int i 
	 */
	public Browser getBrowser(int i) {
		return browserList.get(i);
	}
	
	/**
	 * @author Cian
	 * @Desc -Remove a browser from list
	 * @param Browser b 
	 */
	public void removeList(Browser b) {
		browserList.remove(b);
	}
	
	/**
	 * @author Cian
	 * @Desc - return size of list
	 */
	public int getListSize() {
		return browserList.size();
	}
	
	/**
	 * @author Cian
	 * @Desc - Close all browsers in list
	 */
	public void close() {
	  for(int i=0;i<browserList.size();i++) {
		browserList.get(i).getDriver().close();
	  }
		
	}
	
	/**
	 * @author Cian
	 * @Desc - Starts tests
	 */
	public void startTest() {
	  for(int i=0;i<browserList.size();i++) {
		browserList.get(i).startTest();
	  }
		
	}
	
	/**
	 * @author Cian
	 * @Desc - Error handler
	 */
	public void errorHandler(Exception e) {
	  for(int i=0;i<browserList.size();i++) {
		browserList.get(i).errorHandler(e);
	  }
		
	}
	
	/**
	 * @author Cian
	 * @Desc - Starts tests
	 */
	public void passedTest() {
	  for(int i=0;i<browserList.size();i++) {
		browserList.get(i).passedTest();
	  }
		
	}
	
	/**
	 * @author Cian
	 * @Desc - Returns a list of elements that match the criteria from ALL browsers in list
	 * @param By arg0
	 */
	public List<WebElement> findElement(By arg0) {
		List<WebElement> list = new ArrayList<WebElement>();
		 for(int i=0;i<browserList.size();i++) {
				if(browserList.get(i).findElement(arg0)!=null) {
					list.add(browserList.get(i).findElement(arg0));
				}
		}
		return list;
	}

	/**
	 * @author Cian
	 * @Desc - Returns a list of lists of elements that match the criteria from ALL browsers in list
	 * @param By arg0
	 */
	public List<List<WebElement>> findElements(By arg0) {
		List<List<WebElement>> list = new ArrayList<List<WebElement>>();
		 for(int i=0;i<browserList.size();i++) {
			 list.add(browserList.get(i).findElements(arg0));
		 }
		 return list;
	}

	/**
	 * @author Cian
	 * @Desc - Goes to specified URL in all browsers in list
	 * @param String arg0
	 */
	public void get(String arg0) {
		 for(int i=0;i<browserList.size();i++) {
			 browserList.get(i).get(arg0);
		 }
		
	}

	/**
	 * @author Cian
	 * @Desc - Returns a list of Strings of URLs that all browsers are in
	 */
	public List<String> getCurrentUrl() {
		List<String> list = new ArrayList<String>();
		 for(int i=0;i<browserList.size();i++) {
			 list.add(browserList.get(i).getCurrentUrl());
		 }
		return list;
	}

	
	/**
	 * @author Cian
	 * @Desc - Returns a list of Strings of Page sources that all browsers are in
	 */
	public List<String> getPageSource() {
		List<String> list = new ArrayList<String>();
		 for(int i=0;i<browserList.size();i++) {
			 list.add(browserList.get(i).getPageSource());
		 }
		return list;
	}

	/**
	 * @author Cian
	 * @Desc - Returns a list of Strings of Titles that all browsers are on
	 */
	public List<String> getTitle() {
		List<String> list = new ArrayList<String>();
		 for(int i=0;i<browserList.size();i++) {
			 list.add(browserList.get(i).getTitle());
		 }
		return list;
	}

	/**
	 * @author Cian
	 * @Desc - Returns a list of Strings of window handles
	 */
	public List<String> getWindowHandle() {
		List<String> list = new ArrayList<String>();
		 for(int i=0;i<browserList.size();i++) {
			 list.add(browserList.get(i).getWindowHandle());
		 }
		return list;
	}



	/**
	 * @author Cian
	 * @Desc - quit ALL browsers
	 */
	public void quit() {
		for(int i=0;i<browserList.size();i++) {
			 browserList.get(i).quit();
		 }
		
	}

	/**
	 * @author Cian
	 * @Desc - Returns a list of TargetLocators from all browsers
	 */
	public List<TargetLocator> switchTo() {
		List<TargetLocator> list = new ArrayList<TargetLocator>();
		
		for(int i=0;i<browserList.size();i++) {
			 list.add(browserList.get(i).switchTo());
		 }
		
		return list;
		
	}

}
