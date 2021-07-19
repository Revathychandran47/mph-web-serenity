package StepDefinitions;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.IOException;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import Reusable_Functions.Generic_function;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Utilities_negative_scenarios  extends Generic_function{
	static boolean value;
	static String balance,text,ere,str;
	static WebElement ele;

	/*Validate that the user is navigated to Welcome page*/
	@Given("User is on home page")
	public void launch_url() {
		try {
			Browser_Launch();
			click("welcome_login");
			driver.findElement(By.xpath(OR_reader( "login_phone_number"))).sendKeys(td_reader("login_phone_number",9));
			driver.findElement(By.xpath(OR_reader("login_password"))).sendKeys(td_reader("login_password",5));
			click("login");
			browser_wait(1000);
			value = driver.findElement(By.xpath(OR_reader("logout"))).isDisplayed();
			Assert.assertEquals(true,value);
		}catch (Exception e) {
			e.printStackTrace();
		}		
	}

	/* TC_001 -Navigate to Utilities screen*/
	@When("Clicks on Utilities tab")
	public static void utilities_negative_tc_001() throws Exception {
		try {
			click("utilities");
			browser_wait(1000);
			value = driver.findElement(By.xpath(OR_reader("wallet"))).isDisplayed();
			Assert.assertEquals(true,value);
		}catch (Exception e) {
			e.printStackTrace();
		}	
	}

	/* TC_002 -Verify the scenario when 'Add Card' fields is blank*/
	@When("Leave Add card field as blank")
	public void utilities_negative_tc_002() throws IOException {
		try{
			click("wallet");
			browser_explicit_wait("utilities_add_card");
			click_javascript("utilities_add_card");
			browser_explicit_wait("utilities_save_button");
			click("utilities_save_button");
			browser_wait(1000);
		}
		catch (Exception e) {
			e.printStackTrace();
		}	
	}

	@Then("Verify the message on leaving Add Card fields as blank")
	public void blank_field_validation() throws Exception {
		try{
			str= driver.findElement(By.xpath(OR_reader("utilities_save_as_valid_msg"))).getText();
			Assert.assertEquals(str,td_reader("utilities_save_as_valid_msg"));
			str= driver.findElement(By.xpath(OR_reader("utilities_name_on_card_valid_msg"))).getText();
			Assert.assertEquals(str,td_reader("utilities_name_on_card_valid_msg")); 
			str= driver.findElement(By.xpath(OR_reader("utilities_zip_code_valid_msg"))).getText();
			Assert.assertEquals(str,td_reader("utilities_zip_code_valid_msg")); 
			str= driver.findElement(By.xpath(OR_reader("utilities_phone_number_valid_msg"))).getText();
			Assert.assertEquals(str,td_reader("utilities_phone_number_valid_msg"));   
			str= driver.findElement(By.xpath(OR_reader("utilities_address_valid_msg"))).getText(); 
			Assert.assertEquals(str,td_reader("utilities_address_valid_msg")); 
			str= driver.findElement(By.xpath(OR_reader("utilities_country_valid_msg"))).getText();
			Assert.assertEquals(str,td_reader("utilities_country_valid_msg")); 
			str= driver.findElement(By.xpath(OR_reader("utilities_state_valid_msg"))).getText();
			Assert.assertEquals(str,td_reader("utilities_state_valid_msg")); 
			str= driver.findElement(By.xpath(OR_reader("utilities_city_valid_msg"))).getText();
			Assert.assertEquals(str,td_reader("utilities_city_valid_msg"));
		}
		catch (Exception e) {
			e.printStackTrace();
		}	
	}

	/* TC_003 -Verify the message on entering invalid details in the Add Card page*/
	@When("Enter invalid card details")
	public static void utilities_negative_tc_003() throws Exception {
		try {
			browser_wait(1000);
			click_javascript("utilities");
			click_javascript("wallet");
			browser_wait(1000);
			click_javascript("utilities_add_card");
			driver.findElement(By.xpath(OR_reader("utilities_save_as"))).sendKeys(td_reader("utilities_save_as"));
			driver.findElement(By.xpath(OR_reader("utilities_name_on_card"))).sendKeys(td_reader("utilities_name_on_card"));
			browser_wait(1000);
			Robot robot = new Robot();
			browser_wait(1000);
			robot.keyPress(KeyEvent.VK_TAB);
			browser_wait(1000);
			robot.keyPress(KeyEvent.VK_NUMPAD4);
			robot.keyPress(KeyEvent.VK_NUMPAD2);
			robot.keyPress(KeyEvent.VK_NUMPAD4);
			robot.keyPress(KeyEvent.VK_NUMPAD2);
			robot.keyPress(KeyEvent.VK_TAB);
			browser_wait(1000);
			robot.keyPress(KeyEvent.VK_NUMPAD1);
			robot.keyPress(KeyEvent.VK_NUMPAD2);
			robot.keyPress(KeyEvent.VK_BACK_SLASH);
			robot.keyPress(KeyEvent.VK_TAB); 
			browser_wait(1000);
			robot.keyPress(KeyEvent.VK_NUMPAD1);
			robot.keyPress(KeyEvent.VK_NUMPAD2);
			driver.findElement(By.xpath(OR_reader("utilities_zip_code"))).sendKeys(td_reader("utilities_zip_code",1));
			driver.findElement(By.xpath(OR_reader("utilities_phone_number"))).sendKeys(td_reader("utilities_phone_number",1));
			driver.findElement(By.xpath(OR_reader("utilities_address"))).sendKeys(td_reader("utilities_address")); 			
			browser_wait(1000);
			click_javascript("utilities_save_button");
		}catch (Exception e) {
		}	
	}

	@Then("Verify the message on entering invalid Card details")
	public static void invalid_card_assertion() throws Exception {
		try {
			//put assertions here
		}catch (Exception e) {

		}
	}

	/*TC_004- Verify the scenario when 'Add Bank' fields is blank*/
	@When("Leave Add Bank field as blank")
	public static void utilities_negative_tc_004() throws Exception {
		try {
			browser_wait(1000);
			click_javascript("utilities");
			click_javascript("wallet");
			browser_wait(1000);
			click_javascript("utilities_add_bank");
			click("utilities_bank_saveas");
			click("utilities_account_name");
			click("utilities_routing_no");
			click("utilities_account_number");
			click("utilities_routing_no");	
		}
		catch (Exception e) {
			e.printStackTrace();
		}	
	}

	@Then("Verify the message on leaving Add Bank fields as blank")
	public static void blank_bank_details() throws Exception {
		try {
			str= driver.findElement(By.xpath(OR_reader("utilities_bank_save_as_valid_msg"))).getText();
			Assert.assertEquals(str,td_reader("utilities_bank_save_as_valid_msg"));  
			str= driver.findElement(By.xpath(OR_reader("utilities_bank_account_holder_name_valid_msg"))).getText();
			Assert.assertEquals(str,td_reader("utilities_bank_account_holder_name_valid_msg"));   
			str= driver.findElement(By.xpath(OR_reader("utilities_bank_routing_no_valid_msg"))).getText();
			Assert.assertEquals(str,td_reader("utilities_bank_routing_no_valid_msg"));   
			str= driver.findElement(By.xpath(OR_reader("utilities_bank_account_no_valid_msg"))).getText();
			Assert.assertEquals(str,td_reader("utilities_bank_account_no_valid_msg"));  
		}
		catch (Exception e) {
			e.printStackTrace();
		}	
	}

	/* TC_005 - Verify the message on entering invalid details in the 'Add Bank' page*/
	@When("Enter invalid bank details")
	public static void utilities_negative_tc_005() throws Exception {
		try {
			browser_wait(1000);
			click_javascript("utilities");
			click_javascript("wallet");
			click_javascript("utilities_add_bank");
			driver.findElement(By.xpath(OR_reader("utilities_bank_saveas"))).sendKeys(td_reader("utilities_bank_saveas"));
			driver.findElement(By.xpath(OR_reader("utilities_account_name"))).sendKeys(td_reader("utilities_account_name",1));
			browser_wait(1000);
			click("utilities_routing_no");
		}catch (Exception e) {
			e.printStackTrace();
		}	
	}

	@Then("Verify the message on entering invalid bank details")
	public static void invalid_bank_details() throws Exception {
		try {
			str= driver.findElement(By.xpath(OR_reader("utilities_bank_account_holder_name_invalid_msg"))).getText();
			Assert.assertEquals(str,td_reader("utilities_bank_account_holder_name_invalid_msg"));  
			browser_wait(1000);
			driver.findElement(By.xpath(OR_reader("utilities_routing_no"))).sendKeys(td_reader("utilities_routing_no",1));
			click("utilities_account_type");
			str= driver.findElement(By.xpath(OR_reader("utilities_bank_routing_no_invalid_msg"))).getText();
			Assert.assertEquals(str,td_reader("utilities_bank_routing_no_invalid_msg"));  
			text = td_reader("utilities_account_type");
			drop_down(OR_reader( "utilities_account_type_list"),text);  
			browser_wait(2000);
			driver.findElement(By.xpath(OR_reader("utilities_account_number"))).sendKeys(td_reader("utilities_account_number",1));
			browser_wait(2000);
			click("utilities_routing_no");
			str= driver.findElement(By.xpath(OR_reader("utilities_bank_account_no_invalid_msg"))).getText();
			Assert.assertEquals(str,td_reader("utilities_bank_account_no_invalid_msg"));  
		}catch (Exception e) {
			e.printStackTrace();
		}	
	}

	/* TC_006 - Verify the redeem button when the balance is less than 2000 */
	@When ("Verify the redeem button is disabled")
	public static void utilities_positive_tc_006() throws Exception{
		try {
			click_javascript("utilities");
			browser_wait(2000);
			click_javascript("award_points");
			browser_explicit_wait("awardpoints_redeem_button");
			value=driver.findElement(By.xpath(OR_reader("awardpoints_redeem_button"))).isEnabled();
			if(value==true) {
				click("awardpoints_redeem_button");				
			}
			else
			{
				browser_back();
			}
			System.out.println("Utilities negative");
			browser_close();
		}catch (Exception e) {
			e.printStackTrace();
		}	
	}

}