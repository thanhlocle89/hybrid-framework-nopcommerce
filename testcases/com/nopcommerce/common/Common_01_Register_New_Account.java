package com.nopcommerce.common;

import commons.BaseTest;
import pageObjects.nopCommer.user.UserHomePageObject;
import pageObjects.nopCommer.user.PageGeneratorManager;
import pageObjects.nopCommer.user.UserRegisterPageObject;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class Common_01_Register_New_Account extends BaseTest {

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

	}

	@AfterTest
	public void afterClass() {
		driver.quit();
	}

	public int generateFakeNumber() {
		Random rad = new Random();
		return rad.nextInt(999);
	}

	private UserHomePageObject homePage;
	private UserRegisterPageObject registerPage;
	private WebDriver driver;
	public static String emailAddress,password;
	private String firstName;
	private String lastName;
}
