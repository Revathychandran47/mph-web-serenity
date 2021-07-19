package StepDefinitions;

import org.junit.Assert;
import org.openqa.selenium.By;
import Reusable_Functions.Generic_function;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Signup_negative_scenarios extends Generic_function{
	public static String str;

	/*TC_001 -Verify the scenario when entered invalid firstname and lastname*/
	@Given("Launch  URL and click on signup")
	public static void signup_negative_tc_001() throws Exception  {
		try {
			Browser_Launch();
			click("welcome_signup"); 
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/* To refresh the page that is currently in use */
	@Then("Verify the validation message")
	public static void signup_negative_validation_msg() throws Exception {
		browser_refresh();
	}

	@When("Enter invalid 'Firstname' and 'Lastname' details")
	public static void invalid_details() throws Exception {
		try {
			driver.findElement(By.xpath(OR_reader("signup_first_name"))).sendKeys(td_reader("signup_first_name",0));
			click("signup_last_name");
			str= driver.findElement(By.xpath(OR_reader("firstname_valid_msg"))).getText();
			Assert.assertEquals(str,td_reader("signup_firstname_valid_msg"));
			driver.findElement(By.xpath(OR_reader("signup_last_name"))).sendKeys(td_reader("signup_last_name",0));
			click("signup_email_id");
			str= driver.findElement(By.xpath(OR_reader("lastname_valid_msg"))).getText();
			Assert.assertEquals(str,td_reader("signup_lastname_valid_msg"));   
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/* TC_002 -Verify the scenario when entered invalid 'Email ID'*/
	@When("Enter invalid 'Email ID'")
	public static void signup_negative_tc_002() throws Exception {
		try {
			driver.findElement(By.xpath(OR_reader("signup_email_id"))).sendKeys(td_reader("signup_email_id",0));
			click("signup_phone_number");
			str= driver.findElement(By.xpath(OR_reader("emailid_valid_msg"))).getText();
			Assert.assertEquals(str,td_reader("signup_email_invalid_msg"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/* TC_003 -Verify the scenario when blank 'Email ID' field*/
	@When("Enter 'Email ID' as blank")
	public static void signup_negative_tc_003() throws Exception  {
		try {
			click("signup_email_id");
			click("signup_phone_number");
			str = driver.findElement(By.xpath(OR_reader("emailid_valid_msg"))).getText();
			Assert.assertEquals(str,td_reader("signup_email_blank_msg")); 
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/* TC_004 -Verify the scenario when entering less than 10 digits in the 'Phone number' field*/
	@When("Enter phone number with less than ten digits")
	public static void signup_negative_tc_004() throws Exception {
		try {
			driver.findElement(By.xpath(OR_reader("signup_phone_number"))).sendKeys(td_reader("signup_phone_number",0));
			click("signup_password");
			str= driver.findElement(By.xpath(OR_reader("phonenumber_valid_msg"))).getText();
			Assert.assertEquals(str,"Phone number should be 10 digit number");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/* TC_005 -Verify the scenario when entering more than 10 digits in 'Phone number' field*/
	@When("Enter phone number with more than ten digits")
	public static void signup_negative_tc_005() throws Exception {
		try {
			driver.findElement(By.xpath(OR_reader("signup_phone_number"))).sendKeys(td_reader("signup_phone_number",1));
			click("signup_password");
			str= driver.findElement(By.xpath(OR_reader("phonenumber_valid_msg"))).getText();
			Assert.assertEquals(str,td_reader("signup_less_ten_msg"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/* TC_006 -Verify the scenario when entering already registered phone number*/
	@When("Enter already registered phone number")
	public static void signup_negative_tc_006() throws Exception {
		try {
			driver.findElement(By.xpath(OR_reader("signup_first_name"))).sendKeys(td_reader("signup_first_name",1));
			driver.findElement(By.xpath(OR_reader("signup_last_name"))).sendKeys(td_reader("signup_last_name",1));
			driver.findElement(By.xpath(OR_reader("signup_email_id"))).sendKeys(td_reader("signup_email_id",1));
			driver.findElement(By.xpath(OR_reader("signup_phone_number"))).sendKeys(td_reader("signup_phone_number",2));
			driver.findElement(By.xpath(OR_reader("signup_password"))).sendKeys(td_reader("signup_password",0));
			driver.findElement(By.xpath(OR_reader("signup_confirm_password"))).sendKeys(td_reader("signup_confirm_password",1));
			click("signup_terms_and_conditions");
			click("signup");
			browser_wait(1000);
			str= driver.findElement(By.xpath(OR_reader("phonenumber_valid_msg"))).getText();
			Assert.assertEquals(str,td_reader("signup_exist_no_msg"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/* TC_007 -Verify the scenario when blank 'Password' field*/
	@When("Enter 'Password' as blank")
	public static void signup_negative_tc_007() throws Exception  {
		try {
			click("signup_password");
			click("signup_confirm_password");
			str = driver.findElement(By.xpath(OR_reader("password_valid_msg"))).getText();
			Assert.assertEquals(str,td_reader("signup_pass_blank_msg"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/*TC_008 -Verify the scenario when password strength message and progress bar is displayed while entering password in 'Password' field */
	@When("Enter password")
	public static void signup_negative_tc_008() throws Exception {
		try {
			driver.findElement(By.xpath(OR_reader("signup_password"))).sendKeys(td_reader("signup_password",1));
			str= driver.findElement(By.xpath(OR_reader("passwordstrength_valid_msg"))).getText();
			Assert.assertEquals(str,td_reader("signup_pass_stren_msg"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/*TC_009 -Verify the scenario when entering different data in 'Password' and 'Confirm Password'*/
	@When("Enter password and confirm password data differently")
	public static void signup_negative_tc_009() throws Exception  {
		try {
			driver.findElement(By.xpath(OR_reader("signup_password"))).sendKeys(td_reader("signup_password",1));
			driver.findElement(By.xpath(OR_reader("signup_confirm_password"))).sendKeys(td_reader("signup_confirm_password",0));
			click("signup_referral_code");
			str= driver.findElement(By.xpath(OR_reader("passwordmatch_valid_msg"))).getText();
			Assert.assertEquals(str,td_reader("signup_pass_match_msg"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/*TC_010 -Verify the scenario when 'Sign Up' button is disabled  when 'Terms & Conditions' is unchecked*/
	@When("Check box is unchecked")
	public static void signup_negative_tc_010() throws Exception  {
		try {
			Assert.assertEquals(driver.findElement(By.xpath(OR_reader("signup_terms_and_conditions"))).isSelected(),false);
			Assert.assertEquals(driver.findElement(By.xpath(OR_reader("signup"))).isEnabled(),true);
			System.out.println("signup negative");
			browser_close();
		} catch (Exception e) {
			e.printStackTrace();
		}		
	}
}
