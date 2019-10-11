package seleniumWrapper;
import org.openqa.selenium.WebElement;

import static org.junit.Assert.fail;

import java.util.List;

public class SubmitCommand implements CommandInterface {
    private final ElementHandler elementHandler;

    public SubmitCommand(ElementHandler elementHandler) {
        this.elementHandler = elementHandler;
    }

    
    public void execute() {
    	elementHandler.submit();
    }
}
