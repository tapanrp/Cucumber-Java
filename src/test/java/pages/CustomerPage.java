package pages;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeoutException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CustomerPage {
	WebDriver driver;

	//Find web element on web page
	@FindBy(id = "Email")
	WebElement email;
	@FindBy(id = "Password")
	WebElement password;
	@FindBy(id = "FirstName")
	WebElement firstname;
	@FindBy(id = "LastName")
	WebElement lastname;
	@FindBy(id = "Gender_Male")
	WebElement genderMale;
	@FindBy(id = "Gender_Female")
	WebElement genderFemale;
	@FindBy(id = "DateOfBirth")
	WebElement dateofbirth;
	@FindBy(id = "Company")
	WebElement company;
	@FindBy(id = "IsTaxExempt")
	WebElement taxExempt;
	@FindBy(linkText="nopCommerce")
	WebElement selectNews;
	@FindBy(id="AdminComment")
	WebElement adminComment;
	@FindBy(xpath="//input[@class='k-input k-readonly']")
	WebElement newsSelect;
	@FindBy(linkText="nopCommerce")
	WebElement scrollView;
	@FindBy(xpath="//input[@aria-labelledby='SelectedCustomerRoleIds_label']")
	WebElement customerRole;
	@FindBy(xpath="//select[@id='VendorId']/option[2]")
	WebElement vendor;
	@FindBy(xpath="//button[@name='save']")
	WebElement saveCustomer;

	//constructor
	public CustomerPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	
	//Action methods for the web elements
	
	public String getPageTitle() {
		return driver.getTitle();
		
	}
	
	public void enterEmail(String emailText) {
		email.sendKeys(emailText);
	}
	
	public void enterPassword(String passwordT) {
		password.sendKeys(passwordT);
	}
	
	public void enterFirstName(String fname) {
		firstname.sendKeys(fname);
	}
	
	public void enterLastName(String lname) {
		lastname.sendKeys(lname);
	}
	
	public void clickGender(String gender) {
		if(gender.equalsIgnoreCase("Male")) {
			genderMale.click();
		}else if(gender.equalsIgnoreCase("Female")) {
			genderFemale.click();
		}else {
			genderMale.click(); // default
		}
	}
	
	public void enterDob(String dob) {
		dateofbirth.sendKeys(dob);
	}
	
	public void enterCoName(String coName) {
		company.sendKeys(coName);
	}
	
	public void texExempt() {
		taxExempt.click();
	}
	
	public void addAdminComment(String comment) {
		adminComment.sendKeys(comment);
	}
	
	public void newLetter(String newsletter) {
		Actions actions = new Actions(driver);
		actions.click(newsSelect).sendKeys(newsletter).sendKeys(Keys.ARROW_DOWN).pause(Duration.ofSeconds(2)).sendKeys(Keys.ENTER).perform();

	}
	
	public void selectCusomerRol(String customerrol) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", scrollView);
		Actions actions = new Actions(driver);
		actions.click(customerRole).sendKeys(Keys.BACK_SPACE).perform();
		actions.click(customerRole).sendKeys(customerrol).sendKeys(Keys.ARROW_DOWN).pause(Duration.ofSeconds(2)).sendKeys(Keys.ENTER).perform();
	}
	
	public void selectVendor() {
		vendor.click();
	}
	
	public void saveCustomer() {
		saveCustomer.click();
	}
	
}

///////////////////////////////////
//actions.click(newsLetterN).pause(Duration.ofSeconds(10)).click(newsLetterN).sendKeys(newsletter).sendKeys(Keys.ENTER).perform();
//actions.click(newsLetterN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).perform();
//actions.click(newsLetterN).sendKeys("Your store name").sendKeys(Keys.ARROW_DOWN).perform();
//actions.click(newsLetterN).sendKeys(newsletter).perform();
//WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

//wait.until(ExpectedConditions.attributeToBe(newsLetterN, "value", "1"));
//actions.sendKeys(Keys.ENTER).perform();

//wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//option[@value='1' and @selected='selected']")));
//actions.sendKeys(Keys.ENTER).perform();
//JavascriptExecutor js = (JavascriptExecutor) driver;
//js.executeScript("arguments[0].scrollIntoView();", newsSelect);
//WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
//wait.until(ExpectedConditions.visibilityOf(newsSelect));
//js.executeScript("arguments[0].display.style='inline';", newsSelect);
//selectOption1(newsLetter);
