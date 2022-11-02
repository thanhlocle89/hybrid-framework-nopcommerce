package oop;

public class CarOOP {
	protected CarOOP(String carName, String carType, String fuelType, double mileAge, float carPrice) {
		this.carName = carName;
		this.carType = carType;
		this.fuelType = fuelType;
		this.mileAge = mileAge;
		this.carPrice = carPrice;
	}

	private String carName;
	private String carType;
	private String fuelType;
	private double mileAge;
	private float carPrice;
	
	
	
	protected String getCarName() {
		return carName;
	}



	protected void setCarName(String carName) {
		this.carName = carName;
	}



	protected String getCarType() {
		return carType;
	}



	protected void setCarType(String carType) {
		this.carType = carType;
	}



	protected String getFuelType() {
		return fuelType;
	}



	protected void setFuelType(String fuelType) {
		this.fuelType = fuelType;
	}



	protected double getMileAge() {
		return mileAge;
	}



	protected void setMileAge(double mileAge) {
		this.mileAge = mileAge;
	}



	protected float getCarPrice() {
		return carPrice;
	}



	protected void setCarPrice(float carPrice) {
		this.carPrice = carPrice;
	}

	protected void showCarInfo() {
		System.out.println("Car name: " +  getCarName() );
		System.out.println("Car type: " + getCarType() );
		System.out.println("Car fuel type: " + getFuelType() );
		System.out.println("Car mile age: " + getMileAge() );
		System.out.println("Car price: " + getCarPrice() );
	}

	public static void main(String[] args) {
		CarOOP honda = new CarOOP("Honda","City","Electric",100d,5000f);
		honda.showCarInfo();
	}

}
