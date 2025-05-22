package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	public WebDriver driver;

	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath = "//a[@data-toggle='dropdown']")
	private WebElement Admin;
	@FindBy(xpath = "//div[@class='dropdown-menu dropdown-menu-lg dropdown-menu-right text_black show']/a[2]")
	private WebElement Logout;
	@FindBy(xpath = "//p[@class='login-box-msg']")
	private WebElement signinpagetitle;

	public void clickOnAdminlink() {
		Admin.click();
	}

	public void clickOnLogout() {
		Logout.click();
	}

	public String getsigninpagetitle() {
		return signinpagetitle.getText();

	}
}
