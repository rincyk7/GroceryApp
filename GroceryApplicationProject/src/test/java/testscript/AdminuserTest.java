package testscript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import automationcore.GroceryBase;
import constants.Messages;
import pages.AdminPage;
import pages.HomePage;
import pages.LoginPage;
import utilities.ExcelUtility;
import utilities.RandomDataUtility;

public class AdminuserTest extends GroceryBase{
	HomePage homepage;
	AdminPage adminpage;
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
		loginpage.enterValidUserName(username).enterValidPassword(password);
		homepage=loginpage.clickOnSignInButton();
		//object refernce to HomePage
		//HomePage homepage = new HomePage(driver);
		adminpage=homepage.clickOnAdminMoreInfo();
		//object refernce to AdminPage
		//AdminPage adminpage = new AdminPage(driver);
		adminpage.clickOnNewBUtton().enterNewUserName(username1).enterNewUserPassword(password1)
		.selectNewUserDropdownValue("admin").clickOnNewUserSubmitButton();
		//Assert
		String Actual = adminpage.alertMessagedisplayedforNewUserCreation();
		Assert.assertEquals(Actual, "Alert!",Messages.UNSUCCESSFULLUSERCREATION);
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
		adminpage.enterUsernameValueInSearchButton(username1).selectSearchNewUserDropdownValue("admin").searchInSearchUser();
		//Assertion
				boolean searchAdminUserstext=adminpage.alertMessagedisplayedforUserSearch();
				Assert.assertTrue(searchAdminUserstext,Messages.UNSUCCESSFULLUSERSEARCH);

	}
	@Test(priority =3,description= "verify whether user is able to Reset")
	public void verifyUserIsAbletoResetSuccessfully() throws IOException {
		String username = ExcelUtility.getStringData(0, 0, "GroceryLoginPage");
		String password = ExcelUtility.getStringData(0, 1, "GroceryLoginPage");
		String username1 = ExcelUtility.getStringData(1, 0, "GroceryLoginPage");
		String password1 = ExcelUtility.getStringData(1, 1, "GroceryLoginPage");
		
		//object refernce to LoginPage
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterValidUserName(username).enterValidPassword(password);
		homepage=loginpage.clickOnSignInButton();
		//object refernce to HomePage
		//HomePage homepage = new HomePage(driver);
		adminpage=homepage.clickOnAdminMoreInfo().clickOnResetButton();
		//object refernce to AdminPage
		//AdminPage adminpage = new AdminPage(driver);
		adminpage.clickOnResetButton();
		//Assertion
		boolean resetAdminUserstext=adminpage.alertMessagedisplayedforUserReset();
		Assert.assertTrue(resetAdminUserstext,Messages.UNSUCCESSFULLUSERRESET);
	}
}
