package testscript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import automationcore.GroceryBase;
import constants.Messages;
import pages.HomePage;
import pages.LoginPage;
import pages.NewsPage;
import utilities.ExcelUtility;

public class NewsTest extends GroceryBase{
	HomePage homepage;
	NewsPage newspage;
	
	@Test(description = "verify Whether User Is Able to Create New News In NewsPage")
	public void verifyWhetherUserIsAbletoCreateNewNewsInNewsPage() throws IOException {
		String username = ExcelUtility.getStringData(0, 0, "GroceryLoginPage");
		String password = ExcelUtility.getStringData(0, 1, "GroceryLoginPage");
		//object for LoginPage
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterValidUserName(username);
		loginpage.enterValidPassword(password);
		homepage=loginpage.clickOnSignInButton();
		//Object for Homepage
		//HomePage homepage = new HomePage(driver);
		newspage=homepage.clickOnManageNewsMoreinfoButton();
		//Object for New page
		//NewsPage newspage = new NewsPage(driver);
		//creating new news
		newspage.clickOnNewUserButtonInNewsPage().typeInNewsTextAreaInNewsPage(username )
		//String news = (username+"This is the news");
		.typeInNewsTextAreaInNewsPage(username )
		.clickOnSubmitButtonInNewsPage();
		//assert
		boolean AlertmessageDisplay = newspage.alertMessagedisplayedforNewNewsCreation();
		Assert.assertTrue(AlertmessageDisplay,Messages.UNSUCCESSFULLNEWSCREATION);
		
	}
	@Test(description = "verify Whether User Is Able to search New News In NewsPage")
	public void verifyWhetherUserIsAbletoSearchNewNewsInNewsPage() throws IOException {
		String username = ExcelUtility.getStringData(0, 0, "GroceryLoginPage");
		String password = ExcelUtility.getStringData(0, 1, "GroceryLoginPage");
		//object for LoginPage
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterValidUserName(username);
		loginpage.enterValidPassword(password);
		homepage= loginpage.clickOnSignInButton();
		//Object for Homepage
		//HomePage homepage = new HomePage(driver);
		newspage=homepage.clickOnManageNewsMoreinfoButton();
		//Object for New page
		//NewsPage newspage = new NewsPage(driver);
		//searching new news
		newspage.clickOnSearchButtonInNewsPage()
		//String news = (username+"This is the news");
		.typeInNewsTitleInSearchNewsPage(username)
		.clickOnSearchButtonInManageNewsPage();
		
	}
	

}
