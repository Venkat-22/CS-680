package edu.umb.cs680.hw10;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


public class ManhattanTest {
	@Test
	public void distanceTestWithP1P2() {
		List<Double> p1 = Arrays.asList(2.0, 3.0, 5.0);
		List<Double> p2 = Arrays.asList(2.0, 5.0, 6.0);
		double expected = 3;
		double actual = new Manhattan().distance(p1, p2);
		assertEquals(expected, actual);
	}
}