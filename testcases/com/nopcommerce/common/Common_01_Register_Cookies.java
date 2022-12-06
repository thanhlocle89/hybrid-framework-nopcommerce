package com.nopcommerce.common;

import commons.BaseTest;
import pageObjects.nopCommer.user.UserHomePageObject;
import pageObjects.nopCommer.user.UserLoginPageObject;
import pageObjects.nopCommer.user.PageGeneratorManager;
import pageObjects.nopCommer.user.UserRegisterPageObject;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import java.util.Random;
import java.util.Set;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class Common_01_Register_Cookies extends BaseTest {

	@Parameters("browser")
	@BeforeTest(description = "Create new common User for all Classes Test")
	public void Register(String browserName) {
		driver = getBrowserDriver(browserName);
		homePage = PageGeneratorManager.getUserHomePage(driver);

		firstName = "AutomationFcStudent";
		lastName = "Loc";
		emailAddress = "afc" + generateFakeNumber() + "@gmail.com";
		password = "123456";
		registerPage = homePage.openRegisterPage();

		registerPage.inputToFirstNameTextbox(firstName);

		registerPage.inputToLastNameTextbox(lastName);

		registerPage.inputToEmailTextbox(emailAddress);

		registerPage.inputToPasswordTextbox(password);

		registerPage.inputToConfirmPasswordTextbox(password);

		registerPage.clickToRegisterButton();

		Assert.assertEquals(registerPage.getRegisterSuccessMessage(), "Your registration completed");
		
		homePage = registerPage.clickToLogoutlink();

		loginPage = homePage.openUserLoginPage();

		loginPage.InputToEmailTextbox(emailAddress);

		loginPage.InputToPasswordTextbox(password);

		loginPage.clickToLoginButton();
		loggedCookies=loginPage.getAllCookies(driver);
		
		driver.quit();
	}


	public int generateFakeNumber() {
		Random rad = new Random();
		return rad.nextInt(999);
	}

	private UserHomePageObject homePage;
	private UserRegisterPageObject registerPage;
	private UserLoginPageObject loginPage;
	private WebDriver driver;
	public static String emailAddress,password;
	private String firstName;
	private String lastName;
	public static Set<Cookie> loggedCookies; 
}
