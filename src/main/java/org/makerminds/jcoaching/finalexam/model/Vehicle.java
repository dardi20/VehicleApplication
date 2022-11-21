package org.makerminds.jcoaching.finalexam.model;

/**
 * class for vehicle objects.
 * 
 * @author <DardiRrapaj>
 *
 */
public class Vehicle {
	private int vehicleId;
	private String model;
	private int horsePower;
	private double price;
	private int mileage;
	private int productionYear;
	
	public Vehicle() {
	}
	public int getVehicleId() {
		return vehicleId;
	}
	public void setVehicleId(int vehicleId) {
		this.vehicleId = vehicleId;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public int getMotorCapacity() {
		return horsePower;
	}
	public void setMotorCapacity(int motorCapacity) {
		this.horsePower = motorCapacity;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getActualKilometers() {
		return mileage;
	}
	public void setActualKilometers(int actualKilometers) {
		this.mileage = actualKilometers;
	}
	public int getProductionYear() {
		return productionYear;
	}
	public void setProductionYear(int productionYear) {
		this.productionYear = productionYear;
	}
	
}
