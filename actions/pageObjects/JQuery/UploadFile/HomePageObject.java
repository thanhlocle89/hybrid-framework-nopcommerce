package pageObjects.JQuery.UploadFile;


import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import commons.BasePage;
import pageUIs.JQuery.UploadFile.HomePageUIs;


public class HomePageObject extends BasePage {
	WebDriver driver;
	
	public HomePageObject(WebDriver driver) {
		this.driver = driver;
	}

	public boolean isFileLoadedByName(String fileName) {
		waitForElementVisible(driver, HomePageUIs.FILE_NAME_LOADED, fileName);
		return isElementDisplayed(driver, HomePageUIs.FILE_NAME_LOADED, fileName);
	}

	public void clickToStartButton() {
		List<WebElement> StartButtons = getListWebElement(driver, HomePageUIs.START_BUTTON);
		
		for (WebElement startButton : StartButtons) {
			startButton.click();
			sleepInSecond(2);
		}
	}

	public boolean isFileUploadedByLink(String fileName) {
		waitForElementVisible(driver, HomePageUIs.FILE_NAME_UPLOADED_LINK, fileName);
		return isElementDisplayed(driver, HomePageUIs.FILE_NAME_UPLOADED_LINK, fileName);
	}

	public boolean isFileUploadedByImage(String fileName) {
		waitForElementVisible(driver, HomePageUIs.FILE_NAME_UPLOADED_IMAGE, fileName);
		return isImageLoaded(driver, HomePageUIs.FILE_NAME_UPLOADED_IMAGE, fileName);
	}

	
}
