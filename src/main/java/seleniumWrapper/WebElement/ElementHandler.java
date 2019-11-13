package seleniumWrapper.WebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.Rectangle;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;

import static org.junit.Assert.fail;

import java.util.List;

public class ElementHandler implements WebElement{
	private WebElement element;
	
	public ElementHandler(WebElement element) {
		this.element = element;
	}

	/**
	 *@name getScreenshotAs()
	 *@author Alex
	 *@param OutputType<X> target
	 *@return <X> X
	 *@desc - Capture screenshot and store it in target location (Default selenium method)
	*/
	@Override
	public <X> X getScreenshotAs(OutputType<X> target) throws WebDriverException {
		return element.getScreenshotAs(target);
	}

	/**
	 *@name click()
	 *@author Alex
	 *@param None
	 *@return void
	 *@desc - Clicks the element (Default selenium method)
	*/
	@Override
	public void click() {
		element.click();
	}

	/**
	 *@name submit()
	 *@author Alex
	 *@param None
	 *@return void
	 *@desc - Submits the form if the element is a form/within a form (Default selenium method)
	*/
	@Override
	public void submit() {
		element.submit();
	}

	/**
	 *@name sendKeys()
	 *@author Alex
	 *@param CharSequence... keysToSend
	 *@return void
	 *@desc - Sets the value of the element	(Default selenium method)
	*/
	@Override
	public void sendKeys(CharSequence... keysToSend) {
		element.sendKeys(keysToSend);
	}

	/**
	 *@name clear()
	 *@author Alex
	 *@param None
	 *@return void
	 *@desc - Clears the element (Default selenium method)
	*/
	@Override
	public void clear() {
		element.clear();
	}

	/**
	 *@name getTagName()
	 *@author Alex
	 *@param None
	 *@return String
	 *@desc - Gets the tag name of the element (Default selenium method)
	*/
	@Override
	public String getTagName() {
		return element.getTagName();
	}

	/**
	 *@name getAttribute()
	 *@author Alex
	 *@param String name
	 *@return String
	 *@desc - Gets an attribute of the element (Default selenium method)
	*/
	@Override
	public String getAttribute(String name) {
		return element.getAttribute(name);
	}

	/**
	 *@name isSelected()
	 *@author Alex
	 *@param None
	 *@return boolean
	 *@desc - Checks if element is selected	(Default selenium method)
	*/
	@Override
	public boolean isSelected() {
		return element.isSelected();
	}

	/**
	 *@name isEnabled()
	 *@author Alex
	 *@param None
	 *@return void
	 *@desc - Checks if element is enabled (Default selenium method)
	*/
	@Override
	public boolean isEnabled() {
		return element.isEnabled();
	}

	@Override
	/**
	 *@name getText()
	 *@author Alex
	 *@param None
	 *@return String
	 *@desc - Returns the text of the element (Default selenium method)
	*/
	public String getText() {
		return element.getText();
	}

	/**
	 *@name findElements()
	 *@author Alex
	 *@param By by
	 *@return List<WebElement>
	 *@desc - Find all elements using given mechanism in current context (Default selenium method)
	*/
	@Override
	public List<WebElement> findElements(By by) {
		return element.findElements(by);
	}

	/**
	 *@name findElements()
	 *@author Alex
	 *@param By by
	 *@return WebElement
	 *@desc - Find the first using given mechanism in current context (Default selenium method)
	*/
	@Override
	public WebElement findElement(By by) {
		return element.findElement(by);
	}

	/**
	 *@name isDisplayed()
	 *@author Alex
	 *@param None
	 *@return void
	 *@desc - Checks if the element is displayed (Default selenium method)
	*/
	@Override
	public boolean isDisplayed() {
		return element.isDisplayed();
	}

	/**
	 *@name getLocation()
	 *@author Alex
	 *@param None
	 *@return Point
	 *@desc - Returns the location of the element (Default selenium method)
	*/
	@Override
	public Point getLocation() {
		return element.getLocation();
	}

	/**
	 *@name getSize()
	 *@author Alex
	 *@param None
	 *@return Dimension
	 *@desc - Returns the size of the element (Default selenium method)
	*/
	@Override
	public Dimension getSize() {
		return element.getSize();
	}

	/**
	 *@name getRect()
	 *@author Alex
	 *@param None
	 *@return Rectangle
	 *@desc - 
	*/
	@Override
	public Rectangle getRect() {
		return element.getRect();
	}

	/**
	 *@name getCssValue()
	 *@author Alex
	 *@param String propertyName
	 *@return String
	 *@desc - Returns value of given CSS property (Default selenium method)
	*/
	@Override
	public String getCssValue(String propertyName) {
		return element.getCssValue(propertyName);
	}
}