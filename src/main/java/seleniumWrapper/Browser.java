package seleniumWrapper;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.Navigation;
import org.openqa.selenium.WebDriver.Options;
import org.openqa.selenium.WebDriver.TargetLocator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Browser {
	private WebDriver driver;
	
	public Browser(String browserType) {
	
		 if(browserType.equals(constantVariables.chrome)) {
	            String chromeDriverPath = System.getProperty("user.dir") + "\\src\\test\\java\\drivers\\chromedriver.exe";
	            System.setProperty("webdriver.chrome.driver", chromeDriverPath);
	            driver = new ChromeDriver();
	        }
	        else if(browserType.equals(constantVariables.firefox)) {
	            driver = new FirefoxDriver();
	        }
	}

	public void close() {
		driver.close();
		
	}
	
	public WebElement findElement(By arg0) {
		return driver.findElement(arg0);
	}

	public List<WebElement> findElements(By arg0) {
		return driver.findElements(arg0);
	}

	public void get(String arg0) {
		driver.get(arg0);
		
	}

	public String getCurrentUrl() {
		return driver.getCurrentUrl();
	}

	public String getPageSource() {
		return driver.getPageSource();
	}

	public String getTitle() {
		return driver.getTitle();
	}

	public String getWindowHandle() {
		return driver.getWindowHandle();
	}

	public Set<String> getWindowHandles() {
		return driver.getWindowHandles();
	}

	public Options manage() {
		return driver.manage();
	}

	public Navigation navigate() {
		return driver.navigate();
	}

	public void quit() {
		driver.quit();
		
	}
	
	public WebDriver getDriver() {
		return driver;
	}

	public TargetLocator switchTo() {
		return driver.switchTo();
	}

}
