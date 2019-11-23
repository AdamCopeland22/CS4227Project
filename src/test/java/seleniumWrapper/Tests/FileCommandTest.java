package seleniumWrapper.Tests;
import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;

import org.apache.http.protocol.HTTP;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;

import seleniumWrapper.*;
import seleniumWrapper.Commands.ClickCommand;
import seleniumWrapper.Commands.CommandInterface;
import seleniumWrapper.Commands.HttpsCheckCommand;
import seleniumWrapper.Commands.UICheckCommand;
import seleniumWrapper.Commands.SendKeysCommand;
import seleniumWrapper.Commands.SubmitCommand;
import seleniumWrapper.SecureLogin.SecureLogin;
import seleniumWrapper.WebElement.Client;
import seleniumWrapper.WebElement.ElementHandler;
import seleniumWrapper.WebElement.FilterManager;
import seleniumWrapper.WebElement.LogFilter;
import seleniumWrapper.WebElement.VisibleFilter;
import seleniumWrapper.fileChecker.FileFilterManager;

public class FileCommandTest {

	private static String Base_Url = "https://www.google.com";
    private BrowserInterface myBrowser;
    private BrowserManager browserList;
    private static String TRANSACTION = "Transaction";
    private static String HTTP = "Http";
    
    //This is a check to display the Json file validation that could be used or testing transactions, data sharing, message sending etc.
    @Test
    public void fileChecks() {
    	File file = new File( System.getProperty("user.dir") + "\\src\\main\\java\\seleniumWrapper\\fileChecker\\Files\\transaction.json");
    	FileFilterManager fileManager = FileFilterManager.ManagerCreation(TRANSACTION, file);
    	fileManager.FilterRequest();
    }
    
    //This test is to show how you can use commands to run executable pieces of code for testing browser interaction.
    @Test
    public void inputValidation() {
    	myBrowser = new Browser(Config.chrome);
    	myBrowser.get("https://www.google.com/");
    	WebElement searchBar = myBrowser.findElement(By.name("q")).get(0);
    	CommandInterface UIValidation = new UICheckCommand(searchBar, "Armadillo", "q", "Armadillo", 3, myBrowser);
    	UIValidation.execute();
    	myBrowser.close();
    	System.out.println("UI Elements Validated");
    }
    
    //This test is to show how using an intercepter on HTTP Post/Get requests can be a proficient way to test the capabilities of a system.
    @Test
    public void httpsRequest() {
    	File file = new File( System.getProperty("user.dir") + "\\src\\main\\java\\seleniumWrapper\\fileChecker\\Files\\HttpResponseValidator.txt");
    	FileFilterManager fileManager = FileFilterManager.ManagerCreation(HTTP, file);
    	fileManager.FilterRequest();
    }
}
	

