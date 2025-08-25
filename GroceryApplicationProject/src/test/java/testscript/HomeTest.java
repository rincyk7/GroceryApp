package testscript;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import automationcore.GroceryBase;
import constants.Messages;
import pages.HomePage;
import pages.LoginPage;
import utilities.ExcelUtility;

public class HomeTest extends GroceryBase{
	HomePage homepage;
	@Test
	public void verifyUserisAbleToLoginSuccessfully() throws IOException {
		String username= ExcelUtility.getStringData(0, 0, "GroceryLoginPage");
		String password =ExcelUtility.getStringData(0, 1, "GroceryLoginPage");
		//object
		LoginPage loginpage = new LoginPage(driver);
		//sending values from excel
		loginpage.enterValidUserName(username).enterValidPassword(password);
		//explicit wait command
		//WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		//wait.until(ExpectedConditions.elementToBeCLickoble(password));
		homepage=loginpage.clickOnSignInButton();
		//HomePage homepage = new HomePage(driver);
		homepage.clickOnadminlogo();
		loginpage=homepage.clickOnLogout();
		//assertequals
		String Actual = loginpage.pageHeading();
		Assert.assertEquals(Actual,"7mart",Messages.SUCCESSFULLLOGOUT);
		
	}

}
