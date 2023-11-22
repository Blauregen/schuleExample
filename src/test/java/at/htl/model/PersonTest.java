package at.htl.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.text.SimpleDateFormat;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

public class PersonTest {
	Person person;

	@BeforeEach
	public void beforeEach() {
		person = new Person();
	}

	@Test
	public void firstNameIsSetCorrectlyWhenValidNameIsProvided() {
		String validName = "John";
		person.setFirstName(validName);
		assertEquals(validName, person.getFirstName());
	}

	@Test
	public void firstNameRemainsNullWhenNullIsProvided() {
		person.setFirstName(null);
		assertNull(person.getFirstName());
	}

	@Test
	public void lastNameIsSetCorrectlyWhenValidNameIsProvided() {
		String validName = "Doe";
		person.setLastName(validName);
		assertEquals(validName, person.getLastName());
	}

	@Test
	public void lastNameRemainsNullWhenNullIsProvided() {
		person.setLastName(null);
		assertNull(person.getLastName());
	}

	@Test
	public void dateOfBirthIsSetCorrectlyWhenValidDateIsProvided() {
		String validDate = "2000-01-01";
		person.setDateOfBirth(validDate);
		assertEquals(validDate, new SimpleDateFormat("yyyy-MM-dd").format(person.getDateOfBirth()));
	}

	@Test
	public void throwsExceptionWhenBirthdateIsSetToInvalidDate() {
		String invalidDate = "invalid-date";
		assertThrows(IllegalArgumentException.class, () -> person.setDateOfBirth(invalidDate));
	}

	@Test
	public void throwsExceptionWhenBirthdateIsSetToNull() {
		assertThrows(IllegalArgumentException.class, () -> person.setDateOfBirth((Date) null));
	}

	@Test
	public void addressIsSetCorrectlyWhenValidAddressIsProvided() {
		Address validAddress = new Address();
		validAddress.setZipCode(4020);
		validAddress.setCity("Linz");
		validAddress.setStreet("Hauptstraße");
		validAddress.setHouseNumber("1");

		person.setAddress(validAddress);
		assertEquals(validAddress, person.getAddress());
	}

	@Test
	public void throwsExceptionWhenAddressIsSetToNull() {
		assertThrows(IllegalArgumentException.class, () -> person.setAddress(null));
	}

	@Test
	public void throwsExceptionWhenAddressIsSetToInvalidAddress() {
		Address invalidAddress = new Address();
		invalidAddress.setCity(null);
		invalidAddress.setStreet(null);
		invalidAddress.setHouseNumber(null);
		assertThrows(IllegalArgumentException.class, () -> person.setAddress(invalidAddress));
	}
}
