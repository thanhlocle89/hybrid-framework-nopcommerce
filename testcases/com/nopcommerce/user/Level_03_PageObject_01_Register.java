package com.nopcommerce.user;

import org.testng.annotations.Test;

import commons.BasePage;

import org.testng.annotations.BeforeClass;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.By.ByCssSelector;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class Level_03_PageObject_01_Register extends BasePage{

	WebDriver driver;
	String projectPath = System.getProperty("user.dir");
	String emailAddress;
	
	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDriver\\geckodriver.exe");
		driver = new FirefoxDriver();
		emailAddress ="afc" + generateFakeNumber() + "@gmail.com";
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("https://demo.nopcommerce.com/");
	}

	@Test
	public void TC_01_Register_Empty_Data() {
//		goto register page
		waitForEnableClickable(driver, "//a[@class='ico-register']");
		clickToElement(driver, "//a[@class='ico-register']");
//		click Register button
		waitForEnableClickable(driver, "//button[@id='register-button']");
		clickToElement(driver, "//button[@id='register-button']");
//		Verify text
		Assert.assertEquals(getElementText(driver, "//span[@id='FirstName-error']"), "First name is required.");
		Assert.assertEquals(getElementText(driver, "//span[@id='LastName-error']"), "Last name is required.");
		Assert.assertEquals(getElementText(driver, "//span[@id='Email-error']"), "Email is required.");
		Assert.assertEquals(getElementText(driver, "//span[@id='Password-error']"), "Password is required.");
		Assert.assertEquals(getElementText(driver, "//span[@id='ConfirmPassword-error']"), "Password is required.");
	}

	@Test
	public void TC_02_Register_Invalid_Email() {
//		goto register page
		waitForEnableClickable(driver, "//a[@class='ico-register']");
		clickToElement(driver, "//a[@class='ico-register']");
//		Input data 
		sendKeyToElement(driver, "//input[@id='FirstName']", "AutomationFcStudent");
		sendKeyToElement(driver, "//input[@id='LastName']", "Loc");
		sendKeyToElement(driver, "//input[@id='Email']", "123@123!@#");
		sendKeyToElement(driver, "//input[@id='Password']", "123456");
		sendKeyToElement(driver, "//input[@id='ConfirmPassword']", "123456");
		
//		click Register button
		waitForEnableClickable(driver, "//button[@id='register-button']");
		clickToElement(driver, "//button[@id='register-button']");
//		Verify text
		Assert.assertEquals(getElementText(driver, "//span[@id='Email-error']"), "Wrong email");
	}

	@Test
	public void TC_03_Register_Success() {
//		goto register page
		waitForEnableClickable(driver, "//a[@class='ico-register']");
		clickToElement(driver, "//a[@class='ico-register']");
//		Input data 
		sendKeyToElement(driver, "//input[@id='FirstName']", "AutomationFcStudent");
		sendKeyToElement(driver, "//input[@id='LastName']", "Loc");
		sendKeyToElement(driver, "//input[@id='Email']", emailAddress);
		sendKeyToElement(driver, "//input[@id='Password']", "123456");
		sendKeyToElement(driver, "//input[@id='ConfirmPassword']", "123456");
		
//		click Register button
		waitForEnableClickable(driver, "//button[@id='register-button']");
		clickToElement(driver, "//button[@id='register-button']");
//		Verify text
		Assert.assertEquals(getElementText(driver, "//div[@class='result']"), "Your registration completed");
//		click Logout
		waitForEnableClickable(driver, "//a[@class='ico-logout']");
		clickToElement(driver, "//a[@class='ico-logout']");
	}

	@Test
	public void TC_04_Register_Existing_Email() {
//		goto register page
		waitForEnableClickable(driver, "//a[@class='ico-register']");
		clickToElement(driver, "//a[@class='ico-register']");
//		Input data 
		sendKeyToElement(driver, "//input[@id='FirstName']", "AutomationFcStudent");
		sendKeyToElement(driver, "//input[@id='LastName']", "Loc");
		sendKeyToElement(driver, "//input[@id='Email']", emailAddress);
		sendKeyToElement(driver, "//input[@id='Password']", "123456");
		sendKeyToElement(driver, "//input[@id='ConfirmPassword']", "123456");
		
//		click Register button
		waitForEnableClickable(driver, "//button[@id='register-button']");
		clickToElement(driver, "//button[@id='register-button']");
//		Verify text
		Assert.assertEquals(getElementText(driver, "//div[contains(@class,'message-error')]//li"), "The specified email already exists");
	}

	@Test
	public void TC_05_Register_Password_Less_Than_6_Chars() {
//		goto register page
		waitForEnableClickable(driver, "//a[@class='ico-register']");
		clickToElement(driver, "//a[@class='ico-register']");
//		Input data 
		sendKeyToElement(driver, "//input[@id='FirstName']", "AutomationFcStudent");
		sendKeyToElement(driver, "//input[@id='LastName']", "Loc");
		sendKeyToElement(driver, "//input[@id='Email']", emailAddress);
		sendKeyToElement(driver, "//input[@id='Password']", "123");
		sendKeyToElement(driver, "//input[@id='ConfirmPassword']", "123");
//		click Register button
		waitForEnableClickable(driver, "//button[@id='register-button']");
		clickToElement(driver, "//button[@id='register-button']");
//		Verify text
		Assert.assertEquals(getElementText(driver, "//span[@id='Password-error']"), "Password must meet the following rules:\nmust have at least 6 characters");
	}

	@Test
	public void TC_06_Register_Invalid_Confirm_Password() {	
//		goto register page
		waitForEnableClickable(driver, "//a[@class='ico-register']");
		clickToElement(driver, "//a[@class='ico-register']");
//		Input data 
		sendKeyToElement(driver, "//input[@id='FirstName']", "AutomationFcStudent");
		sendKeyToElement(driver, "//input[@id='LastName']", "Loc");
		sendKeyToElement(driver, "//input[@id='Email']", emailAddress);
		sendKeyToElement(driver, "//input[@id='Password']", "123456");
		sendKeyToElement(driver, "//input[@id='ConfirmPassword']", "654321");
		
//		click Register button
		waitForEnableClickable(driver, "//button[@id='register-button']");
		clickToElement(driver, "//button[@id='register-button']");
//		Verify text
		Assert.assertEquals(getElementText(driver, "//span[@id='ConfirmPassword-error']"), "The password and confirmation password do not match.");
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

	public int generateFakeNumber(){
		Random rad = new Random();
		return rad.nextInt(999);
	}
}
