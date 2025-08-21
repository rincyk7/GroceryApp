package testscript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import automationcore.GroceryBase;
import pages.HomePage;
import pages.LoginPage;
import pages.NewsPage;
import utilities.ExcelUtility;

public class NewsTest extends GroceryBase{
	
	@Test
	public void verifyWhetherUserIsAbletoCreateNewNewsInNewsPage() throws IOException {
		String username = ExcelUtility.getStringData(0, 0, "GroceryLoginPage");
		String password = ExcelUtility.getStringData(0, 1, "GroceryLoginPage");
		//object for LoginPage
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterValidUserName(username);
		loginpage.enterValidPassword(password);
		loginpage.clickOnSignInButton();
		//Object for Homepage
		HomePage homepage = new HomePage(driver);
		homepage.clickOnManageNewsMoreinfoButton();
		//Object for New page
		NewsPage newspage = new NewsPage(driver);
		//creating new news
		newspage.clickOnNewUserButtonInNewsPage();
		//String news = (username+"This is the news");
		newspage.typeInNewsTextAreaInNewsPage(username );
		newspage.clickOnSubmitButtonInNewsPage();
		//assert
		boolean AlertmessageDisplay = newspage.alertMessagedisplayedforNewNewsCreation();
		Assert.assertTrue(AlertmessageDisplay,"News creation Failed");
		
	}
	@Test
	public void verifyWhetherUserIsAbletoSearchNewNewsInNewsPage() throws IOException {
		String username = ExcelUtility.getStringData(0, 0, "GroceryLoginPage");
		String password = ExcelUtility.getStringData(0, 1, "GroceryLoginPage");
		//object for LoginPage
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterValidUserName(username);
		loginpage.enterValidPassword(password);
		loginpage.clickOnSignInButton();
		//Object for Homepage
		HomePage homepage = new HomePage(driver);
		homepage.clickOnManageNewsMoreinfoButton();
		//Object for New page
		NewsPage newspage = new NewsPage(driver);
		//searching new news
		newspage.clickOnSearchButtonInNewsPage();
		//String news = (username+"This is the news");
		newspage.typeInNewsTitleInSearchNewsPage(username);
		newspage.clickOnSearchButtonInManageNewsPage();
		
	}
	

}
