package utils;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class AssertActions {

	WebDriver driver;
	WebDriverWait wait;

	// Konstruktor

	public AssertActions(WebDriver driver) {
		this.driver = driver;
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		PageFactory.initElements(driver, this);
	}

	public void assertElementIsVisible(WebElement element) {
		wait.until(ExpectedConditions.visibilityOf(element));
		Assert.assertTrue(element.isDisplayed(), "Element is not visible");

	}

	public void assertElementIsNotVisible(WebElement element) {
		boolean isNotVisible = wait.until(ExpectedConditions.invisibilityOf(element));
		Assert.assertTrue(isNotVisible, "Element is visible");

	}

}
