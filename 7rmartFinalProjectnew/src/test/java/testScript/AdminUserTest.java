package testScript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import baseClass.Base;
import constants.Messages;
import pages.AdminUserPage;
import pages.HomePage;
import pages.LoginPage;
import utilities.ExcelUtility;
import utilities.RandomDataUtility;

public class AdminUserTest extends Base {

	HomePage homepage;
	AdminUserPage adminuser;

	@Test(description = "Verify whether new user addition")
	public void verifyUserabletoCreateNewAdminuser() throws IOException {

		String username = ExcelUtility.getStringData(1, 0, "LoginPage");
		String password = ExcelUtility.getStringData(1, 1, "LoginPage");
		LoginPage login = new LoginPage(driver);
		login.enterUsernameOnUsernameField(username).enterPasswordOnPasswordField(password);
		homepage = login.clickOnsubmit();

		RandomDataUtility randomdata = new RandomDataUtility();
		String newusername = randomdata.createRandomUsername();
		String newpassword = randomdata.createRandomPassword();
		
		adminuser=homepage.clickOnAdminuser();
		adminuser.clickOnNew().enternewusernameOnField(newusername).enternewPasswordOntheField(newpassword).selectUserType().clickOnsavebutton();

		boolean isdisplayedAlert = adminuser.successMessage();
		Assert.assertTrue(isdisplayedAlert, Messages.ADDNEWSERROR);

	}

	@Test(description = "Verify user able to fetch details of an existing user")
	public void verifytheSearchofAddedUser() throws IOException {

		String username = ExcelUtility.getStringData(1, 0, "LoginPage");
		String password = ExcelUtility.getStringData(1, 1, "LoginPage");
		LoginPage login = new LoginPage(driver);
		login.enterUsernameOnUsernameField(username).enterPasswordOnPasswordField(password);
		homepage = login.clickOnsubmit();

		String searchusername = ExcelUtility.getStringData(1, 0, "AdminUser");
		String usertype = ExcelUtility.getStringData(1, 1, "AdminUser");
		
		adminuser=homepage.clickOnAdminuser();
		adminuser.searchForCreatedUser().searchForUser(searchusername).selectUserTypesearch(usertype).searchUser();

		boolean isUserDisplayed = adminuser.verifyUserDisplay();
		Assert.assertTrue(isUserDisplayed, Messages.SEARCHUSERERROR);
	}
}