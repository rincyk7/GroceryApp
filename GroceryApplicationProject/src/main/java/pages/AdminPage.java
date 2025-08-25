package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import utilities.PageUtility;

public class AdminPage {
	WebDriver Driver;

	// constructor
	public AdminPage(WebDriver Driver) {
		this.Driver = Driver;
		PageFactory.initElements(Driver, this);

	}

	// @FindBy(xpath =
	// "//a[@href=\'https://groceryapp.uniqassosiates.com/admin/list-admin\']")
	// private WebElement adminMoreinfoButton;
	// New user
	@FindBy(xpath = "//a[@class=\'btn btn-rounded btn-danger\']")
	private WebElement newUserButton;
	// searchButton
	@FindBy(xpath = "//a[@class=\'btn btn-rounded btn-primary\']")
	private WebElement searchButton;
	// Reset button fields
	@FindBy(xpath = "//a[@class='btn btn-rounded btn-warning']")
	private WebElement resetButton;
	// NewButton fields
	@FindBy(xpath = "//input[@name=\'username\']")
	private WebElement newUserNameField;
	@FindBy(xpath = "//input[@type=\'password\']")
	private WebElement newUserPasswordField;
	@FindBy(id = "user_type")
	private WebElement newUserTypeDropdown;
	@FindBy(xpath = "//button[@name=\'Create\']")
	private WebElement newUserSaveButton;
	// searchbutton fields
	@FindBy(id = "un")
	private WebElement searchButtonUserName;
	@FindBy(id = "ut")
	private WebElement newUserTypeDropdown2;
	@FindBy(xpath = "//button[@name=\'Search\']")
	private WebElement searchButton2;
	// Asser for new user creation alert field
	@FindBy(xpath = "//h5[contains(text(),'Alert!')]")
	private WebElement newUserCreatedsuccesfullyMessage;
	@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']")
	WebElement userSavedAlertMsg;
	
	@FindBy(xpath="//h4[text()='Admin Users']")
	WebElement searchAdminUsersText;
	
	

	@FindBy(xpath="h4[text()='Admin Users']")
	WebElement resetAdminUsersText;

	/**
	 * public void clickOnAdminMoreInfo() { adminMoreinfoButton.click(); }
	 */
	public AdminPage clickOnNewBUtton() {
		newUserButton.click();
		return this;
	}

	public AdminPage clickOnSearchButton() {
		searchButton.click();
		return this;
	}

	public AdminPage clickOnResetButton() {
		resetButton.click();
		return this;
	}

	public AdminPage enterNewUserName(String Newusername) {
		newUserNameField.sendKeys(Newusername);
		return this;
	}

	public AdminPage enterNewUserPassword(String NewUserPassword) {
		newUserPasswordField.sendKeys(NewUserPassword);
		return this;
	}

	public AdminPage selectNewUserDropdownValue(String role) {
		// Select select = new Select(newUserTypeDropdown);
		// select.selectByValue("admin");
		// select.selectByVisibleText("Admin");
		// select.selectByIndex(2); // Index starts at 0
		PageUtility pageUtility = new PageUtility();
		pageUtility.selectDropdownWithVisibleText(newUserTypeDropdown, role);
		return this;

	}

	public AdminPage clickOnNewUserSubmitButton() {
		newUserSaveButton.click();
		return this;
	}

	public AdminPage enterUsernameValueInSearchButton(String searchButtonUserNamevalue) {
		System.out.println("Displayed: " + searchButtonUserName.isDisplayed());
		System.out.println("Enabled: " + searchButtonUserName.isEnabled());
		searchButtonUserName.sendKeys(searchButtonUserNamevalue);
		return this;
	}

	public AdminPage selectSearchNewUserDropdownValue(String usertype) {
		//Select select = new Select(newUserTypeDropdown2);
		// select.selectByValue("admin");
		PageUtility page = new PageUtility();
		page.selectDropdownWithVisibleText(newUserTypeDropdown2, usertype);
		return this;
	}

	public AdminPage searchInSearchUser() {
		searchButton2.click();
		return this;
	}

	public String alertMessagedisplayedforNewUserCreation() {
		return newUserCreatedsuccesfullyMessage.getText();

	}
	public Boolean alertMessagedisplayedforUserSearch() {
		return searchAdminUsersText.isDisplayed();

	}
	public Boolean alertMessagedisplayedforUserReset() {
		return resetAdminUsersText.isDisplayed();

	}

}
