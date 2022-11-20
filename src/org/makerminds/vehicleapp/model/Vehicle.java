package org.makerminds.vehicleapp.model;

public class Vehicle {
@Override
	public String toString() {
		return "Model: " + model + ", Fuel Type: " + fuelType + ", Color: " + color;
	}

private CarModel model;
private FuelType fuelType;
private Color color;

public Vehicle(CarModel model, FuelType fuelType, Color color) {
	this.model = model;
	this.fuelType = fuelType;
	this.color = color;
}
public CarModel getModel() {
	return model;
}

public void setModel(CarModel model) {
	this.model = model;
}

public FuelType getFuelType() {
	return fuelType;
}

public void setFuelType(FuelType fuelType) {
	this.fuelType = fuelType;
}

public Color getColor() {
	return color;
}

public void setColor(Color color) {
	this.color = color;
}


}
