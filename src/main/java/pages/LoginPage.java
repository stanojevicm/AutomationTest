package pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.AssertActions;
import utils.ElementActions;

public class LoginPage {

	WebDriver driver;
	WebDriverWait wait;
	ElementActions elementActions;
	AssertActions assertActions;

	// Elementi

	@FindBy(xpath = "//input[@id='username']")
	private WebElement usernameInput;

	@FindBy(xpath = "//input[@id='password']")
	private WebElement passwordInput;

	@FindBy(xpath = "//button[text()='LOGIN']")
	private WebElement loginButton;

	@FindBy(xpath = "//img[@src='https://images-web.int-green.ug.cdn.united.cloud/2020/06/01/18/27/45/84581_family_l.png']")
	private WebElement familyProfileAvatar;

	// Konstruktor

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		PageFactory.initElements(driver, this);
		elementActions = new ElementActions(driver);
		assertActions = new AssertActions(driver);
	}

	// Metode

	public void enterUsername(String username) {
		elementActions.inputText(usernameInput, username);

	}

	public void enterPassword(String password) {
		elementActions.inputText(passwordInput, password);
	}

	public void clickOnLoginButton() {
		elementActions.clickOnElement(loginButton);
	}

	public void verifyThatUserIsSuccessfullyLoggedin() {
		assertActions.assertElementIsVisible(familyProfileAvatar);
	}
	

	public void userLogIn(String username, String password) {
		enterUsername(username);
		enterPassword(password);
		try {
			Thread.sleep(2000); // Sleep for 3 seconds (3000 milliseconds)
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		clickOnLoginButton();
		verifyThatUserIsSuccessfullyLoggedin();
	}

}
