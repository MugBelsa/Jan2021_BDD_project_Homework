
package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.Select;

public class BankAndCashPage extends BasePage {

	WebDriver driver;

	public BankAndCashPage(WebDriver driver) {

		this.driver = driver;
	}

	@FindBy(how = How.XPATH, using = "//input[@id='username']")
	WebElement User_Name;

	@FindBy(how = How.XPATH, using = "//input[@id='password']")
	WebElement Password;

	@FindBy(how = How.XPATH, using = "//button[@name='login']")
	WebElement SignIn;

	@FindBy(how = How.XPATH, using = "//span[contains(text(),'Bank & Cash')]")
	WebElement Bank_And_Cash_field;

	@FindBy(how = How.XPATH, using = "//a[contains(text(),'New Account')]")
	WebElement New_account_field;

	@FindBy(how = How.XPATH, using = "//input[@name=\"account\"]")
	WebElement AccountTitle_field;

	@FindBy(how = How.XPATH, using = "//input[@id=\"description\"]")
	WebElement Description_field;

	@FindBy(how = How.XPATH, using = "//input[@id=\"balance\"]")
	WebElement InitialBalance_field;

	@FindBy(how = How.XPATH, using = "//input[@id=\"account_number\"]")
	WebElement AccountNumber_field;

	@FindBy(how = How.XPATH, using = "//input[@id=\"contact_person\"]")
	WebElement ContactPerson_field;

	@FindBy(how = How.XPATH, using = "//input[@id=\"contact_phone\"]")
	WebElement Phone_Number_field;

	@FindBy(how = How.XPATH, using = "//input[@id=\"ib_url\"]")
	WebElement InternetBankingURL_field;

	@FindBy(how = How.XPATH, using = "//button[@class=\"btn btn-primary\"]")
	WebElement Submit_Button;

	public void bank_And_cash() {
		Bank_And_Cash_field.click();

	}

	/*
	 * public void selectDropdown(String bankandCash) { Select sel = new
	 * Select(bankandCash); sel.selectByVisibleText(value);
	 * selectDropdown(Bank_And_Cash_field, bankandCash);
	 * 
	 * }
	 */
	public void New_account() {
		New_account_field.click();

	}

	public void enterCredentialsForNewAccount(String accountTitle, String description, String initial_balance,
			String account_number, String contact_person, String phone_number, String Internet_Banking_URL) {
		AccountTitle_field.sendKeys(accountTitle);
		Description_field.sendKeys(description);
		InitialBalance_field.sendKeys(initial_balance);
		AccountNumber_field.sendKeys(account_number);
		ContactPerson_field.sendKeys(contact_person);
		Phone_Number_field.sendKeys(phone_number);
		InternetBankingURL_field.sendKeys(Internet_Banking_URL);

	}

	public void randomNumber(String account_number) {

		AccountNumber_field.sendKeys(generateNumber(999) + account_number);
	}

	public void randomNumForAccount(String accountTitle) {

		AccountTitle_field.sendKeys(generateNumber(999) + accountTitle);
	}

	public void Submit_Button_field() {
		Submit_Button.click();

	}

}
