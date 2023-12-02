package steps;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.*;
import pages.CustomerPage;

public class CustomerSteps{
	WebDriver driver;
	CustomerPage customerPage;
	public static final Logger logger = LogManager.getLogger(CustomerSteps.class);

	
	public CustomerSteps(BaseSteps basesteps) {
		this.driver = basesteps.getDriver();
	}

	@Then("User can view Add new customer page")
	public void user_can_view_add_new_customer_page() {
		customerPage = new CustomerPage(driver);
		String expectedTitle = "Add a new customer / nopCommerce administration";
		String actualTitle = driver.getTitle();
		if (actualTitle.equals(expectedTitle)) {
			Assert.assertTrue(true);
			logger.warn("Add new customer page. Test passed.");
		} else {
			Assert.assertTrue(false);
			logger.warn("Add new customer page. Test failed.");
		}
	}

	@When("User enter customer information")
	public void user_enter_customer_information() throws InterruptedException {
		customerPage.enterEmail("abccdefg@wxyz.com");
		customerPage.enterPassword("abcedf");
		customerPage.enterFirstName("Raj");
		customerPage.enterLastName("Patel");
		customerPage.clickGender("female");
		customerPage.enterDob("02/21/1997");
		customerPage.enterCoName("Corus Entertainment Inc");
		customerPage.texExempt();
		customerPage.newLetter("Test store 2");
		customerPage.selectCusomerRol("Guests");
		customerPage.selectVendor();
		customerPage.addAdminComment("This is admin comment.");
		Thread.sleep(5000);
		logger.info("Customer information entered.");
	}

	@When("click on save button")
	public void click_on_save_button() {
		customerPage.saveCustomer();
		logger.info("User click on save button.");
	}

	@Then("User can view confirmation message {string} or can view information message {string}")
	public void user_can_view_confirmation_message_or_can_view_information_message(String confirmMessage, String informMessage) {
		String bodyTagText = driver.findElement(By.tagName("body")).getText();
		System.out.println("Body Text:::"+bodyTagText);
		if ((bodyTagText.contains(confirmMessage)) || (bodyTagText.contains(informMessage))){
			Assert.assertTrue(true); //pass
			logger.warn("User can view confirmation message. Test passed.");
		}else {
			Assert.assertTrue(false); //fail
			logger.warn("User can view confirmation message. Test failed.");
		}
		
	}
}