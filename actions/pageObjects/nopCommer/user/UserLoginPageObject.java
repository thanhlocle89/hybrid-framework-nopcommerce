package pageObjects.nopCommer.user;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import io.qameta.allure.Step;
import pageUIs.nopCommer.user.HomePageUI;
import pageUIs.nopCommer.user.LoginPageUI;

public class UserLoginPageObject extends BasePage {

	private WebDriver driver;

	public UserLoginPageObject(WebDriver driver) {
		this.driver = driver;
	}

	@Step("Input to email textbox {0}")
	public void InputToEmailTextbox(String emailAddress) {
		waitForElementVisible(driver, LoginPageUI.EMAIL_TEXTBOX);
		sendKeyToElement(driver, LoginPageUI.EMAIL_TEXTBOX, emailAddress);
	}

	@Step("Input to pw textbox {0}")
	public void InputToPasswordTextbox(String password) {
		waitForElementVisible(driver, LoginPageUI.PASSWORD_TEXTBOX);
		sendKeyToElement(driver, LoginPageUI.PASSWORD_TEXTBOX, password);
	}

	@Step("click to login button")
	public UserHomePageObject clickToLoginButton() {
		waitForElementClickable(driver, LoginPageUI.LOGIN_BUTTON);
		clickToElement(driver, LoginPageUI.LOGIN_BUTTON);
//		return new HomePageObject(driver);
		return PageGeneratorManager.getUserHomePage(driver);
	}

	public String getErrorMessageAtEmailTextbox() {
		waitForElementVisible(driver, LoginPageUI.EMAIL_ERROR_MESSAGE);
		return getElementText(driver, LoginPageUI.EMAIL_ERROR_MESSAGE);
	}

	public String getErrorMessageUnsuccessful() {
		waitForElementVisible(driver, LoginPageUI.UNSUCCESSFUL_ERROR_MESSAGE);
		return getElementText(driver, LoginPageUI.UNSUCCESSFUL_ERROR_MESSAGE);
	}

	@Step("login user to system")
	public UserHomePageObject logInAsUser(String emailAddress, String password) {
		InputToEmailTextbox(emailAddress);
		InputToPasswordTextbox(password);
		return clickToLoginButton();
	}

}
