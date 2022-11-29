package com.facebook.register;

import org.testng.annotations.Test;
import commons.BaseTest;
import facebook.HomePageObject;
import facebook.PageGeneratorManager;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;

public class Level_13_Element_Undisplayed extends BaseTest {

	@Parameters({ "browser", "url" })
	@BeforeClass
	public void beforeClass(String browserName, String appUrl) {
		driver = getBrowserDriver(browserName, appUrl);
		homePage = PageGeneratorManager.getHomePage(driver);
	}

	@Test
	public void TC_01_Verify_Element_Displayed() {
		homePage.clickToCreatNewAccountButton();
		verifyTrue(homePage.isEmailAddressTextboxDisplayed());
	}
	
	@Test
	public void TC_02_Verify_Element_Undisplayed_In_DOM() {
		homePage.enterToEmailAddressTextbox("leloc89@hotmail.com");
		verifyTrue(homePage.isConfirmEmailAddressTextboxDisplayed());
		homePage.sleepInSecond(3);
		
		homePage.enterToEmailAddressTextbox("");
		homePage.sleepInSecond(3);
		verifyFalse(homePage.isConfirmEmailAddressTextboxDisplayed());
	}
	
	@Test
	public void TC_03_Verify_Element_Undisplayed_Not_In_DOM() {
		homePage.clickToCloseIconAtRegisterForm();
		homePage.sleepInSecond(3);
		verifyTrue(homePage.isConfirmEmailAddressTextboxUnDisplayed());
	}
	@AfterClass
	public void afterClass() {
		driver.quit();
	}

	private WebDriver driver;
	private HomePageObject homePage;
}
