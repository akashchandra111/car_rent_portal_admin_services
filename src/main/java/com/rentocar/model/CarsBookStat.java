package com.rentocar.model;

public class CarsBookStat {

	private String carType, availableCars, rentedCars;

	public CarsBookStat(String carType, String availableCars, String rentedCars) {
		this.carType = carType;
		this.availableCars = availableCars;
		this.rentedCars = rentedCars;
	}

	public String getCarType() {
		return carType;
	}

	public void setCarType(String carType) {
		this.carType = carType;
	}

	public String getAvailableCars() {
		return availableCars;
	}

	public void setAvailableCars(String availableCars) {
		this.availableCars = availableCars;
	}

	public String getRentedCars() {
		return rentedCars;
	}

	public void setRentedCars(String rentedCars) {
		this.rentedCars = rentedCars;
	}
}
