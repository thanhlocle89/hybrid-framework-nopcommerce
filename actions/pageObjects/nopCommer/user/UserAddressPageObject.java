package pageObjects.nopCommer.user;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.nopCommer.user.UserCustomerInfoPageUI;
import pageUIs.nopCommer.user.UserAddressesPageUI;

public class UserAddressPageObject extends BasePage{
	 WebDriver driver;
	
	public UserAddressPageObject(WebDriver driver) {
		this.driver =driver;
	} 
	public boolean isUserAddressPageDisplayed() {
		waitForElementVisible(driver, UserAddressesPageUI.CUSTOMER_ADDRESSES_HEADER);
		return isElementDisplayed(driver, UserAddressesPageUI.CUSTOMER_ADDRESSES_HEADER);
	}
}
