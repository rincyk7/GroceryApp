package utilities;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class PageUtility {
	public void selectDropdownWithValue(WebElement element, String value) {
		Select object = new Select(element);
		object.selectByValue(value);
		// WebElement selectedElement = object.getFirstSelectedOption();
		// return selectedElement.getText();
	}

	public void selectDropdownWithVisibleText(WebElement element, String text) {
		Select object = new Select(element);
		object.selectByVisibleText(text);
	}

	public void clickRadioButton(WebElement element) {

		element.click();
	}

	public void clickCheckBox(WebElement element) {

		element.click();
	}

	public void jsExecuter(WebElement element, WebDriver driver) {

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", element);
		js.executeScript("window.scrollBy(0,350)", ""); // scroll down
		js.executeScript("window.scrollBy(0,-350)", "");

	}

	public void verifyRightClick(WebElement element, WebDriver driver) {

		Actions a = new Actions(driver);
		a.contextClick(element).build().perform();
	}
}
