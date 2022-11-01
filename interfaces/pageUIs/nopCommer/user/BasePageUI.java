package pageUIs.nopCommer.user;

public class BasePageUI {
	public static String ADDRESS_LINK = "xpath=//div[contains(@class,'account-navigation')]//a[text()='Addresses']";
	public static String CUSTOMER_INFOR_LINK = "xpath=//div[contains(@class,'account-navigation')]//a[text()='Customer info']";
	public static String MY_PRODUCT_REVIEW_LINK = "xpath=//div[contains(@class,'account-navigation')]//a[text()='My product reviews']";
	public static String REWARD_POINT_LINK = "xpath=//div[contains(@class,'account-navigation')]//a[text()='Reward points']";
	public static String DYNAMIC_LINKS_MY_ACCOUNT_PAGE = "xpath=//div[contains(@class,'account-navigation')]//a[text()='%s']";
	
	public static String LOGOUT_LINK_AT_USER = "css=a[class='ico-logout']";
	public static String LOGOUT_LINK_AT_ADMIN = "xpath=//a[text()='Logout']";
}
