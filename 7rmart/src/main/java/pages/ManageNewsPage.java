package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import utilities.PageUtility;
import utilities.WaitUtility;

public class ManageNewsPage {
	// @FindBy(xpath="//a[@href='https://groceryapp.uniqassosiates.com/admin/list-news'
	// and @class='small-box-footer']")WebElement moreinfo;
	@FindBy(xpath = "//a[@class='btn btn-rounded btn-danger']")
	WebElement addNewbutton;
	@FindBy(xpath = "//textarea[@id='news']")
	WebElement newsTextBox;
	@FindBy(xpath = "//button[@class='btn btn-danger']")
	WebElement saveButton;
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
	WebElement alert;
	@FindBy(xpath = "(//a[@class='btn btn-sm btn btn-primary btncss'])[1]")
	WebElement editNewsButton;
	@FindBy(xpath = "//textarea[@placeholder='Enter the news']")
	WebElement editNewsTextBox;
	@FindBy(xpath = "//button[@name='update']")
	WebElement updateNewsButton;

	public WebDriver driver;

	public ManageNewsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	/*
	 * public ManageNewsPage clickMoreInfo() { moreinfo.click(); return this;
	 * 
	 * }
	 */
	public ManageNewsPage clickNewButton() {
		addNewbutton.click();
		return this;

	}

	public ManageNewsPage enterTheNews(String news) {
		newsTextBox.sendKeys(news);
		return this;

	}

	public ManageNewsPage clickSaveButton() {
		WaitUtility waitutility = new WaitUtility();
		waitutility.waitForElementToBeClickable(driver, saveButton);

		PageUtility pageutility = new PageUtility();
		pageutility.javaScriptScrollToBottom(driver);
		pageutility.javaScriptClick(driver, saveButton);
		return this;

	}

	public ManageNewsPage clickEditNewsButton() {
		editNewsButton.click();
		return this;

	}

	public ManageNewsPage editNews(String updatednews) {
		editNewsTextBox.clear();
		editNewsTextBox.sendKeys(updatednews);
		return this;
	}

	public ManageNewsPage clickUpdateNewsButton() {
		WaitUtility waitutility = new WaitUtility();
		waitutility.waitForElementToBeClickable(driver, updateNewsButton);

		PageUtility pageutility = new PageUtility();
		pageutility.javaScriptScrollToBottom(driver);
		pageutility.javaScriptClick(driver, updateNewsButton);
		return this;

	}

	public boolean isAlertDisplayed() {

		return alert.isDisplayed();
	}

}
