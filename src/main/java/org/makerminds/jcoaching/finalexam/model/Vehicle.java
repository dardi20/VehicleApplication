package org.makerminds.jcoaching.finalexam.model;

/**
 * class for vehicle objects.
 * 
 * @author <DardiRrapaj>
 *
 */
public class Vehicle {
	private int vehicleId;
	private Manufacturer manufacturer;
	private String model;
	private int motorCapacity;
	private double price;
	private Color color;
	private int actualKilometers;
	private int productionYear;
	private FuelType fuelType;
	private Transmission transmission;
	
	public Vehicle() {
	}
	public int getVehicleId() {
		return vehicleId;
	}
	public void setVehicleId(int vehicleId) {
		this.vehicleId = vehicleId;
	}
	public Manufacturer getManufacturer() {
		return manufacturer;
	}
	public void setManufacturer(Manufacturer manufacturer) {
		this.manufacturer = manufacturer;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public int getMotorCapacity() {
		return motorCapacity;
	}
	public void setMotorCapacity(int motorCapacity) {
		this.motorCapacity = motorCapacity;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public Color getColor() {
		return color;
	}
	public void setColor(Color color) {
		this.color = color;
	}
	public int getActualKilometers() {
		return actualKilometers;
	}
	public void setActualKilometers(int actualKilometers) {
		this.actualKilometers = actualKilometers;
	}
	public int getProductionYear() {
		return productionYear;
	}
	public void setProductionYear(int productionYear) {
		this.productionYear = productionYear;
	}
	public FuelType getFuelType() {
		return fuelType;
	}
	public void setFuelType(FuelType fuelType) {
		this.fuelType = fuelType;
	}
	public Transmission getTransmission() {
		return transmission;
	}
	public void setTransmission(Transmission transmission) {
		this.transmission = transmission;
	}
}
