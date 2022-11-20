package org.makerminds.jcoaching.finalexam.controller;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;

import org.makerminds.jcoaching.finalexam.model.Vehicle;

/**
 * managing the file.
 * 
 * @author <DardiRrapaj>
 *
 */
public class VehicleFileManager {

	private String filePath;

	public VehicleFileManager(String filePath) {
		this.filePath = filePath;
	}

	public List<String> importVehiclesFromFile() {
		List<String> vehicleList = null;
		try {
			vehicleList = Files.readAllLines(Paths.get(getClass().getResource(filePath).toURI()));
			return vehicleList;
		} catch (IOException e) {
			e.printStackTrace();
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}
		// TODO read vehicle-list-txt and transform to String array
		// Hint: use java.nio.file.Files and Paths class
		return vehicleList;
	}

	public void rewriteFile(List<Vehicle> vehicleList) {

		StringBuffer vehicleStringForRewrite = new StringBuffer();
		for (Vehicle vehicle : vehicleList) {
			prepareTheVehicleForRewriting(vehicleStringForRewrite, vehicle);
		}
		try {
			Files.write(Paths.get(getClass().getResource(filePath).toURI()), vehicleStringForRewrite.toString().getBytes()
					,StandardOpenOption.WRITE,StandardOpenOption.TRUNCATE_EXISTING);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// TODO write back into vehicle-list-txt and transform to String array
		// TODO call method prepareTheVehicleForRewriting(StringBuffer, Vehicle)
		// Hint: use java.nio.file.Path and java.nio.file.Paths class
	}

	private void prepareTheVehicleForRewriting(StringBuffer vehicleStringForRewrite, Vehicle vehicle) {
		vehicleStringForRewrite.append(vehicle.getVehicleId()).append(",").append(vehicle.getManufacturer().toString())
				.append(",").append(vehicle.getModel()).append(",").append(vehicle.getMotorCapacity()).append(",")
				.append(vehicle.getPrice()).append(",").append(vehicle.getColor().toString()).append(",")
				.append(vehicle.getActualKilometers()).append(",").append(vehicle.getProductionYear()).append(",")
				.append(vehicle.getFuelType().toString()).append(",")
				.append(vehicle.getTransmission().toString() + "\n");

		// TODO add vehicle attribute information to StringBuffer
		// Hint: vehicleStringForRewrite.append(String)
	}

}
