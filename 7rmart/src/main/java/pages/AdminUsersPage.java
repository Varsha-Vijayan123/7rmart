package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.PageUtility;

public class AdminUsersPage {
	//@FindBy(xpath="//a[@href="https://groceryapp.uniqassosiates.com/admin/list-admin" and @ class="small-box-footer"]")WebElement addAdminLink;
	@FindBy(xpath="//a[@class='btn btn-rounded btn-danger']")WebElement addNewAdminButton;
	@FindBy(xpath="//input[@id='username']")WebElement addNewAdminTextBox;
	@FindBy(xpath="//input[@id='password']")WebElement passwordTextBoxAdmin;
	@FindBy(xpath="//select[@id='user_type']")WebElement selectDropDown;
	@FindBy(xpath="//button[@name='Create']")WebElement saveAdminButton;
	@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']")WebElement alert;
	@FindBy(xpath="//button[@class='btn btn-block-sm btn-info']")WebElement update;
	@FindBy(xpath="//input[@id='username']")WebElement editUsername;
	@FindBy(xpath="//input[@id='password']")WebElement editpassword;
	@FindBy(xpath="//select[@id='user_type']")WebElement editSelectdropdown;
	@FindBy(xpath="//a[@href='https://groceryapp.uniqassosiates.com/admin/user/edit?edit=15579&page_ad=1']")WebElement editIconbutton;
	WebDriver driver;
	public AdminUsersPage(WebDriver driver) 
		{
		this.driver = driver;
		PageFactory.initElements(driver, this);
		}
	
	
	/*public void adminUserMoreInfo()
	{
		addAdminLink.click();
	}*/
	
	public AdminUsersPage clickAddNewAdminButton() {
		addNewAdminButton.click();
		return this;
	}
	
	public AdminUsersPage enterNewAdminUsername(String username) 
	{
		addNewAdminTextBox.sendKeys(username);
		return this;
	}
	
	public AdminUsersPage enterNewAdminPassword(String password) 
	{
		passwordTextBoxAdmin.sendKeys(password);
		return this;
	}
	
	public AdminUsersPage selectUserType() 
	{
		selectDropDown.click();
		//Select select = new Select(selectDropDown);
		//select.selectByVisibleText("Admin");
		PageUtility pageutility = new PageUtility();
		pageutility.selectByVisibleText(selectDropDown, "Admin");
		return this;
	}
	
	public AdminUsersPage clickSaveAdminButton() 
	{
		saveAdminButton.click();
		return this;
	}
	public AdminUsersPage update()
	{
		update.click();
		return this;
	}
	public AdminUsersPage clickEditIcon() {
		editIconbutton.click();
		return this;
	}
	public AdminUsersPage editUsername(String updatedUsername) {
		editUsername.clear();
		editUsername.sendKeys(updatedUsername);
		return this;
		
	}
	public AdminUsersPage editPassword(String updatedPassword) {
		editpassword.clear();
		editpassword.sendKeys(updatedPassword);
		return this;
	}
	public AdminUsersPage editUsertype() {
		editSelectdropdown.click();
		PageUtility pageutility=new PageUtility();
		pageutility.selectByVisibleText(editSelectdropdown, "Staff");
		return this;
	}
	public boolean isAlertDisplayed() 
	{
		return alert.isDisplayed();
	}
	

}



