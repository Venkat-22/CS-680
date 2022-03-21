package edu.umb.cs680.hw03;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class CarTest {

	private String[] CarToStringArray(Car instance) {
		String[] carDetails = { instance.getMake(), instance.getModel(), Integer.toString(instance.getYear()) };
		return carDetails;
	}

	@Test
	public void verifyCarEqualityWithMakeModelYear() {
		String[] expected = { "BMW", "M5", "2022" };
		Car actual = new Car("BMW", "M5", 14, 2022, 21000);
		assertArrayEquals(expected, CarToStringArray(actual));
	}
	

}
