package testScript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import constant.Constant;
import pages.LogOutPage;
import pages.LoginPage;
import pages.ManageNewsPage;
import utilities.ExcelUtilities;

public class ManageNewsTest extends Base {
	ManageNewsPage managenewspage;
	LogOutPage logoutpage;
	
	@Test(priority=1,groups= {"regression"} ,retryAnalyzer=retry.Retry.class,description="to add a new news")
	public void verifyUserIsAbleToAddNewsInManageNews() throws IOException
	{
		/*String news="New new is added";
		String user="admin";
		String pass="admin";*/
		String user=ExcelUtilities.getStringData(1, 0,"LoginPage");
		String pass=ExcelUtilities.getStringData(1, 1, "LoginPage");
		String news=ExcelUtilities.getStringData(1, 0, "News");

		
	LoginPage loginpage=new LoginPage(driver);
	loginpage.enterUsername(user).enterPassword(pass);
	logoutpage=loginpage.clickSigninButton();


	managenewspage=logoutpage.clickManageNewsMoreInfo();
	//managenews.clickMoreInfo();
	managenewspage.clickNewButton().enterTheNews(news).clickSaveButton();
	
	boolean alertdisplayed=managenewspage.isAlertDisplayed();
	Assert.assertTrue(alertdisplayed,Constant.ADDNEWS);
	
	}
	@Test(priority=2,description="to update a news")
	public void verifyUserIsAbleToUpdateNewsInManageNews() throws IOException
	{
		/*String news="This is the updated news";
		String user="admin";
		String pass="admin";*/
		String user=ExcelUtilities.getStringData(1, 0,"LoginPage");
		String pass=ExcelUtilities.getStringData(1, 1, "LoginPage");
		String updatednews=ExcelUtilities.getStringData(1, 1, "News");
	LoginPage loginpage=new LoginPage(driver);
	loginpage.enterUsername(user).enterPassword(pass);
	logoutpage=loginpage.clickSigninButton();
	
    managenewspage=logoutpage.clickManageNewsMoreInfo();
    //managenewspage=new ManageNewsPage(driver);
	
	//managenews.clickMoreInfo();
	managenewspage.clickEditNewsButton().editNews(updatednews).clickUpdateNewsButton();
	
	boolean alertdisplayed=managenewspage.isAlertDisplayed();
	Assert.assertTrue(alertdisplayed,Constant.UPDATENEWS);
}

}
