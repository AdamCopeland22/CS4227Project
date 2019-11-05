package seleniumWrapper.WebElement;

import seleniumWrapper.Browser;

public class VisibleFilter implements Filter {

	public VisibleFilter() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean execute(ElementHandler e,Browser b,String request) {
		System.out.println("Element is visible:"+e.isVisible());
		return e.isVisible();
	}

}
