package pageObjects.JQuery;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import commons.BasePage;
import pageUIs.JQuery.HomePageUIs;

public class HomePageObject extends BasePage {
	WebDriver driver;
	
	public HomePageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void openPagingByPageNumber(String pageNumber) {
		waitForElementClickable(driver, HomePageUIs.PAGINATION_PAGE_BY_NUMBER, pageNumber);
		clickToElement(driver, HomePageUIs.PAGINATION_PAGE_BY_NUMBER, pageNumber);
	}

	public void enterToHeaderTextboxByLable(String headerLable, String value) {
		waitForAllElementVisible(driver, HomePageUIs.HEADER_TEXTBOX_BY_LABLE, headerLable);
		sendKeyToElement(driver, HomePageUIs.HEADER_TEXTBOX_BY_LABLE, value, headerLable);
		pressKeyToElement(driver, HomePageUIs.HEADER_TEXTBOX_BY_LABLE, Keys.ENTER, headerLable);
	}

	public boolean isPageActiveByNumber(String pageNumber) {
		waitForElementVisible(driver, HomePageUIs.PAGINATION_PAGE_ACTIVATED_BY_NUMBER, pageNumber);
		return isElementDisplayed(driver, HomePageUIs.PAGINATION_PAGE_ACTIVATED_BY_NUMBER, pageNumber);
		
	}

	public List<String> getValueEachRowAtAllPage() {
		int totalPage = getElementSize(driver, HomePageUIs.TOTAL_PAGINATION);
		List<String> allRowValueAllPage = new ArrayList<String>();
		for (int index = 1; index <= totalPage; index++) {
			clickToElement(driver, HomePageUIs.PAGINATION_INDEX, String.valueOf(index));
			sleepInSecond(1);
			
			List<WebElement> allRowElementEachPage  = getListWebElement(driver, HomePageUIs.ALL_ROW_EACH_PAGE);
			for (WebElement eachRow : allRowElementEachPage) {
				allRowValueAllPage.add(eachRow.getText());
			}
		}
		
		return allRowValueAllPage;
	}

	public void enterToTextboxByColumnNameAtRowNumber(String columnName, String rowNumber, String value) {
		int columnIndex = getElementSize(driver, HomePageUIs.COLUMN_INDEX_BY_NAME,columnName) +1;
		
		waitForElementVisible(driver, HomePageUIs.ROW_TEXTBOX_BY_COLUMN_INDEX_AND_ROW_INDEX, rowNumber,String.valueOf(columnIndex));
		sendKeyToElement(driver, HomePageUIs.ROW_TEXTBOX_BY_COLUMN_INDEX_AND_ROW_INDEX, value, rowNumber,String.valueOf(columnIndex));
	}

	public void selectDropdownByColumnNameAtRowNumber(String columnName, String rowNumber, String value) {
		int columnIndex = getElementSize(driver, HomePageUIs.COLUMN_INDEX_BY_NAME,columnName) +1;
		waitForElementClickable(driver, HomePageUIs.DROPDOWN_BY_COLUMN_INDEX_AND_ROW_INDEX, rowNumber,String.valueOf(columnIndex));
		selectItemDefaultDropdown(driver, HomePageUIs.DROPDOWN_BY_COLUMN_INDEX_AND_ROW_INDEX,value,rowNumber,String.valueOf(columnIndex));
	}
	
	public void clickToLoadButton() {
		waitForElementClickable(driver, HomePageUIs.LOAD_BUTTON);
		clickToElement(driver, HomePageUIs.LOAD_BUTTON);
	}

	public void checkToCheckboxByColumnNameAtRowNumber(String columnName, String rowNumber) {
		int columnIndex = getElementSize(driver, HomePageUIs.COLUMN_INDEX_BY_NAME,columnName) +1;
		waitForElementClickable(driver, HomePageUIs.ROW_CHECKBOX_BY_COLUMN_INDEX_AND_ROW_INDEX, rowNumber,String.valueOf(columnIndex));
		checkToDefaultCheckboxRadioButton(driver, HomePageUIs.ROW_CHECKBOX_BY_COLUMN_INDEX_AND_ROW_INDEX, rowNumber,String.valueOf(columnIndex));
	}
	
	public void uncheckToCheckboxByColumnNameAtRowNumber(String columnName, String rowNumber) {
		int columnIndex = getElementSize(driver, HomePageUIs.COLUMN_INDEX_BY_NAME,columnName) +1;
		waitForElementClickable(driver, HomePageUIs.ROW_CHECKBOX_BY_COLUMN_INDEX_AND_ROW_INDEX, rowNumber,String.valueOf(columnIndex));
		uncheckToDefaultCheckboxRadioButton(driver, HomePageUIs.ROW_CHECKBOX_BY_COLUMN_INDEX_AND_ROW_INDEX, rowNumber,String.valueOf(columnIndex));
	}

	public void clickToIconByRowNumber(String rowNumber, String iconName) {
		waitForElementClickable(driver, HomePageUIs.ICON_LOCATOR, rowNumber,iconName);
		clickToElement(driver, HomePageUIs.ICON_LOCATOR, rowNumber,iconName);

	}

}
