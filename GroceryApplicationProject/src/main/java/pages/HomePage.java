package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

	WebDriver driver;

	// constructor
	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// webelement dashboard
	@FindBy(xpath = "//p[text()='Dashboard']")
	private WebElement dashboard;
	@FindBy(xpath = "//img[@class='img-circle']")
	private WebElement adminlogo;
	@FindBy(xpath = "//i[@class=\'ace-icon fa fa-power-off\']")
	private WebElement logoutButton;
	@FindBy(xpath = "//a[@class='small-box-footer' and contains(@href, 'list-admin')]")
	private WebElement adminMoreinfoButton;
	@FindBy(xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/list-news']")
	private WebElement ManageNewsMoreinfoButton;

	public HomePage clickOnadminlogo() {
		adminlogo.click();
		return this;
	}

	public LoginPage clickOnLogout() {
		logoutButton.click();
		return new LoginPage(driver);
	}

	public AdminPage clickOnAdminMoreInfo() {
		adminMoreinfoButton.click();
		return new AdminPage(driver);
	}

	public NewsPage clickOnManageNewsMoreinfoButton() {
		ManageNewsMoreinfoButton.click();
		return new NewsPage(driver);

	}

	// webelement dashboard
	public boolean isDashboardDisplayed() {
		return dashboard.isDisplayed();
	}
}
