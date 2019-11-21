package seleniumWrapper.Page;

public abstract class PageFactory {
	
	public enum PageType {

	    LOGINPAGE,

	    GOOGLESIGNUPPAGE,
	    
	    SEARCHPAGE,
	    
	    BUTTONONPAGE

	}
	
	/**
	 *@name getPage()
	 *@author Adam
	 *@param Pass the type of page to create
	 *@return page
	 *@desc - factory for creating pages
	*/
	public static Page getPage(PageType name) {
		Page page = null;
		switch(name) 
		{
			case LOGINPAGE: page = new LoginPage("//*[@id=\"email\"]", "//*[@id=\"pass\"]", "//*[@id=\"loginbutton\"]", "https://www.facebook.com/?stype=lo&jlou=Afe3LTKY9wMMPDeuhoMupdZq1rRtykGVVKEK4H3zjxXLczrk1ikN2JlMUHa7ZZxUDmQxYkZERmEqcJL9KReRt-BScx2qwLkWa901rA6QKxbkag&smuh=9211&lh=Ac_4cCfhZ6w2ek2m"); break;
			case GOOGLESIGNUPPAGE: page = new GoogleSignUpPage("//*[@id=\"firstName\"]", "//*[@id=\"lastName\"]", "//*[@id=\"username\"]", "//*[@id=\"passwd\"]/div[1]/div/div[1]/input", "//*[@id=\"confirm-passwd\"]/div[1]/div/div[1]/input", "//*[@id=\"accountDetailsNext\"]/span/span", "https://accounts.google.com/signup/v2/webcreateaccount?flowName=GlifWebSignIn&flowEntry=SignUp"); break;
			case SEARCHPAGE: page = new SearchPage("//*[@id=\"tsf\"]/div[2]/div[1]/div[1]/div/div[2]/input", "//*[@id=\"tsf\"]/div[2]/div[1]/div[3]/center/input[1]", "https://www.google.com"); break;
			case BUTTONONPAGE: page = new ButtonOnPage("//*[@id=\"nav_toggle\"]", "https://www.thegamecollection.net"); break;
		} 
		return page;	
	}
}
