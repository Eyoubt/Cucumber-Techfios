package steps;

import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.PageFactory;

import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.LoginPage;
import pages.NewAccountPage;
import pages.TestBase;

public class LoginStep extends TestBase {

	LoginPage loginPage;

	@Before(order = 1)
	public void beforeRun() {
		initDriver();
		loginPage = PageFactory.initElements(driver, LoginPage.class);
	}

	@Given("User is on the techfios login page")
	public void user_is_on_the_techfios_login_page() {
		driver.get("https://techfios.com/billing/?ng=login/");

	}

	@When("User enters the {string} in the {string} field")
	public void user_enters_the_in_the_field(String value, String inputField) {

		if (inputField.equalsIgnoreCase("username")) {
			loginPage.enterUserName(value);
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else if (inputField.equalsIgnoreCase("password")) {
			loginPage.enterPassword(value);
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	@Then("User should land on Dashboard page")
	public void user_should_land_on_dashboard_page() {
		String expectedTitle = "Dashboard- iBilling";
		String actualTitle = loginPage.getPageTitle();
		Assert.assertEquals(expectedTitle, actualTitle);

	}

	@And("User clicks on {string}")
	public void user_clicks_on(String btn) {
		if (btn.equalsIgnoreCase("login")) {
			loginPage.clickSignInButton();

		} else if (btn.equalsIgnoreCase("bankCash")) {
			NewAccountPage.clickOnBankAndCash();
		} else if (btn.equalsIgnoreCase("newAccount")) {
			NewAccountPage.clickNewAccount();
		} else if (btn.equalsIgnoreCase("submit")) {

			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(0,100)");

			NewAccountPage.submit();

		}
	}

}
