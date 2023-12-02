package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	WebDriver driver;
	
	//Web elements on loginpage
	@FindBy(id="Email")
	WebElement email;
	
	@FindBy(id="Password")
	WebElement password;
	
	@FindBy(xpath="//div[@class='buttons']/button")
	WebElement loginBtn;
	
	@FindBy(linkText="Logout")
	WebElement logout;
	
	//element control
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void goToLoginPage(String url) {
		driver.get(url);
	}
	
	public void enterEmail(String email) {
		this.email.clear();
		this.email.sendKeys(email);
	}
	
	public void eneterPassword(String pwd) {
		password.clear();
		password.sendKeys(pwd);
	}
	
	public void clickLogingButton() {
		loginBtn.click();
	}
	
	public void clickLogout() {
		logout.click();
	}
	
	public void closeBrowser() {
		driver.close();
		driver.quit();
	}
	
}
