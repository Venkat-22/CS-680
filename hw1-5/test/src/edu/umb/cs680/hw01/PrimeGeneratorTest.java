package edu.umb.cs680.hw01;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class PrimeGeneratorTest {
	@Test
	public void primeBetween1To10() {
		PrimeGenerator prime = new PrimeGenerator(1, 10);
		prime.generatePrimes();
		Long[] expectedPrimes = { 2L, 3L, 5L, 7L };
		assertArrayEquals(expectedPrimes, prime.getPrimes().toArray());
	}

	
	@Test
	public void primeBetween50to100() {
		PrimeGenerator prime = new PrimeGenerator(50, 100);
		prime.generatePrimes();
		Long[] expectedPrimes = {53L,59L,61L,67L,71L,73L,79L,83L,89L,97L };
		assertArrayEquals( expectedPrimes, prime.getPrimes().toArray() );
	}


	@Test
	public void primeBetweenegative10to10() {
		long from = -10;
		long to = 10;
		try {

			PrimeGenerator prime = new PrimeGenerator(from, to);
			Long[] expectedPrimes = {};
			assertArrayEquals(expectedPrimes, prime.getPrimes().toArray());
		} catch (RuntimeException ex) {
			assertEquals("Wrong input values: from=" + from + " to=" + to, ex.getMessage());
		}

	}

	@Test
	public void primeBetween100to1() {
		long from = 100;
		long to = 1;
		try {

			PrimeGenerator prime = new PrimeGenerator(from, to);
			Long[] expectedPrimes = {};
			assertArrayEquals(expectedPrimes, prime.getPrimes().toArray());
		} catch (RuntimeException ex) {
			assertEquals("Wrong input values: from=" + from + " to=" + to, ex.getMessage());
		}

	}
	}

