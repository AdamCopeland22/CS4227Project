package seleniumWrapper.LoginPage;

public interface LoginPage {
	void loginWithXpaths(String usernameXpath, String PaswordXpath, String submitButton);
	void loginWithIDs(String unameID, String pwordID, String submitButton);
}
