package org.makerminds.jcoaching.finalexam.gui;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.event.MouseInputListener;
import javax.swing.table.DefaultTableModel;

import org.makerminds.jcoaching.finalexam.controller.VehicleFileManager;
import org.makerminds.jcoaching.finalexam.controller.VehicleShopProcessor;
import org.makerminds.jcoaching.finalexam.controller.VehicleTransformer;
import org.makerminds.jcoaching.finalexam.model.Vehicle;

import java.awt.BorderLayout;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;

public class VehicleShopGUI {
	int selectedRow;
	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VehicleShopGUI window = new VehicleShopGUI();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public VehicleShopGUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		VehicleFileManager fileManager = new VehicleFileManager("/vehicle-list.txt");
		VehicleTransformer vehicleTransformer = new VehicleTransformer();
		List<Vehicle> vehicleList = vehicleTransformer
				.transformDataArrayToVehicleObjects(fileManager.importVehiclesFromFile());

		DefaultTableModel tableModel = new DefaultTableModel();
		String[] tableColons = { "Id", "Model", "Price", "Horse Power", "Mileage" };
		String[][] tableData = initializeTableData(vehicleList);
		tableModel.setDataVector(tableData, tableColons);

		JTable table = new JTable(tableModel);

		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBorder(BorderFactory.createTitledBorder("Vehicle Shop"));
		frame.getContentPane().add(scrollPane);

		VehicleShopProcessor vehicleShopProcessor = new VehicleShopProcessor();
		JButton sellButton = new JButton("Sell");
		frame.getContentPane().add(sellButton,BorderLayout.WEST);
		table.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent evt) {
				JTable table = (JTable) evt.getSource();
				selectedRow = table.getSelectedRow();
			}
		});

		sellButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				System.out.println(table.getSelectedRow());
				vehicleShopProcessor.sellVehicle(vehicleList, Integer.valueOf(tableData[table.getSelectedRow()][0]));
				fileManager.rewriteFile(vehicleList);
				initializeTableData(vehicleList);
				frame.revalidate();
			}
		});
	}

	private String[][] initializeTableData(List<Vehicle> vehicleList) {
		String[][] tableData = new String[vehicleList.size()][5];
		int i = 0;
		for (Vehicle vehicle : vehicleList) {
			tableData[i][0] = Integer.toString(vehicle.getVehicleId());
			tableData[i][1] = vehicle.getModel();
			tableData[i][2] = Double.toString(vehicle.getPrice());
			tableData[i][3] = Integer.toString(vehicle.getMotorCapacity());
			tableData[i][4] = Integer.toString(vehicle.getActualKilometers());
			i++;
		}

		return tableData;
	}

}
