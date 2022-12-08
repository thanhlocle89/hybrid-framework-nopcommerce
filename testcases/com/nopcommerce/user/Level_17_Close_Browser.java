package com.nopcommerce.user;

import org.testng.annotations.Test;

import com.nopcommerce.common.Common_01_Register_New_Account;

import commons.BaseTest;
import pageObjects.nopCommer.user.UserHomePageObject;
import pageObjects.nopCommer.user.UserLoginPageObject;
import pageObjects.nopCommer.user.PageGeneratorManager;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;

public class Level_17_Close_Browser extends BaseTest {

	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) {
		driver = getBrowserDriver(browserName);
		homePage = PageGeneratorManager.getUserHomePage(driver);
		
		emailAddress = Common_01_Register_New_Account.emailAddress;
		password = Common_01_Register_New_Account.password;

		loginPage = homePage.openUserLoginPage();

		loginPage.InputToEmailTextbox(emailAddress);

		loginPage.InputToPasswordTextbox(password);

		loginPage.clickToLoginButton();
	}

	@Test
	public void Search__01_Empty_Data() {

	}
	
	
	public void Search__02_Relative_Product_Name() {
		
	}
	
	public void Search__03_Absoulute_Product_Name() {
		
	}
	
	public void Search__04_Paretn_Category() {
		
	}
	
	public void Search__05_Incorrect_Manufactorer() {
		
	}
	
	public void Search__06_Correct_Manufactorer() {
		
	}
	@AfterClass(alwaysRun = true)
	public void afterClass() {
		closeBrowserAndDriver();
	}

	public int generateFakeNumber() {
		Random rad = new Random();
		return rad.nextInt(999);
	}

	private UserHomePageObject homePage;
	private UserLoginPageObject loginPage;
	private WebDriver driver;
	private String emailAddress,password;
}
