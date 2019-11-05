package seleniumWrapper.WebElement;

import seleniumWrapper.Browser;

public class LogFilter implements Filter{

	public LogFilter() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean execute(ElementHandler e, Browser b,String request) {
		
		try {
			//b.setLog();   --Uncomment this line to see interceptor aborting steps
			b.addAction(request+"On Element:"+e);
			System.out.println(request+"On Element:"+e);
			return true;
		}catch(Exception ex) {
			return false;
		}
	}
	
	

}
