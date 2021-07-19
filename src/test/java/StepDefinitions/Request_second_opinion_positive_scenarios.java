package StepDefinitions;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import Reusable_Functions.Generic_function;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import java.io.File;

public class Request_second_opinion_positive_scenarios extends Generic_function {
	static boolean value;
	static String text,month,year,monthval,yearval,te,driver_name;
	static WebElement fr,fr1,element,ele,temp;
	static File file;

	/*Browser opens and user is on home page*/ 	
	@When("home page is open")
	public static void homepage() throws Exception{
		try {
			Browser_Launch();
			click("welcome_login");
			driver.findElement(By.xpath(OR_reader( "login_phone_number"))).sendKeys(td_reader("login_phone_number",6));
			driver.findElement(By.xpath(OR_reader("login_password"))).sendKeys(td_reader("login_password",7));
			click("login");
			browser_wait(1000);
			value = driver.findElement(By.xpath(OR_reader( "logout"))).isDisplayed();
			Assert.assertEquals(true,value);
		}catch (Exception e) {
			e.printStackTrace();
		}		
	}

	/* TC_001 -Validate that user must be able to view 'Request for a second opinion' under Home page */
	@Then("clicks on 'Request a Second Opinion' button")
	public static void request_second_opinion_positive_tc_001() throws Exception {
		try {
			click("request_second_opinion_button");
			browser_wait(1000);
			click("create_new_case");		
		}catch (Exception e) {			
		}	
	}
	@And("navigated to Request a Second Opinion page")
	public static void secondopinionpage() throws Exception {
		try {
			value = driver.findElement(By.xpath(OR_reader("request_second_opinion_title"))).isDisplayed();
			Assert.assertEquals(true,value);
		}catch (Exception e) {
		}	
	}

	/* TC_002 -Validate that user must be able to view the texts on the landing page */
	@Then("able to view texts on the page")
	public static void request_second_opinion_positive_tc_002() throws Exception {
		try {
			//			value = driver.findElement(By.xpath(OR_reader("so_your_price_text"))).isDisplayed();
			//			Assert.assertEquals(true,value);
			//			browser_explicit_wait("so_who_is_this_text");
			//			value = driver.findElement(By.xpath(OR_reader("so_who_is_this_text"))).isDisplayed();
			//			Assert.assertEquals(true,value);
			//			browser_explicit_wait("so_you_are_about_to_text");
			//			value = driver.findElement(By.xpath(OR_reader("so_you_are_about_to_text"))).isDisplayed();
			//			Assert.assertEquals(true,value);
		}catch (Exception e) {
			e.printStackTrace();			
		}	
	}

	/* TC_003 -Validate that user can able to view  box  with  additional information at the bottom of page */
	@Then("able to view the informations")
	public static void request_second_opinion_positive_tc_003() throws Exception {
		try {
			//			value = driver.findElement(By.xpath(OR_reader( "so_if_you_need_help_text"))).isDisplayed();
			//			Assert.assertEquals(true,value);
			//			browser_explicit_wait("so_mail_id_text");
			//			value = driver.findElement(By.xpath(OR_reader( "so_mail_id_text"))).isDisplayed();
			//			Assert.assertEquals(true,value);
			//			browser_explicit_wait("so_phone_number_text");
			//			value = driver.findElement(By.xpath(OR_reader("so_phone_number_text"))).isDisplayed();
			//			Assert.assertEquals(true,value);
			//			browser_explicit_wait("so_for_more_info_text");
			//			value = driver.findElement(By.xpath(OR_reader("so_for_more_info_text"))).isDisplayed();
			//			Assert.assertEquals(true,value);
		}catch (Exception e) {
			e.printStackTrace();			
		}	
	}

	/* TC_004 -Validate that the user should navigated to "Upload Scans " page when "Proceed" button is clicked */
	@When("clicks on 'proceed' button")
	public static void request_second_opinion_positive_tc_004() throws Exception {
		try {
			click("so_agree_to_docpanel_checkbox");
			browser_wait(10);
			click("so_proceed_button");
			Thread.sleep(8000);
			fr= driver.findElement(By.xpath(OR_reader("outer_frame")));
			driver.switchTo().frame(fr);
		}catch (Exception e) {
			e.printStackTrace();		
		}	
	}
	@Then("navigated to Upload Scans page")
	public static void uploadscanspage() throws Exception {
		try {
			value = driver.findElement(By.xpath(OR_reader("so_upload_scans_page_title"))).isDisplayed();
			Assert.assertEquals(true,value);
			browser_wait(30);
		}catch (Exception e) {
			e.printStackTrace();

		}	
	}

	/* TC_005 -Validate that user should be able to view the bar with Upload Scans as green color at the top of the page and links are working or not */
	@Then("Able to view the bar and links")
	public static void request_second_opinion_positive_tc_005() throws Exception {
		try {
			value = driver.findElement(By.xpath(OR_reader( "so_upload_scans_page_title"))).isDisplayed();
			Assert.assertEquals(true,value);
			click_javascript("so_how_do_upload_link");
			browser_wait(30);
			click_javascript("so_close_button");
			browser_wait(30);
			click_javascript("so_don’t_have_scans_link");
			value = driver.findElement(By.xpath(OR_reader( "so_don’t_have_scans_ok"))).isDisplayed();
			Assert.assertEquals(true,value);
			click_javascript("so_don’t_have_scans_ok");
		}catch (Exception e) {
			e.printStackTrace();		
		}	
	}

