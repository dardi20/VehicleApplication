package org.makerminds.vehicleapp.controller;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;

import org.makerminds.vehicleapp.model.CarModel;
import org.makerminds.vehicleapp.model.Vehicle;

public class VehicleImporter {

	public void importVehicleList(String path) {
		HashMap<CarModel, Vehicle> vehicleList = null;
		try {
			List<String>vehicleListAsString=Files.readAllLines(Paths.get(getClass().getResource(path).toURI()));
			for(String vehicleItemAsString : vehicleListAsString) {
			Vehicle vehicle = null;
			String[] vehicleListSplited =  vehicleItemAsString.split(",");
			
			}
		} catch (IOException | URISyntaxException e) {
			e.printStackTrace();
		}
	}
}
