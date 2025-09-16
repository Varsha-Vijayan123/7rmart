package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LogOutPage {
	@FindBy(xpath="//a[@data-toggle='dropdown']")WebElement admin;
	@FindBy(xpath="//a[@href='https://groceryapp.uniqassosiates.com/admin/logout' and @class='dropdown-item']")WebElement logout;
	@FindBy(xpath="//button[text()='Sign In']")WebElement signin;
	@FindBy(xpath="//a[@href='https://groceryapp.uniqassosiates.com/admin/list-admin' and @class='small-box-footer']")WebElement addAdminLink;
	@FindBy(xpath="//a[@href='https://groceryapp.uniqassosiates.com/admin/list-category' and@class='small-box-footer']")WebElement moreinfoCategory;
	@FindBy(xpath="//a[@href='https://groceryapp.uniqassosiates.com/admin/list-contact' and@class='small-box-footer']")WebElement moreinfoContact;
	@FindBy(xpath="//a[@href='https://groceryapp.uniqassosiates.com/admin/list-footertext' and@class='small-box-footer']")WebElement moreinfoFooter;
	@FindBy(xpath="//a[@href='https://groceryapp.uniqassosiates.com/admin/list-news' and @class='small-box-footer']")WebElement moreinfoNews;
	public WebDriver driver;
	public LogOutPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	public AdminUsersPage adminUserMoreInfo() {
		addAdminLink.click();
		return new AdminUsersPage(driver);
		
	}
	public ManageCategoryPage clickManageCategoryMoreInfo() {
		moreinfoCategory.click();
		return new ManageCategoryPage(driver);
		
	}
	public ManageContactPage clickMoreInfoContact()
	{
		moreinfoContact.click();
		return new ManageContactPage(driver);
	}
	public ManageFooterTextPage clickManageFooterMoreInfo() {
		moreinfoFooter.click();
		return new ManageFooterTextPage(driver);
	}
	public ManageNewsPage clickManageNewsMoreInfo() {
		moreinfoNews.click();
		return new ManageNewsPage(driver);
	}
public LogOutPage clickAdminButton() {
	admin.click();
	return this;
}
public LogOutPage clickLogOutButton() {
	logout.click();
	return this;
}
public boolean isLoginPageDisplayed() {
	return signin.isDisplayed();
	
}
	
}
