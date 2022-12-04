package pageObjects.nopCommer.user;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import io.qameta.allure.Step;
import pageUIs.nopCommer.user.RegisterPageUI;

public class UserRegisterPageObject extends BasePage {
	private WebDriver driver;
	
	
	public UserRegisterPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void clickToRegisterButton() {
		waitForElementClickable(driver, RegisterPageUI.REGISTER_BUTTON);
		clickToElement(driver, RegisterPageUI.REGISTER_BUTTON);
	}

	public String getErrorMessageAtFirstNameTextbox() {
		waitForElementVisible(driver, RegisterPageUI.FIRST_NAME_ERROR_MESSAGE);
		return getElementText(driver, RegisterPageUI.FIRST_NAME_ERROR_MESSAGE);
	}

	public String getErrorMessageAtLastNameTextbox() {
		waitForElementVisible(driver, RegisterPageUI.LAST_NAME_ERROR_MESSAGE);
		return getElementText(driver, RegisterPageUI.LAST_NAME_ERROR_MESSAGE);
	}

	public String getErrorMessageAtEmailTextbox() {
		waitForElementVisible(driver, RegisterPageUI.EMAIL_ERROR_MESSAGE);
		return getElementText(driver, RegisterPageUI.EMAIL_ERROR_MESSAGE);
	}

	public String getErrorMessageAtPasswordTextbox() {
		waitForElementVisible(driver, RegisterPageUI.PASSWORD_ERROR_MESSAGE);
		return getElementText(driver, RegisterPageUI.PASSWORD_ERROR_MESSAGE);
	}

	public String getErrorMessageAtConfirmPasswordTextbox() {
		waitForElementVisible(driver, RegisterPageUI.CONFIRM_PASSWORD_ERROR_MESSAGE);
		return getElementText(driver, RegisterPageUI.CONFIRM_PASSWORD_ERROR_MESSAGE);
	}

	@Step("Enter to firstname textbox with value is {0}")
	public void inputToFirstNameTextbox(String firstName) {
		waitForElementVisible(driver, RegisterPageUI.FIRST_NAME_TEXTBOX);
		sendKeyToElement(driver, RegisterPageUI.FIRST_NAME_TEXTBOX, firstName);
	}
	@Step("Enter to last textbox with value is {0}")
	public void inputToLastNameTextbox(String lastName) {
		waitForElementVisible(driver, RegisterPageUI.LAST_NAME_TEXTBOX);
		sendKeyToElement(driver, RegisterPageUI.LAST_NAME_TEXTBOX, lastName);
	}
	@Step("Enter to email address textbox with value is {0}")
	public void inputToEmailTextbox(String emailAddress) {
		waitForElementVisible(driver, RegisterPageUI.EMAIL_TEXTBOX);
		sendKeyToElement(driver, RegisterPageUI.EMAIL_TEXTBOX, emailAddress);
	}
	@Step("Enter to password textbox with value is {0}")
	public void inputToPasswordTextbox(String password) {
		waitForElementVisible(driver, RegisterPageUI.PASSWORD_TEXTBOX);
		sendKeyToElement(driver, RegisterPageUI.PASSWORD_TEXTBOX, password);
	}

	@Step("Enter to confirm pw textbox with value is {0}")
	public void inputToConfirmPasswordTextbox(String confirmPassword) {
		waitForElementVisible(driver, RegisterPageUI.CONFIRM_PASSWORD_TEXTBOX);
		sendKeyToElement(driver, RegisterPageUI.CONFIRM_PASSWORD_TEXTBOX, confirmPassword);
	}
	@Step("get the register success message")
	public String getRegisterSuccessMessage() {
		waitForElementVisible(driver, RegisterPageUI.REGISTER_SUCCESS_MESSAGE);
		return getElementText(driver, RegisterPageUI.REGISTER_SUCCESS_MESSAGE);
	}

	@Step("click to logout user")
	public UserHomePageObject clickToLogoutlink() {
		waitForElementClickable(driver, RegisterPageUI.LOGOUT_LINK);
		clickToElement(driver, RegisterPageUI.LOGOUT_LINK);
//		return new HomePageObject(driver);
		return PageGeneratorManager.getUserHomePage(driver);
	}

	public String getErrorExistingEmailMessage() {
		waitForElementVisible(driver, RegisterPageUI.EXISTING_EMAIL_ERROR_MESSAGE);
		return getElementText(driver, RegisterPageUI.EXISTING_EMAIL_ERROR_MESSAGE);
	}

}
