package org.makerminds.jcoaching.finalexam.controller;

import java.util.ArrayList;
import java.util.List;

import org.makerminds.jcoaching.finalexam.model.Color;
import org.makerminds.jcoaching.finalexam.model.FuelType;
import org.makerminds.jcoaching.finalexam.model.Manufacturer;
import org.makerminds.jcoaching.finalexam.model.Transmission;
import org.makerminds.jcoaching.finalexam.model.Vehicle;

/**
 * responsible for transforming vehicle data into {@link Vehicle} objects.
 * 
 * @author <DardiRrapaj>
 *
 */
public class VehicleTransformer {

	/**
	 * transforms a data array into a {@link Vehicle} list
	 * 
	 * @param vehicle data array
	 * @return list of {@link Vehicle} objects
	 */
	public List<Vehicle> transformDataArrayToVehicleObjects(List<String> vehicleDataArray) {
		ArrayList<Vehicle> vehiclesList = new ArrayList<Vehicle>();
		for (String vehicleAsString : vehicleDataArray) {
			Vehicle vehicle = transformToVehicleObject(vehicleAsString);
			vehiclesList.add(vehicle);
		}
		// TODO take data from String list and transform to list of vehicle objects
		// TODO call method transformToVehicleObject
		// Hint: use for loop
		return vehiclesList;
	}

	/**
	 * transforms a vehicle data record as String into a {@link Vehicle} object
	 * 
	 * @param vehicle data record as String
	 * @return {@link Vehicle} object
	 */
	private Vehicle transformToVehicleObject(String vehicleAsString) {
		String[] splitedVehicleList = vehicleAsString.split(",");
		Vehicle vehicle = new Vehicle();
		vehicle.setVehicleId(Integer.valueOf(splitedVehicleList[0]));
		vehicle.setManufacturer(generateManufacterer(splitedVehicleList[1]));
		vehicle.setModel(splitedVehicleList[2]);
		vehicle.setMotorCapacity(Integer.valueOf(splitedVehicleList[3]));
		vehicle.setPrice(Double.valueOf(splitedVehicleList[4]));
		vehicle.setColor(generateColor(splitedVehicleList[5]));
		vehicle.setActualKilometers(Integer.valueOf(splitedVehicleList[6]));
		vehicle.setProductionYear(Integer.valueOf(splitedVehicleList[7]));
		vehicle.setFuelType(generateFuelType(splitedVehicleList[8]));
		vehicle.setTransmission(generateTransmission(splitedVehicleList[9]));

		// TODO transform the vehicle as string into a vehicle object
		// Hint: use the split(String) method of a String to define where to split the
		// String. In this case split on every comma (;)
		return vehicle;
	}

	private Transmission generateTransmission(String transmissionAsString) {
		for (Transmission transmission : Transmission.values()) {
			if (transmissionAsString.toUpperCase().equals(transmission.toString().toUpperCase())) {
				return transmission;
			}
		}
		return null;
	}

	private FuelType generateFuelType(String fuelTypeAsString) {
		for (FuelType fuelType : FuelType.values()) {
			if (fuelTypeAsString.toUpperCase().equals(fuelType.toString().toUpperCase())) {
				return fuelType;
			}
		}
		return null;
	}

	private Color generateColor(String colorAsString) {
		for (Color color : Color.values()) {
			if (colorAsString.toUpperCase().equals(color.toString().toUpperCase())) {
				return color;
			}
		}
		return null;
	}

	private Manufacturer generateManufacterer(String manufactererAsString) {
		for (Manufacturer manufacturer : Manufacturer.values()) {
			if (manufactererAsString.toUpperCase().equals(manufacturer.toString().toUpperCase())) {
				return manufacturer;
			}
		}
		return null;
	}
}
