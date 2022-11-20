package org.makerminds.jcoaching.finalexam.console;

import java.util.List;
import java.util.Scanner;

import org.makerminds.jcoaching.finalexam.controller.VehicleFileManager;
import org.makerminds.jcoaching.finalexam.controller.VehicleShopPrinter;
import org.makerminds.jcoaching.finalexam.controller.VehicleShopProcessor;
import org.makerminds.jcoaching.finalexam.controller.VehicleTransformer;
import org.makerminds.jcoaching.finalexam.model.Vehicle;
/**
 * providing main method to start the application.
 * 
 * @author <DardiRrapaj>
 *
 */
public class VehicleShop {

	private static VehicleTransformer vehicleTransformer = new VehicleTransformer();
	private static final String VEHICLE_LIST_PATH = "/vehicle-list.txt";

	public static void main(String[] args) {

		// File reading
		VehicleFileManager vehicleFileManager = new VehicleFileManager(VEHICLE_LIST_PATH);
		List<String> vehicleDataAsStringList = vehicleFileManager.importVehiclesFromFile();

		// Transformation into Vehicle Java Objects
		List<Vehicle> vehicleList = vehicleTransformer.transformDataArrayToVehicleObjects(vehicleDataAsStringList);

		// Printing available vehicles
		VehicleShopPrinter vehicleShopPrinter = new VehicleShopPrinter();
		vehicleShopPrinter.printAvailableVehicles(vehicleList);

		// User interaction - selecting a vehicle to sell
		vehicleShopPrinter.filterRequest();

		Scanner scanner = new Scanner(System.in);
		String filterActivated = scanner.next();

		filterVehicleList(vehicleList, vehicleShopPrinter, scanner, filterActivated);

		vehicleShopPrinter.printVehicleIdToSellRequest();
		int vehicleChosenId = scanner.nextInt();

		// Selling a vehicle
		VehicleShopProcessor vehicleShopProcessor = new VehicleShopProcessor();
		vehicleShopProcessor.sellVehicle(vehicleList, vehicleChosenId);

		vehicleFileManager.rewriteFile(vehicleList);

		vehicleShopPrinter.printVehicleSoldMessage(vehicleChosenId);
		vehicleShopPrinter.printAvailableVehicles(vehicleList);
		scanner.close();
	}

	private static void filterVehicleList(List<Vehicle> vehicleList, VehicleShopPrinter vehicleShopPrinter,
			Scanner scanner, String filterActivated) {
		if (filterActivated.toString().equals("1")) {
			vehicleShopPrinter.filterType();
			int filterType = scanner.nextInt();
			vehicleShopPrinter.filterVehicleList(filterType);
			String filterKey = scanner.next();
			vehicleShopPrinter.printAvaibleVehicleByFilterKey(filterType, filterKey, vehicleList);
		}
	}
}
