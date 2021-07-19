package StepDefinitions;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import Reusable_Functions.Generic_function;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Homepage_positive_scenarios extends Generic_function {
	public static boolean value;
	WebElement ele;
	String ere;
	
	@Given("Welcome page is available")
	public static void browser_is_open() {
		try {
			Browser_Launch();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/*TC_001 -Validate that the user is navigated to Welcome page*/
	@When("Click on 'Welcome Login' button")
	public static void home_positive_tc_001() throws Exception {
		click("welcome_login");
	}
	@Then("Verify the Welcome page")
	public void verifyTheWelcomePage() throws Exception {
		try {
			value = driver.findElement(By.xpath(OR_reader( "login_title"))).isDisplayed();
			Assert.assertEquals(true,value);
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/*Tc_002- Validate that the user is able to Login with valid credentials*/
	@When("User enters valid phonenumber and password")
	public static void enter_login_details() throws InterruptedException, Exception {
		try {
			driver.findElement(By.xpath(OR_reader( "login_phone_number"))).sendKeys(td_reader("login_phone_number",7));
			driver.findElement(By.xpath(OR_reader( "login_password"))).sendKeys(td_reader("login_password",8));
			browser_wait(1000);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Then("click on 'login' button")
	public static void home_positive_tc_002() throws InterruptedException, Exception {
		click("login");
		browser_wait(1000);
	}

	/*Tc_003 - Validate that the user is navigated to  the Home page and User should be able to click on all the grid tiles */
	@When("clicks on all the grid tiles")
	public static void home_positive_tc_003() throws Exception, InterruptedException {
		try {
			grid_tiles(OR_reader("grid_path"));
			browser_wait(1000);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	/*TC_004 -Validate that the user is navigated to the Second Opinion page on clicking 'Request for second opinion' button*/
	@When("clicks on the 'Request for second opinion' button")
	public void home_positive_tc_004() throws InterruptedException, Exception {
		try {
			click("request_second_opinion_button");
			browser_wait(1000);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	@Then("navigated to the Second opinion page")
	public void refer_a_friend_page() throws Exception {
		try {
			value1=driver.findElement(By.xpath(OR_reader( "request_second_opinion_title"))).isDisplayed();
			Assert.assertEquals(true,value1);
			browser_wait(1500);
			browser_back();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/*TC_005-Validate that the user is navigated to the  Refer a friend page on clicking 'Refer a friend' button*/
	@When("clicks on 'Refer a friend' button")
	public static void home_positive_tc_005() throws InterruptedException, Exception {
		try {
			click("refer_a_friend_button");
			browser_wait(1500);
		}catch(Exception e) {
			e.printStackTrace();
		}				
	}
	@Then("navigated to the Refer a friend page")
	public void navigated_to_the_refer_a_friend_page() throws Exception {

		try {
			value1=driver.findElement(By.xpath(OR_reader("refer_a_friend_title"))).isDisplayed();
			Assert.assertEquals(true,value1);
			browser_wait(1000);
			System.out.println("home positive");
			browser_close();
		} catch (Exception e) {
			e.printStackTrace();
		}		
	}
}
