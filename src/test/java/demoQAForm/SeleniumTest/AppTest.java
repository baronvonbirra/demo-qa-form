package demoQAForm.SeleniumTest;

import java.util.concurrent.TimeUnit;
import java.util.Random;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.Keys;
import java.util.Arrays;

import demoQAForm.SeleniumTest.Randomizator;

public class AppTest {
	private static FirefoxDriver driver;
	WebElement element;
	Randomizator random = new Randomizator();
	
	// Test data
	public String RegistrationURL = "https://demoqa.com/automation-practice-form";
	static String[] nameList = { "Jan van Dam", "Chack Norris", "Klark n Kent", "John Daw", "Bat Man", "Tim Los",
			"Dave o Core", "Pay Pal", "Lazy Cat", "Jack & Johnes" };
	// Get 5 random users
	public String[] shuffler() {
		Random rand = new Random();
		for (int i = 0; i < nameList.length; i++) {
			int randomIndexToSwap = rand.nextInt(nameList.length);
			String temp = nameList[randomIndexToSwap];
			nameList[randomIndexToSwap] = nameList[i];
			nameList[i] = temp;
		}
		return nameList;
	}
	public String[] shuffledList = shuffler();
	
	@BeforeClass
	public static void openBrowser() {
		System.setProperty("webdriver.gecko.driver","C:\\Program Files\\selenium-java-3.141.59\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	@Test
	public void testWebsite() {
		System.out.println("Starting test " + new Object() {
		}.getClass().getEnclosingMethod().getName());

		driver.get(RegistrationURL);
		String URL = driver.getCurrentUrl();
		// Check URL matches the navigation path
		Assert.assertTrue(URL.contains(RegistrationURL));
		
		// RegistrationPage Elements
		WebElement fieldName = driver.findElement(By.id("firstName"));
		WebElement fieldSurname = driver.findElement(By.id("lastName"));
		WebElement fieldEmail = driver.findElement(By.id("userEmail"));
		WebElement fieldGender1 = driver.findElement(By.id("gender-radio-1"));
		WebElement fieldGender2 = driver.findElement(By.id("gender-radio-2"));
		WebElement fieldGender3 = driver.findElement(By.id("gender-radio-3"));
		WebElement[] fieldsGender = {fieldGender1, fieldGender2, fieldGender3};
		WebElement fieldPhone = driver.findElement(By.id("userNumber"));
		WebElement fieldDate = driver.findElement(By.id("dateOfBirthInput"));
		WebElement fieldHobbies1 = driver.findElement(By.id("hobbies-checkbox-1"));
		WebElement fieldHobbies2 = driver.findElement(By.id("hobbies-checkbox-2"));
		WebElement fieldHobbies3 = driver.findElement(By.id("hobbies-checkbox-3"));
		WebElement[] fieldsHobbies = {fieldHobbies1, fieldHobbies2, fieldHobbies3};
		WebElement fieldAddress = driver.findElement(By.id("currentAddress"));
		WebElement buttonSubmit = driver.findElement(By.id("submit"));
		String modalTitle;
		WebElement buttonCloseModal;
		
		System.out.println("Users to register are: " + Arrays.toString(shuffledList));

		// Register User 1
		String user1 = shuffledList[0];
		System.out.println("user 1 is: " + user1);
		String user1Split[] = user1.split("\\W+");
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", fieldName);
		fieldName.sendKeys(user1Split[0]);
		fieldSurname.sendKeys(user1Split[user1Split.length - 1]);
		fieldEmail.sendKeys(user1Split[0] + user1Split[user1Split.length - 1] + "@demoqa.com");
		((JavascriptExecutor)driver).executeScript("arguments[0].checked = true;", fieldsGender[random.RandomNumber(3)]);
		fieldPhone.sendKeys(random.RandomPhone());
		fieldDate.sendKeys(Keys.chord(Keys.CONTROL, "a"));
		fieldDate.sendKeys(random.RandomDate());
		fieldDate.sendKeys(Keys.chord(Keys.ENTER));
		((JavascriptExecutor)driver).executeScript("arguments[0].checked = true;", fieldsHobbies[random.RandomNumber(3)]);
		fieldAddress.sendKeys(random.RandomAddress());
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", buttonSubmit);
		buttonSubmit.click();
		modalTitle = driver.findElement(By.id("example-modal-sizes-title-lg")).getText();
		Assert.assertTrue(modalTitle.contains("Thanks for submitting the form"));
		buttonCloseModal = driver.findElement(By.id("closeLargeModal"));
		buttonCloseModal.click();
		
		// Register User 2
		String user2 = shuffledList[1];
		System.out.println("user 2 is: " + user2);
		String user2Split[] = user2.split("\\W+");
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", fieldName);
		fieldName.sendKeys(user2Split[0]);
		fieldSurname.sendKeys(user2Split[user2Split.length - 1]);
		fieldEmail.sendKeys(user2Split[0] + user2Split[user2Split.length - 1] + "@demoqa.com");
		((JavascriptExecutor)driver).executeScript("arguments[0].checked = true;", fieldsGender[random.RandomNumber(3)]);
		fieldPhone.sendKeys(random.RandomPhone());
		fieldDate.sendKeys(Keys.chord(Keys.CONTROL, "a"));
		fieldDate.sendKeys(random.RandomDate());
		fieldDate.sendKeys(Keys.chord(Keys.ENTER));
		((JavascriptExecutor)driver).executeScript("arguments[0].checked = true;", fieldsHobbies[random.RandomNumber(3)]);
		fieldAddress.sendKeys(random.RandomAddress());
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", buttonSubmit);
		buttonSubmit.click();
		modalTitle = driver.findElement(By.id("example-modal-sizes-title-lg")).getText();
		Assert.assertTrue(modalTitle.contains("Thanks for submitting the form"));
		buttonCloseModal = driver.findElement(By.id("closeLargeModal"));
		buttonCloseModal.click();
		
		// Register User 3
		String user3 = shuffledList[2];
		System.out.println("user 3 is: " + user3);
		String user3Split[] = user3.split("\\W+");
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", fieldName);
		fieldName.sendKeys(user3Split[0]);
		fieldSurname.sendKeys(user3Split[user3Split.length - 1]);
		fieldEmail.sendKeys(user3Split[0] + user3Split[user3Split.length - 1] + "@demoqa.com");
		((JavascriptExecutor)driver).executeScript("arguments[0].checked = true;", fieldsGender[random.RandomNumber(3)]);
		fieldPhone.sendKeys(random.RandomPhone());
		fieldDate.sendKeys(Keys.chord(Keys.CONTROL, "a"));
		fieldDate.sendKeys(random.RandomDate());
		fieldDate.sendKeys(Keys.chord(Keys.ENTER));
		((JavascriptExecutor)driver).executeScript("arguments[0].checked = true;", fieldsHobbies[random.RandomNumber(3)]);
		fieldAddress.sendKeys(random.RandomAddress());
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", buttonSubmit);
		buttonSubmit.click();
		modalTitle = driver.findElement(By.id("example-modal-sizes-title-lg")).getText();
		Assert.assertTrue(modalTitle.contains("Thanks for submitting the form"));
		buttonCloseModal = driver.findElement(By.id("closeLargeModal"));
		buttonCloseModal.click();
		
		// Register User 4
		String user4 = shuffledList[3];
		System.out.println("user 4 is: " + user4);
		String user4Split[] = user4.split("\\W+");
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", fieldName);
		fieldName.sendKeys(user4Split[0]);
		fieldSurname.sendKeys(user4Split[user4Split.length - 1]);
		fieldEmail.sendKeys(user4Split[0] + user4Split[user4Split.length - 1] + "@demoqa.com");
		((JavascriptExecutor)driver).executeScript("arguments[0].checked = true;", fieldsGender[random.RandomNumber(3)]);
		fieldPhone.sendKeys(random.RandomPhone());
		fieldDate.sendKeys(Keys.chord(Keys.CONTROL, "a"));
		fieldDate.sendKeys(random.RandomDate());
		fieldDate.sendKeys(Keys.chord(Keys.ENTER));
		((JavascriptExecutor)driver).executeScript("arguments[0].checked = true;", fieldsHobbies[random.RandomNumber(3)]);
		fieldAddress.sendKeys(random.RandomAddress());
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", buttonSubmit);
		buttonSubmit.click();
		modalTitle = driver.findElement(By.id("example-modal-sizes-title-lg")).getText();
		Assert.assertTrue(modalTitle.contains("Thanks for submitting the form"));
		buttonCloseModal = driver.findElement(By.id("closeLargeModal"));
		buttonCloseModal.click();
		
		// Register User 5
		String user5 = shuffledList[4];
		System.out.println("user 5 is: " + user5);
		String user5Split[] = user5.split("\\W+");
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", fieldName);
		fieldName.sendKeys(user5Split[0]);
		fieldSurname.sendKeys(user5Split[user5Split.length - 1]);
		fieldEmail.sendKeys(user5Split[0] + user5Split[user5Split.length - 1] + "@demoqa.com");
		((JavascriptExecutor)driver).executeScript("arguments[0].checked = true;", fieldsGender[random.RandomNumber(3)]);
		fieldPhone.sendKeys(random.RandomPhone());
		fieldDate.sendKeys(Keys.chord(Keys.CONTROL, "a"));
		fieldDate.sendKeys(random.RandomDate());
		fieldDate.sendKeys(Keys.chord(Keys.ENTER));
		((JavascriptExecutor)driver).executeScript("arguments[0].checked = true;", fieldsHobbies[random.RandomNumber(3)]);
		fieldAddress.sendKeys(random.RandomAddress());
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", buttonSubmit);
		buttonSubmit.click();
		modalTitle = driver.findElement(By.id("example-modal-sizes-title-lg")).getText();
		Assert.assertTrue(modalTitle.contains("Thanks for submitting the form"));
		buttonCloseModal = driver.findElement(By.id("closeLargeModal"));
		buttonCloseModal.click();
		
		// Display non-registered users
		String[] remainingUsers = Arrays.copyOfRange(shuffledList, 5, 10);
		System.out.println("Non-registered users are: " + Arrays.toString(remainingUsers));
	
		System.out.println("Ending test " + new Object() {
		}.getClass().getEnclosingMethod().getName());
	}

	@AfterClass
	public static void closeBrowser() {
		// driver.quit();
	}
}