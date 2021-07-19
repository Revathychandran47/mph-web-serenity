package StepDefinitions;

import Reusable_Functions.Generic_function;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class Circles_positive_scenarios extends Generic_function  {
	public static boolean value;
	public static String str;

	/*Browser launch*/
	@Given("launch the browser")
	public void browserlaunching() {
		try {
			browser_launch();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@When("Click on the Circles tab")
	public void click_circles() throws Exception {
		try {
		click("welcome_login");
		browser_wait(1200);
		driver.findElement(By.xpath(OR_reader( "login_phone_number"))).sendKeys(td_reader("login_phone_number",6));
		driver.findElement(By.xpath(OR_reader("login_password"))).sendKeys(td_reader("login_password",7));
		click("login");
		browser_wait(1200);
		click("circle_click");
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

	/*TC 001 - Validate that a user is taken to the Circles page when they click on the Circles tab*/
	@Then("Validate Circles page")
	public void circle_positive_tc_001() throws Exception {
		try {
			browser_wait(1000);
			value = driver.findElement(By.xpath(OR_reader("circle_header_assert"))).isDisplayed();
			Assert.assertEquals(true,value);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/*TC 002 - Validate that a user is able to click on Add a Partner and options pop up*/
	@When("Click on Add a Partner")
	public void click_add_partner() throws Exception {
		browser_wait(1000);
		click("circle_add_partner");
	}

	@Then("Validate options pop up")
	public void circle_positive_tc_002() throws Exception {
		try {
			browser_wait(1200);
			value = driver.findElement(By.xpath(OR_reader("circle_add_assert"))).isDisplayed();
			Assert.assertEquals(true,value);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/*TC 003 - Validate that when a user clicks on Add a Provider option under Add a Partner drop-down, they are directed to the provider screen*/
	@When ("Click on Add a Partner link")
	public void add_partner() throws Exception {
		browser_wait(1500);
		click("circle_select_partner");
	}

	@Then ("Click on Select a partner")
	public void select_partner() throws Exception {
		value = driver.findElement(By.xpath(OR_reader("circle_mymedicare"))).isDisplayed();
		Assert.assertEquals(true,value);
		try {
			click("circle_mymedicare");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Then("select the My Medicare option finally click on Proceed")
	public void circle_positive_tc_003() throws Exception {
		try {

			browser_wait(1000);
			click("circle_proceed");
			value = driver.findElement(By.xpath(OR_reader("circle_continue"))).isDisplayed();
			Assert.assertEquals(true,value);
			click("circle_continue");
			click("logout");
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}

	/*TC 004 - Validate that the user is able to click on the 'Forgot username?' link*/
	@When ("click on the Forgot username? link")
	public void forgot_username() throws Exception {
		browser_handle();
		value = driver.findElement(By.xpath(OR_reader("circle_usernamelink"))).isDisplayed();
		Assert.assertEquals(true,value);
		click("circle_usernamelink");
	}

	@Then("Validate forgot username")
	public void circle_positive_tc_004() throws Exception {
		try {
			value = driver.findElement(By.xpath(OR_reader( "circle_allfieldsnumber"))).isDisplayed();
			Assert.assertEquals(true,value);
			browser_back();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/*TC 005 - Validate that the user is able to click on the 'Forgot password?' link*/
	@When ("Click on the Forgot password link")
	public void forgot_password() throws Exception {
		browser_wait(1200);
		click("circle_forgotpasswordlink");
	}

	@Then("Validate the forgot password")
	public void circle_positive_tc_005() throws Exception {
		try {
			value = driver.findElement(By.xpath(OR_reader("circle_allfieldsnumber"))).isDisplayed();
			Assert.assertEquals(true,value);
			browser_back();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/*TC 006 - Validate that the user is able to enter  the Username and Password in the 'USERNAME' and 'PASSWORD' field*/
	@When("Enter  the Username and Password")
	public void Login() throws Exception {
		driver.findElement(By.xpath(OR_reader("circle_username"))).sendKeys(td_reader("circle_user_name"));
		driver.findElement(By.xpath(OR_reader( "circle_password"))).sendKeys(td_reader("circle_password"));
	}

	@Then("Validate the username and password")
	public void circle_positive_tc_006() throws Exception {
		try {

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/*TC 007 Validate that the password should be displayed on clicking the eye*/
	@When("Click on eye symbol")
	public void eye_symbol() throws Exception {
		click("circle_eye");
	}

	@Then("View password on clicking the eye")
	public void circle_positive_tc_007() throws Exception {
		try {
			str =driver.findElement(By.xpath(OR_reader("circle_password"))).getAttribute("value");
			Assert.assertEquals(str,"PW27961!");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/*TC 008 Validate that the user is able to Login with valid data*/
	@When("Enter valid username and password")
	public void username_password() throws Exception {
		click("circle_login");
	}

	@Then("Validate Login with valid data")
	public void circle_positive_tc_008() throws Exception {
		try {
			browser_close();
			browser_switch();
			driverquit();
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}

	/*TC 012 - Validate that the user can able to view 'My Medicare’ icon in the Circles page and also it should be clickable */
	@When("Navigate to Circles page")
	public void circles() throws Exception {
		try {
		Browser_Launch();
		click("welcome_login");
		browser_wait(1200);
		driver.findElement(By.xpath(OR_reader( "login_phone_number"))).sendKeys(td_reader("login_phone_number",9));
		driver.findElement(By.xpath(OR_reader("login_password"))).sendKeys(td_reader("login_password",5));
		click("login");
		browser_wait(1000);
		click("circle_click");
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}

	@When("My Medicare logo should be present")
	public void medicare_logo() throws Exception {
		browser_wait(1000);
		value = driver.findElement(By.xpath(OR_reader("circle_mymedicareassert"))).isDisplayed();
		Assert.assertEquals(true,value);
		browser_wait(1200);
		click("circle_mymedicareassert");
	}

	@And("Validate that its clickable")
	public void circle_positive_tc_012() throws Exception  {
		try {
			value = driver.findElement(By.xpath(OR_reader( "circle_mymedicareassert"))).isDisplayed();
			Assert.assertEquals(true,value);
			click("logout");
			System.out.println("circles positive");
			driverquit();
		} catch (Exception e) {
			e.printStackTrace();
		}		
	}
}
