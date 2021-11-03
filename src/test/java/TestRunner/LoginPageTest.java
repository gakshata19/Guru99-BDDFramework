package TestRunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features= {"Features/Login.feature"},
		glue= {"StepDefination"},
		monochrome=true,
		dryRun=false,
		plugin= {
				"html:Reports/login.html",
				"json:Reports/login.json",
				"junit:Reports/login.xml",
				"pretty:Reports/login.txt"
		}
		)
public class LoginPageTest {

}
