package com.nopcommerce.user;

import org.testng.annotations.Test;

import commons.BasePage;
import commons.BaseTest;
import pageObjects.nopCommer.user.UserAddressPageObject;
import pageObjects.nopCommer.user.UserCustomerInfoPageObject;
import pageObjects.nopCommer.user.UserHomePageObject;
import pageObjects.nopCommer.user.UserLoginPageObject;
import pageObjects.nopCommer.user.UserMyProductReviewPageObject;
import pageObjects.nopCommer.user.PageGeneratorManager;
import pageObjects.nopCommer.user.UserRegisterPageObject;
import pageObjects.nopCommer.user.UserRewardPointPageObject;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import static org.testng.Assert.assertEquals;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.By.ByCssSelector;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class Level_18_Pattern_Object extends BaseTest {


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
	public void User_01_Register() {
		log.info("Register - Step 01: Navigate to 'Login page'");
		registerPage = homePage.openRegisterPage();
		
		log.info("Register - Step 02: Enter to First Name text box with value is '"+ firstName+ "'");
//		registerPage.inputToFirstNameTextbox(firstName);
		registerPage.inputToTextBoxByID(driver,"FirstName",firstName);
		
		log.info("Register - Step 03: Enter to last name text box with value is '"+ lastName + "'");
//		registerPage.inputToLastNameTextbox(lastName);
		registerPage.inputToTextBoxByID(driver,"LastName",lastName);
		
		log.info("Register - Step 04: Enter to Email address text box with value is '"+ emailAddress + "'");
//		registerPage.inputToEmailTextbox(emailAddress);
		registerPage.inputToTextBoxByID(driver,"Email",emailAddress);
		
		log.info("Register - Step 05: Enter to password text box with value is '"+ password+ "'");
//		registerPage.inputToPasswordTextbox(password);
		registerPage.inputToTextBoxByID(driver,"Password",password);
		
		log.info("Register - Step 06: Enter to confirm password text box with value is '"+ password+ "'");
//		registerPage.inputToConfirmPasswordTextbox(password);
		registerPage.inputToTextBoxByID(driver,"ConfirmPassword",password);
		
		log.info("Register - Step 07: Click to Register button");
		registerPage.clickToButtonByText(driver, "Register");
		
		log.info("Register - Step 08: Verify register success");
		verifyEquals(registerPage.getRegisterSuccessMessage(), "Your registration completed");
		
		log.info("Register - Step 09: Click to logout link");
		homePage = registerPage.clickToLogoutlink();
	}

	@Test
	public void User_02_Login	() {
		log.info("Register - Step 01: Navigate to 'Login page'");
		loginPage = homePage.openUserLoginPage();
		log.info("Register - Step 02: Enter to email address with value is '" + emailAddress + "'");
//		loginPage.InputToEmailTextbox(emailAddress);
		loginPage.inputToTextBoxByID(driver, "Email", emailAddress);
		log.info("Register - Step 03: Enter to password with value is '" + password + "'");
//		loginPage.InputToPasswordTextbox(password);
		loginPage.inputToTextBoxByID(driver, "Password", password);
		log.info("Register - Step 04: Click to Login Button");
//		loginPage.clickToLoginButton();
		loginPage.clickToButtonByText(driver, "Login");
		homePage = PageGeneratorManager.getUserHomePage(driver);
		log.info("Register - Step 05: Verify Account display");
		verifyTrue(homePage.isMyAccountLinkDisplayed());
	}

	@Test
	public void User_03_Customer_Infor() {
		customerInforPage = homePage.openMyAccountPage();
		verifyTrue(customerInforPage.isCustomerInfoPageDisplayed());
	}

	@Test
	public void User_04_Switch_Page() {
		addressPage = customerInforPage.openAddressPage(driver);
		myProductReviewPage = addressPage.openUserMyProductReviewPage(driver);
		rewardPoinPage = myProductReviewPage.openUserRewardPointPage(driver);
		customerInforPage = rewardPoinPage.openUserCustomerInfoPage(driver);
	}
	
	@Test
	public void User_05_Dynamic_Page_01() {
		addressPage = (UserAddressPageObject) customerInforPage.openPagesAtMyAccountByName(driver,"Addresses");
		myProductReviewPage = (UserMyProductReviewPageObject) addressPage.openPagesAtMyAccountByName(driver,"My product reviews");
		rewardPoinPage = (UserRewardPointPageObject) myProductReviewPage.openPagesAtMyAccountByName(driver,"Reward points");
		customerInforPage = (UserCustomerInfoPageObject) rewardPoinPage.openPagesAtMyAccountByName(driver,"Customer info");
	}
	
	@Test
	public void User_05_Dynamic_Page_02() {
		customerInforPage.openPagesAtMyAccountByPageName(driver, "My product reviews");
		myProductReviewPage = PageGeneratorManager.getUserMyProductReview(driver);
		myProductReviewPage.openPagesAtMyAccountByPageName(driver, "Reward points");
		rewardPoinPage = PageGeneratorManager.getUserRewardPointPage(driver);
		rewardPoinPage.openPagesAtMyAccountByPageName(driver, "Addresses"); 
		addressPage = PageGeneratorManager.getUserAddressPage(driver);
		addressPage.openPagesAtMyAccountByPageName(driver, "Reward points");
		rewardPoinPage = PageGeneratorManager.getUserRewardPointPage(driver);
		
	}

	@AfterClass(alwaysRun = true)
	public void afterClass() {
		closeBrowserAndDriver();
	}

	public int generateFakeNumber() {
		Random rad = new Random();
		return rad.nextInt(999);
	}

	private UserRewardPointPageObject rewardPoinPage;
	private UserMyProductReviewPageObject myProductReviewPage;
	private UserCustomerInfoPageObject customerInforPage;
	private UserHomePageObject homePage;
	private UserRegisterPageObject registerPage;
	private UserLoginPageObject loginPage;
	private UserAddressPageObject addressPage;
	private WebDriver driver;
	private String emailAddress;
	private String firstName;
	private String lastName;
	private String password;
}
