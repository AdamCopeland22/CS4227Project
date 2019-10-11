package seleniumWrapper;
import org.openqa.selenium.WebElement;

import static org.junit.Assert.fail;

import java.util.List;


public class ClickCommand implements CommandInterface {
    private final ElementHandler elementHandler;

    public ClickCommand(ElementHandler elementHandler) {
        this.elementHandler = elementHandler;
    }

    public void execute() {
    	elementHandler.click();
    }
}
