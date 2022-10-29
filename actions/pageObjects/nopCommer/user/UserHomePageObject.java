package pageObjects;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.HomePageUI;
import pageUIs.CustomerInfoPageUI;

public class HomePageObject extends BasePage{
	private WebDriver driver;
	
	public HomePageObject(WebDriver driver) {
		this.driver =driver;
	}
	public RegisterPageObject clickToRegisterLink() {
		waitForEnableClickable(driver, HomePageUI.REGISTER_LINK);
		clickToElement(driver, HomePageUI.REGISTER_LINK);
//		2
//		return new RegisterPageObject(driver);
//		3
		return PageGeneratorManager.getRegisterPage(driver);	
	}
	public LoginPageObject clickToLoginLink() {
		waitForEnableClickable(driver, HomePageUI.LOGIN_LINK);
		clickToElement(driver, HomePageUI.LOGIN_LINK);
//		return new LoginPageObject(driver);
		return PageGeneratorManager.getLoginPage(driver);
	}
	public boolean isMyAccountLinkDisplayed() {
		waitForElementVisible(driver, HomePageUI.MY_ACCOUNT_LINK);
		return isElementDisplayed(driver,  HomePageUI.MY_ACCOUNT_LINK);
	}
	public CustomerInfoPageObject clickToGoCustomerInforPage() {
		waitForEnableClickable(driver, HomePageUI.MY_ACCOUNT_LINK);
		clickToElement(driver, HomePageUI.MY_ACCOUNT_LINK);
		return PageGeneratorManager.getMyAccountPage(driver);
	}


}
