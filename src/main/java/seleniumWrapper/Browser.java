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
		 if(browserType.equals(ConstantVariables.chrome)) {
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
	        else if(browserType.equals(ConstantVariables.firefox)) {
	            driver = new FirefoxDriver();
	        }
		 log = new LogController(new Log(),new LogBarChart());
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
	
	public void addAction(String action) {
		log.addAction(action);
	}
	
	public void writeReport() throws IOException {
		log.getReport();
	}
	
	public void startTest() {
		log.startTest();
	}
	
	public void errorHandler() {
		log.errorHandler();
	}
	
	public void passedTest() {
		log.passedTest();
	}
	
	public void displayTestStats() {
		log.updateView();
	}

}
