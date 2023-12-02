package pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchPage {
	WebDriver driver;
	
	public SearchPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	//Declare elements
	
	@FindBy(id="SearchEmail")
	WebElement searchemail;

	@FindBy(id="SearchFirstName")
	WebElement searchFirstname;
	
	@FindBy(id="SearchLastName")
	WebElement searchLastname;
	
	@FindBy(xpath="/html/body/div[3]/div[1]/form[1]/section/div/div/div/div[1]/div/div[1]")
	WebElement presearch;
	
	@FindBy(id="search-customers")
	WebElement searchbutton;
	
	@FindBy(xpath="//table[@id='customers-grid']//tbody/tr")
	List<WebElement> tableRows;
	
	//Action methods for the web elements
	public void enterSearchEmail(String email) {
//		presearch.click();
		searchemail.sendKeys(email);
	}
	
	public void clickSearchButton() {
		searchbutton.click();
	}
	
	public List<WebElement> listOfResultRow(){
		
		System.out.println("Table Total No of Rows inside SearchPage:::"+tableRows.size());
		return tableRows;
	}
	
	public void enterFirstandLastName(String firstname, String lastname) {
		searchFirstname.sendKeys(firstname);
		searchLastname.sendKeys(lastname);
	}
	
	public List<WebElement> listofResultRow1(Integer counter){
		System.out.println("Table Total No of Rows inside SearchPage:::"+counter+":::"+tableRows.size());
		return tableRows;
		
	}
}
