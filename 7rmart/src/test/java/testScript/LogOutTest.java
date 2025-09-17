package testScript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import constant.Constant;
import pages.LogOutPage;
import pages.LoginPage;
import utilities.ExcelUtilities;

public class LogOutTest extends Base {
	@Test(priority = 1)
	public void verifyUserIsRedirectedTologinPageAfterLogOut() throws IOException {
		String user = ExcelUtilities.getStringData(1, 0, "LoginPage");
		String pass = ExcelUtilities.getStringData(1, 1, "LoginPage");
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUsername(user);
		loginpage.enterPassword(pass);
		loginpage.clickSigninButton();

		LogOutPage logout = new LogOutPage(driver);
		logout.clickAdminButton();
		logout.clickLogOutButton();
		Assert.assertTrue(logout.isLoginPageDisplayed(), Constant.LOGOUTFROMPAGE);

	}

}
