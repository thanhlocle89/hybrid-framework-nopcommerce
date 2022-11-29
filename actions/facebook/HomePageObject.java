package facebook;

import org.openqa.selenium.WebDriver;

import commons.BasePage;

public class HomePageObject extends BasePage {
	WebDriver driver;

	public HomePageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void clickToCreatNewAccountButton() {
		waitForElementClickable(driver, HomePageUI.CREATE_NEW_ACCOUNT_BUTTON);
		clickToElement(driver, HomePageUI.CREATE_NEW_ACCOUNT_BUTTON);
	}

	public boolean isEmailAddressTextboxDisplayed() {
		waitForElementVisible(driver, HomePageUI.EMAIL_ADDRESS_TEXTBOX);
		return isElementDisplayed(driver, HomePageUI.EMAIL_ADDRESS_TEXTBOX);
	}

	public void enterToEmailAddressTextbox(String emailAddress) {
		waitForElementVisible(driver, HomePageUI.EMAIL_ADDRESS_TEXTBOX);
		sendKeyToElement(driver, HomePageUI.EMAIL_ADDRESS_TEXTBOX, emailAddress);
	}

	public boolean isConfirmEmailAddressTextboxDisplayed() {
		return isElementDisplayed(driver, HomePageUI.CONFIRMED_EMAIL_ADDRESS_TEXTBOX);
	}

	public void clickToCloseIconAtRegisterForm() {
		waitForElementClickable(driver, HomePageUI.CLOSE_ICON);
		clickToElement(driver, HomePageUI.CLOSE_ICON);
	}

	public boolean isConfirmEmailAddressTextboxUnDisplayed() {
		waitForElementUndisplayed(driver, HomePageUI.CONFIRMED_EMAIL_ADDRESS_TEXTBOX);
		return isElementUndisplayed(driver, HomePageUI.CONFIRMED_EMAIL_ADDRESS_TEXTBOX);
	}

}
