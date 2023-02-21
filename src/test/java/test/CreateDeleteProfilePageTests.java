package test;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import logic.Browser;
import pages.CreateNewProfilePage;
import pages.LoginPage;

public class CreateDeleteProfilePageTests {

	WebDriver driver;
	LoginPage loginPage;
	CreateNewProfilePage createNewProfilePage;

	@BeforeTest
	public void before_test() {
		driver = Browser.initializeDriver();
		driver.manage().window().maximize();
		loginPage = new LoginPage(driver);
		createNewProfilePage = new CreateNewProfilePage(driver);
		Browser.driver.get("https://qa-interview.united.cloud/login");
	}

	@Test
	public void createAndDeleteUserProfile() {

		loginPage.userLogIn("milos.stanojevic", "test123");

		createNewProfilePage.createNewUserProfile("Milos", "1992");
		createNewProfilePage.deleteUserProfile();
	}

	@AfterTest
	public void after_test() {
		Browser.driver.close();
		Browser.driver.quit();
	}

}
