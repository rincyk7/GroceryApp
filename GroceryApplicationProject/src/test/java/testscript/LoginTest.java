package testscript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import automationcore.GroceryBase;
import constants.Messages;
import pages.HomePage;
import pages.LoginPage;
import utilities.ExcelUtility;

public class LoginTest extends  GroceryBase{
	HomePage homepage;
	
	
	//Both valid
	@Test(priority =1,description= "verify whether user is able to login with valid credentials",retryAnalyzer = retry.Retry.class)
	public void verifyValidCredentials() throws IOException {
		// Fetching data from Excel
		String username= ExcelUtility.getStringData(0, 0, "GroceryLoginPage");
		String password =ExcelUtility.getStringData(0, 1, "GroceryLoginPage");
		//object
		LoginPage loginpage = new LoginPage(driver);
		//sending values from excel
		//going to do chaining
		loginpage.enterValidUserName(username).enterValidPassword(password);
		//loginpage.enterValidPassword(password);
		//loginpage.clickOnSignInButton();
		homepage = loginpage.clickOnSignInButton();
		HomePage homepage = new HomePage(driver);
		//assertion for dashboard
		//logintest
		boolean dashboardDisplay = homepage.isDashboardDisplayed();
		Assert.assertTrue(dashboardDisplay, Messages.VALIDCREDENTIALMESSAGE);
		
	}
	
	//wrongusername TC
	@Test(priority =2,description= "verify whether user is able to login with invalid username",groups= {"smoke"})
	public void verifyValidPassword() throws IOException {
		// Fetching data from Excel
		String username= ExcelUtility.getStringData(1, 0, "GroceryLoginPage");
		String password =ExcelUtility.getStringData(1, 1, "GroceryLoginPage");
		//object
		LoginPage loginpage = new LoginPage(driver);
		//sending values from excel
		loginpage.enterValidUserName(username);
		loginpage.enterValidPassword(password);
		loginpage.clickOnSignInButton();
		//invalid username method
				String actual=loginpage.pageHeading();
				String expected ="7rmart"; //change text to fail it
				Assert.assertEquals(actual,expected,Messages.INVALIDUSERNAMEERROR);
		
	}
	
	//wrong Password TC
	@Test(priority =3,description= "verify whether user is able to login with invalid password",groups= {"smoke"})
	public void verifyValidUsername() throws IOException {
		// Fetching data from Excel
		String username= ExcelUtility.getStringData(2, 0, "GroceryLoginPage");
		String password =ExcelUtility.getStringData(2, 1, "GroceryLoginPage");
		//object
		LoginPage loginpage = new LoginPage(driver);
		//sending values from excel
		loginpage.enterValidUserName(username).enterValidPassword(password).clickOnSignInButton();
		//invalid password method
		String actual=loginpage.pageHeading();
		String expected ="7rmaart"; //change text to fail it
		Assert.assertEquals(actual,expected,Messages.INVALIDPASSWORDERROR);

		
	}
	//Both wrong Tc
	@Test(priority =4,description= "verify whether user is able to login with invalid credentials",dataProvider = "loginProvider")
	public void verifyInValidCredentials(String username, String password) throws IOException {
		// Fetching data from Excel
		//String username= ExcelUtility.getStringData(3, 0, "GroceryLoginPage");
		//String password =ExcelUtility.getStringData(3, 1, "GroceryLoginPage");
		//object
		LoginPage loginpage = new LoginPage(driver);
		//sending values from excel
		loginpage.enterValidUserName(username).enterValidPassword(password).clickOnSignInButton();
		//invalid credentials method Assertion 
				String actual=loginpage.pageHeading();
				String expected ="7ramart"; //change text to fail it
				Assert.assertEquals(actual,expected,Messages.INVALIDCREDENTIALERROR);
		
	}
	
	@DataProvider(name="loginProvider")
	public Object[][] getDataFromDataProvider() throws IOException
	{
	return new Object[][] { new Object[] {"admin123","admin1234"},
	new Object[] {"123","123"},
	//new Object[] {ExcelUtility.getStringData(3, 0,"Login"),ExcelUtility.getStringData(3,1 ,"Login")}
	};
	}

	

}
