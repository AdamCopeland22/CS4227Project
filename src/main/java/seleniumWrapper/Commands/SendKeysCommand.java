package seleniumWrapper.Commands;
import org.openqa.selenium.WebElement;

import seleniumWrapper.WebElement.ElementHandler;

import static org.junit.Assert.fail;

import java.util.List;

public class SendKeysCommand implements CommandInterface {
    private final ElementHandler elementHandler;
    private String keys;

    public SendKeysCommand(ElementHandler elementHandler, String keys) {
        this.elementHandler = elementHandler;
        this.keys = keys;
    }

    
    public void execute() {
    	elementHandler.sendKeys(keys);
    }
}