package steps;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

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
	BankAndCashPage bankandcash;
	
	

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

	@Then("^user should be able to click on the New Account$")
	public void user_should_be_able_to_click_on_the_New_Account() throws Throwable {
		Thread.sleep(2000);
		bankandcash = PageFactory.initElements(driver, BankAndCashPage.class);
		bankandcash.New_account();
		Thread.sleep(2000);

	}

	@Then("^user should fill the form by entering \"([^\"]*)\" and \"([^\"]*)\" and \"([^\"]*)\" and \"([^\"]*)\" and \"([^\"]*)\" and \"([^\"]*)\" and \"([^\"]*)\"$")
	public void user_should_fill_the_form_by_entering_and_and_and_and_and_and(String accountTitle,
			String description, String initial_balance, String account_number, String contact_person,
			String phone_number, String Internet_Banking_URL) throws Throwable {
		bankandcash = PageFactory.initElements(driver, BankAndCashPage.class);
		bankandcash.enterCredentialsForAccount(accountTitle, description, initial_balance, account_number, contact_person,
			 phone_number, Internet_Banking_URL);
		bankandcash.randomNumber(account_number);
		bankandcash.randomNumForAccount(accountTitle);
	}

	@Then("^user should be click on Submitt Button$")
	public void user_should_be_click_on_Submitt_Button() throws Throwable {
		bankandcash = PageFactory.initElements(driver, BankAndCashPage.class);
		bankandcash.Submit_Button_field();
		Thread.sleep(2000);
		loginPage.takeScreenShotsAtOfTest(driver);

	}
	@Then("^validate Accounts$")
	public void validate_Accounts() throws Throwable {
		String expectedTitle = "Accounts- iBilling";
		String actualTitle = bankandcash.getMessage();
		Assert.assertEquals(expectedTitle, actualTitle);
		System.out.println("Account created!!!");
		bankandcash.takeScreenShotsAtOfTest(driver);
	}
	

	
	//class="alert alert-success fade in"
	
	@After
	public void tearDown() {

		driver.close();
		driver.quit();
	}

}
