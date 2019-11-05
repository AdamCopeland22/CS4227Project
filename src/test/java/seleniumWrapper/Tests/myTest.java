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
    	
    	
    	try {
    		
    		browserList.get(Base_Url);
    	Thread.sleep(5000);
    	
    	List<WebElement> email = browserList.findElement(By.name("q"));
        
    	for(int i=0;i<email.size();i++) {
      	ElementHandler elementHandler = new ElementHandler(email.get(i));
          
        	
        	FilterManager filterManager = new FilterManager(elementHandler,myBrowser);
            filterManager.setFilter(new VisibleFilter());
            filterManager.setFilter(new LogFilter());

            Client client = new Client();
            client.setFilterManager(filterManager);
            client.sendRequest("click");
            
            filterManager.setKeys("Example@gmail.com");
        	client.sendRequest("sendKeys");
        	client.sendRequest("submit");
    	}
        
        

    	}catch(Exception e) {
    		e.printStackTrace();
    		//myBrowser.errorHandler();
    	}
    }

}
	

