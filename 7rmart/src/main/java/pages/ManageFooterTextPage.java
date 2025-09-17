package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.PageUtility;
import utilities.WaitUtility;

public class ManageFooterTextPage {
	// @FindBy(xpath="//a[@href='https://groceryapp.uniqassosiates.com/admin/list-footertext'
	// and@class='small-box-footer']")WebElement moreinfo;
	@FindBy(xpath = "//a[@href=\"https://groceryapp.uniqassosiates.com/admin/Footertext/edit?edit=1\"]")
	WebElement editIcon;
	@FindBy(xpath = "//textarea[@id='content']")
	WebElement addAddress;
	@FindBy(xpath = "//input[@id='email']")
	WebElement addEmail;
	@FindBy(xpath = "//input[@id='phone']")
	WebElement addPhone;
	@FindBy(xpath = "//button[@name='Update']")
	WebElement update;
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
	WebElement alert;
	public WebDriver driver;

	public ManageFooterTextPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	/*
	 * public ManageFooterTextPage clickMoreInfo() { moreinfo.click(); return this;
	 * }
	 */
	public ManageFooterTextPage clickEditIcon() {
		editIcon.click();
		return this;
	}

	public ManageFooterTextPage addAddress(String address) {
		addAddress.clear();
		addAddress.sendKeys(address);
		return this;
	}

	public ManageFooterTextPage addEmail(String mailid) {
		addEmail.clear();
		addEmail.sendKeys(mailid);
		return this;
	}

	public ManageFooterTextPage addPhone(String phoneno) {
		addPhone.clear();
		addPhone.sendKeys(phoneno);
		return this;
	}

	public ManageFooterTextPage clickUpdatebutton() {
		WaitUtility waitutility = new WaitUtility();
		waitutility.waitForElementToBeClickable(driver, update);

		PageUtility pageutility = new PageUtility();
		pageutility.javaScriptScrollToBottom(driver);
		pageutility.javaScriptClick(driver, update);
		return this;
	}

	public boolean isAlertDisplayed() {
		return alert.isDisplayed();
	}

}
