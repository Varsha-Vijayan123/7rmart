package testScript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import constant.Constant;
import pages.LogOutPage;
import pages.LoginPage;
import pages.ManageFooterTextPage;
import utilities.ExcelUtilities;
import utilities.FakerUtility;
import utilities.PageUtility;

public class ManageFooterTest extends Base {
	ManageFooterTextPage managefootertextpage;
	LogOutPage logoutpage;

	@Test(priority = 1, description = "To update footer information")
	public void verifyUserIsAbleToEditFooterTextInManageFooterText() throws IOException {
		String user = ExcelUtilities.getStringData(1, 0, "LoginPage");
		String pass = ExcelUtilities.getStringData(1, 1, "LoginPage");
		String address = ExcelUtilities.getStringData(1, 0, "ManageFooter");
		String email = ExcelUtilities.getStringData(1, 1, "ManageFooter");
		String phoneno = ExcelUtilities.getIntergerData(1, 2, "ManageFooter");
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUsername(user).enterPassword(pass);
		logoutpage = loginpage.clickSigninButton();
		// managefootertextpage=new ManageFooterTextPage(driver);

		managefootertextpage = logoutpage.clickManageFooterMoreInfo();

		// footer.clickMoreInfo();
		managefootertextpage.clickEditIcon().addAddress(address).addEmail(email).addPhone(phoneno).clickUpdatebutton();
		boolean isAlertDisplayed = managefootertextpage.isAlertDisplayed();
		Assert.assertTrue(managefootertextpage.isAlertDisplayed(), Constant.UPDATEFOOTER);

	}
}
