package pageObjects.nopCommer.admin;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.nopCommer.admin.AdminDashBoardPageUI;

public class AdminDashBoardPageObject extends BasePage {
	WebDriver driver;

	public AdminDashBoardPageObject(WebDriver driver) {
		this.driver = driver;
	}
	public boolean isDashBoardHeaderDisplayed() {
		waitForElementVisible(driver, AdminDashBoardPageUI.DASHBOARD_HEADER);
		return isElementDisplayed(driver, AdminDashBoardPageUI.DASHBOARD_HEADER);
	}
}
