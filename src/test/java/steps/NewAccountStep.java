package steps;

import org.junit.Assert;
import org.openqa.selenium.support.PageFactory;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.LoginPage;
import pages.NewAccountPage;
import pages.TestBase;

public class NewAccountStep extends TestBase {

	NewAccountPage newAccountPage;

	@Before(order = 2)
	public void bankAndCash() {
		newAccountPage = PageFactory.initElements(driver, NewAccountPage.class);
	}

	@And("User enters {string} in the {string} field in accounts page")
	public void user_enters_in_the_field_in_accounts_page(String value, String inputField) {

		switch (inputField) {
		case "accountTitle":
			newAccountPage.accountTitle(value);
			break;

		case "description":
			newAccountPage.description(value);
			;
			break;

		case "initialBalance":
			newAccountPage.initBalance(value);
			;
			break;

		case "accountNumber":
			newAccountPage.accountNum(value);
			break;

		case "contactPerson":
			newAccountPage.contactPerson(value);
			break;

		case "Phone":
			newAccountPage.accountTitle(value);
			break;

		case "internetBankingURL":
			newAccountPage.url(value);
			break;

		default:
			break;
		}

	}

	@Then("User should be able to validate account created successfully")
	public void user_should_be_able_to_validate_account_created_successfully() {

		String expectedAlertSuccess = "Account Created Successfully. Error: Invalid URL. URL Not Updated.";
		String actualAlertSuccess = newAccountPage.alertSuccess();
		Assert.assertEquals(expectedAlertSuccess, actualAlertSuccess);
	}

	@After
	public void tearDown() {
		driver.close();
		driver.quit();
	}

}
