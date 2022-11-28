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

public class Level_12_Assert_Verify extends BaseTest {


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
		registerPage = homePage.openRegisterPage();
		registerPage.inputToFirstNameTextbox(firstName);
		registerPage.inputToLastNameTextbox(lastName);
		registerPage.inputToEmailTextbox(emailAddress);
		registerPage.inputToPasswordTextbox(password);
		registerPage.inputToConfirmPasswordTextbox(password);
		registerPage.clickToRegisterButton();
		verifyEquals(registerPage.getRegisterSuccessMessage(), "Your registration completed....");
		homePage = registerPage.clickToLogoutlink();
	}

	@Test
	public void User_02_Login	() {
		loginPage = homePage.openUserLoginPage();
		loginPage.InputToEmailTextbox(emailAddress);
		loginPage.InputToPasswordTextbox(password);
		loginPage.clickToLoginButton();
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

	@AfterClass
	public void afterClass() {
		driver.quit();
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
