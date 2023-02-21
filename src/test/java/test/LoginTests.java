package test;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import logic.Browser;
import pages.LoginPage;

public class LoginTests {

	WebDriver driver;
	LoginPage loginPage;

	@BeforeTest
	public void before_test() {
		driver = Browser.initializeDriver();
		driver.manage().window().maximize();
		loginPage = new LoginPage(driver);
		Browser.driver.get("https://qa-interview.united.cloud/login");

	}

	@Test
	public void loginUser() {
		loginPage.userLogIn("milos.stanojevic", "test123");
	}

	@AfterTest
	public void after_test() {
		Browser.driver.close();
		Browser.driver.quit();
	}

}
