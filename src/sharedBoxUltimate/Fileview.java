/**
 * This class is the View class; it views the data, e.g. Files and Directories.
 */

//package sharedBoxUltimate;

import javax.swing.*;
import java.time.temporal.TemporalQueries;
import java.awt.*;

public class Fileview extends JFrame {

	JFrame frame = null;
	FlowLayout topLayout = new FlowLayout();
	JTextArea directoryContentAreaPlaceholder = null;
	//JTextArea userSettingsAreaPlaceholder = null;

	public void go() {
		frame = new JFrame("Shared-Box Ultimate");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(1000,500);
        frame.setLocation(300,300);
        frame.getContentPane();

		final JPanel topPanel = new JPanel();
		topPanel.setLayout(topLayout);
		topLayout.setAlignment(FlowLayout.TRAILING);

		JButton moveUpButton = new JButton("Move up directory");
		JLabel filePathLabel = new JLabel("/user");

		topPanel.add(filePathLabel);
		topPanel.add(moveUpButton);
		topPanel.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);

		directoryContentAreaPlaceholder = new JTextArea(25, 65);
		directoryContentAreaPlaceholder.setEditable(false);

		JPanel directoryContentAreaPanel = new JPanel();
		directoryContentAreaPanel.add(directoryContentAreaPlaceholder);
		directoryContentAreaPanel.setOpaque(true);

		JPanel userSettingsPanel = new JPanel();
		JButton editProfileButton = new JButton("Edit Profile");
		JButton deleteProfileButton = new JButton("Delete Profile");
		JButton createDepartmentButton = new JButton("Create Department");
		JButton editDepartmentButton = new JButton("Edit Departments");
		JButton deleteDepartmentsButton = new JButton("Delete Departments");
		userSettingsPanel.setLayout(new BoxLayout(userSettingsPanel, BoxLayout.PAGE_AXIS));
		userSettingsPanel.add(editProfileButton);
		userSettingsPanel.add(deleteProfileButton);
		userSettingsPanel.add(createDepartmentButton);
		userSettingsPanel.add(editDepartmentButton);
		userSettingsPanel.add(deleteDepartmentsButton);

		frame.getContentPane().add(BorderLayout.NORTH, topPanel);
		frame.getContentPane().add(BorderLayout.LINE_END, directoryContentAreaPanel);
		frame.getContentPane().add(BorderLayout.LINE_START, userSettingsPanel);

		frame.setVisible(true);
	}
}
