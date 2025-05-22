package testScript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import baseClass.Base;
import constants.Messages;
import pages.LoginPage;
import utilities.ExcelUtility;

public class LoginTest extends Base {

	@Test(description = "Verifying user login with valid credentials",priority=1)
	public void verifyUserLoginWithValidCredentials() throws IOException {
		String username = ExcelUtility.getStringData(1, 0, "LoginPage");
		String password = ExcelUtility.getStringData(1, 1, "LoginPage");
		LoginPage login = new LoginPage(driver);
		login.enterUsernameOnUsernameField(username);
		login.enterPasswordOnPasswordField(password);
		login.clickOnsubmit();
		String expected = "Dashboard";
		String actual = login.getDashboardText();
		Assert.assertEquals(actual, expected, Messages.VALIDCREDENTIALERROR);
		//,retryAnalyzer=retry.Retry.class -add this code to implement retry,iside the @Test tag
	}

	@Test(description = "Verify the login with Valid username and invalid password")
	public void verifyUserLoginWithValidUsernameAndInvalidPassword() throws IOException {
		String username = ExcelUtility.getStringData(2, 0, "LoginPage");
		String password = ExcelUtility.getStringData(2, 1, "LoginPage");
	
		LoginPage login = new LoginPage(driver);
		login.enterUsernameOnUsernameField(username);
		login.enterPasswordOnPasswordField(password);
		login.clickOnsubmit();
		// Assertion
		boolean isalertDisplayed = login.alertVisibility();
		Assert.assertTrue(isalertDisplayed,Messages.INVALIDPASSWORDERROR);
	}

	@Test(description = "Verify the login with invalid username and valid password")
	public void verifyUserLoginWithInvalidUsernameAndValidPassword() throws IOException {
		String username = ExcelUtility.getStringData(3, 0, "LoginPage");
		String password = ExcelUtility.getStringData(3, 1, "LoginPage");

		LoginPage login = new LoginPage(driver);
		login.enterUsernameOnUsernameField(username);
		login.enterPasswordOnPasswordField(password);
		login.clickOnsubmit();

		boolean isalertDisplayed = login.alertVisibility();
		Assert.assertTrue(isalertDisplayed,Messages.INVALIDUSERNAMEERROR);
	}

	@Test(description = "Verify the login with invalid credentials")
	public void verifyUserLoginWithInvalidCredentials() throws IOException {
		String username = ExcelUtility.getStringData(4, 0, "LoginPage");
		String password = ExcelUtility.getStringData(4, 1, "LoginPage");

		LoginPage login = new LoginPage(driver);
		login.enterUsernameOnUsernameField(username);
		login.enterPasswordOnPasswordField(password);
		login.clickOnsubmit();
		
		boolean isalertDisplayed = login.alertVisibility();
		Assert.assertTrue(isalertDisplayed,Messages.VALIDCREDENTIALERROR);
	}

}