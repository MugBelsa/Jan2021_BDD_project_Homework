
package steps;



import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import cucumber.api.PendingException;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import page.BankAndCashPage;
import page.LoginPageH;

public class BankAndCashSteps {

	WebDriver driver;
	LoginPageH loginPage;
	BankAndCashPage bankandcash;
	
	
//	@When("^user clicks on Bank and Cash Button$")
//	public void user_clicks_on_Bank_and_Cash_Button() throws Throwable {
//		bankandcash = PageFactory.initElements(driver, BankAndCashPage.class);
//		Thread.sleep(1000);
//		bankandcash.bank_And_cash();
//		Thread.sleep(1000);
//	}

	@Then("^user should be able to click on New Account$")
	public void user_should_be_able_to_click_on_New_Account() throws Throwable {
		Thread.sleep(2000);
		bankandcash = PageFactory.initElements(driver, BankAndCashPage.class);
		bankandcash.New_account();
		Thread.sleep(2000);

	}

	@Then("^user should be able to fill up the form by entering \"([^\"]*)\" and \"([^\"]*)\" and \"([^\"]*)\" and \"([^\"]*)\" and \"([^\"]*)\" and \"([^\"]*)\" and \"([^\"]*)\"$")
	public void user_should_be_able_to_fill_up_the_form_by_entering_and_and_and_and_and_and(String accountTitle,
			String description, String initial_balance, String account_number, String contact_person,
			String phone_number, String Internet_Banking_URL) throws Throwable {
		bankandcash = PageFactory.initElements(driver, BankAndCashPage.class);
		bankandcash.enterCredentialsForNewAccount("savings Account", "My business account", "500000 ", "28965562",
				"MichFish", "825-456-3156", "www.bofa.com");
		bankandcash.randomNumber(account_number);
		bankandcash.randomNumForAccount(accountTitle);
	}

	@Then("^user should be able to click on Submitt Button$")
	public void user_should_be_able_to_click_on_Submitt_Button() throws Throwable {
		bankandcash = PageFactory.initElements(driver, BankAndCashPage.class);
		bankandcash.Submit_Button_field();
		Thread.sleep(2000);
		loginPage.takeScreenShotsAtOfTest(driver);

	}

}
