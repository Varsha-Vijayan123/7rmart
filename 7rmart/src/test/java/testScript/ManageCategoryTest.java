package testScript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import constant.Constant;
import pages.LogOutPage;
import pages.LoginPage;
import pages.ManageCategoryPage;
import utilities.ExcelUtilities;

public class ManageCategoryTest extends Base {
	LogOutPage logout;
	ManageCategoryPage managecategorypage;
	
	@Test(priority=1,description="To add Manage category information ")
	public void addNewCategoryInManageCategoryTest() throws IOException {
		String user=ExcelUtilities.getStringData(1, 0,"LoginPage");
		String pass=ExcelUtilities.getStringData(1, 1, "LoginPage");
		LoginPage loginpage=new LoginPage(driver);
		loginpage.enterUsername(user).enterPassword(pass);
		//loginpage.enterPassword(pass);
		logout=loginpage.clickSigninButton();
		String categoryname=ExcelUtilities.getStringData(1, 0, "categories");
		managecategorypage=logout.clickManageCategoryMoreInfo();
		//managecategory.clickMoreInfo();
		//managecategorypage=new ManageCategoryPage(driver);
		managecategorypage.clickAddNewCategoryButton().addCategory(categoryname).clickChooseFileButton().clickSavebutton();
		//boolean isAlertDisplayed=managecategorypage.isAlertDisplayed();
		Assert.assertTrue(managecategorypage.isAlertDisplayed(),Constant.UPDATECATEGORY);
	}
	@Test(priority=2,description="To upload image in managecategory page")
	public void uploadImageOfAnExistingCategoryInManageCategoryTest() throws IOException {
		String user=ExcelUtilities.getStringData(1, 0,"LoginPage");
		String pass=ExcelUtilities.getStringData(1, 1, "LoginPage");
		LoginPage loginpage=new LoginPage(driver);
		loginpage.enterUsername(user).enterPassword(pass);
		logout=loginpage.clickSigninButton();
		
	managecategorypage=logout.clickManageCategoryMoreInfo();
	//managecategorypage=new ManageCategoryPage(driver);
		managecategorypage.clickEditIcon().clickChooseFileButtonInAddNewCategory().clickUpdatebutton();
		//boolean isAlertDisplayed=managecategorypage.isAlertDisplayed();
		Assert.assertTrue(managecategorypage.isAlertDisplayed(),Constant.ADDCATEGORY);
	}
}

	