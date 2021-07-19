package StepDefinitions;

import Reusable_Functions.Generic_function;
import java.io.File;
import java.io.IOException;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Request_second_opinion_negative_scenarios extends Generic_function{
	public static boolean value;
	public static WebElement ele,fr;
	public static String ere,str;
	public static File file;

	@Given("Browser opens and opens the URL")
	public void browser_launching() {
		try {
			Browser_Launch();
			browser_wait(1000);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/*Validate that the user is navigated to Welcome page*/
	@And("clicks on the 'Welcome login' button")
	public static void Request_second_opinion_negative_welcome() throws Exception {
		try {
			click("welcome_login");
			value = driver.findElement(By.xpath(OR_reader("login_title"))).isDisplayed();
			Assert.assertEquals(true,value);
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

	/*Validate that the user is able to Login with valid credentials*/
	@When("user enters the valid phonenumber and password")
	public static void Request_second_opinion_negative_login() throws InterruptedException, Exception {
		try {
			driver.findElement(By.xpath(OR_reader("login_phone_number"))).sendKeys(td_reader("login_phone_number",5));
			driver.findElement(By.xpath(OR_reader("login_password"))).sendKeys(td_reader("login_password",6));

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Then("clicks on 'login' button")
	public static void login() throws InterruptedException, Exception {
		try {

			click("login");
			browser_wait(1000);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@When("clicks on 'Request for second opinion' button")
	public static void Request_second_opinion_negative_click() throws IOException {
		try {
			click("request_second_opinion_button");

		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	@Then("navigated to the second opinion page")
	public static void Request_second_opinion() throws IOException {
		try {

			click("create_new_case");
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	//TC_001 Validate that the user is not allowed to leave  check box "self"  unchecked and "Proceed" button is disabled when user unchecked  the check box - 'I agree to DocPanel's terms and condition'
	@When("unchecked  the check box 'self and I agree to DocPanels terms and condition'")
	public static void click_checkbox() throws Exception, InterruptedException {
		try {
			click("so_self_checkbox");
		}catch (Exception e) {
			e.printStackTrace();
		}	
	}
	@Then("'Proceed' button is disabled")
	public static void Request_second_opinion_negative_tc_001() throws Exception, InterruptedException {
		try {
			value = driver.findElement(By.xpath(OR_reader("so_proceed_button"))).isEnabled();
			Assert.assertEquals(true,value); 
		}catch (Exception e) {
			e.printStackTrace();
		}	
	}

	//TC_002 Validate that user should navigated to the "Upload your scan page" and should not allowed to  click on "Continue to add clinical details" without "upload my scans"
	@When("clicks on 'Continue to add clinical details' button")
	public static void click_continue()  throws Exception {	   
		try {
			//			click("so_agree_to_docpanel_checkbox");
			//			browser_wait(10);
			//			click("so_proceed_button");
			//			Thread.sleep(8000);
			//			fr= driver.findElement(By.xpath(OR_reader("outer_frame")));
			//			driver.switchTo().frame(fr);
			//			browser_wait(30);
			//			click_javascript("so_don’t_have_doctors_checkbox");
			//			browser_wait(5);
			//			click_javascript("so_i_dont_have_it");
			//			click_javascript("so_clinical_details_button");
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	@Then("validation message is displayed without clicking on'upload my scans'")
	public static void Request_second_opinion_negative_tc_002() throws Exception {	   
		try {
			//		str= driver.findElement(By.xpath(OR_reader("upload_scan_validation_msg"))).getText();
			//			Assert.assertEquals(str,td_reader("upload_scan_validation_msg")); 
			//			browser_wait(10);
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

	//TC_003 Validate that user should get validation message on clicking "Continue to add clinical details" button when the check box "I don not have a doctor's reports" is unchecked
	@When("unchecked the check box 'I do not have a doctors reports'")
	public static void click_uncheck() throws Exception {
		try {
			//			click_javascript("so_don’t_have_doctors_checkbox");
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	@And("clicks on 'Continue to add clinical details'")
	public static void clicks_continue () throws Exception {
		try {
			//			browser_wait(5);
			//			click_javascript("so_clinical_details_button");
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Then("Validation message is displayed")
	public static void Request_second_opinion_negative_tc_003 () throws Exception {
		try {
			//			browser_wait(10);
			//			str= driver.findElement(By.xpath(OR_reader("upload_scan_validation_msg"))).getText();
			//			Assert.assertEquals(str,td_reader("upload_scan_validation_msg")); 
			//			str= driver.findElement(By.xpath(OR_reader("upload_report_validation_msg"))).getText();
			//			Assert.assertEquals(str,td_reader("upload_report_validation_msg")); 
			//			browser_wait(10);
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	//TC_004 Validate that user should not allowed to  click on "Continue to add clinical details" without "upload my reports"
	@When("click on the 'Continue to add clinical details' button")
	public static void Request_second_opinion_negative_tc_004() throws InterruptedException, Exception {
		try {
			//			browser_wait(2);
			//			file = new File(getreport());
			//			driver.findElement(By.xpath(OR_reader("Object_Locator", "so_upload_report_button"))).sendKeys(file.getAbsolutePath());
			//			click_javascript("so_clinical_details_button");
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	@Then("validation message is displayed without clicking on 'upload my reports'")
	public static void reports_message() throws InterruptedException, Exception {
		try {
			//			str= driver.findElement(By.xpath(OR_reader("Object_Locator","upload_scan_validation_msg"))).getText();
			//			Assert.assertEquals(str,td_reader("upload_scan_validation_msg")); 
			//			browser_wait(10);
			//			driver.navigate().to(getsourl());
			//			click_javascript("create_new_case");
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

	//TC_005 Validate that the user is not allowed to leave  check box "other"  unchecked
	@When("not allowed to uncheck the other check box")
	public static void Request_second_opinion_negative_tc_005()  throws Exception {
		try {
			click("so_other_checkbox");
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	//TC_006 Validate that the user is not allowed to proceed when 'First name' and 'Last name' fields are blank
	@When("'First name' and 'Last name' fields are blank")
	public static void Request_second_opinion_negative_tc_006() throws Exception, InterruptedException {
		try {
			click("so_other_agree_to_docpanel_checkbox");
			click("so_iam_legal_guardian_checkbox");
			click("so_proceed_button");
		}catch(Exception e) {
		}
	}
	@Then("validation message is displayed under 'First name' and 'Last name' fields")
	public static void blank_message() throws IOException, InterruptedException {
		try {
			str= driver.findElement(By.xpath(OR_reader("so_first_name_validation_msg"))).getText();
			Assert.assertEquals(str,td_reader("so_first_name_validation_msg")); 
			browser_wait(1000);
			browser_refresh();
			click("create_new_case");
		}catch(Exception e) {
		}
	}

	//TC_007 Validate that the user is not allowed leave blank 'First name' field
	@When("'First name' field are blank")
	public static void Request_second_opinion_negative_tc_007() throws InterruptedException, Exception {	
		try {
			click("so_other_checkbox");
			browser_wait(2000);
			driver.findElement(By.xpath(OR_reader("so_patient_last_name"))).sendKeys(td_reader("so_patient_last_name",2));
			click("so_other_agree_to_docpanel_checkbox");
			click("so_iam_legal_guardian_checkbox");
			click("so_proceed_button");
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	@Then("validation message is displayed under 'First name' field")
	public static void firstname_blank() throws InterruptedException, IOException {
		try {
			str= driver.findElement(By.xpath(OR_reader("so_first_name_validation_msg"))).getText();
			Assert.assertEquals(str,td_reader("so_first_name_validation_msg")); 
			browser_wait(1000);
			browser_refresh();
			click("create_new_case");
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	//TC_008 Validate that the user is not allowed leave blank 'Last name' field
	@When("'Last name' field are blank")
	public static void Request_second_opinion_negative_tc_008() throws Exception, InterruptedException {	
		try {
			click("so_other_checkbox");
			browser_wait(1000);
			driver.findElement(By.xpath(OR_reader("so_patient_first_name"))).sendKeys(td_reader("so_patient_first_name",2));
			click("so_other_agree_to_docpanel_checkbox");
			click("so_iam_legal_guardian_checkbox");
			click("so_proceed_button");
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	@Then("validation message is displayed under 'Last name' field")
	public static void lastname_blank() throws Exception, InterruptedException {
		try {
			str= driver.findElement(By.xpath(OR_reader("so_last_name_validation_msg"))).getText();
			Assert.assertEquals(str,td_reader("so_last_name_validation_msg")); 
			browser_wait(1000);
			browser_refresh();
			click("create_new_case");
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	//TC_009 Validate that the user should get a validation message on entering invalid 'First name'  and 'Last name' 
	@When("'First name' and 'Last name' fields are invalid")
	public static void Request_second_opinion_negative_tc_009() throws Exception, InterruptedException {		
		try {
			click("so_other_checkbox");
			driver.findElement(By.xpath(OR_reader( "so_patient_first_name"))).sendKeys(td_reader("so_patient_first_name",0));
			driver.findElement(By.xpath(OR_reader("so_patient_last_name"))).sendKeys(td_reader("so_patient_last_name",0));
			click("so_other_agree_to_docpanel_checkbox");
			click("so_iam_legal_guardian_checkbox");
			click("so_proceed_button");
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	@Then("validation message is display")
	public static void invalid_message() throws Exception, InterruptedException {
		try {
			str= driver.findElement(By.xpath(OR_reader("so_invalid_first_name"))).getText();
			Assert.assertEquals(str,td_reader("so_invalid_first_name")); 
			str= driver.findElement(By.xpath(OR_reader("so_invalid_last_name"))).getText();
			Assert.assertEquals(str,td_reader("so_invalid_last_name")); 
			browser_wait(1000);
			browser_refresh();
			click("create_new_case");
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	//TC_010 Validate that the user is not allowed to Proceed with invalid 'First name' and valid 'Last name'
	@When("invalid 'First name' and valid 'Last name'")
	public static void Request_second_opinion_negative_tc_010()  throws Exception, InterruptedException {	
		try {
			click("so_other_checkbox");
			driver.findElement(By.xpath(OR_reader( "so_patient_first_name"))).sendKeys(td_reader("so_patient_first_name",0));
			driver.findElement(By.xpath(OR_reader("so_patient_last_name"))).sendKeys(td_reader("so_patient_last_name",2));
			click("so_other_agree_to_docpanel_checkbox");
			click("so_iam_legal_guardian_checkbox");
			click("so_proceed_button");
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	@Then("validation message is displayed under 'First name'")
	public static void not_proceed()  throws Exception, InterruptedException {
		try {
			str= driver.findElement(By.xpath(OR_reader("so_invalid_first_name"))).getText();
			Assert.assertEquals(str,td_reader("so_invalid_first_name")); 
			browser_wait(1000);
			browser_refresh();
			click("create_new_case");
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

	//TC_011 Validate that the user is not allowed to Proceed with valid 'First name' and invalid 'Last name'
	@When("valid 'First name' and invalid 'Last name'")
	public static void Request_second_opinion_negative_tc_011()  throws Exception, InterruptedException {
		try {
			click_javascript("so_other_checkbox");
			driver.findElement(By.xpath(OR_reader("so_patient_first_name"))).sendKeys(td_reader("so_patient_first_name",3));
			driver.findElement(By.xpath(OR_reader("so_patient_last_name"))).sendKeys(td_reader("so_patient_last_name",3));
			click_javascript("so_other_agree_to_docpanel_checkbox");
			click_javascript("so_iam_legal_guardian_checkbox");
			click_javascript("so_proceed_button");
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	@Then("validation message is displayed under 'Last name'")
	public static void invalid_lastname()  throws Exception, InterruptedException {
		try {
			str= driver.findElement(By.xpath(OR_reader("so_invalid_last_name"))).getText();
			Assert.assertEquals(str,td_reader("so_invalid_last_name"));
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

	//TC_012 Validate that the "Proceed" button is disabled when user unchecked  the check box - 'I agree to DocPanel's
	@When("unchecked the check box 'I agree to DocPanels terms and condition'")
	public static void Request_second_opinion_negative_tc_012()  throws Exception {
		try {
			click("so_iam_legal_guardian_checkbox");
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	@Then("not allowed to Proceed")
	public static void checkbox_proceed()  throws Exception {
		try {
			value = driver.findElement(By.xpath(OR_reader("so_proceed_button"))).isEnabled();
			Assert.assertEquals(true,value); 
			browser_wait(1000);
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	//TC_013 Validate that  "Proceed" button is disabled when the check box - "I am the legal guardian or have the necessary consents to order this second opinion" is unchecked
	@When("unchecked the check box 'I am the legal guardian or have the necessary consents to order this second opinion'")
	public static void Request_second_opinion_negative_tc_013()  throws Exception {
		try {
			click("so_iam_legal_guardian_checkbox");
			click("so_other_agree_to_docpanel_checkbox");
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	@Then("unable to clicks on 'Proceed' button")
	public static void uncheck_proceed()  throws Exception {
		try {
			value = driver.findElement(By.xpath(OR_reader("so_proceed_button"))).isEnabled();
			Assert.assertEquals(true,value); 
			browser_wait(1000);
			System.out.println("Request second opinion negative");
			browser_close();
		} catch(Exception e) {
			e.printStackTrace();
		}		
	}
}

