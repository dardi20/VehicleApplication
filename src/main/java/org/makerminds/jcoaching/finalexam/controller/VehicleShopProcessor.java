package org.makerminds.jcoaching.finalexam.controller;

import java.util.List;

import org.makerminds.jcoaching.finalexam.model.Vehicle;

/**
 * responsible for processing business processes.
 * 
 * @author <DardiRrapaj>
 *
 */
public class VehicleShopProcessor {

	/**
	 * responsible to sell a specified vehicle by id
	 * 
	 * @param vehiclesList
	 * @param vehicleChosenId
	 */
	public void sellVehicle(List<Vehicle> vehiclesList, int vehicleChosenId) {
		int i = 0;
		while (i < vehiclesList.size()) {
			if (vehiclesList.get(i).getVehicleId() == vehicleChosenId) {
				vehiclesList.remove(i);
				return;
			}
			i++;
		}

		// TODO selling a vehicle means to remove it from the available vehicle list
		// Hint: use while loop to safely remove an oject from a lst
	}
}
