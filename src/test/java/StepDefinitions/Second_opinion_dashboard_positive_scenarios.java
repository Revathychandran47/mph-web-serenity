package StepDefinitions;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import Reusable_Functions.Generic_function;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import java.io.File;

public class Second_opinion_dashboard_positive_scenarios extends Generic_function {
	static boolean value;
	public static WebElement fr1, fr,temp;
	public static File file;
	public static String driver_name;

	/* Browser opens and enter URL*/ 	
	@Given("browser is open")
	public void browser_open() throws Exception {
		try {
			Browser_Launch();						
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@When("clicks on the 'login' button")
	public void login() throws Exception {
		try {
			click("welcome_login");
			driver.findElement(By.xpath(OR_reader("login_phone_number"))).sendKeys(td_reader("login_phone_number",5));
			driver.findElement(By.xpath(OR_reader( "login_password"))).sendKeys(td_reader("login_password",6));
			click("login");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	@And("navigated to the login page")
	public void loginpage() throws Exception {
		try {
			browser_wait(1000);
			value = driver.findElement(By.xpath(OR_reader("logout"))).isDisplayed();
			Assert.assertEquals(true,value);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/*  TC_001-Validate that the user is able to click on the Second Opinion tab*/	
	@When("clicks on the second opinion tab")
	public void second_opinion_positive_dashboard_tc_001() throws Exception {
		try {
			browser_wait(1000);
			click("services");
			click("second_opinion");			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

	@Then("navigated to second opinion page")
	public void second_opinion_page() throws Exception {
		try {
			browser_explicit_wait("second_opinion_title");
			value = driver.findElement(By.xpath(OR_reader("second_opinion_title"))).isDisplayed();
			Assert.assertEquals(true,value);
		} catch (Exception e) {
			e.printStackTrace();
		}	
	}

	/* TC_002-Validate that the user is able to click on Resume Cases and is navigated to uplaod scans page */
	@When ("clicks on Resume Cases")
	public void second_opinion_positive_dashboard_tc_002() throws Exception, InterruptedException{
		try{
			Thread.sleep(5000);
			click_javascript("second_opinion_resume_cases");
			fr= driver.findElement(By.xpath(OR_reader("outer_frame")));
			driver.switchTo().frame(fr);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

	@Then("navigated to uplaod scans page")
	public void uploadscanspage() throws Exception {
		try {
			value = driver.findElement(By.xpath(OR_reader( "so_upload_scans_page_title"))).isDisplayed();
			Assert.assertEquals(true,value);
		} catch (Exception e) {
			e.printStackTrace();
		}		
	}

	/* TC_003 -Validate that user should be able to view the bar with Upload Scans as green color at the top of the page and links are working or not */
	@When("able to view the bar and links")
	public static void second_opinion_positive_dashboard_tc_003() throws Exception {
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

	/* TC_004 -Validate that the user should be able to upload scans by clicking on Upload my scans button */
	@When ("clicks on 'Upload my scans' button")
	public static void second_opinion_positive_dashboard_tc_004() throws Exception{
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
	@Then("able to upload scans")
	public void uploadscans() throws Exception {
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
		} catch (Exception e) {
			e.printStackTrace();
		}		
	}

	/* TC_005 -Validate that the user should be able to view the dialogue box when I do not have a doctor's report checkbox*/
	@When("'I do not have a doctors report' is check")
	public static void second_opinion_positive_dashboard_tc_005() throws Exception {
		try {
			browser_wait(20);
			click_javascript("so_don’t_have_doctors_checkbox");
			value = driver.findElement(By.xpath(OR_reader("so_upload_report"))).isDisplayed();
			Assert.assertEquals(true,value);
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	@Then("able to view the Upload scans page")
	public void viewuploadscans() throws Exception {
		try {
			click_javascript("so_upload_report");
			click_javascript("so_don’t_have_doctors_checkbox");
			click_javascript("so_don’t_have_doctors_checkbox");
			click_javascript("so_i_dont_have_it");
			value = driver.findElement(By.xpath(OR_reader( "so_don’t_have_doctors_checkbox"))).isDisplayed();
			Assert.assertEquals(true,value);
		} catch (Exception e) {
			e.printStackTrace();
		}		
	}

	/* TC_006 -Validate that the user should be able to upload reports by clicking on Upload my reports button*/
	@When("clicks on 'Upload my reports' button")
	public static void second_opinion_positive_dashboard_tc_006() throws Exception {
		try {
			browser_wait(30);
			file = new File(getreport());
			upload_files(file,"so_upload_report_button");
			Thread.sleep(3000);
			value = driver.findElement(By.xpath(OR_reader("so_uploaded_report"))).isDisplayed();
			Assert.assertEquals(true,value);
			browser_wait(5);
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	@Then("able to upload reports")
	public void uploadreports() throws Exception {
		try {
			click_javascript("so_upload_report");
			click_javascript("so_don’t_have_doctors_checkbox");
			click_javascript("so_don’t_have_doctors_checkbox");
			click_javascript("so_i_dont_have_it");
			value = driver.findElement(By.xpath(OR_reader( "so_don’t_have_doctors_checkbox"))).isDisplayed();
			Assert.assertEquals(true,value);
		} catch (Exception e) {
			e.printStackTrace();				
		}
	}

	/* TC_007 - Validate that User is able to click on Requested tab */
	@When ("clicks on the Requested tab")
	public static void second_opinion_positive_dashboard_tc_007() throws Exception, InterruptedException
	{
		try {
			driver.navigate().to(geturl());
			browser_explicit_wait("second_opinion_requested");
			click_javascript("second_opinion_requested");		
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	@Then("navigated to Requested page")
	public void Requestedpage() throws Exception {
		try {
			value = driver.findElement(By.xpath(OR_reader( "second_opinion_title"))).isDisplayed();
			Assert.assertEquals(true,value);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	/* TC_008 - Validate that User is able to click on Reviewed tag */
	@When ("clicks on the Reviewed tab")
	public static void second_opinion_positive_dashboard_tc_008() throws Exception
	{ 
		try {
			click_javascript("second_opinion_reviewed");   		
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	@Then("navigated to Reviewed  page")
	public void Reviewedpage() throws Exception {
		try {
			value = driver.findElement(By.xpath(OR_reader("second_opinion_title"))).isDisplayed();
			Assert.assertEquals(true,value);
			System.out.println("Second opinion dashboard positive");
			browser_close();
		} catch (Exception e) {
			e.printStackTrace();
		}		
	}
}
