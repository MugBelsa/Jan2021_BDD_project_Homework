package steps;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import cucumber.api.PendingException;
import cucumber.api.java.After;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import junit.framework.Assert;
import page.BankAndCashPage;
import page.BasePage;
import page.LoginPageH;
import util.BrowserFactoryH;

public class LoginStepsDef {

	WebDriver driver;
	LoginPageH loginPage;
	BasePage basepage;

	@Given("^User is on the Techfios login page$")
	public void User_is_on_the_Techfios_login_page() {
		driver = BrowserFactoryH.startBrowser();
	}

	@When("^user should be able to enter the \"([^\"]*)\" and \"([^\"]*)\"$")
	public void user_should_be_able_to_enter_the_and(String username, String password) throws Throwable {
		loginPage = PageFactory.initElements(driver, LoginPageH.class);
		loginPage.enterCredentials(username, password);
		Thread.sleep(2000);
	}

	@When("^user should be able to click on signin button$")
	public void user_should_be_able_to_click_on_signin_button() throws Throwable {
		loginPage = PageFactory.initElements(driver, LoginPageH.class);
		loginPage.clickOnSignInButton();
		Thread.sleep(2000);
	}

	@Then("^user should be able to land on the Dashboard page$")
	public void user_should_be_able_to_land_on_the_Dashboard_page() throws Throwable {
		String expectedTitle = "Dashboard- iBilling";
		String actualTitle = loginPage.getPageTitle();
		Assert.assertEquals(expectedTitle, actualTitle);
		loginPage.takeScreenShotsAtOfTest(driver);
	}
	@Then("^user clicks on Bank and Cash Button$")
	public void user_clicks_on_Bank_and_Cash_Button() throws Throwable {
		loginPage = PageFactory.initElements(driver, LoginPageH.class);
		Thread.sleep(1000);
		loginPage.bank_And_cash();
		Thread.sleep(1000);
	}

//	@After
//	public void tearDown() {
//
//		driver.close();
//		driver.quit();
//	}

}
