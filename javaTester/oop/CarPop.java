package oop;

public class CarPop {
	static String carName;
	static String carType;
	static String fuelType;
	static float mileAge;
	static double carPrice;
	
	public static void main(String[] args) {
		carName = "BMW";
		carType = "Electric Car";
		fuelType = "Hybrid";
		mileAge = 100f;
		carPrice = 50000d;
		
		System.out.println("Car name" + carName );
		System.out.println("Car type" + carType );
		System.out.println("Car fuel type" + fuelType );
		System.out.println("Car mile age" + mileAge );
		System.out.println("Car price" + carPrice );
	}
}
