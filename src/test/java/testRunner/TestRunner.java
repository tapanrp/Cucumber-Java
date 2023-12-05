package testRunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features= {"./src/test/resources/Features/loginTest.feature","./src/test/resources/Features/customer.feature"},
		glue= {"steps"},
		dryRun= false,
		monochrome=true,
		plugin = {"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"},
//		plugin= {"pretty","html:target/cucumber-reports/html-reports/report1.html",
//				"junit:target/cucumber-reports/xml-reports/report1.xml",
//				"json:target/cucumber-reports/json-reports/report1.json"},
		tags = "@Raj3"
//html:target/cucumber-reports/html-reports/report1.html
//junit:target/cucumber-reports/xml-reports/report1.xml
//json:target/cucumber-reports/json-reports/report1.json
)

public class TestRunner {

}
