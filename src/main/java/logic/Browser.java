package logic;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Browser {

	public static WebDriver driver;
	public static WebDriverWait wait;
	public static int defaultWaitTime = 30;

	public static WebDriver initializeDriver() {

		System.setProperty("webdriver.chrome.driver",
				"/Users/3biilsoft/Documents/JavaEclipseTutorial/eclipse-workspace/TestAutomation/resources/chromedriver");

		driver = new ChromeDriver();
		wait = new WebDriverWait(driver, Duration.ofSeconds(defaultWaitTime));

		return driver;
	}

}
