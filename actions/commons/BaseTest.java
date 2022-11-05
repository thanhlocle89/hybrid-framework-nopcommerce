package commons;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.opera.OperaDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {
	private WebDriver driver;
	
	protected WebDriver getBrowserDriver(String browserName) {
		BrowserList browserList = BrowserList.valueOf(browserName.toUpperCase());
		
		if (browserList == BrowserList.FIREFOX) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		} else if (browserList == BrowserList.H_FIREFOX) {
			WebDriverManager.firefoxdriver().setup();
			FirefoxOptions options = new FirefoxOptions();
			options.addArguments("--headless");
			options.addArguments("window-size=1920x1080");
			driver = new FirefoxDriver(options);
		} else if (browserList == BrowserList.CHROME) {
//			System.setProperty("webdriver.chrome.driver", projectPath + "\\browserDriver\\chromedriver.exe");
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		} else if (browserList == BrowserList.H_CHROME) {
//			System.setProperty("webdriver.chrome.driver", projectPath + "\\browserDriver\\chromedriver.exe");
			WebDriverManager.chromedriver().setup();
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--headless");
			options.addArguments("window-size=1920x1080");
			driver = new ChromeDriver(options);
		} else if (browserList == BrowserList.EDGE) {
//			System.setProperty("webdriver.edge.driver", projectPath + "\\browserDriver\\msedgedriver.exe");
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		} else if (browserList == BrowserList.COCCOC) {
			WebDriverManager.chromedriver().driverVersion("105.0.5195.52").setup();
			ChromeOptions options = new ChromeOptions();
			options.setBinary("C:\\Program Files\\CocCoc\\Browser\\Application\\browser.exe");
			driver = new ChromeDriver(options);
		} else if (browserList == BrowserList.OPERA) {
			WebDriverManager.operadriver().setup();
			driver = new OperaDriver();
		} else {
			throw new RuntimeException("Browser name is invalid");
		}
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get(GlobalConstants.PORTAL_PAGE_URL);
		return driver;
	}
}
