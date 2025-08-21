package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class AdminPage {
	WebDriver Driver;
	
	//constructor
	public AdminPage(WebDriver Driver) {
		this.Driver=Driver;
		PageFactory.initElements(Driver, this);
		
	}
	//@FindBy(xpath = "//a[@href=\'https://groceryapp.uniqassosiates.com/admin/list-admin\']") private WebElement adminMoreinfoButton;
	//New user
	@FindBy(xpath = "//a[@class=\'btn btn-rounded btn-danger\']") private WebElement newUserButton;
	//searchButton
	@FindBy(xpath = "//a[@class=\'btn btn-rounded btn-primary\']") private WebElement searchButton;
	//Reset button fields
	@FindBy(xpath= "//a[@class='btn btn-rounded btn-warning']") private WebElement resetButton;
	//NewButton fields
	@FindBy(xpath= "//input[@name=\'username\']") private WebElement newUserNameField;
	@FindBy(xpath= "//input[@type=\'password\']") private WebElement newUserPasswordField;
	@FindBy(id="user_type") private WebElement newUserTypeDropdown;
	@FindBy(xpath="//button[@name=\'Create\']") private WebElement newUserSaveButton;
	//searchbutton fields
	@FindBy(id = "un") private WebElement searchButtonUserName;
	@FindBy(id = "ut") private WebElement newUserTypeDropdown2;
	@FindBy(xpath = "//button[@name=\'Search\']") private WebElement searchButton2;
	//Asser for new user creation alert field
	@FindBy(xpath = "//h5[contains(text(),'Alert!')]")private WebElement newUserCreatedsuccesfullyMessage;

	/**public void clickOnAdminMoreInfo() {
		adminMoreinfoButton.click();
	}
	*/
	public void clickOnNewBUtton() {
		newUserButton.click();
	}
	public void clickOnSearchButton() {
		searchButton.click();
	}
	public void clickOnResetButton() {
		resetButton.click();
	}
	public void enterNewUserName(String Newusername) {
		newUserNameField.sendKeys(Newusername);
	}
	public void enterNewUserPassword(String NewUserPassword) {
		newUserNameField.sendKeys(NewUserPassword);
	}
	public void selectNewUserDropdownValue() {
		Select select = new Select(newUserTypeDropdown);
		select.selectByValue("admin");
		//select.selectByVisibleText("Admin");
		//select.selectByIndex(2); // Index starts at 0
		
	}
	public void clickOnNewUserSubmitButton() {
		newUserSaveButton.click();
		
	}
	public void enterUsernameValueInSearchButton(String searchButtonUserNamevalue) {
		System.out.println("Displayed: " + searchButtonUserName.isDisplayed());
		System.out.println("Enabled: " + searchButtonUserName.isEnabled());
		searchButtonUserName.sendKeys(searchButtonUserNamevalue);
	}
	public void selectSearchNewUserDropdownValue() {
		Select select = new Select(newUserTypeDropdown2);
		select.selectByValue("admin");
	}
	public void searchInSearchUser() {
		searchButton2.click();	
	}
	public String alertMessagedisplayedforNewUserCreation() {
		return newUserCreatedsuccesfullyMessage.getText();
	}
	
}
