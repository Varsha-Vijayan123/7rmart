package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.PageUtility;

public class ManageContactPage {
	// @FindBy(xpath="//a[@href='https://groceryapp.uniqassosiates.com/admin/list-contact'
	// and@class='small-box-footer']")WebElement moreinfo;
	@FindBy(xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/contact/edit_contact?edit=1']")
	WebElement editIcon;
	@FindBy(xpath = "//input[@id='phone']")
	WebElement addphoneno;
	@FindBy(xpath = "//input[@id='email']")
	WebElement addemail;
	@FindBy(xpath = "//textarea[@placeholder='Enter the Address']")
	WebElement addaddress;
	@FindBy(xpath = "//textarea[@placeholder='Enter Delivery Time']")
	WebElement adddeliverytime;
	@FindBy(xpath = "//input[@id='del_limit']")
	WebElement adddeliverychargelimit;
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
	WebElement alert;
	@FindBy(xpath = "//button[@class='btn btn-block-sm btn-info']")
	WebElement update;
	public WebDriver driver;

	public ManageContactPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	/*
	 * public ManageContactPage clickMoreInfo() { moreinfo.click(); return this; }
	 */
	public ManageContactPage clickEditIcon() {
		editIcon.click();
		return this;
	}

	public ManageContactPage addPhoneno(String phoneno) {
		addphoneno.clear();
		addphoneno.sendKeys(phoneno);
		return this;
	}

	public ManageContactPage addEmail(String email) {
		addemail.clear();
		addemail.sendKeys(email);
		return this;
	}

	public ManageContactPage addAddress(String address) {
		addaddress.clear();
		addaddress.sendKeys(address);
		return this;
	}

	public ManageContactPage addDeliveryTime(String deliverytime) {
		adddeliverytime.clear();
		adddeliverytime.sendKeys(deliverytime);
		return this;
	}

	public ManageContactPage addDeliveryChargeLimit(String deliverychargelimit) {
		adddeliverychargelimit.clear();
		adddeliverychargelimit.sendKeys(deliverychargelimit);
		return this;
	}

	public ManageContactPage update() {

		PageUtility pageutility = new PageUtility();
		pageutility.javaScriptScrollToBottom(driver);
		pageutility.javaScriptClick(driver, update);
		return this;
	}

	public boolean isAlertDisplayed() {
		return alert.isDisplayed();

	}
}
