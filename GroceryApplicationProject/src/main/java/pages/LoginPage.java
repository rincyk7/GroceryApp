package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.Waitutility;

public class LoginPage {

	WebDriver Driver;

	// constructor
	public LoginPage(WebDriver Driver) {
		this.Driver = Driver;
		PageFactory.initElements(Driver, this);
	}

	// webelement 7mart
	@FindBy(xpath = "//b[text()='7rmart supermarket']")
	private WebElement supermarketname;

	@FindBy(name = "username")
	private WebElement userName;
	@FindBy(name = "password")
	private WebElement passWord;
	@FindBy(xpath = "//button[text()='Sign In']")
	private WebElement loginButton;
	@FindBy(xpath = "//p[text()='Dashboard']")
	private WebElement dahsboard;

	// public void enterValidUserName(String username) {
	public LoginPage enterValidUserName(String username) {
		userName.sendKeys(username);
		return this;
	}

	public LoginPage enterValidPassword(String password) {
		passWord.sendKeys(password);
		return this;
	}

	public HomePage clickOnSignInButton() {
		Waitutility wait = new Waitutility();
		wait.waitForWebElementClickable(Driver, loginButton);
		loginButton.click();
		return new HomePage(Driver);

	}

	public boolean isDashboardDisplayed() {
		return dahsboard.isDisplayed();
	}

	// 7mart
	public String pageHeading() {
		return supermarketname.getText();
	}

}
