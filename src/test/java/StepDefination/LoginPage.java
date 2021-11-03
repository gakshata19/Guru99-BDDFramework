package StepDefination;

import org.junit.Assert;
import org.openqa.selenium.By;

import Com.BaseClass.BaseClass;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class LoginPage extends BaseClass{
	
	@Given("Launch Guru99 Application")
	public void launch_guru99_application() {
	   BaseClass.setUp();
	}
	@When("User enter valid username and password")
	public void user_enter_valid_username_and_password() {
	    	driver.findElement(By.name("uid")).sendKeys(prop.getProperty("username"));
	    	driver.findElement(By.name("password")).sendKeys(prop.getProperty("password"));
	}
	@Then("User click on login button")
	public void user_click_on_login_button() {
	    driver.findElement(By.name("btnLogin")).click();
	}
	@Then("User is on home page")
	public void user_is_on_home_page() {
	    System.out.println("Scrolling msg: "+driver.findElement(By.xpath("/html/body/table/tbody/tr/td/table/tbody/tr[2]/td/marquee")).getText());
	    System.out.println("Actual id: "+driver.findElement(By.xpath("/html/body/table/tbody/tr/td/table/tbody/tr[3]/td")));
	    String actualTitle=driver.getTitle();
	    Assert.assertEquals(actualTitle,"Guru99 Bank Manager HomePage");
	}
	@Then("Close browser")
	public void close_browser() throws InterruptedException {
	    Thread.sleep(3000);
	    driver.close();
	}
}