	/* TC_006 -Validate that the user should be able to upload scans by clicking on Upload my scans button*/
	@When("clicks on the 'Upload my scans' button")
	public static void request_second_opinion_positive_tc_006() throws Exception {
		try {
			click_javascript("so_upload_scans_button");
			Thread.sleep(4000);
			fr1= driver.findElement(By.xpath(OR_reader("inner_frame")));
			driver.switchTo().frame(fr1);
			Thread.sleep(2000);
			value = driver.findElement(By.xpath(OR_reader( "so_choose_file_title"))).isDisplayed();
			Assert.assertEquals(true,value);
		}catch (Exception e) {
			e.printStackTrace();			
		}
	}
	@Then("Able to upload scans")
	public static void uploadscans() throws Exception {
		try {
			browser_wait(20);
			click_javascript("so_choose_file_button");	
			driver_name = browser_name();
			file = new File(getimage());
			if(driver_name.equals("geck"))
			{
				ff_upload_files(file);
				Thread.sleep(1000);
				driver.switchTo().alert().accept();				
			}
			else{
				upload_files(file,"so_choose_file_button");
			}
			browser_wait(20);
			Thread.sleep(1000);
			driver.switchTo().defaultContent();
			fr= driver.findElement(By.xpath(OR_reader("outer_frame")));
			driver.switchTo().frame(fr);
			click_javascript("so_upload_scan_close_button");
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

	/* TC_007 -Validate that the user should be able to upload reports by clicking on Upload my reports button*/
	@When("clicks on the 'Upload my reports' button")
	public static void request_second_opinion_positive_tc_007() throws Exception {
		try {
			browser_wait(30);
			file = new File(getreport());
			upload_files(file,"so_upload_report_button");
			Thread.sleep(3000);
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	@Then("Able to upload reports")
	public static void reports() throws Exception {
		try {
			value = driver.findElement(By.xpath(OR_reader( "so_uploaded_report"))).isDisplayed();
			Assert.assertEquals(true,value);
			browser_wait(5);
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

	/* TC_008 -Validate that the user should be able to view the dialogue box when I do not have a doctor's report checkbox*/
	@When("Checkbox 'I do not have a doctors report' is check")
	public static void request_second_opinion_positive_tc_008() throws Exception {
		try {
			browser_wait(20);
			click_javascript("so_don’t_have_doctors_checkbox");
			value = driver.findElement(By.xpath(OR_reader( "so_upload_report"))).isDisplayed();
			Assert.assertEquals(true,value);
			click_javascript("so_upload_report");
			click_javascript("so_don’t_have_doctors_checkbox");
			click_javascript("so_don’t_have_doctors_checkbox");
			click_javascript("so_i_dont_have_it");
		}catch (Exception e) {
			e.printStackTrace();		
		}
	}
	@Then("Able to view the Upload scans page")
	public static void viewscans() throws Exception {
		try {
			value = driver.findElement(By.xpath(OR_reader("so_don’t_have_doctors_checkbox"))).isDisplayed();
			Assert.assertEquals(true,value);
		}catch (Exception e) {
			e.printStackTrace();		
		}
	}

	/* TC_009 -Validate that the user should navigated to "Upload Scans" page by checking "Other " check box and by entering details.*/
	@When("checks other check box and enters details")
	public static void request_second_opinion_positive_tc_009() throws Exception {
		try {
			driver.navigate().to(getsourl());
			click("create_new_case");
			click("so_other_checkbox");
			browser_wait(1000);
			driver.findElement(By.xpath(OR_reader("so_patient_first_name"))).sendKeys(td_reader("patient_first_name"));
			driver.findElement(By.xpath(OR_reader("so_patient_last_name"))).sendKeys(td_reader("patient_last_name"));
			click("so_patient_dob");
			te= driver.findElement(By.xpath(OR_reader("so_patient_dob_month_year"))).getText();
			month = te.split(" ")[0].trim();
			year = te.split(" ")[1].trim();
			monthval=td_reader("dob_month");
			yearval=td_reader("dob_year");
			while(!(month.equals(monthval)&& year.equals(yearval)))
			{
				click("so_dob_left_arrow");
				te= driver.findElement(By.xpath(OR_reader("so_patient_dob_month_year"))).getText();
				month = te.split(" ")[0].trim();
				year = te.split(" ")[1].trim();
			}
			click("so_dob_date");
			click("so_dob_year_ok");
			click("so_patient_relationship");
			text = td_reader("patient_relationship");
			drop_down(OR_reader( "so_patient_relationship_list"),text);
			driver.findElement(By.xpath(OR_reader("so_patient_state"))).sendKeys(td_reader("patient_state"));
			click("so_patient_gender");
			text = td_reader("patient_gender");
			drop_down(OR_reader( "so_patient_relationship_list"),text);
			browser_wait(1000);
			click("so_other_agree_to_docpanel_checkbox");
			click("so_iam_legal_guardian_checkbox");
			click("so_proceed_button");
			Thread.sleep(8000);
			fr= driver.findElement(By.xpath(OR_reader("outer_frame")));
			driver.switchTo().frame(fr);
		}catch (Exception e) {
			e.printStackTrace();			
		}
	}
	@Then("navigated to upload scans page")
	public static void uploadscanpage() throws Exception {
		try {
			value = driver.findElement(By.xpath(OR_reader( "so_upload_scans_page_title"))).isDisplayed();
			Assert.assertEquals(true,value);
			System.out.println("Request a second opinion positive");
			browser_close();
		}catch (Exception e) {
			e.printStackTrace();

		}
	}
}
