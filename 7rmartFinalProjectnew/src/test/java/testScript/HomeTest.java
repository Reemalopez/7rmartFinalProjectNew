package testScript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import baseClass.Base;
import constants.Messages;
import pages.HomePage;
import pages.LoginPage;
import utilities.ExcelUtility;

public class HomeTest extends Base {

	@Test(description = "Verify whether user able to logout from home page")
	public void verifyUserLogoutFromHomepage() throws IOException {

		String username = ExcelUtility.getStringData(1, 0, "LoginPage");
		String password = ExcelUtility.getStringData(1, 1, "LoginPage");
		LoginPage login = new LoginPage(driver);
		login.enterUsernameOnUsernameField(username);
		login.enterPasswordOnPasswordField(password);
		login.clickOnsubmit();

		HomePage homepage = new HomePage(driver);
		homepage.clickOnAdminlink();
		homepage.clickOnLogout();

		String expected = "Sign in to start your session";
		String actual = homepage.getsigninpagetitle();
		Assert.assertEquals(actual, expected,Messages.LOGOUTERROR);

	}

}