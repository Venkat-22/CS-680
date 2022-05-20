package edu.umb.cs680.hw11;
//change car names
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Collections;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;



class CarTest {
	static ArrayList<Car> cars = new ArrayList<>();
	@BeforeAll
	static void setupBeforeTest() throws Exception{
	 
     cars.add(new Car("Toyota", "Atlis", 1000, 2021, 25000));
     cars.add(new Car("Suzuki", "Swift", 4000, 2018, 20000));
     cars.add(new Car("Volvo", "V10", 2000, 2021, 30000));
     cars.add(new Car("BMW", "X5", 500, 2022, 50000));
     
	}
	  @Test
	    public void priceComparatorTest() {
		  for(Car car : cars) {
	            car.setDominationCount(cars);
	        }
	        Collections.sort(cars, new PriceComparator());

	        assertEquals(20000, cars.get(0).getPrice());
	        assertEquals(25000, cars.get(1).getPrice());
	        assertEquals(30000, cars.get(2).getPrice());
	        assertEquals(50000, cars.get(3).getPrice());
	    }

	    @Test
	    public void mileageComparatorTest() {
	    	for(Car car : cars) {
	            car.setDominationCount(cars);
	        }
	        Collections.sort(cars, new MileageComparator());

	        assertEquals(500, cars.get(0).getMileage());
	        assertEquals(1000, cars.get(1).getMileage());
	        assertEquals(2000, cars.get(2).getMileage());
	        assertEquals(4000, cars.get(3).getMileage());
	    }

	    @Test
	    public void yearComparatorTest() {
	        
	        for(Car car : cars) {
	            car.setDominationCount(cars);
	        }
	        Collections.sort(cars, new YearComparator());

	        assertEquals(2022, cars.get(0).getYear());
	        assertEquals(2021, cars.get(1).getYear());
	       assertEquals(2021, cars.get(2).getYear());
	       
	    }

	    @Test
	    public void paretoComparatorTest() {
 	        for(Car car : cars) {
	            car.setDominationCount(cars);
	        }
	        Collections.sort(cars, new ParetoComparator());

	        assertEquals(25000, cars.get(1).getPrice());
	        assertEquals(4000, cars.get(2).getMileage());
	        assertEquals(2021, cars.get(1).getYear());
	        assertEquals("Volvo", cars.get(3).getMake());
	        assertEquals("V10", cars.get(3).getModel());
	    }

}
