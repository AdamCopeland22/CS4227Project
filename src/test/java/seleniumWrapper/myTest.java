package seleniumWrapper;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

public class myTest {

	private static String Base_Url = "https://www.facebook.com";
    private WebDriver driver;
    

    @Before
    public void setUp() 
    {
    	System.setProperty("webdriver.chrome.driver", "C:\\Users\\user\\eclipse-workspace\\seleniumWrapper\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get(Base_Url);
    }

    @After
    public void after()
    {
        driver.quit();
    }

    @Test
    public void testCasePassed()
    {
        System.out.println("PLz");
    }

}
	

