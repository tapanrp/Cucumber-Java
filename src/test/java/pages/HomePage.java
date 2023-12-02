package pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage{
	WebDriver driver;
	
	//WebElements on homepage
	@FindBy(xpath="//a[@href='#']//p[contains(text(),'Customers')]")
	WebElement customerMenu;

	@FindBy(xpath="//a[@href='/Admin/Customer/List']//p")
	WebElement customerMenuItem;
	
	@FindBy(linkText="Add new")
	WebElement addnewButton;
	
	//element control
	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void clickCustomerMenu() {
		customerMenu.click();
	}
	public void clickCustomerMenuItem() {
		customerMenuItem.click();
	}
	
	public void clickAddNewButton() {
		addnewButton.click();
	}
}
