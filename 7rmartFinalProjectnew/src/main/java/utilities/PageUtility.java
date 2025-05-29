package utilities;

import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class PageUtility {
	static JavascriptExecutor javascript;
	static WebDriver driver;
	
	public static void selectDropdownWithValue(WebElement element, int index) {
		Select select = new Select(element);
		select.selectByIndex(index);
	}
	
	public void selectRadiobuttonAndCheckbox(WebElement element) {
		element.click();
	}
	
	public void handleAlert() {
		Alert alert= driver.switchTo().alert();//to switch to the alert box
		alert.accept();
	}
	
	public  void pagedown() {
		javascript.executeScript("window.scrollBy(0,350)", "");
	}
	
	public void pageup() {
		javascript.executeScript("window.scrollBy(0,-350)", "");
	}
	
	public void jsExecutorClick(WebDriver driver,WebElement elementName) {
		JavascriptExecutor javascript = (JavascriptExecutor)driver;
		javascript.executeScript("arguments[0].click();", elementName);
	}
}
