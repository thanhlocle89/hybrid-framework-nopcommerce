package com.jquery.uploadfile;

import org.testng.annotations.Test;

import commons.BasePage;
import commons.BaseTest;
import pageObjects.JQuery.UploadFile.HomePageObject;
import pageObjects.JQuery.UploadFile.PageGeneratorManager;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class Level_11_Upload_File extends BaseTest {
	String csharpFileName = "CSharp.jpg";
	String javaFileName = "Java.jpg";
	String pythonFileName = "Python.jpg";
	String rubyFileName = "Ruby.jpg";
	String [] fileNames = {csharpFileName,javaFileName,rubyFileName,pythonFileName};
	
	@Parameters({ "browser", "url" })
	@BeforeClass
	public void beforeClass(String browserName, String appUrl) {
		driver = getBrowserDriver(browserName, appUrl);
		homePage = PageGeneratorManager.getHomePage(driver);
	}

	@Test
	public void Upload_1_File_1_Time() {
		homePage.uploadMutipleFiles(driver, csharpFileName);
		Assert.assertTrue(homePage.isFileLoadedByName(csharpFileName));
		
		homePage.clickToStartButton();
		Assert.assertTrue(homePage.isFileUploadedByLink(csharpFileName));
		Assert.assertTrue(homePage.isFileUploadedByImage(csharpFileName));
	}

	@Test
	public void Upload_Multiple_File_1_Time() {
		homePage.refreshToPage(driver);
		homePage.uploadMutipleFiles(driver, fileNames);
		Assert.assertTrue(homePage.isFileLoadedByName(csharpFileName));
		Assert.assertTrue(homePage.isFileLoadedByName(javaFileName));
		Assert.assertTrue(homePage.isFileLoadedByName(rubyFileName));
		Assert.assertTrue(homePage.isFileLoadedByName(pythonFileName));
		
		homePage.clickToStartButton();
		Assert.assertTrue(homePage.isFileUploadedByLink(csharpFileName));
		Assert.assertTrue(homePage.isFileUploadedByLink(javaFileName));
		Assert.assertTrue(homePage.isFileUploadedByLink(rubyFileName));
		Assert.assertTrue(homePage.isFileUploadedByLink(pythonFileName));
		
		Assert.assertTrue(homePage.isFileUploadedByImage(csharpFileName));
		Assert.assertTrue(homePage.isFileUploadedByImage(javaFileName));
		Assert.assertTrue(homePage.isFileUploadedByImage(rubyFileName));
		Assert.assertTrue(homePage.isFileUploadedByImage(pythonFileName));
	}

	@AfterClass
	public void afterClass() {
//		driver.quit();
	}

	private WebDriver driver;
	private HomePageObject homePage;
}
