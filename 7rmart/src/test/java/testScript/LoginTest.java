package testScript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import constant.Constant;
import pages.LogOutPage;
import pages.LoginPage;
import utilities.ExcelUtilities;

public class LoginTest extends Base {
	LogOutPage logoutpage;
	@Test(priority=1,groups= {"regression"})
	public void verificationOfLoginWithValidUsernameAndPassword()throws IOException {
		//String user="admin";
		//String pass="admin";
		String user=ExcelUtilities.getStringData(1,0,"LoginPage");
		String pass=ExcelUtilities.getStringData(1,1,"LoginPage");
		LoginPage loginpage=new LoginPage(driver);
		loginpage.enterUsername(user).enterPassword(pass);
		//loginpage.enterPassword(pass);
		logoutpage=loginpage.clickSigninButton();
	boolean isdashboarddisplayed=loginpage.isHomePageLoaded();
	Assert.assertTrue(isdashboarddisplayed,Constant.HOMEPAGENOTDISPLAYEDMESSAGE);
	}
	@Test(priority=2,groups= {"regression"})
	public void verificationOfLoginWithInvalidUsernameandInvalidPassword()throws IOException {
		//String user="adm";
		//String pass="chinnu";
		String user=ExcelUtilities.getStringData(2,0,"LoginPage");
		String pass=ExcelUtilities.getStringData(2,1,"LoginPage");
		LoginPage loginpage=new LoginPage(driver);
		loginpage.enterUsername(user).enterPassword(pass);
		//loginpage.enterPassword(pass);
		logoutpage=loginpage.clickSigninButton();
	boolean isalertdisplayed=loginpage.isAlertDisplayed();
	Assert.assertTrue(isalertdisplayed,Constant.HOMEPAGEDISPLAYEDMESSAGE);
	}
	@Test(priority=3,groups= {"regression"})
	public void verifiationOfLoginWithValidUsernameAndInvalidPassword()throws IOException {
		//String user="admin";
		//String pass="chinnu";
		String user=ExcelUtilities.getStringData(3,0,"LoginPage");
		String pass=ExcelUtilities.getStringData(3,1,"LoginPage");
		LoginPage loginpage=new LoginPage(driver);
		loginpage.enterUsername(user).enterPassword(pass);
		//loginpage.enterPassword(pass);
		logoutpage=loginpage.clickSigninButton();
	boolean isalertdisplayed=loginpage.isAlertDisplayed();
	Assert.assertTrue(isalertdisplayed,Constant.HOMEPAGEDISPLAYEDMESSAGE1);
	}
	
	@Test(priority=4,groups={"regression"})
	public void verifiationOfLoginWithInvalidUsernameAndValidPassword()throws IOException {
		//String user="adn";
		//String pass="admin";
		String user=ExcelUtilities.getStringData(4,0,"LoginPage");
		String pass=ExcelUtilities.getStringData(4,1,"LoginPage");
		LoginPage loginpage=new LoginPage(driver);
		loginpage.enterUsername(user).enterPassword(pass);
		//loginpage.enterPassword(pass);
		logoutpage=loginpage.clickSigninButton();
	boolean isalertdisplayed=loginpage.isAlertDisplayed();
	Assert.assertTrue(isalertdisplayed,Constant.HOMEPAGEDISPLAYEDMESSAGE2);
	}
	
	}
	
		
		


