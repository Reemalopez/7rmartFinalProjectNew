package testScript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import baseClass.Base;
import constants.Messages;
import pages.AdminUserPage;
import pages.LoginPage;
import utilities.ExcelUtility;
import utilities.RandomDataUtility;

public class AdminUserTest extends Base {

	@Test(description = "Verify whether new user addition")
	public void verifyUserabletoCreateNewAdminuser() throws IOException {

		String username = ExcelUtility.getStringData(1, 0, "LoginPage");
		String password = ExcelUtility.getStringData(1, 1, "LoginPage");
		LoginPage login = new LoginPage(driver);
		login.enterUsernameOnUsernameField(username);
		login.enterPasswordOnPasswordField(password);
		login.clickOnsubmit();
		
		RandomDataUtility randomdata = new RandomDataUtility();
		String newusername = randomdata.createRandomUsername();
		String newpassword = randomdata.createRandomPassword();


		AdminUserPage adminuser = new AdminUserPage(driver);
		
		adminuser.clickOnAdminuser();
		adminuser.clickOnNew();
		adminuser.enternewusernameOnField(newusername);
		adminuser.enternewPasswordOntheField(newpassword);
		adminuser.selectUserType();
		adminuser.clickOnsavebutton();

		boolean isdisplayedAlert = adminuser.successMessage();
		Assert.assertTrue(isdisplayedAlert,Messages.ADDNEWSERROR);

	}

	@Test(description = "Verify user able to fetch details of an existing user")
	public void verifytheSearchofAddedUser() throws IOException {
		
		String username = ExcelUtility.getStringData(1, 0, "LoginPage");
		String password = ExcelUtility.getStringData(1, 1, "LoginPage");
		LoginPage login = new LoginPage(driver);
		login.enterUsernameOnUsernameField(username);
		login.enterPasswordOnPasswordField(password);
		login.clickOnsubmit();
		String searchusername = ExcelUtility.getStringData(1, 0, "AdminUser");
		String usertype=ExcelUtility.getStringData(1, 1, "AdminUser");
		System.out.println(usertype);
		AdminUserPage adminuser = new AdminUserPage(driver);
		adminuser.clickOnAdminuser();
		adminuser.searchForCreatedUser();
		adminuser.searchForUser(searchusername);
		adminuser.selectUserTypesearch(usertype);
		adminuser.searchUser();
		boolean isUserDisplayed = adminuser.verifyUserDisplay();
		Assert.assertTrue(isUserDisplayed, Messages.SEARCHUSERERROR);
	}
}