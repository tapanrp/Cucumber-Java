package steps;

import java.util.Set;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;

import io.cucumber.java.en.When;
import pages.HomePage;

public class HomeSteps {
	WebDriver driver;
	HomePage homepage;
	public static final Logger logger = LogManager.getLogger(HomeSteps.class);

	public HomeSteps(BaseSteps basesteps) {
		this.driver = basesteps.getDriver();
	}
	@When("User click on Customers Menu")
	public void user_click_on_customers_menu() {
		homepage = new HomePage(driver);
		System.out.println("HomeSteps:"+driver);
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		homepage.clickCustomerMenu();
	}
	@When("click on Customers Menu Item")
	public void click_on_customers_menu_item() {
		homepage.clickCustomerMenuItem();
	}
	@When("click on Add New Button")
	public void click_on_add_new_button() {
		homepage.clickAddNewButton();
	}

}
