package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ManageNewsPage {
	public WebDriver driver;

	public ManageNewsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	
	@FindBy(xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/list-news' and @class='active nav-link']")
	private WebElement managenewsicon;
	@FindBy(xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/news/add']")
	private WebElement addnewsbutton;
	@FindBy(xpath = "//textarea[@class=\'form-control\']")
	private WebElement newstextbox;
	@FindBy(xpath = "//button[@name='create']")
	private WebElement saveNewsButton;
	
	

	public void clickOnManageNewsIcon() {
		managenewsicon.click();			
	}

	public void clickaddnewsbutton() {
		addnewsbutton.click();
	}

	public void enternewsonnewstextbox(String testnewsdata) {
		newstextbox.sendKeys(testnewsdata);
	}

	public void clickOnSaveNewsButton() {
		saveNewsButton.click();
	}

	
	@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']")
	private WebElement alerbox;
	
	public boolean alertboxVisiblity() {
		return alerbox.isDisplayed();
	}
}
