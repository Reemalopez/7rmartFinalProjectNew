package testScript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import baseClass.Base;
import constants.Messages;
import pages.LoginPage;
import pages.ManageCategoryPage;
import utilities.ExcelUtility;
import utilities.RandomDataUtility;

public class ManageCategoryTest extends Base {
	
	
	@Test(description = "Verifying user able to add new Category ")
	public void verifyAddCategory() throws IOException {
		String username = ExcelUtility.getStringData(1, 0, "LoginPage");
		String password = ExcelUtility.getStringData(1, 1, "LoginPage");
		LoginPage login = new LoginPage(driver);
		login.enterUsernameOnUsernameField(username);
		login.enterPasswordOnPasswordField(password);
		login.clickOnsubmit();
		ManageCategoryPage managecategory=new ManageCategoryPage(driver);
		managecategory.clickOnManageCategoryField();
		managecategory.clickOnAddNewCategoryField();
		RandomDataUtility randomdatautility = new RandomDataUtility();
		String categoryname = randomdatautility.createRandomName();
		managecategory.EnterCategory(categoryname);
		managecategory.selectGroup();
		managecategory.uploadImage();
		managecategory.saveCategory();
		boolean alertmessage=managecategory.getAlertMessageForSuccessfullCategoryCreation();
		Assert.assertTrue(alertmessage,Messages.ADDCATEGORYERROR);

	}

	@Test(description = "Verifying User able to search an existing category")
	public void verifySearchCategory() throws IOException {
		String username = ExcelUtility.getStringData(1, 0, "LoginPage");
		String password = ExcelUtility.getStringData(1, 1, "LoginPage");
		LoginPage login = new LoginPage(driver);
		login.enterUsernameOnUsernameField(username);
		login.enterPasswordOnPasswordField(password);
		login.clickOnsubmit();
		ManageCategoryPage managecategory=new ManageCategoryPage(driver);
		managecategory.clickOnManageCategoryField();
		managecategory.searchCategory();
		String searchcategoryname = ExcelUtility.getStringData(1, 0, "ManageCategory");
		managecategory.enterCategoryname(searchcategoryname);
		managecategory.clickOnSearchCategoryButton();
		String Expected="Active";
		String actual=managecategory.getSearchedCategoryMessage();
		Assert.assertEquals(actual,Expected,Messages.SEARCHCATEGORYERROR);
	}
}