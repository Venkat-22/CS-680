package edu.umb.cs680.hw13;

import java.util.ArrayList;

public class Car {
	
		private String make, model;
		private int mileage, year;
		private float price;
		private int dominationCount;

		public String getMake() {
			return make;
		}

		public String getModel() {
			return model;
		}

		public int getMileage() {
			return mileage;
		}

		public int getYear() {
			return year;
		}
		
		public float getPrice() {
			return price;
		}
		
		public void setDominationCount(ArrayList<Car> cars) {
			this.dominationCount = 0;
			for (Car car : cars) {
				if(car.getMileage() <= this.getMileage() && car.getPrice() <= this.getPrice() && car.getYear() >= this.getYear()) {
					if(car.getMileage() < this.getMileage() || car.getPrice() < this.getPrice() || car.getYear() > this.getYear()) {
						dominationCount++;
					}
				}
			}
		}
		public int getDominationCount() {
			return dominationCount;
		}

		public Car(String make, String model, int mileage, int year, float price) {
			super();
			this.make = make;
			this.model = model;
			this.mileage = mileage;
			this.year = year;
			this.price = price;
		}
}
