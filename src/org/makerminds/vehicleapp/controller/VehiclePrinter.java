package org.makerminds.vehicleapp.controller;

import java.util.HashMap;
import java.util.Map.Entry;

import org.makerminds.vehicleapp.model.CarModel;
import org.makerminds.vehicleapp.model.Vehicle;

public class VehiclePrinter {
	public void printVehicle(HashMap<CarModel,Vehicle> carCollection) {
		System.out.println("Vehicle SHOP");
		System.out.println("------------------------");
		for(Entry vehicleEntry : carCollection.entrySet()) {
			System.out.println(vehicleEntry.getValue().toString());
		}
		System.out.println("------------------------");
	}
}
