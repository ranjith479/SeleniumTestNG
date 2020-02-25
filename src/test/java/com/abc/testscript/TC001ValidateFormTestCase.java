package com.abc.testscript;
import java.net.UnknownHostException;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;

import com.abc.projectpage.TestngAnnotations;
import com.abc.seleniumrepository.SeleniumRepo;
import com.abc.seleniumrepository.SeleniumRepoDropdown;
import com.abc.util.PropertyFileRead;
/**
 * 
 * @author name
 * Search related functionality test cases
 */

public class TC001ValidateFormTestCase extends TestngAnnotations {
	
	
	/*@BeforeTest
	public void BeforeTest() throws UnknownHostException
	{
	
	 * @param 1: Browser name -firefox or internetExplorer or chrome
	 *  Below firefox string is being read from the ProjectData.property file in resources package
	 *  
	 *  @param 2: Browser Proxy Yes or No. If yes then port and Host details are read from the Property file
	 
		Reporter.log("TestCase Starts");
		SeleniumRepo.startBrowser(PropertyFileRead.FileRead("ProjectData.properties","BrowserType"), false);
		SeleniumRepo.driver.manage().window().maximize();
	}*/
	
	/*@AfterTest
	public void AfterTest() throws UnknownHostException
	{
	Reporter.log("TestCase Ends");
		SeleniumRepo.shutDownDriver();
		
	}*/
	/**
	 * @author name
	 * Goes to a specific site and performs Search Suggestion Test
	 * @throws InterruptedException 
	 */
	@Test
	public void formValidationTest() throws InterruptedException 
	{
	/*
	 * @param : Site URL Navigation
	 * URL is read from ProjectData.properties file in resources package
	 */
		Reporter.log("Start Test");
		SeleniumRepo.GoToUrl(PropertyFileRead.FileRead("ProjectData.properties","TS01SiteURLNavigation"));
		SeleniumRepo.WaitForLoad(2000);
		
		// Check if textbox is Present, Text Input Suggestion is available, click and Enter text
		if(SeleniumRepo.isElementPresent(PropertyFileRead.FileRead("ProjectData.properties","FirstName")))
		{
		SeleniumRepo.enterText(PropertyFileRead.FileRead("ProjectData.properties","FirstName"),"Som");
		Reporter.log("First Name Textbox is found and First Name is Entered");
		Assert.assertEquals("First Name TextBox found","First Name TextBox found","First Name Textbox is found and First Name is Entered");
		}
		else
		{
			Reporter.log("First Name Textbox not found");
			Assert.assertEquals("First Name TextBox","First Name TextBox Not found	","First Name TextBox Not found");
			
		}
		
		
		// Check if textbox is Present, Text Input Suggestion is available, click and Enter text
		if(SeleniumRepo.isElementPresent(PropertyFileRead.FileRead("ProjectData.properties","LastName")))
		{
		SeleniumRepo.enterText(PropertyFileRead.FileRead("ProjectData.properties","LastName"),"Sah");
		Reporter.log("Last Name Textbox is found and Last Name is Entered");
		Assert.assertEquals("Last Name TextBox found","Last Name TextBox found","Last Name Textbox is found and Last Name is Entered");
		}
		else
		{
			Reporter.log("LastName Textbox not found");
			Assert.assertEquals("Last Name TextBox","Last Name TextBox Not found	","LastName Textbox not found");
		}
				
		// Check if textbox is Present, Text Input Suggestion is available, click and Enter text
		if(SeleniumRepo.isElementPresent(PropertyFileRead.FileRead("ProjectData.properties","Company")))
		{
		SeleniumRepo.enterText(PropertyFileRead.FileRead("ProjectData.properties","Company"),"Acc");
		Reporter.log("Company Textbox is found and Company Name is Entered");
		}
		else
		{
			Reporter.log("Company TextBox not found");
		}
	
		// Click and Enter the Job Title 						
		if(SeleniumRepo.isElementPresent(PropertyFileRead.FileRead("ProjectData.properties","JobTitle")))
		{
		SeleniumRepo.enterText(PropertyFileRead.FileRead("ProjectData.properties","JobTitle"),"Title Job");
		}
		else
		{
			Reporter.log("Job Title TextBox not found");
		}
		
		// Click on the Dropdown and then select the value
		if(SeleniumRepo.isElementPresent(PropertyFileRead.FileRead("ProjectData.properties","Country")))
		{
		
		SeleniumRepo.click(PropertyFileRead.FileRead("ProjectData.properties","Country"));
		SeleniumRepoDropdown.selectDropDownByVisibleText(PropertyFileRead.FileRead("ProjectData.properties","Country"),"United States");
		Reporter.log("Country dropdown is found and Country Name is Selected");
		try {
			SeleniumRepo.WaitForLoad(500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		}
		else
		{
			Reporter.log("Country Dropdown not found");
		}

		// Check if textbox is Present, Text Input Suggestion is available, click and Enter text
		if(SeleniumRepo.isElementPresent(PropertyFileRead.FileRead("ProjectData.properties","EmailID")))
		{
		SeleniumRepo.enterText(PropertyFileRead.FileRead("ProjectData.properties","EmailID"),"tmail@gmail.com");
		Reporter.log("Email Textbox is found and Email ID is Entered");
		}
		else
		{
			Reporter.log("Email TextBox not found");
		}
		
		SeleniumRepo.WaitForLoad(500);
	}
}