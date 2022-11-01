package pageObjects.nopCommer.user;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.nopCommer.user.UserAddressesPageUI;
import pageUIs.nopCommer.user.UserRewardsPointPageUI;

public class UserRewardPointPageObject extends BasePage{
	 WebDriver driver;
	
	public UserRewardPointPageObject(WebDriver driver) {
		this.driver =driver;
	} 
	public boolean isUserRewardPointPageDisplayed() {
		waitForElementVisible(driver, UserRewardsPointPageUI.REWARD_POIN_HEADER);
		return isElementDisplayed(driver, UserRewardsPointPageUI.REWARD_POIN_HEADER);
	}
}
