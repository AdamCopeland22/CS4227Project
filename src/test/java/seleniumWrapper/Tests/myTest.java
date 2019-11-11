package seleniumWrapper.Tests;
import java.io.IOException;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;

import seleniumWrapper.*;
import seleniumWrapper.Commands.ClickCommand;
import seleniumWrapper.Commands.CommandInterface;
import seleniumWrapper.Commands.SendKeysCommand;
import seleniumWrapper.Commands.SubmitCommand;
import seleniumWrapper.WebElement.Client;
import seleniumWrapper.WebElement.ElementHandler;
import seleniumWrapper.WebElement.FilterManager;
import seleniumWrapper.WebElement.Handler;
import seleniumWrapper.WebElement.LogFilter;
import seleniumWrapper.WebElement.TextBox;
import seleniumWrapper.WebElement.VisibleFilter;

public class myTest {

	private static String Base_Url = "https://www.google.com";
    private Browser myBrowser,browser2;
    private BrowserManager browserList;

    @Before
    public void setUp()
    {
    	try {
    		browserList= new BrowserManager();
        myBrowser = new Browser(ConstantVariables.chrome);
        browser2 = new Browser(ConstantVariables.chrome);
        browserList.addBrowser(browser2);
        browserList.addBrowser(myBrowser);
    	
     
    	
     
        
    	}catch(Exception e) {
    		System.out.println(e);
    	}
        
        
        
    }

    @After
    public void after() throws IOException
    {
       	myBrowser.writeReport();
    	myBrowser.displayTestStats();
    	browserList.quit();
 
    }

    @Test
    public void testCasePassed ()
    {
    	//Test to open two browsers and execute actions on them sim
    	
    	try {
    		browserList.startTest();
    		browserList.get(Base_Url);
    		Thread.sleep(5000);
    	
    	//Get all elements matching the ID
    	List<WebElement> email = browserList.findElement(By.name("q"));
        
    	//For each element, execute some actions using Interceptor
    	for(int i=0;i<email.size();i++) {
    		WebElement elementHandler = email.get(i);
          
        	
        	FilterManager filterManager = new FilterManager(elementHandler,browserList.getBrowser(i));
            filterManager.setFilter(new VisibleFilter());
            filterManager.setFilter(new LogFilter());

            Client client = new Client();
            client.setFilterManager(filterManager);
            client.sendRequest("click");
            
            filterManager.setKeys("Example@gmail.com");
        	client.sendRequest("sendKeys");
        	client.sendRequest("submit");
    	}
        
        
    	browserList.passedTest();
    	}catch(Exception e) {
    		e.printStackTrace();
    		browserList.errorHandler();
    	}
    }
    
    @Test
    public void cuteDogPics() {
    	//An essential test to search for cute dog pics
      try {
    	  myBrowser.startTest();
    	myBrowser.get(Base_Url);
		Thread.sleep(5000);
		
		WebElement search = myBrowser.findElement(By.name("q"));
          
        	
        	FilterManager filterManager = new FilterManager(search,myBrowser);
            filterManager.setFilter(new VisibleFilter());
            filterManager.setFilter(new LogFilter());

            Client client = new Client();
            client.setFilterManager(filterManager);
            client.sendRequest("click");
            
            filterManager.setKeys("Cute dog pics");
        	client.sendRequest("sendKeys");
        	client.sendRequest("submit");
    	
        
	
		myBrowser.passedTest();
      }catch(Exception e) {
    	  myBrowser.errorHandler();
    	  
      }
    	
    	
    }

}
	

