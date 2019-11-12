package seleniumWrapper;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
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

import seleniumWrapper.Logger.Log;
import seleniumWrapper.Logger.LogBarChart;
import seleniumWrapper.Logger.LogController;

public class Browser implements BrowserInterface{
	private WebDriver driver;
	private LogController log;
	
	public Browser(String browserType) {
		String chromeDriverPath;
		 if(browserType.equals(Config.chrome)) {
			 if(System.getProperty("os.name").toLowerCase().equals("linux"))
			 {
				 	chromeDriverPath = System.getProperty("user.dir") + "//src//test//java//drivers//chromedriver";
				 	System.setProperty("webdriver.chrome.driver", chromeDriverPath);
		            driver = new ChromeDriver(); 
			 }
			 else
			 {
				 chromeDriverPath = System.getProperty("user.dir") + "\\src\\test\\java\\drivers\\chromedriver.exe";
				 System.setProperty("webdriver.chrome.driver", chromeDriverPath);
		         driver = new ChromeDriver();
			 }
		 }
	        else if(browserType.equals(Config.firefox)) {
	            driver = new FirefoxDriver();
	        }
		 log = new LogController(new Log(),new LogBarChart());
	}
	
	

	/**
	 *@name close()
	 *@author Cian
	 *@param None 
	 *@return void
	 *@desc - Closes the browser	
	*/
	public void close() {
		driver.close();
	}
	
	
	
	/**
	 *@name setLog()
	 *@author Cian
	 *@param None 
	 *@return void
	 *@desc - **TEST METHOD - To demonstrate what happens when an interceptor step fails	
	*/
	public void setLog() {
		log = null;
	}
	
	/**
	 *@name findElement(By arg0)
	 *@author Cian
	 *@param By arg0 
	 *@return void
	 *@desc - Returns the element matching the input (Default selenium method)	
	*/
	public WebElement findElement(By arg0) {
		return driver.findElement(arg0);
	}

	/**
	 *@name findElements(By arg0)
	 *@author Cian
	 *@param By arg0 
	 *@return void
	 *@desc - Returns the list of elements matching the input (Default selenium method)	
	*/
	public List<WebElement> findElements(By arg0) {
		return driver.findElements(arg0);
	}

	/**
	 *@name get(String arg0)
	 *@author Cian
	 *@param String arg0 
	 *@return void
	 *@desc - Goes to the specified URL (Default selenium method)	
	*/
	public void get(String arg0) {
		driver.get(arg0);
		
	}

	/**
	 *@name getCurrentUrl()
	 *@author Cian
	 *@param None
	 *@return void
	 *@desc - Gets current URL (Default selenium method)	
	*/
	public String getCurrentUrl() {
		return driver.getCurrentUrl();
	}

	/**
	 *@name getPageSource()
	 *@author Cian
	 *@param None 
	 *@return String
	 *@desc - Gets the page source (Default selenium method)	
	*/
	public String getPageSource() {
		return driver.getPageSource();
	}

	
	/**
	 *@name getTitle()
	 *@author Cian
	 *@param None
	 *@return String
	 *@desc - Gets page title (Default selenium method)	
	*/
	public String getTitle() {
		return driver.getTitle();
	}

	
	/**
	 *@name getWindowHandle()
	 *@author Cian
	 *@param None 
	 *@return String
	 *@desc - Gets the window handle (Default selenium method)	
	*/
	public String getWindowHandle() {
		return driver.getWindowHandle();
	}

	/**
	 *@name getWindowHandles()
	 *@author Cian
	 *@param None
	 *@return Set<String>
	 *@desc -Returns a set of window handles (Default selenium method)	
	*/
	public Set<String> getWindowHandles() {
		return driver.getWindowHandles();
	}

	/**
	 *@name manage()
	 *@author Cian
	 *@param None 
	 *@return Options
	 *@desc - Returns the driver options (Default selenium method)	
	*/
	public Options manage() {
		return driver.manage();
	}

	/**
	 *@name navigate()
	 *@author Cian
	 *@param None
	 *@return Navigation
	 *@desc - Returns browser navigation (Default selenium method)	
	*/
	public Navigation navigate() {
		return driver.navigate();
	}

	
	/**
	 *@name quit()
	 *@author Cian
	 *@param None 
	 *@return void
	 *@desc - Closes the browser (Default selenium method)	
	*/
	public void quit() {
		driver.quit();
		
	}
	
	/**
	 *@name getDriver()
	 *@author Cian
	 *@param None
	 *@return WebDriver
	 *@desc - Returns the assosciated driver (Default selenium method)	
	*/
	public WebDriver getDriver() {
		return driver;
	}

	/**
	 *@name switchTo()
	 *@author Cian
	 *@param None
	 *@return TargetLocator
	 *@desc - Returns a TargetLocator for the browser, used for IFramed mostly (Default selenium method)	
	*/
	public TargetLocator switchTo() {
		return driver.switchTo();
	}
	
	/**
	 *@name addAction(String action)
	 *@author Cian
	 *@param String action 
	 *@return void
	 *@desc - Adds an action to the log of this browser
	*/
	public void addAction(String action) {
		log.addAction(action);
	}
	
	/**
	 *@name writeReport()
	 *@author Cian
	 *@param None
	 *@return void
	 *@desc - Writes the log report to a txt file	
	*/
	public void writeReport() throws IOException {
		log.getReport();
	}
	
	/**
	 *@name startTest()
	 *@author Cian
	 *@param None
	 *@return void
	 *@desc - Logs the start of a test	
	*/
	public void startTest() {
		log.startTest();
	}
	
	/**
	 *@name errorHandler()
	 *@author Cian
	 *@param None
	 *@return void
	 *@desc - Logs an error in a test case	
	*/
	public void errorHandler(Exception e) {
		log.errorHandler(e);
	}
	/**
	 *@name passedTest()
	 *@author Cian
	 *@param None
	 *@return void
	 *@desc - Logs a passed test case	
	*/
	public void passedTest() {
		log.passedTest();
	}
	
	/**
	 *@name displayTestStatistics()
	 *@author Cian
	 *@param None
	 *@return void
	 *@desc - Displays results of test suite	
	*/
	public void displayTestStats() {
		log.updateView();
	}

}
