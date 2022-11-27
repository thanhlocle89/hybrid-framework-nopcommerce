package pageObjects.JQuery.UploadFile;

import org.openqa.selenium.WebDriver;

import pageObjects.nopCommer.admin.AdminDashBoardPageObject;
import pageObjects.nopCommer.admin.AdminLoginPageObject;

public class PageGeneratorManager {
	public static HomePageObject getHomePage(WebDriver driver) {
		return new HomePageObject(driver);
	}
}
