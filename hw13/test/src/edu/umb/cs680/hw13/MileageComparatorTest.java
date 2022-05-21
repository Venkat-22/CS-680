package edu.umb.cs680.hw13;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.junit.jupiter.api.Test;

class MileageComparatorTest {

	List<Car> carList = new ArrayList<Car>();
	@Test
	public void mileageComparatorVerifier() 
	{
		 carList.add(new Car("Toyota", "Atlis", 27, 2021, 26000));
		 carList.add(new Car("Suzuki", "Swift", 18, 2015, 10000));	 
		 Collections.sort(carList,(Car car1, Car car2) -> car1.getMileage()-car2.getMileage());
		 assertEquals(18,carList.get(0).getMileage());
		 assertEquals(27, carList.get(1).getMileage());
		
	}
	
	
}
