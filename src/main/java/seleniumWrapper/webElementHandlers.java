package seleniumWrapper;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;

import static org.junit.Assert.fail;

public class webElementHandlers {
	
	private List<WebElement> elements;
	
	public int size() {
		return elements.size();
	}
	
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

	class ClickCommand implements Command {
	    private final ElementHandler elementHandler;

	    public ClickCommand(ElementHandler elementHandler) {
	        this.elementHandler = elementHandler;
	    }

	    @Override // Command
	    public void execute() {
	    	elementHandler.click();
	    }
	}
	
	class SendKeysCommand implements Command {
	    private final ElementHandler elementHandler;
	    private String keys;

	    public SendKeysCommand(ElementHandler elementHandler, String keys) {
	        this.elementHandler = elementHandler;
	        this.keys = keys;
	    }

	    @Override // Command
	    public void execute() {
	    	elementHandler.sendKeys(keys);
	    }
	}

	class SubmitCommand implements Command {
	    private final ElementHandler elementHandler;

	    public SubmitCommand(ElementHandler elementHandler) {
	        this.elementHandler = elementHandler;
	    }

	    @Override // Command
	    public void execute() {
	    	elementHandler.submit();
	    }
	}
	
    public static void waitForElementToDissapear(WebElement element, int secondsToWaitFor){
        for(int i = 0; i < secondsToWaitFor; i++) {
            try {
                element.isDisplayed();
                Thread.sleep(1000);
            } catch (StaleElementReferenceException exc) {
                return;
            } catch (NoSuchElementException e) {
                return;
            } catch (InterruptedException e) {
                System.out.println("Thread Failure");
            }
        }
        fail("WebElement did not disappear after " + secondsToWaitFor + " seconds");
    }
}
