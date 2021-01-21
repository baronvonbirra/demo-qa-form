package demoQAForm.SeleniumTest;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.ThreadLocalRandom;
import org.apache.commons.lang3.RandomStringUtils;
public class Randomizator {

	public int RandomNumber(int Numb) {
		ThreadLocalRandom random = ThreadLocalRandom.current();
		return random.nextInt(1, Numb);
	}

	public String RandomPhone() {
		ThreadLocalRandom random = ThreadLocalRandom.current();
		long randomNum = random.nextLong(1111111111, 9999999999L);
		return Long.toString(randomNum);
	}

	public String RandomDate() {
		int hundredYears = 100 * 365;
		LocalDate date = LocalDate.ofEpochDay(ThreadLocalRandom.current().nextInt(-hundredYears, hundredYears));
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd LLLL yyyy");
		String formattedString = date.format(formatter);
		return formattedString;
	}

	public String RandomAddress() {
		int length = 10;
		boolean useLetters = true;
		boolean useNumbers = false;
		String generatedString = RandomStringUtils.random(length, useLetters, useNumbers);
		return generatedString;
	}

}
