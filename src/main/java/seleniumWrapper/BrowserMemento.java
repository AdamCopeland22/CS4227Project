package seleniumWrapper;

import java.util.List;
import org.openqa.selenium.WebDriver;
import seleniumWrapper.Logger.LogController;

public class BrowserMemento {
	
	private WebDriver driver;
	private LogController log;
	private BrowserState state;
	private List<String> url;
	
	public BrowserMemento(WebDriver driver, LogController log, BrowserState state, List<String> url)	{
		this.driver = driver;
		this.log = log;
		this.state = state;
		this.url = url;
	}
	
	/**
	 * @name getDriver()
	 * @author Alex
	 * @param None
	 * @return WebDriver
	 * @desc - Returns the BrowserMemento's driver
	 */
	public WebDriver getDriver()	{
		return driver;
	}
	
	/**
	 * @name setDriver()
	 * @author Alex
	 * @param WebDriver driver
	 * @return void
	 * @desc - Sets the BrowserMemento's driver
	 */
	public void setDriver(WebDriver driver)	{
		this.driver = driver;
	}
	
	/**
	 * @name getLogController()
	 * @author Alex
	 * @param None
	 * @return LogController
	 * @desc - Returns the BrowserMemento's log controller
	 */
	public LogController getLogController()	{
		return log;
	}
	
	/**
	 * @name setLogController()
	 * @author Alex
	 * @param LogController log
	 * @return void
	 * @desc - Sets the BrowserMemento's log controller
	 */
	public void setLogController(LogController log)	{
		this.log = log;
	}
	
	/**
	 * @name getState()
	 * @author Alex
	 * @param None
	 * @return BrowserState
	 * @desc - Returns the BrowserMemento's state
	 */
	public BrowserState getState()	{
		return state;
	}
	
	/**
	 * @name setState()
	 * @author Alex
	 * @param BrowserState
	 * @return void
	 * @desc - Sets the BrowserMemento's state
	 */
	public void getState(BrowserState state)	{
		this.state = state;
	}
	
	/**
	 * @name getURL()
	 * @author Alex
	 * @param None
	 * @return List<String>
	 * @desc - Returns the BrowserMemento's URL
	 */
	public List<String> getURL()	{
		return url;
	}
	
	/**
	 * @name setURL()
	 * @author Alex
	 * @param List<String>
	 * @return void
	 * @desc - Set the BrowserMemento's URL
	 */
	public void setURL(List<String> url)	{
		this.url = url;
	}
}
