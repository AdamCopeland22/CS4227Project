package seleniumWrapper.Page;

public abstract class PageFactory {
	
	public enum PageType {

	    LOGINPAGE,

	    GOOGLESIGNUPPAGE,
	    
	    SEARCHPAGE

	}
	
	public static Page getPage(PageType name) {
		Page page = null;
		switch(name) 
		{
			case LOGINPAGE: page = new LoginPage("//*[@id=\"email\"]", "//*[@id=\"pass\"]", "//*[@id=\"loginbutton\"]"); break;
			case GOOGLESIGNUPPAGE: page = new GoogleSignUpPage("//*[@id=\"firstName\"]", "//*[@id=\"lastName\"]", "//*[@id=\"username\"]", "//*[@id=\"passwd\"]/div[1]/div/div[1]/input", "//*[@id=\"confirm-passwd\"]/div[1]/div/div[1]/input", "//*[@id=\"accountDetailsNext\"]/span/span"); break;
			case SEARCHPAGE: page = new SearchPage("//*[@id=\"tsf\"]/div[2]/div[1]/div[1]/div/div[2]/input", "//*[@id=\"tsf\"]/div[2]/div[1]/div[3]/center/input[1]"); break;
		} 
		return page;	
	}
}
