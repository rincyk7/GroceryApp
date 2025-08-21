package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	WebDriver Driver;

	// constructor
	public LoginPage(WebDriver Driver) {
		this.Driver = Driver;
		PageFactory.initElements(Driver, this);
	}


	//webelement 7mart
	@FindBy(xpath = "//b[text()='7rmart supermarket']") private WebElement supermarketname;

	@FindBy(name = "username")
	private WebElement userName;
	@FindBy(name = "password")
	private WebElement passWord;
	@FindBy(xpath = "//button[text()='Sign In']")
	private WebElement loginButton;

	public void enterValidUserName(String username) {
		userName.sendKeys(username);
	}

	public void enterValidPassword(String password) {
		passWord.sendKeys(password);
	}

	public void clickOnSignInButton() {
		loginButton.click();
	}

	
	//7mart
	public String pageHeading() {
		return supermarketname.getText();
	}

}
