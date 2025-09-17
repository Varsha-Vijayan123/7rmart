package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import constant.Constant;
import utilities.FileUploadUtility;
import utilities.PageUtility;
import utilities.WaitUtility;

public class ManageCategoryPage {
	// @FindBy(xpath="//a[@href='https://groceryapp.uniqassosiates.com/admin/list-category'
	// and @ class='small-box-footer']")WebElement moreinfo;
	@FindBy(xpath = "//a[@class='btn btn-rounded btn-danger']")
	WebElement addNewCategoryButton;
	@FindBy(xpath = "//input[@id='category']")
	WebElement categorynametextbox;
	@FindBy(xpath = "//input[@name='main_img']")
	WebElement chooseFileButton;
	@FindBy(xpath = "//button[text()='Save']")
	WebElement savebutton;
	@FindBy(xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/category/edit?edit=2891&page_ad=1']")
	WebElement editIcon;
	@FindBy(xpath = "//input[@id='main_img']")
	WebElement chooseFileButtonInAddNewCategory;
	@FindBy(xpath = "//button[@name='update']")
	WebElement update;
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
	WebElement alert;
	@FindBy(xpath = "//b[text()='Fatal error']")
	WebElement errorException;

	public WebDriver driver;

	public ManageCategoryPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	/*
	 * public ManageCategoryPage clickMoreInfo() { moreinfo.click(); return this;
	 * 
	 * }
	 */
	public ManageCategoryPage clickEditIcon() {
		editIcon.click();
		return this;
	}

	public ManageCategoryPage clickChooseFileButton() {
		// chooseFileButton.sendKeys(filepath);
		FileUploadUtility fileuploadutility = new FileUploadUtility();
		fileuploadutility.fileUploadUsingSendkeys(chooseFileButton, Constant.TESTIMAGEFILE);
		return this;
	}

	public ManageCategoryPage addCategory(String categoryName) {
		categorynametextbox.sendKeys(categoryName);
		return this;

	}

	public ManageCategoryPage clickSavebutton() {

		WaitUtility waitutility = new WaitUtility();
		waitutility.waitForElementToBeClickable(driver, savebutton);

		PageUtility pageutility = new PageUtility();
		pageutility.javaScriptScrollToBottom(driver);
		pageutility.javaScriptClick(driver, savebutton);

		return this;

	}

	public ManageCategoryPage clickUpdatebutton() {
		WaitUtility waitutility = new WaitUtility();
		waitutility.waitForElementToBeClickable(driver, update);

		PageUtility pageutility = new PageUtility();
		pageutility.javaScriptScrollToBottom(driver);
		pageutility.javaScriptClick(driver, update);

		return this;

	}

	public ManageCategoryPage clickChooseFileButtonInAddNewCategory() {
		FileUploadUtility fileuploadutility = new FileUploadUtility();
		fileuploadutility.fileUploadUsingSendkeys(chooseFileButtonInAddNewCategory, Constant.TESTIMAGEFILE2);
		return this;

	}

	public ManageCategoryPage clickAddNewCategoryButton() {
		addNewCategoryButton.click();
		return this;
	}

	public boolean isAlertDisplayed() {
		try {

			return alert.isDisplayed();
		} catch (Exception e) {
			System.out.println("Uncaught Error Exception");
			return false;

		}

	}

}
