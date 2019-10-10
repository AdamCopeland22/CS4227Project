package seleniumWrapper.Tests;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import seleniumWrapper.myDriver;
import seleniumWrapper.webElementHandlers;

public class myTest {

	private static String Base_Url = "https://www.facebook.com";
    private WebDriver driver;

    @Before
    public void setUp()
    {
        driver = new myDriver().getDriver();
        driver.get(Base_Url);
        WebElement email = driver.findElement(By.id("email"));
        email.click();
        email.sendKeys("jimbob@gmail.com");
        email.submit();
        webElementHandlers.waitForElementToDissapear(email, 3);
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
	

