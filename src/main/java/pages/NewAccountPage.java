package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class NewAccountPage {
	
	WebDriver driver; 
	 public NewAccountPage(WebDriver driver) {
	  this.driver = driver;
	 }

	// Element Library
	@FindBy(how = How.XPATH, using = "//*[@id=\"side-menu\"]/li[10]/a")

	static WebElement BankAndCash;

	@FindBy(how = How.LINK_TEXT, using = "New Account")

	static WebElement NewAccount;

	@FindBy(how = How.ID, using = "account")
	WebElement AccountTitle;

	@FindBy(how = How.CSS, using = "input[id='description']")
	WebElement Description;

	@FindBy(how = How.CSS, using = "input[id='balance']")
	WebElement InitialBalance;

	@FindBy(how = How.XPATH, using = "//input[@name='account_number']")
	WebElement AccountNumber;

	@FindBy(how = How.XPATH, using = "//input[@name='contact_person']")
	WebElement ContactPerson;

	@FindBy(how = How.XPATH, using = "//input[@name='contact_phone']")
	WebElement Phone;

	@FindBy(how = How.XPATH, using = "//input[@name='ib_url']")
	WebElement Url;

	@FindBy(how = How.XPATH, using = "//button[@type='submit']")

	static WebElement Submit;

	@FindBy(how = How.XPATH, using = "//*[@id=\"page-wrapper\"]/div[3]/div[1]")
	WebElement AlertSuccess;

	public static void clickOnBankAndCash() {
		BankAndCash.click();
	}

	public static void clickNewAccount() {
		NewAccount.click();
	}

	public void accountTitle(String title) {
		AccountTitle.sendKeys(title);
	}

	public void description(String desc) {
		Description.sendKeys(desc);
	}

	public void initBalance(String init) {
		InitialBalance.sendKeys(init);
	}

	public void accountNum(String actNum) {
		AccountNumber.sendKeys(actNum);
	}

	public void contactPerson(String contactPsn) {
		ContactPerson.sendKeys(contactPsn);
	}

	public void phone(String phone) {
		Phone.sendKeys(phone);
	}

	public void url(String url) {
		Url.sendKeys(url);
	}

	public static void submit() {
		Submit.click();
	}

	public String alertSuccess() {

		String alert = AlertSuccess.getText();

		return alert;

	}
}
