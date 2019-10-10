package seleniumWrapper;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;

import static org.junit.Assert.fail;

public class webElementHandlers {
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
