package seleniumWrapper.Tests;
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
import seleniumWrapper.WebElement.ElementHandler;
import seleniumWrapper.WebElement.Handler;

public class myTest {

	private static String Base_Url = "https://www.facebook.com";
    private Browser myBrowser,browser2;
    private BrowserManager browserList;

    @Before
    public void setUp()
    {
    	try {
    		browserList= new BrowserManager();
        myBrowser = new Browser(ConstantVariables.chrome);
    	
        browser2 = new Browser(ConstantVariables.chrome);
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
      	ElementHandler elementHandler = new ElementHandler(email.get(i));
      	CommandInterface clickCommand = new ClickCommand(elementHandler);
      	CommandInterface sendKeysCommand = new SendKeysCommand(elementHandler, "jimbob@gmail.com");
      	CommandInterface submitCommand = new SubmitCommand(elementHandler);
        	
        	Handler handler = new Handler();
        	handler.register("click", clickCommand);
        	handler.register("sendKeys", sendKeysCommand);
        	handler.register("submit", submitCommand);

        	handler.execute("click");
        	handler.execute("sendKeys");
        	handler.execute("submit");
        }
        

    	}catch(Exception e) {
    		System.out.println(e);
    	}
    }

}
	

