package steps;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import io.cucumber.java.en.*;
import pages.SearchPage;

public class SearchSteps {
	WebDriver driver;
	SearchPage searchpage;
	public static final Logger logger = LogManager.getLogger(SearchSteps.class);

	public SearchSteps(BaseSteps basestep) {
		this.driver = basestep.getDriver();
		searchpage = new SearchPage(driver);
	}

	@When("Enter customer's email")
	public void enter_customer_s_email() throws InterruptedException {
		String email = "brenda_lindgren@nopCommerce.com";
		searchpage.enterSearchEmail(email);
		Thread.sleep(5000);

	}

	@When("Enter customer's email {string}")
	public void enter_customer_s_email(String emailToSearch) {
		searchpage.enterSearchEmail(emailToSearch);
	}

	@When("Click on search button")
	public void click_on_search_button() {
		searchpage.clickSearchButton();
	}

	@Then("User should found the email in the search table")
	public void user_should_found_the_email_in_the_search_table() throws InterruptedException {
		String emailToSearch = "brenda_lindgren@nopCommerce.com";
		List<WebElement> rows = searchpage.listOfResultRow();
		boolean emailFound = false;
		int attempts = 0;
		while (attempts < 2) {

			try {
				for (int i = 0; i < rows.size(); i++) {
					List<WebElement> cols = rows.get(i).findElements(By.tagName("td"));
					System.out.println("cols.size::"+cols.size());
					for (int j = 0; j < cols.size(); j++) {
						System.out.println("Checking cell..."+ cols.get(j).getText());
						if(cols.get(j).getText().equals(emailToSearch)) {
							System.out.println("Email Fond!!"+cols.get(j).getText());
							emailFound = true;
							break;
						}
						if(emailFound) {
							break;
						}
					}
					
				}
				if(emailFound) {
					Assert.assertTrue(true);
				}else {
					Assert.assertTrue(false);
				}
				break;

			} catch (StaleElementReferenceException e) {
				rows = searchpage.listOfResultRow();
				attempts++;
			}
		}

	}

	@Then("User should found the email {string} in the search table")
	public void user_should_found_the_email_in_the_search_table(String emailToSearch) {
		boolean emailFound = false;
		List<WebElement> rows = searchpage.listOfResultRow();
		int attempts = 0;
		while(attempts<2) {
		try {
			for (int i = 0; i < rows.size(); i++) {
					List<WebElement> cols = rows.get(i).findElements(By.tagName("td"));
					for (int j = 0; j < cols.size(); j++) {
						System.out.println("Checking cell: "+ cols.get(j).getText());
						if (cols.get(j).getText().equals(emailToSearch)) {
							System.out.println("Email Found!!" + cols.get(j).getText());
							emailFound = true;
							break;
						}
					}
					if(emailFound) {
						break;
					}
					
			}
			if(emailFound) {
				Assert.assertTrue(true);
			}else {
				Assert.assertTrue(false);
			}
			break;
		} catch (StaleElementReferenceException e) {
			rows = searchpage.listOfResultRow();
			attempts++;		
		}
		}	

	}

	@When("Enter customer's first name {string} and last name {string}")
	public void enter_customer_s_first_name_and_last_name(String firstname, String lastname) {
		searchpage.enterFirstandLastName(firstname, lastname);
	}

	@Then("User should found the first name {string} and last name {string} in the search table")
	public void user_should_found_the_first_name_and_last_name_in_the_search_table(String firstname, String lastname) {
		boolean namefound = false;
		List<WebElement> rows = searchpage.listOfResultRow();
		String name = firstname + " " + lastname;
		int attempts = 0;

		while (attempts < 2) {
			try {
				for (int i = 0; i < rows.size(); i++) {
					List<WebElement> cols = rows.get(i).findElements(By.tagName("td"));
					for (int j = 0; j < cols.size(); j++) {
						System.out.println("Checking cell " + cols.get(j).getText());
						if (cols.get(j).getText().equals(name)) {
							System.out.println("Name Found!!" + cols.get(j).getText());
							namefound = true;
							break;
						}
					}
					if (namefound) {
						break;
					}
				}
				if (namefound) {
					Assert.assertTrue(true);
				} else {
					Assert.assertTrue(false);
				}
				break;
			} catch (StaleElementReferenceException e) {
				rows = searchpage.listOfResultRow();
				attempts++;
			}
		}

	}

	@Then("User1 should found the email {string} in the search table")
	public void user1_should_found_the_email_in_the_search_table(String expectedEmailInResult) {

		boolean notfound = false;
		List<WebElement> rows = searchpage.listOfResultRow();
		int attempts = 0;
		System.out.println(expectedEmailInResult);
		while (attempts < 2) {
			try {
				for (int i = 0; i < rows.size(); i++) {
					List<WebElement> cols = rows.get(i).findElements(By.tagName("td"));
					for (int j = 0; j < cols.size(); j++) {
						System.out.println("Checking cell: " + cols.get(j).getText());
						if (cols.get(j).getText().equals(expectedEmailInResult)) {
							notfound = true;
							System.out.println("Email Found!!" + cols.get(j).getText());
							break;
						}
					}
					if (notfound) {
						break;
					}
				}
				if (notfound) {
					Assert.assertTrue(true);
				} else {
					Assert.assertTrue(false);
				}
				break;
			} catch (StaleElementReferenceException e) {
				rows = searchpage.listOfResultRow();
				attempts++;
			}
		}
	}

	@Then("User1 should found the email {string} in the search table counter {int}")
	public void user1_should_found_the_email_in_the_search_table_counter(String expectedEmailInResult,
			Integer counter) {
		boolean notfound = false;
		List<WebElement> rows = searchpage.listofResultRow1(counter);
		counter++;
		int attempts = 0;
		System.out.println(expectedEmailInResult);
		while (attempts < 2) {
			try {
				for (int i = 0; i < rows.size(); i++) {
					List<WebElement> cols = rows.get(i).findElements(By.tagName("td"));
					for (int j = 0; j < cols.size(); j++) {
						System.out.println("Checking cell: " + cols.get(j).getText());
						if (cols.get(j).getText().equals(expectedEmailInResult)) {
							notfound = true;
							System.out.println("Email Found!!" + cols.get(j).getText());
							break;
						}
					}
					if (notfound) {
						break;
					}
				}
				if (notfound) {
					Assert.assertTrue(true);
				} else {
					Assert.assertTrue(false);
				}
				break;
			} catch (StaleElementReferenceException e) {
				rows = searchpage.listofResultRow1(counter);
				attempts++;
				counter++;
			}
		}

	}

}