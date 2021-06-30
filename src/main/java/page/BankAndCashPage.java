
package page;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

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

	@FindBy(how = How.XPATH, using = "//*[@id=\"side-menu\"]/li[10]/a/span[2]")
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
	
	@FindBy(how = How.XPATH, using = "//div[@class=\"alert alert-success fade in\"]")
	WebElement Validation_successScreen;
	

	
	public void New_account() {
		New_account_field.click();

	}

	public void enterCredentialsForAccount(String accountTitle, String description, String initial_balance,
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
	public String getMessage() {
	 return driver.getTitle();
	 
	}
	public void takeScreenShotsAtOfTest(WebDriver driver) throws IOException {

		TakesScreenshot ts = ((TakesScreenshot) driver);
		File sourceFile = ts.getScreenshotAs(OutputType.FILE);
		SimpleDateFormat formatter = new SimpleDateFormat("MMddyy_HHmmss");
		Date date = new Date();
		String label = formatter.format(date);
		String currentDirectory = System.getProperty("user.dir");
		FileUtils.copyFile(sourceFile, new File(currentDirectory + "/screenshot/" + label + ".png"));

	}
	
	
	
	//div[@class="alert alert-success fade in"]

}
