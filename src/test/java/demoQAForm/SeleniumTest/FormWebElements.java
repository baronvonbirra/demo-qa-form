package demoQAForm.SeleniumTest;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class FormWebElements {
	FirefoxDriver driver;
	Randomizator random = new Randomizator();

	public void fillNameField(String query) {
		WebElement fieldName = driver.findElement(By.id("firstName"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", fieldName);
		fieldName.sendKeys(query);
	}
	
	public void fillSurnameField(String query) {
		WebElement fieldSurname = driver.findElement(By.id("lastName"));
		fieldSurname.sendKeys(query);
	}
	
	public void fillEmailField(String query) {
		WebElement fieldEmail = driver.findElement(By.id("userEmail"));
		fieldEmail.sendKeys(query + "@demoqa.com");
	}
	
	public void markRandomGender() {
		WebElement fieldGender1 = driver.findElement(By.id("gender-radio-1"));
		WebElement fieldGender2 = driver.findElement(By.id("gender-radio-2"));
		WebElement fieldGender3 = driver.findElement(By.id("gender-radio-3"));
		WebElement[] fieldsGender = {fieldGender1, fieldGender2, fieldGender3};
		((JavascriptExecutor)driver).executeScript("arguments[0].checked = true;", fieldsGender[random.RandomNumber(3)]);
	}
	
	public void fillRandomPhoneField() {
		WebElement fieldPhone = driver.findElement(By.id("userNumber"));
		fieldPhone.sendKeys(random.RandomPhone());
	}
	
	public void fillRandomDateField() {
		WebElement fieldDate = driver.findElement(By.id("dateOfBirthInput"));
		fieldDate.sendKeys(Keys.chord(Keys.CONTROL, "a"));
		fieldDate.sendKeys(random.RandomDate());
		fieldDate.sendKeys(Keys.chord(Keys.ENTER));
	}
	
	public void markRandomHobby() {
		WebElement fieldHobbies1 = driver.findElement(By.id("hobbies-checkbox-1"));
		WebElement fieldHobbies2 = driver.findElement(By.id("hobbies-checkbox-2"));
		WebElement fieldHobbies3 = driver.findElement(By.id("hobbies-checkbox-3"));
		WebElement[] fieldsHobbies = {fieldHobbies1, fieldHobbies2, fieldHobbies3};
		((JavascriptExecutor)driver).executeScript("arguments[0].checked = true;", fieldsHobbies[random.RandomNumber(3)]);
	}
	
	public void fillRandomAddressField() {
		WebElement fieldAddress = driver.findElement(By.id("currentAddress"));
		fieldAddress.sendKeys(random.RandomAddress());
	}
	
	public void pressSubmitButton() {
		WebElement buttonSubmit = driver.findElement(By.id("submit"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", buttonSubmit);
		buttonSubmit.click();
	}
	
	public void pressCloseButton() {
		WebElement buttonCloseModal = driver.findElement(By.id("closeLargeModal"));
		buttonCloseModal.click();
	}
	
	public void checkModalConfirmation() {
		String modalTitle;
		modalTitle = driver.findElement(By.id("example-modal-sizes-title-lg")).getText();
		Assert.assertTrue(modalTitle.contains("Thanks for submitting the form"));
		System.out.println("User succesfully registered.");
	}
	
	public void registerUser(String[] user) {
		fillNameField(user[0]);
		fillSurnameField(user[user.length - 1]);
		fillEmailField(user[0] + user[user.length - 1]);
		markRandomGender();
		fillRandomPhoneField();
		fillRandomDateField();
		markRandomHobby();
		fillRandomAddressField();
		pressSubmitButton();
		checkModalConfirmation();
		pressCloseButton();
	}
	
	public FormWebElements(WebDriver driver) {
		this.driver = (FirefoxDriver) driver;
	}
}
