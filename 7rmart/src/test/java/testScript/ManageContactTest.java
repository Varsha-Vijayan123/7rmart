package testScript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import constant.Constant;
import pages.ManageContactPage;
import pages.LogOutPage;
import pages.LoginPage;
import utilities.ExcelUtilities;
import utilities.FakerUtility;

public class ManageContactTest extends Base {
	ManageContactPage managecontactpage;
	LogOutPage logoutpage;

	@Test(priority = 1, description = "To update contact information")
	public void verifyUserIsAbletoUpdateContactinformationInManageContact() throws IOException {
		String user = ExcelUtilities.getStringData(1, 0, "LoginPage");
		String pass = ExcelUtilities.getStringData(1, 1, "LoginPage");
		String phoneno = ExcelUtilities.getIntergerData(1, 0, "ManageContact");
		String email = ExcelUtilities.getStringData(1, 1, "ManageContact");
		String address = ExcelUtilities.getStringData(1, 2, "ManageContact");
		String deliverytime = ExcelUtilities.getIntergerData(1, 3, "ManageContact");
		String deliverychargelimit = ExcelUtilities.getIntergerData(1, 4, "ManageContact");

		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUsername(user).enterPassword(pass);
		logoutpage = loginpage.clickSigninButton();

		managecontactpage = logoutpage.clickMoreInfoContact();

		managecontactpage.clickEditIcon().addPhoneno(phoneno).addEmail(email).addAddress(address)
				.addDeliveryTime(deliverytime).addDeliveryChargeLimit(deliverychargelimit).update();
		boolean isAlertDisplayed = managecontactpage.isAlertDisplayed();
		Assert.assertTrue(managecontactpage.isAlertDisplayed(), Constant.UPDATECONTACT);
	}
}
