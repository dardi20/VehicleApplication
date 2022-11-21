package org.makerminds.jcoaching.finalexam.controller;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.makerminds.jcoaching.finalexam.model.Car;
import org.makerminds.jcoaching.finalexam.model.Motorcycle;
import org.makerminds.jcoaching.finalexam.model.Vehicle;

/**
 * responsible for printing vehicle shop data.
 * 
 * @author <DardiRrapaj>
 *
 */
public class VehicleShopPrinter {

	public void printAvailableVehicles(List<Vehicle> vehicleList) {

		for (Vehicle vehicle : vehicleList) {
			if (vehicle.getVehicleId() < 200) {
				System.out.println("" + vehicle.getVehicleId() + ", " + ((Car) vehicle).getManufacturer() + ", "
						+ vehicle.getModel() + ", " + vehicle.getMotorCapacity() + ", " + vehicle.getPrice() + ", "
						+ ((Car) vehicle).getColor() + ", " + vehicle.getActualKilometers() + ", "
						+ vehicle.getProductionYear() + ", " + ((Car) vehicle).getFuelType() + ", "
						+ ((Car) vehicle).getTransmission());
			} else {
				System.out.println("" + vehicle.getVehicleId() + ", " + vehicle.getModel() + ", "
						+ vehicle.getMotorCapacity() + ", " + vehicle.getPrice() + ", " + vehicle.getActualKilometers()
						+ ", " + vehicle.getProductionYear() + ", " + ((Motorcycle) vehicle).isExtendable());
			}
		}

		// Implementation of print available vehicles
	}

	public void printVehicleSoldMessage(int vehicleChosenId) {
		// \n in a String will cause a line break
		System.out.println("\n" + "Vehicle with ID " + vehicleChosenId + " was sold.");
	}

	public void printVehicleIdToSellRequest() {
		// \n in a String will cause a line break
		System.out.println("\n\n Please enter the number (ID) of the vehicle you want to sell: ");
	}

	public void filterRequest() {
		System.out.println("\n Activate filter ? (Yes input 1 : No input any key.)");
	}

	public void filterType() {
		System.out.println("\n Filter vehicle collection by max price (input 1) or by manufacturer (input 2)");
	}

	public void filterVehicleList(int filterType) {
		switch (filterType) {
		case 1:
			System.out.println("\n Insert your max price: ");
			break;
		case 2:
			System.out.println("\n Insert your desired manufacturer: ");
			break;
		default:
			System.out.println("\n Option: " + filterType + " is not valid !"
					+ "\n Aplication will apply max price filter." + "\n Insert your max price: ");
			filterType = 1;
		}
	}

	public void printAvaibleVehicleByFilterKey(int filterType, String filterKey, List<Vehicle> vehicleList) {
		switch (filterType) {
		case 1:
			printVehicleListByMaxPrice(filterKey, vehicleList);
			break;
		case 2:
			printVehicleListByManufacturer(filterKey, vehicleList);
			break;
		}
	}

	private void printVehicleListByManufacturer(String filterKey, List<Vehicle> vehicleList) {
		List<Vehicle> filteredVehicleList = new ArrayList<Vehicle>();
		Iterator<Vehicle> vehicleListIterator = vehicleList.iterator();
		while (vehicleListIterator.hasNext()) {
			Vehicle actualVehicle = vehicleListIterator.next();
			if (actualVehicle.getVehicleId() >= 200) {
				continue;
			}
			if (((Car) actualVehicle).getManufacturer().toString().toLowerCase().equals(filterKey.toLowerCase())) {
				filteredVehicleList.add(actualVehicle);
			}
		}
		if (filteredVehicleList.size() != 0) {
			printAvailableVehicles(filteredVehicleList);
		} else {
			System.out.println(" There are no vehicles with the selected filter.");
		}
	}

	private void printVehicleListByMaxPrice(String filterKey, List<Vehicle> vehicleList) {
		List<Vehicle> filteredVehicleList = new ArrayList<Vehicle>();
		Iterator<Vehicle> vehicleListIterator = vehicleList.iterator();
		try {
			while (vehicleListIterator.hasNext()) {
				Vehicle actualVehicle = vehicleListIterator.next();
				if (actualVehicle.getPrice() <= (Double.valueOf(filterKey))) {
					filteredVehicleList.add(actualVehicle);
				}
			}
			if (filteredVehicleList.size() != 0) {
				printAvailableVehicles(filteredVehicleList);
			} else {
				System.out.println(" There are no vehicles with the selected filter.");
			}
		} catch (NumberFormatException e) {
			System.out.println(" The value inserted :" + filterKey + " is not a number.");
		}
	}
}
