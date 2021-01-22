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
	
	// Users info
	String user1 = shuffledList[0];
	String user1Split[] = user1.split("\\W+");
	String user2 = shuffledList[1];
	String user2Split[] = user2.split("\\W+");
	String user3 = shuffledList[2];
	String user3Split[] = user3.split("\\W+");
	String user4 = shuffledList[3];
	String user4Split[] = user4.split("\\W+");
	String user5 = shuffledList[4];
	String user5Split[] = user5.split("\\W+");
	
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
		
		System.out.println("Users to register are: " + Arrays.toString(shuffledList));

		FormWebElements elements = new FormWebElements(driver);
		// Register User 1
		System.out.println("user 1 is: " + user1);
		elements.fillNameField(user1Split[0]);
		elements.fillSurnameField(user1Split[user1Split.length - 1]);
		elements.fillEmailField(user1Split[0] + user1Split[user1Split.length - 1]);
		elements.markRandomGender();
		elements.fillRandomPhoneField();
		elements.fillRandomDateField();
		elements.markRandomHobby();
		elements.fillRandomAddressField();
		elements.pressSubmitButton();
		elements.checkModalConfirmation();
		elements.pressCloseButton();

		// Register User 2
		System.out.println("user 2 is: " + user2);
		elements.fillNameField(user2Split[0]);
		elements.fillSurnameField(user2Split[user2Split.length - 1]);
		elements.fillEmailField(user2Split[0] + user2Split[user2Split.length - 1]);
		elements.markRandomGender();
		elements.fillRandomPhoneField();
		elements.fillRandomDateField();
		elements.markRandomHobby();
		elements.fillRandomAddressField();
		elements.pressSubmitButton();
		elements.checkModalConfirmation();
		elements.pressCloseButton();
		
		// Register User 3
		System.out.println("user 3 is: " + user3);
		elements.fillNameField(user3Split[0]);
		elements.fillSurnameField(user3Split[user3Split.length - 1]);
		elements.fillEmailField(user3Split[0] + user3Split[user3Split.length - 1]);
		elements.markRandomGender();
		elements.fillRandomPhoneField();
		elements.fillRandomDateField();
		elements.markRandomHobby();
		elements.fillRandomAddressField();
		elements.pressSubmitButton();
		elements.checkModalConfirmation();
		elements.pressCloseButton();
		
		// Register User 4
		System.out.println("user 4 is: " + user4);
		elements.fillNameField(user4Split[0]);
		elements.fillSurnameField(user4Split[user4Split.length - 1]);
		elements.fillEmailField(user4Split[0] + user4Split[user4Split.length - 1]);
		elements.markRandomGender();
		elements.fillRandomPhoneField();
		elements.fillRandomDateField();
		elements.markRandomHobby();
		elements.fillRandomAddressField();
		elements.pressSubmitButton();
		elements.checkModalConfirmation();
		elements.pressCloseButton();
		
		// Register User 5
		System.out.println("user 5 is: " + user5);
		elements.fillNameField(user5Split[0]);
		elements.fillSurnameField(user5Split[user5Split.length - 1]);
		elements.fillEmailField(user5Split[0] + user5Split[user5Split.length - 1]);
		elements.markRandomGender();
		elements.fillRandomPhoneField();
		elements.fillRandomDateField();
		elements.markRandomHobby();
		elements.fillRandomAddressField();
		elements.pressSubmitButton();
		elements.checkModalConfirmation();
		elements.pressCloseButton();
		
		// Display non-registered users
		String[] remainingUsers = Arrays.copyOfRange(shuffledList, 5, 10);
		System.out.println("Non-registered users are: " + Arrays.toString(remainingUsers));
	
		System.out.println("Ending test " + new Object() {
		}.getClass().getEnclosingMethod().getName());
	}

	@AfterClass
	public static void closeBrowser() {
		driver.quit();
	}
}