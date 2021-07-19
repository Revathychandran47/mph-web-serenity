package StepDefinitions;

import org.junit.Assert;
import org.openqa.selenium.By;
import Reusable_Functions.Generic_function;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
public class Services_positive_scenarios extends Generic_function {
	static boolean value;

	/*Browser Launch*/ 	
	@Given("Open the Browser")
	public void services_page_positive_tc_001() throws Exception {
		try {
			Browser_Launch();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/*TC_001 Validate that the user is able to login with valid credentials*/
	@When("clicks on the 'Login'")
	public void click_login_button() throws Exception {
		try {
			click("welcome_login");
			driver.findElement(By.xpath(OR_reader( "login_phone_number"))).sendKeys(td_reader("login_phone_number",6));
			driver.findElement(By.xpath(OR_reader( "login_password"))).sendKeys(td_reader("login_password",7));
			click("login");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Then("Navigate to the login page")
	public void navigate_login() throws Exception {
		try {
			browser_wait(1000);
			value = driver.findElement(By.xpath(OR_reader( "logout"))).isDisplayed();
			Assert.assertEquals(true,value);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/*TC_002  Validate that the user is able to click on the Services tab */	
	@When("clicks on the 'Services' tab")
	public static void services_page_positive_tc_002() throws Exception{
		try {
			browser_wait(1000);
			click("services");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

	@Then("Navigate to the Services pages")
	public static void navigate_services() throws Exception{
		try {
			browser_wait(1000);
			value = driver.findElement(By.xpath(OR_reader("logout"))).isDisplayed();
			Assert.assertEquals(true,value);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

	/*TC_003 Validate that the user is able to click on the grid tiles*/
	@When("click on all the grid tiles")
	public void services_page_positive_tc_003() throws Exception {
		try {
			grid_tile(OR_reader("grid_path"));
			browser_wait(1000);
			value = driver.findElement(By.xpath(OR_reader( "logout"))).isDisplayed();
			Assert.assertEquals(true,value);
			System.out.println("services positive");
			browser_close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}		
	}
}