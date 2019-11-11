package seleniumWrapper.WebElement;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.Rectangle;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import seleniumWrapper.Browser;
import seleniumWrapper.Commands.ClickCommand;

public class TextBox implements WebElement{

	private Browser browse;
	private WebDriver driver;
	private String xPath;
	private ClickCommand click = new ClickCommand(this);
	
	public TextBox (String xPath) {
		this.xPath = xPath;
	}
	
	@Override
	public <X> X getScreenshotAs(OutputType<X> target) throws WebDriverException {
		// TODO Auto-generated method stub
		browse.addAction("getScreenshotAs() invalid for TextBox");
		browse.errorHandler();
		return null;
	}

	@Override
	public void click() {
		click.execute();
		browse.addAction("click() for TextBox " + xPath);
	}

	@Override
	public void submit() {
		browse.addAction("Form submitted");
	}

	@Override
	public void sendKeys(CharSequence... keysToSend) {
		driver.findElement(By.xpath(xPath)).sendKeys(keysToSend);
		browse.addAction("sendKeys() for TextBox " + xPath + ". Keys Sent:" + keysToSend);
	}

	@Override
	public void clear() {
		driver.findElement(By.xpath(xPath)).clear();		
		browse.addAction("clear() for TextBox " + xPath + ".");
	}

	@Override
	public String getTagName() {
		String out = driver.findElement(By.xpath(xPath)).getTagName();
		browse.addAction("getTagName() for TextBox " + xPath);
		return out;
	}

	@Override
	public String getAttribute(String name) {
		String out = driver.findElement(By.xpath(xPath)).getAttribute(name);
		browse.addAction("getAttribute() " + name + " for TextBox " + xPath + ". Result: " + out);
		return out;
	}

	@Override
	public boolean isSelected() {
		Boolean out = driver.findElement(By.xpath(xPath)).isSelected();
		browse.addAction("isSelected() for TextBox " + xPath + ". Result: " + out);
		return out;
	}

	@Override
	public boolean isEnabled() {
		Boolean out = driver.findElement(By.xpath(xPath)).isEnabled();
		browse.addAction("isEnabled() for TextBox " + xPath + ". Result: " + out);
		return out;
	}

	@Override
	public String getText() {
		String out = driver.findElement(By.xpath(xPath)).getText();
		browse.addAction("getText() for TextBox " + xPath + ". Result: " + out);
		return out;
	}

	@Override
	public List<WebElement> findElements(By by) {
		browse.addAction("findElements() invalid for TextBox");
		browse.errorHandler();	
		return null;
	}

	@Override
	public WebElement findElement(By by) {
		browse.addAction("findElement() invalid for TextBox");
		browse.errorHandler();	
		return null;
	}

	@Override
	public boolean isDisplayed() {
		Boolean out = driver.findElement(By.xpath(xPath)).isDisplayed();
		browse.addAction("isDisplayed() for TextBox " + xPath + ". Result: " + out);
		return out;
	}

	@Override
	public Point getLocation() {
		Point out = driver.findElement(By.xpath(xPath)).getLocation();
		browse.addAction("getLocation() for TextBox " + xPath + ". Result: " + out);
		return out;
	}

	@Override
	public Dimension getSize() {
		Dimension out = driver.findElement(By.xpath(xPath)).getSize();
		browse.addAction("getSize() for TextBox " + xPath + ". Result: " + out);
		return out;
	}

	@Override
	public Rectangle getRect() {
		Rectangle out = driver.findElement(By.xpath(xPath)).getRect();
		browse.addAction("getRect() for TextBox " + xPath + ". Result: " + out);
		return out;
	}

	@Override
	public String getCssValue(String propertyName) {
		String out = driver.findElement(By.xpath(xPath)).getCssValue(propertyName);
		browse.addAction("getCssValue(" + propertyName + ") for TextBox " + xPath + ". Result: " + out);
		return out;
	}
	
	public Browser getBrowser()	{
		return browse;
	}
	
	public void setBrowser(Browser browse)	{
		this.browse = browse;
	}
	
	public WebDriver getDriver()	{
		return driver;
	}
	
	public void setDriver(WebDriver driver)	{
		this.driver = driver;
	}
	
	public String getXPath()	{
		return xPath;
	}
	
	public void setXPath(String xPath)	{
		this.xPath = xPath;
	}
}
