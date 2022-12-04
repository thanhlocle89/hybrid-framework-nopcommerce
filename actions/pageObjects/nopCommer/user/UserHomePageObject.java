package pageObjects.nopCommer.user;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import io.qameta.allure.Step;
import pageUIs.nopCommer.user.UserCustomerInfoPageUI;
import pageUIs.nopCommer.user.HomePageUI;

public class UserHomePageObject extends BasePage {
	private WebDriver driver;

	public UserHomePageObject(WebDriver driver) {
		this.driver = driver;
	}
	@Step("Navigate to register page")
	public UserRegisterPageObject openRegisterPage() {
		waitForElementClickable(driver, HomePageUI.REGISTER_LINK);
		clickToElement(driver, HomePageUI.REGISTER_LINK);
//		2
//		return new RegisterPageObject(driver);
//		3
		return PageGeneratorManager.getUserRegisterPage(driver);
	}
	@Step("Navigate to login page")
	public UserLoginPageObject openUserLoginPage() {
		waitForElementClickable(driver, HomePageUI.LOGIN_LINK);
		clickToElement(driver, HomePageUI.LOGIN_LINK);
//		return new LoginPageObject(driver);
		return PageGeneratorManager.getUserLoginPage(driver);
	}
	@Step("Verify account link displayed success")
	public boolean isMyAccountLinkDisplayed() {
		waitForElementVisible(driver, HomePageUI.MY_ACCOUNT_LINK);
		return isElementDisplayed(driver, HomePageUI.MY_ACCOUNT_LINK);
	}
	@Step("Navigate to Account page")
	public UserCustomerInfoPageObject openMyAccountPage() {
		waitForElementClickable(driver, HomePageUI.MY_ACCOUNT_LINK);
		clickToElement(driver, HomePageUI.MY_ACCOUNT_LINK);
		return PageGeneratorManager.getCustomerInfoPage(driver);
	}

}
