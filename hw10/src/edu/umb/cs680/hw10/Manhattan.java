package edu.umb.cs680.hw10;

import java.util.List;

public class Manhattan implements DistanceMetric {

	@Override
	public double distance(List<Double> p1, List<Double> p2) {
		// TODO Auto-generated method stub
		double coordinateSum = 0;
		if(p1.size()==p2.size()) {
			for (int i = 0; i < p1.size(); i++) {
				coordinateSum= coordinateSum+ Math.abs(p1.get(i) - p2.get(i));
		}
	}
		return coordinateSum;
		
	}
}
