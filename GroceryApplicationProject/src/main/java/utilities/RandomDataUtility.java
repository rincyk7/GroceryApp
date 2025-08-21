package utilities;

import com.github.javafaker.Faker;

public class RandomDataUtility {
	Faker faker = new Faker();

	public String createRandomUserName() {
		return faker.name().username();
	}

	public String createRandomPassword() {
		return faker.internet().password();
	}

	public String createFullName() {
		return faker.name().fullName();
	}

	public String createRandomeMail() {
		return faker.internet().emailAddress();
	}

}
