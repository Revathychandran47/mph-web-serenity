package StepDefinitions;

import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.By;
import Reusable_Functions.Generic_function;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import java.io.IOException;

public class Circles_negative_scenarios extends Generic_function{
	public static boolean value;
	public static String str;

	/*Browser launch*/
	@Given("User is on landing page")
	public void browser_launching() throws Exception {
		try {
			browser_launch();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/*TC 001 - Validate that Proceed button is disabled when they do not select a provider from the drop down*/
	@When("Drop down list is clicked and No selection is made")
	public void click_dropdown() throws Exception {
		try {
			click("welcome_login");
			browser_wait(1200);
			driver.findElement(By.xpath(OR_reader( "login_phone_number"))).sendKeys(td_reader("login_phone_number",6));
			driver.findElement(By.xpath(OR_reader("login_password"))).sendKeys(td_reader("login_password",7));
			click("login");
			browser_wait(1000);
			click("circles");
			browser_wait(1200);
		}
		catch (Exception e){
			e.printStackTrace();
		}
	}
	@Then("Proceed to next page")
	public void circle_positive_tc_001() throws Exception {
		try {
			value = driver.findElement(By.xpath(OR_reader( "circles_page_title"))).isDisplayed();
			Assert.assertEquals(true,value);
			browser_wait(1200);
			click("circles_add_patner_button");
			browser_wait(1200);
			value = driver.findElement(By.xpath(OR_reader("add_patner_page_title"))).isDisplayed();
			Assert.assertEquals(true,value);
			Assert.assertEquals(driver.findElement(By.xpath(OR_reader("add_patner_proceed_button"))).isEnabled(),true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/*TC 002 - Validate that the user is not allowed to login when Username and Password fields are blank*/
	@When("Enter Username and password blank")
	public void Username_Password() throws IOException {
		browser_handle();
		click("mymed_username");
		click("mymed_password");
	}
	@Then("Validate the error message on text fields")
	public void circle_positive_tc_002() throws Exception {
		try {
			str= driver.findElement(By.xpath(OR_reader("mymed_username_valid_msg"))).getText();
			Assert.assertEquals(str,td_reader("mymed_username_valid_msg"));
			click("mymed_login");
			field_clear("mymed_username");
			field_clear("mymed_password");
			str= driver.findElement(By.xpath(OR_reader("mymed_password_valid_msg"))).getText();
			Assert.assertEquals(str,td_reader("mymed_password_valid_msg"));
		}catch (Exception e) {
			e.printStackTrace();
		}	
	}

	/*TC 003 - Validate that the user should get a validation message on entering invalid Username  and Password in the Login Page*/
	@When("Enter incorrect Username and Password")
	public void incorrect_username_password() throws IOException {
		driver.findElement(By.xpath(OR_reader("mymed_username"))).sendKeys(td_reader("mymed_username",0));
		driver.findElement(By.xpath(OR_reader("mymed_password"))).sendKeys(td_reader("mymed_password",0));
		click("mymed_login");
	}
	@Then("verify error message for incorrect username and password")
	public void circle_positive_tc_003() throws Exception {
		try {
			field_clear("mymed_username");
			field_clear("mymed_password");
			str= driver.findElement(By.xpath(OR_reader("mymed_blank_credential_msg"))).getText();
			Assert.assertEquals(str,td_reader("mymed_blank_credential_msg"));
		}catch (Exception e) {
			e.printStackTrace();
		}	
	}

	/*TC 004 - Validate that the user is not allowed leaves blank Username field*/
	@When("Enter Username field as blank and valid password")
	public void incorrect_username() throws IOException {
		driver.findElement(By.xpath(OR_reader("mymed_password"))).sendKeys(td_reader("mymed_password",0));
		click("mymed_login");
	}

	@Then("Validate the error message when username is blank")
	public void circle_positive_tc_004() throws Exception {
		try {
			field_clear("mymed_username");
			field_clear("mymed_password");
			str= driver.findElement(By.xpath(OR_reader("mymed_blank_credential_msg"))).getText();
			Assert.assertEquals(str,td_reader("mymed_blank_credential_msg"));
		}catch (Exception e) {
			e.printStackTrace();
		}	
	}

	/*TC 005 - Validate that the user is not allowed leaves blank Password field*/
	@When("Enter the password as blank")
	public void enter_password() throws Exception {
		driver.findElement(By.xpath(OR_reader("mymed_username"))).sendKeys(td_reader("mymed_username",0));
		click("mymed_login");
	}
	@Then("Validate message when Password field is blank")
	public void circle_positive_tc_005() throws Exception {
		try {
			field_clear("mymed_username");
			field_clear("mymed_password");
			str= driver.findElement(By.xpath(OR_reader("mymed_blank_credential_msg"))).getText();
			Assert.assertEquals(str,td_reader("mymed_blank_credential_msg"));
		}catch (Exception e) {
			e.printStackTrace();
		}	
	}

	/*TC 006 - Validate that the user is not allowed to login with valid Usename and invalid Password*/
	@When("login with valid Username and invalid Password")
	public void login_username_invalid_password() throws IOException {
		driver.findElement(By.xpath(OR_reader("mymed_username"))).sendKeys(td_reader("mymed_username",1));
		driver.findElement(By.xpath(OR_reader("mymed_password"))).sendKeys(td_reader("mymed_password",0));
		click("mymed_login");
	}

	@Then("Validation message invalid password")
	public void circle_positive_tc_006() throws Exception {
		try {
			field_clear("mymed_username");
			field_clear("mymed_password");
			str= driver.findElement(By.xpath(OR_reader("mymed_blank_credential_msg"))).getText();
			Assert.assertEquals(str,td_reader("mymed_blank_credential_msg"));
		}catch (Exception e) {
			e.printStackTrace();
		}	
	}

	/*TC 007 - Validate that the user is not allowed to login with invalid Usename and valid Password */
	@When("login with invalid Username and valid Password")
	public void login_invalid_username() throws IOException {
		driver.findElement(By.xpath(OR_reader("mymed_username"))).sendKeys(td_reader("mymed_username",0));
		driver.findElement(By.xpath(OR_reader("mymed_password"))).sendKeys(td_reader("mymed_password",1));
		click("mymed_login");
	}

	@Then("Validation message invalid username")
	public void circle_positive_tc_007() throws Exception {
		try {
			field_clear("mymed_username");
			field_clear("mymed_password");
			str= driver.findElement(By.xpath(OR_reader("mymed_blank_credential_msg"))).getText();
			Assert.assertEquals(str,td_reader("mymed_blank_credential_msg"));
			browser_close();
			browser_switch();
			System.out.println("Circles negative");
			browser_close();
		}catch (Exception e) {
			e.printStackTrace();
		}	
	}
}
