package steps;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.AfterClass;
import org.junit.Assert;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import pages.HomePage;
import pages.LoginPage;

public class LoginSteps {
	WebDriver driver;
	LoginPage loginpage;
	String adminPageWH;
	HomeSteps homesteps;
	public static final Logger logger = LogManager.getLogger(LoginSteps.class);

	public LoginSteps(BaseSteps basestep) {
		this.driver = basestep.getDriver();
	}

	@Given("User launch chrome browser")
	public void user_launch_chrome_browser() {
		loginpage = new LoginPage(driver);
		logger.info("Browser launched.");
	}

	@When("User opens URL {string}")
	public void user_opens_url(String url) {
		loginpage.goToLoginPage(url);
		logger.warn("URL opened.");
	}

	@When("User enters email as {string} and password as {string}")
	public void user_enters_email_as_and_password_as(String email, String password) {
		loginpage.enterEmail(email);
		loginpage.eneterPassword(password);
		logger.info("User enters email and password.");
	}

	@When("User click login button")
	public void user_click_login_button() {
		loginpage.clickLogingButton();
		logger.info("User clicks login button.");
	}

	@Then("User can view Dashboard")
	public void user_can_view_dashboard() {
		String actualTitle = driver.getTitle();
		String expectedTitle = "Dashboard / nopCommerce administration";
		if (actualTitle.equals(expectedTitle)) {
			Assert.assertTrue(true); // pass
			logger.warn("User can view dashboard. actual title matches expected title. Test passed.");

		} else {
			Assert.assertTrue(false); // fail
			logger.error("Actual title not matches with expected title. Test failed.");
		}

	}

	@When("User click logout")
	public void user_click_logout() {
		loginpage.clickLogout();
		logger.info("User clicked logout.");
		BaseSteps.logger.warn("User clicked logout. BaseSteps");

	}


	@Then("Page title should be {string}")
	public void page_title_should_be(String string) {
	}

	@After
	public void teardown(Scenario sc) {
		long number = System.currentTimeMillis();
		String screenshotFile = System.getProperty("user.dir") + File.separator + "screenshots" + File.separator
				+ "screenshot" + number + ".png";
		System.out.println(screenshotFile);
		if (sc.isFailed()) {
			System.out.println("I am inside if..." + sc.isFailed());
			TakesScreenshot screenshot = (TakesScreenshot) driver;
			File tmp = screenshot.getScreenshotAs(OutputType.FILE);
			File fos = new File(screenshotFile);
			final byte[] screenshotExtentReport = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
			//attach screenshot to the report
			sc.attach(screenshotExtentReport, "image/png", sc.getName());
			logger.warn("Test failed. Screenshots attached.");
			BaseSteps.logger.warn("Test failed. Screenshots attached. BaseSteps");
			try {
				FileUtils.moveFile(tmp, fos);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
