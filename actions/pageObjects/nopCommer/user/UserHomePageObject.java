package pageObjects.nopCommer.user;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.nopCommer.user.UserCustomerInfoPageUI;
import pageUIs.nopCommer.user.HomePageUI;

public class UserHomePageObject extends BasePage{
	private WebDriver driver;
	
	public UserHomePageObject(WebDriver driver) {
		this.driver =driver;
	}
	public UserRegisterPageObject openRegisterPage() {
		waitForEnableClickable(driver, HomePageUI.REGISTER_LINK);
		clickToElement(driver, HomePageUI.REGISTER_LINK);
//		2
//		return new RegisterPageObject(driver);
//		3
		return PageGeneratorManager.getUserRegisterPage(driver);	
	}
	public UserLoginPageObject openUserLoginPage() {
		waitForEnableClickable(driver, HomePageUI.LOGIN_LINK);
		clickToElement(driver, HomePageUI.LOGIN_LINK);
//		return new LoginPageObject(driver);
		return PageGeneratorManager.getUserLoginPage(driver);
	}
	public boolean isMyAccountLinkDisplayed() {
		waitForElementVisible(driver, HomePageUI.MY_ACCOUNT_LINK);
		return isElementDisplayed(driver,  HomePageUI.MY_ACCOUNT_LINK);
	}
	public UserCustomerInfoPageObject openMyAccountPage() {
		waitForEnableClickable(driver, HomePageUI.MY_ACCOUNT_LINK);
		clickToElement(driver, HomePageUI.MY_ACCOUNT_LINK);
		return PageGeneratorManager.getCustomerInfoPage(driver);
	}


}
