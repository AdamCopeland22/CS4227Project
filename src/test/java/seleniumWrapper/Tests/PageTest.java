package seleniumWrapper.Tests;

import org.junit.Test;

import seleniumWrapper.Page.ConcreteUser;
import seleniumWrapper.Page.Page;
import seleniumWrapper.Page.PageFactory;
import seleniumWrapper.Page.PageFactory.PageType;

public class PageTest {
	ConcreteUser user = new ConcreteUser("James", "Kirby", "lol", "lolo"); 
	ConcreteUser user2 = (ConcreteUser) user.clone();
	@Test
    public void GoogleSignUpCheck()
    {
		System.out.print("hello");
    	Page googleSignUp = PageFactory.getPage(PageType.GOOGLESIGNUPPAGE);
    	googleSignUp.setUser(user);
    	System.out.print("hello");
    	googleSignUp.testPage();
    }
	
	@Test
    public void loginPageCheck()
    {
		user2.setFirstName("Adam");
    	Page loginPage = PageFactory.getPage(PageType.LOGINPAGE);
    	loginPage.setUser(user2);
    	loginPage.testPage();
    }
	
	 @Test
	 public void SearchPageCheck()
    {
	    Page searchPage = PageFactory.getPage(PageType.SEARCHPAGE);
	    searchPage.testPage();
	}
}
