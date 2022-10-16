package com.nopcommerce.user;

import org.testng.annotations.Test;

import commons.BasePage;
import pageObjects.HomePageObject;
import pageObjects.RegisterPageObject;

import org.testng.annotations.BeforeClass;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.By.ByCssSelector;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class User_01_Register_Login_Design_Pattern extends BasePage{

	private HomePageObject homePage;
	private RegisterPageObject registerPage;
	private WebDriver driver;
	private String projectPath = System.getProperty("user.dir");
	private String emailAddress;
	private String firstName;
	private String lastName;
	private String password;
	
	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDriver\\geckodriver.exe");
		driver = new FirefoxDriver();
		
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("https://demo.nopcommerce.com/");	
		
		homePage = new HomePageObject(driver);
		registerPage = new RegisterPageObject(driver);
		firstName = "AutomationFcStudent";
		lastName = "Loc";
		emailAddress ="afc" + generateFakeNumber() + "@gmail.com";
		password = "123456";
	}

	@Test
	public void Register_01_Empty_Data() {
//		goto register page
		System.out.println("Register_01 - Step 01: Click to Regsiter link");
		homePage.clickToRegisterLink();
//		click Register button
		
		System.out.println("Register_01 - Step 02: Click to Register Button");
		registerPage.clickToRegisterButton();
//		Verify text
		System.out.println("Register Page - Step 03: Verify error messages displayed");
		Assert.assertEquals(registerPage.getErrorMessageAtFirstNameTextbox(),"First name is required.");
		Assert.assertEquals(registerPage.getErrorMessageAtLastNameTextbox(),"Last name is required.");
		Assert.assertEquals(registerPage.getErrorMessageAtEmailTextbox(),"Email is required.");
		Assert.assertEquals(registerPage.getErrorMessageAtPasswordTextbox(),"Password is required.");
		Assert.assertEquals(registerPage.getErrorMessageAtConfirmPasswordTextbox(),"Password is required.");
	}

	@Test
	public void Register_02_Invalid_Email() {
//		goto register page
		System.out.println("Register_02 - Step 01:Click to Regsiter link");
		homePage.clickToRegisterLink();
		
//		Input data 
		System.out.println("Register_02 - Step 02: Input to required fields");
		registerPage.inputToFirstNameTextbox(firstName);
		registerPage.inputToLastNameTextbox(lastName);
		registerPage.inputToEmailTextbox("123@123!@#");
		registerPage.inputToPasswordTextbox(password);
		registerPage.inputToConfirmPasswordTextbox(password);
		
//		click Register button
		System.out.println("Register_02 - Step 03: Click to Register Button");
		registerPage.clickToRegisterButton();
		
//		Verify text
		System.out.println("Register_02 - Step 04: Verify error messages displayed");
		Assert.assertEquals(registerPage.getErrorMessageAtEmailTextbox(),"Wrong email");
	}

	@Test
	public void Register_03_Success() {
//		goto register page
		System.out.println("Home Page - Step 01:Click to Regsiter link");
		homePage.clickToRegisterLink();
		
//		Input data 
		System.out.println("Register_03 - Step 02: Input to required fields");
		registerPage.inputToFirstNameTextbox(firstName);
		registerPage.inputToLastNameTextbox(lastName);
		registerPage.inputToEmailTextbox(emailAddress);
		registerPage.inputToPasswordTextbox(password);
		registerPage.inputToConfirmPasswordTextbox(password);
		
//		click Register button
		System.out.println("Register_03 - Step 03: Click to Register Button");
		registerPage.clickToRegisterButton();
//		Verify text
		System.out.println("Register_03 - Step 04: Verify success messages displayed");
		Assert.assertEquals(registerPage.getRegisterSuccessMessage(),"Your registration completed");
//		click Logout
		System.out.println("Register_03 - Step 05: Click to Logout link");
		registerPage.clickToLogoutlink();
	}

	@Test
	public void Register_04_Existing_Email() {
//		goto register page
		System.out.println("Register_04 - Step 01:Click to Regsiter link");
		homePage.clickToRegisterLink();
//		Input data 
		System.out.println("Register_04 - Step 02: Input to required fields");
		registerPage.inputToFirstNameTextbox(firstName);
		registerPage.inputToLastNameTextbox(lastName);
		registerPage.inputToEmailTextbox(emailAddress);
		registerPage.inputToPasswordTextbox(password);
		registerPage.inputToConfirmPasswordTextbox(password);
//		click Register button
		System.out.println("Register_04 - Step 03: Click to Register Button");
		registerPage.clickToRegisterButton();
//		Verify text
		System.out.println("Register_04 - Step 04: Verify error messages displayed");
		Assert.assertEquals(registerPage.getErrorExistingEmailMessage(),"The specified email already exists");
	}

	@Test
	public void Register_05_Password_Less_Than_6_Chars() {
//		goto register page
		System.out.println("Register_05 - Step 01:Click to Regsiter link");
		homePage.clickToRegisterLink();
//		Input data 
		System.out.println("Register_05 - Step 02: Input to required fields");
		registerPage.inputToFirstNameTextbox(firstName);
		registerPage.inputToLastNameTextbox(lastName);
		registerPage.inputToEmailTextbox(emailAddress);
		registerPage.inputToPasswordTextbox("123");
		registerPage.inputToConfirmPasswordTextbox("123");
//		click Register button
		System.out.println("Register_05 - Step 03: Click to Register Button");
		registerPage.clickToRegisterButton();
//		Verify text
		System.out.println("Register_05 - Step 04: Verify error messages displayed");
		Assert.assertEquals(registerPage.getErrorMessageAtPasswordTextbox(),"Password must meet the following rules:\nmust have at least 6 characters");
	}

	@Test
	public void Register_06_Invalid_Confirm_Password() {	
//		goto register page
		System.out.println("Register_06 - Step 01:Click to Regsiter link");
		homePage.clickToRegisterLink();
//		Input data
		System.out.println("Register_06 - Step 02: Input to required fields");
		registerPage.inputToFirstNameTextbox(firstName);
		registerPage.inputToLastNameTextbox(lastName);
		registerPage.inputToEmailTextbox(emailAddress);
		registerPage.inputToPasswordTextbox(password);
		registerPage.inputToConfirmPasswordTextbox("123654");
//		click Register button
		System.out.println("Register_06 - Step 03: Click to Register Button");
		registerPage.clickToRegisterButton();
//		Verify text
		System.out.println("RRegister_06 - Step 04: Verify error messages displayed");
		Assert.assertEquals(registerPage.getErrorMessageAtConfirmPasswordTextbox(),"The password and confirmation password do not match.");
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

	public int generateFakeNumber(){
		Random rad = new Random();
		return rad.nextInt(999);
	}

	
}
