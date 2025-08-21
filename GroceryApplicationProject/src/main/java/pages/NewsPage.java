package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NewsPage {
	WebDriver Driver;
	
	//constructor
	public NewsPage(WebDriver Driver) {
		this.Driver=Driver;
		PageFactory.initElements(Driver, this);
		
	}
	//New User Button
	@FindBy(xpath="//a[@href=\"https://groceryapp.uniqassosiates.com/admin/news/add\"]") private WebElement NewUserButtonInNewsPage;
	//New User Fields
	@FindBy(id="news") private WebElement NewsTextAreaInNewsPage;
	@FindBy(xpath = "//button[@type=\"submit\"]") private WebElement SubmitButtonInNewsPage;
	//Search button
	@FindBy(xpath = "//a[@href=\"javascript:void(0)\"]") private WebElement SearchButtonInNewsPage;
	//search button fields
	@FindBy(xpath ="//input[@name=\"un\"]") private WebElement NewsTitleInSearchNewsPage;
	@FindBy(xpath = "//button[@name=\"Search\"]") private WebElement SearchButtonInSearchNewsPage;
	//alert for new news created
	@FindBy(xpath = "//h5[contains(text(),'Alert!')]")private WebElement newNewsCreatedsuccesfullyMessage;

	
	public void clickOnNewUserButtonInNewsPage() {
		NewUserButtonInNewsPage.click();	
	}
	public void typeInNewsTextAreaInNewsPage(String NewsTextInputAreaInNewsPage) {
		NewsTextAreaInNewsPage.sendKeys(NewsTextInputAreaInNewsPage);
	}
	public void clickOnSubmitButtonInNewsPage() {
		SubmitButtonInNewsPage.click();
	}
	public void clickOnSearchButtonInNewsPage() {
		SearchButtonInNewsPage.click();
	}
	public void typeInNewsTitleInSearchNewsPage(String NewsTitleInputInNewsPageInNewsPage) {
		NewsTitleInSearchNewsPage.sendKeys(NewsTitleInputInNewsPageInNewsPage);
		
	}
	public void clickOnSearchButtonInManageNewsPage() {
		SearchButtonInSearchNewsPage.click();
		
	}
	//boolean method
	public boolean alertMessagedisplayedforNewNewsCreation() {
		return newNewsCreatedsuccesfullyMessage.isDisplayed();
	}
	

}
