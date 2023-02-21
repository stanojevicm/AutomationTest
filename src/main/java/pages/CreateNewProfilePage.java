package pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.AssertActions;
import utils.ElementActions;

public class CreateNewProfilePage {

	WebDriver driver;
	WebDriverWait wait;
	ElementActions elementActions;
	AssertActions assertActions;

	// Elementi

	@FindBy(xpath = "//button[text()='Create new profile']")
	private WebElement createNewProfileButton;

	@FindBy(xpath = "//input[@id='profile-name']")
	private WebElement enterNameInputField;

	@FindBy(xpath = "//label[@class='age__text' and @for='AGE_18_PLUS\']")
	private WebElement selectAgeButton;

	@FindBy(xpath = "//input[@id='year']")
	private WebElement enterBirthYearInputField;

	@FindBy(xpath = "//img[@src='https://images-web.int-green.ug.cdn.united.cloud/2020/06/01/18/28/25/412784_profile_l.png']")
	private WebElement selectProfileAvatar;

	@FindBy(xpath = "//button[@type='submit']")
	private WebElement createProfileSubmitButton;

	@FindBy(xpath = "//button[text()='Choose profile']")
	private WebElement chooseProfileButton;

	@FindBy(xpath = "//button[text()='Delete profile']")
	private WebElement deleteProfileButton;

	// Konstruktor

	public CreateNewProfilePage(WebDriver driver) {
		this.driver = driver;
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		PageFactory.initElements(driver, this);
		elementActions = new ElementActions(driver);
		assertActions = new AssertActions(driver);
	}

	// Metode

	public void clickOnCreateNewProfileButton() {
		elementActions.clickOnElement(createNewProfileButton);
	}

	public void enterName(String name) {
		elementActions.inputText(enterNameInputField, name);
	}

	public void clickOnAgeSelection() {
		elementActions.clickOnElement(selectAgeButton);
	}

	public void enterYourBirthYear(String birthYear) {
		elementActions.inputText(enterBirthYearInputField, birthYear);
	}

	public void clickOnAvatarImage() {
		elementActions.clickOnElement(selectProfileAvatar);
	}

	public void clickOnCreateProfileButton() {
		elementActions.clickOnElement(createProfileSubmitButton);
	}

	public void clickOnChooseProfileButton() {
		elementActions.clickOnElement(chooseProfileButton);
	}

	public void verifyThatProfileIsCreated() {
		assertActions.assertElementIsVisible(selectProfileAvatar);
	}

	public void clickOnTheCreatedProfile() {
		wait.until(ExpectedConditions.visibilityOf(selectProfileAvatar));
		selectProfileAvatar.click();
	}

	public void clickOnDeleteProfileButton() {
		wait.until(ExpectedConditions.visibilityOf(deleteProfileButton));
		deleteProfileButton.click();
	}

	public void verifyThatProfileIsDeleted() {
		assertActions.assertElementIsNotVisible(selectProfileAvatar);
	}

	public void createNewUserProfile(String name, String year) {
		clickOnCreateNewProfileButton();
		enterName(name);
		clickOnAgeSelection();
		enterYourBirthYear(year);
		clickOnAvatarImage();
		clickOnCreateProfileButton();
		clickOnChooseProfileButton();
		verifyThatProfileIsCreated();
	}

	public void deleteUserProfile() {
		clickOnTheCreatedProfile();
		clickOnDeleteProfileButton();
		verifyThatProfileIsDeleted();
	}
}
