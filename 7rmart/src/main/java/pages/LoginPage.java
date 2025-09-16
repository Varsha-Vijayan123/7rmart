package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	public WebDriver driver;
	@FindBy(xpath="//input[@placeholder='Username']")WebElement username;
	@FindBy(xpath="//input[@placeholder='Password']")WebElement password;
	@FindBy(xpath="//button[@type='submit']")WebElement signin;
	@FindBy(xpath="//p[text()='Dashboard']")WebElement dashboard;
	@FindBy(xpath="//div[@class='alert alert-danger alert-dismissible']")WebElement alert;
	@FindBy(xpath="//input[@id='login-button']")WebElement login;
	//constructor to initialize the WebDriver and PageFactory elements
	public LoginPage(WebDriver driver) {
		
		this.driver=driver;
		PageFactory.initElements(driver, this);
		//PageFactory:Class
		//initElements:Method that tells selenium to locate elements marked with @FindBy annotations
	}
	public LoginPage enterUsername(String user1) {
		username.sendKeys(user1);
		return this;
		
	}
public LoginPage enterPassword(String pass1) {
	password.sendKeys(pass1);
	return this;
		
	}
public LogOutPage clickSigninButton() {
	signin.click();
	return new LogOutPage(driver);
	
}
	public boolean isHomePageLoaded() {
		return dashboard.isDisplayed();
	}
	public boolean isAlertDisplayed() {
		return alert.isDisplayed();
	}
}
