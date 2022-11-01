package pageObjects.nopCommer.user;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.nopCommer.user.UserAddressesPageUI;
import pageUIs.nopCommer.user.UserMyProductReviewPageUI;

public class UserMyProductReviewPageObject extends BasePage{
	 WebDriver driver;
	
	public UserMyProductReviewPageObject(WebDriver driver) {
		this.driver =driver;
	} 
	public boolean isUserMyProductReviewPageDisplayed() {
		waitForElementVisible(driver, UserMyProductReviewPageUI.MY_PRODUCT_REVIEW_HEADER);
		return isElementDisplayed(driver, UserMyProductReviewPageUI.MY_PRODUCT_REVIEW_HEADER);
	}
}
