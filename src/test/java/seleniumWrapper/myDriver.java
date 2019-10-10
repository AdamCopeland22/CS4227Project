package seleniumWrapper;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class myDriver {
    private WebDriver driver;

    public myDriver() {
        if(constantVariables.driverType.equals("Chrome")) {
            String chromeDriverPath = System.getProperty("user.dir") + "\\src\\test\\java\\drivers\\chromedriver.exe";
            System.setProperty("webdriver.chrome.driver", chromeDriverPath);
            driver = new ChromeDriver();
        }
        else if(constantVariables.driverType.equals("FireFox")) {
            driver = new FirefoxDriver();
        }
    }

    public WebDriver getDriver() {
        return driver;
    }
}
