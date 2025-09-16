package testScript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import constant.Constant;
import pages.AdminUsersPage;
import pages.LogOutPage;
import pages.LoginPage;
import utilities.ExcelUtilities;
import utilities.FakerUtility;

public class AdminUsersTest extends Base {
	AdminUsersPage adminuserspage;
	LogOutPage logoutpage;
	@Test(priority=1,description="Admin login")
	public void addANewadminInAdminUsersTest() throws IOException {
		String loginUserName = ExcelUtilities.getStringData(1,0, "LoginPage"); // Fetching username from Excel file. 1,0 represent cell position
		String loginPassword = ExcelUtilities.getStringData(1,1, "LoginPage");
		LoginPage loginPage = new LoginPage(driver);
		loginPage.enterUsername(loginUserName).enterPassword(loginPassword);
		logoutpage=loginPage.clickSigninButton();
		
		adminuserspage=logoutpage.adminUserMoreInfo();
		
	
		//String loginUserNameAdmin = ExcelUtility.getstringData(1,0, "Admins"); // Fetching username from Excel file. 1,0 represent cell position
		//String loginPasswordAdmin = ExcelUtility.getstringData(1,1, "Admins");
		FakerUtility fakerutility = new FakerUtility();
		String loginUserNameAdmin = fakerutility.createARandomFirstName(); //generating random username using FakerUtility
		String loginPasswordAdmin = fakerutility.createARandomFirstName();// Generating random password using FakerUtility
		adminuserspage.clickAddNewAdminButton().enterNewAdminUsername(loginUserNameAdmin).enterNewAdminPassword(loginPasswordAdmin).selectUserType().clickSaveAdminButton();
		boolean isAlertDisplayed=adminuserspage.isAlertDisplayed();
		Assert.assertTrue(adminuserspage.isAlertDisplayed(),Constant.ADDADMININFORMATION);
		
	}
	@Test(priority=2,description="To update Admin user information")
		public void updateDetailsOfAnExistingAdminInAdminUsersTest () throws IOException {
		String loginnewUsername = ExcelUtilities.getStringData(1, 0, "LoginPage");
		String loginnewpassword = ExcelUtilities.getStringData(1, 1, "LoginPage");
		//String loginUserNameAdmin = ExcelUtility.getstringData(1,0, "Admins"); // Fetching username from Excel file. 1,0 represent cell position
		//String loginPasswordAdmin = ExcelUtility.getstringData(1,1, "Admins");
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUsername(loginnewUsername).enterPassword(loginnewpassword);
		logoutpage=loginpage.clickSigninButton();

		adminuserspage=logoutpage.adminUserMoreInfo();
		FakerUtility fakerutility = new FakerUtility();
		String newUsername = fakerutility.createARandomFirstName(); //generating random username using FakerUtility
		String newpassword = fakerutility.createARandomFirstName();// Generating random password using FakerUtility
		adminuserspage.clickEditIcon().editUsername(newUsername).editPassword(newpassword).editUsertype().update();
		boolean isAlertDisplayed=adminuserspage.isAlertDisplayed();
		Assert.assertTrue(adminuserspage.isAlertDisplayed(),Constant.ADDADMININFORMATION);		
	}
	
	

}


