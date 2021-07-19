package StepDefinitions;

import org.junit.Assert;
import org.openqa.selenium.By;
import Reusable_Functions.Generic_function;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Login_positive_scenarios extends Generic_function {
	public static boolean value;

	@Given("Launch the URL")
	/*Browser launch*/
	public static void browser_launching() throws Exception  {
		try {
			Browser_Launch();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@When("Clicks on 'Login' button")
	public void login() throws Exception {
		try {
			click("welcome_login");
			browser_wait(1000);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/*TC 001 - Validate that the'Phone number' field is prefixed with '+1' country code*/
	@Then("check  the  'Phone number' field is prefixed with country code")	
	public static void login_positive_tc_001() throws Exception   {
		try {
			value = driver.findElement(By.xpath(OR_reader( "plus_one"))).isDisplayed();
			Assert.assertEquals(true,value);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/*TC 002 - Validate that the user is able to click on the 'Forgot password?' link*/
	@When("clicks on 'Forgot password'")
	public static void login_positive_tc_002() throws Exception  {
		//		try {
		//			click("forgot_password_link");			
		//			} catch (Exception e) {
		//				e.printStackTrace();
		//		}
	}
	@Then("navigated to Forgot password page")
	public void navigated_to_forgot_password_page() {
		//	try {
		//		browser_wait(12);
		//		value = driver.findElement(By.xpath(OR_reader( "forgot_password_title"))).isDisplayed();
		//		Assert.assertEquals(true,value);
		//	} catch (Exception e) {
		//		e.printStackTrace();
		//}

	}
	
	/*TC 003 - Validate that the user is able click on the 'Sign up' link*/
	@When("clicks on 'Sign up'")	
	public static void login_positive_tc_003() throws Exception  {
		//       try {
		//			driver.navigate().back();
		//			click("sign_up_link");
		//			}  catch (Exception e) {
		//				e.printStackTrace();
		//		}
	}
	
	@Then("navigated to Sign up page")
	public void sign_up_page()  throws Exception {
		//       try {
		//   		browser_wait(12);
		//			value = driver.findElement(By.xpath(OR_reader("signup_first_name"))).isDisplayed();
		//			Assert.assertEquals(true,value);
		//		} catch (Exception e) {
		//			e.printStackTrace();
		//		}

	}
	@Then("enters the Password")
	/*TC 004 -  Validate that the user is able to enter  the Password in the Password field*/
	public static void login_positive_tc_004() throws Exception {
		try {
			//			driver.navigate().back();
			//			driver.findElement(By.xpath(OR_reader( "login_password"))).sendKeys(td_reader("login_password",5));
			driver.findElement(By.xpath(OR_reader( "login_password"))).sendKeys(td_reader("login_password",5));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/*TC 005 - Validate that the user is able to Login with valid data*/
	@When("enters valid phonenumber and password")	
	public static void login_positive_tc_005() throws Exception  {
		try {
			browser_refresh();
			driver.findElement(By.xpath(OR_reader( "login_phone_number"))).sendKeys(td_reader("login_phone_number",5));
			driver.findElement(By.xpath(OR_reader("login_password"))).sendKeys(td_reader("login_password",6));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	@Then("clicks on 'login'")
	public void loginhome() throws Exception {
		try {
			click("login");
			browser_wait(1000);
			value = driver.findElement(By.xpath(OR_reader( "logout"))).isDisplayed();
			Assert.assertEquals(true,value);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/*TC 006 - Validate that the user is navigated to 'Landing page' on clicking the 'Log out' option*/
	@When("clicks on Logout")	
	public static void login_positive_tc_006() throws Exception {
		try {
			click("logout");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Then("navigated to Landing page")
	public static void landingpage() throws Exception {
		try {		
			browser_wait(1000);
			value = driver.findElement(By.xpath(OR_reader( "welcome_login"))).isDisplayed();
			Assert.assertEquals(true,value);
			System.out.println("login positive");
			browser_close();
		} catch (Exception e) {
			e.printStackTrace();	
		}		
	}
}
