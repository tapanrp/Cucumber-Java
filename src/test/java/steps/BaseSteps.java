package steps;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.logging.log4j.*;
import pages.HomePage;
import pages.LoginPage;

public class BaseSteps {
	private WebDriver driver;
	public static final Logger logger = LogManager.getLogger(BaseSteps.class);
	

	@Before
	public void setup() {
		if(driver == null) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
			logger.warn("driver created..");
		}
		
		
	}

	public WebDriver getDriver() {
		return driver;
		
	}
	
	@Then("close browser")
	public void close_browser() {
		driver.close();;
		driver.quit();
		logger.warn("Closing all browser. Driver quit.");
	}
	

}
