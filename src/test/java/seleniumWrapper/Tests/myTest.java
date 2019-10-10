package seleniumWrapper.Tests;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;

import seleniumWrapper.Browser;
import seleniumWrapper.BrowserManager;
import seleniumWrapper.constantVariables;
import seleniumWrapper.webElementHandlers;

public class myTest {

	private static String Base_Url = "https://www.facebook.com";
    private Browser myBrowser,browser2;
    private BrowserManager browserList;

    @Before
    public void setUp()
    {
    	try {
    		browserList= new BrowserManager();
        myBrowser = new Browser(constantVariables.chrome);
    	
        browser2 = new Browser(constantVariables.chrome);
        browserList.addBrowser(myBrowser);
    	
        browserList.addBrowser(browser2);
        
    	}catch(Exception e) {
    		System.out.println(e);
    	}
        
        
        
    }

    @After
    public void after()
    {
    	browserList.quit();
    }

    @Test
    public void testCasePassed ()
    {
    	try {
    		
    	browserList.get(Base_Url);
    	Thread.sleep(1000);
    	
    	List<WebElement> email = browserList.findElement(By.id("email"));
        for(int i=0;i<email.size();i++) {
        	email.get(i).click();
        	email.get(i).sendKeys("jimbob@gmail.com");
            email.get(i).submit();
        	
        }
        

    	}catch(Exception e) {
    		System.out.println(e);
    	}
    }

}
	

