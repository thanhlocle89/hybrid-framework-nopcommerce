package com.nopcommerce.user;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.By.ByCssSelector;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class User_01_Register_Login_Dont_Follow_DRY {

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
		driver.findElement(By.cssSelector("a.ico-register")).click();
//		click Register button
		driver.findElement(By.cssSelector("button#register-button")).click();
//		Verify text
		Assert.assertEquals(driver.findElement(By.cssSelector("span#FirstName-error")).getText(), "First name is required.");
		Assert.assertEquals(driver.findElement(By.cssSelector("span#LastName-error")).getText(), "Last name is required.");
		Assert.assertEquals(driver.findElement(By.cssSelector("span#Email-error")).getText(), "Email is required.");
		Assert.assertEquals(driver.findElement(By.cssSelector("span#Password-error")).getText(), "Password is required.");
		Assert.assertEquals(driver.findElement(By.cssSelector("span#ConfirmPassword-error")).getText(), "Password is required.");
	}

	@Test
	public void TC_02_Register_Invalid_Email() {
//		goto register page
		driver.findElement(By.cssSelector("a.ico-register")).click();
//		Input data 
		driver.findElement(By.cssSelector("input#FirstName")).sendKeys("AutomationFcStudent");
		driver.findElement(By.cssSelector("input#LastName")).sendKeys("Loc");
		driver.findElement(By.cssSelector("input#Email")).sendKeys("123@123!@#");
		driver.findElement(By.cssSelector("input#Password")).sendKeys("123456");
		driver.findElement(By.cssSelector("input#ConfirmPassword")).sendKeys("123456");
//		click Register button
		driver.findElement(By.cssSelector("button#register-button")).click();
//		Verify text
		Assert.assertEquals(driver.findElement(By.cssSelector("span#Email-error")).getText(), "Wrong email");
	}

	@Test
	public void TC_03_Register_Success() {
//		goto register page
		driver.findElement(By.cssSelector("a.ico-register")).click();
//		Input data 
		driver.findElement(By.cssSelector("input#FirstName")).sendKeys("AutomationFcStudent");
		driver.findElement(By.cssSelector("input#LastName")).sendKeys("Loc");
		driver.findElement(By.cssSelector("input#Email")).sendKeys(emailAddress);
		driver.findElement(By.cssSelector("input#Password")).sendKeys("123456");
		driver.findElement(By.cssSelector("input#ConfirmPassword")).sendKeys("123456");
//		click Register button
		driver.findElement(By.cssSelector("button#register-button")).click();
//		Verify text
		Assert.assertEquals(driver.findElement(By.cssSelector("div.result")).getText(), "Your registration completed");
//		click Logout
		driver.findElement(By.cssSelector("a.ico-logout")).click();
	}

	@Test
	public void TC_04_Register_Existing_Email() {
//		goto register page
		driver.findElement(By.cssSelector("a.ico-register")).click();
//		Input data 
		driver.findElement(By.cssSelector("input#FirstName")).sendKeys("AutomationFcStudent");
		driver.findElement(By.cssSelector("input#LastName")).sendKeys("Loc");
		driver.findElement(By.cssSelector("input#Email")).sendKeys(emailAddress);
		driver.findElement(By.cssSelector("input#Password")).sendKeys("123456");
		driver.findElement(By.cssSelector("input#ConfirmPassword")).sendKeys("123456");
//		click Register button
		driver.findElement(By.cssSelector("button#register-button")).click();
//		Verify text
		Assert.assertEquals(driver.findElement(By.cssSelector("div.message-error li")).getText(), "The specified email already exists");
	}

	@Test
	public void TC_05_Register_Password_Less_Than_6_Chars() {
//		goto register page
		driver.findElement(By.cssSelector("a.ico-register")).click();
//		Input data 
		driver.findElement(By.cssSelector("input#FirstName")).sendKeys("AutomationFcStudent");
		driver.findElement(By.cssSelector("input#LastName")).sendKeys("Loc");
		driver.findElement(By.cssSelector("input#Email")).sendKeys(emailAddress);
		driver.findElement(By.cssSelector("input#Password")).sendKeys("123");
		driver.findElement(By.cssSelector("input#ConfirmPassword")).sendKeys("123");
//		click Register button
		driver.findElement(By.cssSelector("button#register-button")).click();
//		Verify text
		Assert.assertEquals(driver.findElement(By.cssSelector("span#Password-error")).getText(), "Password must meet the following rules:\nmust have at least 6 characters");
	}

	@Test
	public void TC_06_Register_Invalid_Confirm_Password() {	
//		goto register page
		driver.findElement(By.cssSelector("a.ico-register")).click();
//		Input data 
		driver.findElement(By.cssSelector("input#FirstName")).sendKeys("AutomationFcStudent");
		driver.findElement(By.cssSelector("input#LastName")).sendKeys("Loc");
		driver.findElement(By.cssSelector("input#Email")).sendKeys(emailAddress);
		driver.findElement(By.cssSelector("input#Password")).sendKeys("123456");
		driver.findElement(By.cssSelector("input#ConfirmPassword")).sendKeys("654321");
//		click Register button
		driver.findElement(By.cssSelector("button#register-button")).click();
//		Verify text
		Assert.assertEquals(driver.findElement(By.cssSelector("span#ConfirmPassword-error")).getText(), "The password and confirmation password do not match.");
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
