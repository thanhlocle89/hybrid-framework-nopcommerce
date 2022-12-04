package com.nopcommerce.user;

import org.testng.annotations.Test;

import commons.BaseTest;
import io.qameta.allure.Description;
import pageObjects.nopCommer.user.UserCustomerInfoPageObject;
import pageObjects.nopCommer.user.UserHomePageObject;
import pageObjects.nopCommer.user.UserLoginPageObject;
import pageObjects.nopCommer.user.PageGeneratorManager;
import pageObjects.nopCommer.user.UserRegisterPageObject;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class Level_15_Allure extends BaseTest {

	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) {
		driver = getBrowserDriver(browserName);
		homePage = PageGeneratorManager.getUserHomePage(driver);

		firstName = "AutomationFcStudent";
		lastName = "Loc";
		emailAddress = "afc" + generateFakeNumber() + "@gmail.com";
		password = "123456";
	}

	@Test
	@Description("Register to the system")
	public void User_01_Register() {
		registerPage = homePage.openRegisterPage();

		registerPage.inputToFirstNameTextbox(firstName);

		registerPage.inputToLastNameTextbox(lastName);

		registerPage.inputToEmailTextbox(emailAddress);

		registerPage.inputToPasswordTextbox(password);

		registerPage.inputToConfirmPasswordTextbox(password);

		registerPage.clickToRegisterButton();

		Assert.assertEquals(registerPage.getRegisterSuccessMessage(), "Your registration completed..");

	}

	@Test
	@Description("Login to the system")
	public void User_02_Login() {
		homePage = registerPage.clickToLogoutlink();

		loginPage = homePage.openUserLoginPage();

		loginPage.InputToEmailTextbox(emailAddress);

		loginPage.InputToPasswordTextbox(password);

		loginPage.clickToLoginButton();

		Assert.assertFalse(homePage.isMyAccountLinkDisplayed());

		customerInforPage = homePage.openMyAccountPage();

		Assert.assertFalse(customerInforPage.isCustomerInfoPageDisplayed());
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

	public int generateFakeNumber() {
		Random rad = new Random();
		return rad.nextInt(999);
	}

	private UserCustomerInfoPageObject customerInforPage;
	private UserHomePageObject homePage;
	private UserRegisterPageObject registerPage;
	private UserLoginPageObject loginPage;
	private WebDriver driver;
	private String emailAddress;
	private String firstName;
	private String lastName;
	private String password;
}
