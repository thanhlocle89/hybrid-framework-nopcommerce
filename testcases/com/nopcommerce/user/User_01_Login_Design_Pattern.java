package com.nopcommerce.user;

import org.testng.annotations.Test;

import commons.BasePage;
import pageObjects.HomePageObject;
import pageObjects.LoginPageObject;
import pageObjects.RegisterPageObject;

import org.testng.annotations.BeforeClass;

import static org.testng.Assert.assertEquals;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.By.ByCssSelector;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class User_01_Login_Design_Pattern extends BasePage{

	private HomePageObject homePage;
	private RegisterPageObject registerPage;
	private LoginPageObject loginPage;
	private WebDriver driver;
	private String projectPath = System.getProperty("user.dir");
	private String existingEmailAddress,invalidEmail,notFoundEmail;
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
		firstName = "AutomationFcStudent";
		lastName = "Loc";
		invalidEmail = "afc@afc@123@#.vn";
		notFoundEmail = "afc" + generateFakeNumber() + "@gmail.net";
		existingEmailAddress ="afc" + generateFakeNumber() + "@gmail.com";
		password = "123456";
		
//		goto register page
		System.out.println("Precondition - Step 01:Click to Regsiter link");
		homePage.clickToRegisterLink();
		registerPage = new RegisterPageObject(driver);
		
//		Input data 
		System.out.println("Precondition - Step 02: Input to required fields");
		registerPage.inputToFirstNameTextbox(firstName);
		registerPage.inputToLastNameTextbox(lastName);
		registerPage.inputToEmailTextbox(existingEmailAddress);
		registerPage.inputToPasswordTextbox(password);
		registerPage.inputToConfirmPasswordTextbox(password);
		
//		click Register button
		System.out.println("Precondition - Step 03: Click to Register Button");
		registerPage.clickToRegisterButton();
//		Verify text
		System.out.println("Precondition - Step 04: Verify success messages displayed");
		Assert.assertEquals(registerPage.getRegisterSuccessMessage(),"Your registration completed");
//		click Logout
		System.out.println("Precondition - Step 05: Click to Logout link");
		registerPage.clickToLogoutlink();
		homePage = new HomePageObject(driver);
	}

	@Test
	public void Login_01_Empty_Data() {
		homePage.clickToLoginLink();
		loginPage = new LoginPageObject(driver);
		loginPage.clickToLoginButton();
		
		Assert.assertEquals(loginPage.getErrorMessageAtEmailTextbox(),"Please enter your email");
	}
	@Test
	public void Login_02_Invalid_Email() {
		homePage.clickToLoginLink();
		loginPage = new LoginPageObject(driver);
		
		loginPage.InputToEmailTextbox(invalidEmail);
		loginPage.clickToLoginButton();
		
		Assert.assertEquals(loginPage.getErrorMessageAtEmailTextbox(),"Wrong email");
	}
	@Test
	public void Login_03_Email_Not_Found() {
		homePage.clickToLoginLink();
		loginPage = new LoginPageObject(driver);
		
		loginPage.InputToEmailTextbox(notFoundEmail);
		loginPage.clickToLoginButton();
		
		Assert.assertEquals(loginPage.getErrorMessageUnsuccessful(),"Login was unsuccessful. Please correct the errors and try again.\nNo customer account found");
	}
	@Test
	public void Login_04_Existing_Email_Empty_Password() {
		homePage.clickToLoginLink();
		loginPage = new LoginPageObject(driver);
		
		loginPage.InputToEmailTextbox(existingEmailAddress);
		loginPage.InputToPasswordTextbox("");
		loginPage.clickToLoginButton();
		
		Assert.assertEquals(loginPage.getErrorMessageUnsuccessful(),"Login was unsuccessful. Please correct the errors and try again.\nThe credentials provided are incorrect");
		
	}
	@Test
	public void Login_05_Existing_Email_Incorrect_Password() {
		homePage.clickToLoginLink();
		loginPage = new LoginPageObject(driver);
		
		loginPage.InputToEmailTextbox(existingEmailAddress);
		loginPage.InputToPasswordTextbox("654231");
		loginPage.clickToLoginButton();
		
		Assert.assertEquals(loginPage.getErrorMessageUnsuccessful(),"Login was unsuccessful. Please correct the errors and try again.\nThe credentials provided are incorrect");
	}
	@Test
	public void Login_06_Valid_Email_Password() {
		homePage.clickToLoginLink();
		loginPage = new LoginPageObject(driver);
		
		loginPage.InputToEmailTextbox(existingEmailAddress);
		loginPage.InputToPasswordTextbox(password);
		loginPage.clickToLoginButton();
		
		homePage = new HomePageObject(driver);
		Assert.assertTrue(homePage.isMyAccountLinkDisplayed());
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
