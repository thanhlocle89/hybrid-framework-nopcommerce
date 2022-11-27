package com.jquery.datatable;

import org.testng.annotations.Test;

import commons.BasePage;
import commons.BaseTest;
import pageObjects.JQuery.HomePageObject;
import pageObjects.JQuery.PageGeneratorManager;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class Level_10_DataTable_DataGrid extends BaseTest {

	@Parameters({"browser","url"})
	@BeforeClass
	public void beforeClass(String browserName, String appUrl) {
		driver = getBrowserDriver(browserName,appUrl);
		homePage = PageGeneratorManager.getHomePage(driver);
	}

	public void Table_01_Paging() {
		homePage.openPagingByPageNumber("10");
		homePage.sleepInSecond(3);
		Assert.assertTrue(homePage.isPageActiveByNumber("10"));
		
		homePage.openPagingByPageNumber("20");
		homePage.sleepInSecond(3);
		Assert.assertTrue(homePage.isPageActiveByNumber("20"));
		
		homePage.openPagingByPageNumber("15");
		homePage.sleepInSecond(3);
		Assert.assertTrue(homePage.isPageActiveByNumber("15"));
		homePage.openPagingByPageNumber("5");
		Assert.assertTrue(homePage.isPageActiveByNumber("5"));
	}

	public void Table_02() {
		homePage.refreshToPage(driver);
		homePage.enterToHeaderTextboxByLable("Country","Argentina");
		homePage.enterToHeaderTextboxByLable("Females","338282");
		homePage.enterToHeaderTextboxByLable("Males","349238");
		homePage.enterToHeaderTextboxByLable("Total","687522");
	}

	public void Table_03_Enter_To_Header() {
		homePage.refreshToPage(driver);
		homePage.getValueEachRowAtAllPage();
	}
	
	@Test
	public void Table_04_Enter_To_Textbox_At_Any_Row() {
		homePage.enterToTextboxByColumnNameAtRowNumber("Album","1","Michael 97");
		homePage.enterToTextboxByColumnNameAtRowNumber("Artist","1","Michael Jackson");
		homePage.enterToTextboxByColumnNameAtRowNumber("Year","1","1997");
		homePage.enterToTextboxByColumnNameAtRowNumber("Price","1","20$");
		
		homePage.selectDropdownByColumnNameAtRowNumber("Origin","1","Japan");
		homePage.checkToCheckboxByColumnNameAtRowNumber("With Poster?","1");
		homePage.clickToIconByRowNumber("1","Insert Row Above");
	}
	@AfterClass
	public void afterClass() {
//		driver.quit();
	}
	
	private WebDriver driver;
	HomePageObject homePage;
}
