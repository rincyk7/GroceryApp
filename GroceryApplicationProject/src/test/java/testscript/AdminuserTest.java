package testscript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import automationcore.GroceryBase;
import pages.AdminPage;
import pages.HomePage;
import pages.LoginPage;
import utilities.ExcelUtility;
import utilities.RandomDataUtility;

public class AdminuserTest extends GroceryBase{
	@Test(priority =1,description= "verify whether user is able to create with valid credentials")
	public void verifyUserIsAbletoCreateNewSuccessfully() throws IOException {
		String username = ExcelUtility.getStringData(0, 0, "GroceryLoginPage");
		String password = ExcelUtility.getStringData(0, 1, "GroceryLoginPage");
		String username1 = ExcelUtility.getStringData(1, 0, "GroceryLoginPage");
		String password1 = ExcelUtility.getStringData(1, 1, "GroceryLoginPage");
		//random
		RandomDataUtility random = new RandomDataUtility();
		String randomUsername = random.createFullName();
		
		//object refernce to LoginPage
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterValidUserName(username);
		loginpage.enterValidPassword(password);
		loginpage.clickOnSignInButton();
		//object refernce to HomePage
		HomePage homepage = new HomePage(driver);
		homepage.clickOnAdminMoreInfo();
		//object refernce to AdminPage
		AdminPage adminpage = new AdminPage(driver);
		adminpage.clickOnNewBUtton();
		adminpage.enterNewUserName(username1);
		adminpage.enterNewUserPassword(password1);
		adminpage.selectNewUserDropdownValue();
		adminpage.clickOnNewUserSubmitButton();
		//Assert
		String Actual = adminpage.alertMessagedisplayedforNewUserCreation();
		Assert.assertEquals(Actual, "Alert!","User creation failed inside AdminPage");
	}
	@Test(priority =2,description= "verify whether user is able to search with new user")
	public void verifyUserIsAbletoSearchNewSuccessfully() throws IOException {
		String username = ExcelUtility.getStringData(0, 0, "GroceryLoginPage");
		String password = ExcelUtility.getStringData(0, 1, "GroceryLoginPage");
		String username1 = ExcelUtility.getStringData(1, 0, "GroceryLoginPage");
		String password1 = ExcelUtility.getStringData(1, 1, "GroceryLoginPage");
		
		//object refernce to LoginPage
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterValidUserName(username);
		loginpage.enterValidPassword(password);
		loginpage.clickOnSignInButton();
		//object refernce to HomePage
		HomePage homepage = new HomePage(driver);
		homepage.clickOnAdminMoreInfo();
		//object refernce to AdminPage
		AdminPage adminpage = new AdminPage(driver);
		adminpage.clickOnSearchButton();
		adminpage.enterUsernameValueInSearchButton(username1);
		adminpage.selectSearchNewUserDropdownValue();
		adminpage.searchInSearchUser();

	}
	@Test(priority =3,description= "verify whether user is able to Reset")
	public void verifyUserIsAbletoResetSuccessfully() throws IOException {
		String username = ExcelUtility.getStringData(0, 0, "GroceryLoginPage");
		String password = ExcelUtility.getStringData(0, 1, "GroceryLoginPage");
		String username1 = ExcelUtility.getStringData(1, 0, "GroceryLoginPage");
		String password1 = ExcelUtility.getStringData(1, 1, "GroceryLoginPage");
		
		//object refernce to LoginPage
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterValidUserName(username);
		loginpage.enterValidPassword(password);
		loginpage.clickOnSignInButton();
		//object refernce to HomePage
		HomePage homepage = new HomePage(driver);
		homepage.clickOnAdminMoreInfo();
		//object refernce to AdminPage
		AdminPage adminpage = new AdminPage(driver);
		adminpage.clickOnResetButton();
	}
}
