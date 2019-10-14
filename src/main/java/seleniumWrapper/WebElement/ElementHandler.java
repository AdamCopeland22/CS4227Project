package seleniumWrapper.WebElement;
import org.openqa.selenium.WebElement;

import static org.junit.Assert.fail;

import java.util.List;

public class ElementHandler {
	private WebElement element;
	
	public ElementHandler(WebElement element) {
		this.element = element;
	}
	
    public void click() {
        element.click();
    }

    public void submit() {
        element.submit();
    }
    
    public void sendKeys(String keys) {
        element.sendKeys(keys);
    }
}
