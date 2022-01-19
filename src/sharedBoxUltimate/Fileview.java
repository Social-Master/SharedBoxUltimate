/**
 * This class is the View class; it views the data, e.g. Files and Directories and provides access points to the settings.
 */

//package sharedBoxUltimate;

import javax.swing.*;
import java.time.temporal.TemporalQueries;
import java.awt.*;

public class Fileview {

	/**
	 * These are the main things that allow a window to appear.
	 */
	JFrame frame = null;
	FlowLayout topLayout = new FlowLayout();
	JTextArea directoryContentAreaPlaceholder = null;	// This is just a placeholder. It will be replaced with something that views directory content.

	public void fileviewGo() {
		frame = new JFrame("Shared-Box Ultimate");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(1000,500);
        frame.setLocation(300,300);
        frame.getContentPane();

		/**
		 * This is the panel that hold the label displaying the current directory and the button allowing to muve up a directory.
		 * It is using the FlowLayout because the other ones didn't work properly.
		 */
		final JPanel topPanel = new JPanel();
		topPanel.setLayout(topLayout);
		topLayout.setAlignment(FlowLayout.TRAILING);

		JButton moveUpButton = new JButton("Move up directory");
		JLabel filePathLabel = new JLabel("/user");	// This should display the current name of the directory.

		topPanel.add(filePathLabel);
		topPanel.add(moveUpButton);
		topPanel.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);

		/**
		 * This JTextArea is just a placeholder and will be replace by something that allows the display of the current directory's content.
		 */
		directoryContentAreaPlaceholder = new JTextArea(25, 65);
		directoryContentAreaPlaceholder.append("Placeholder for directory content listing");
		directoryContentAreaPlaceholder.setEditable(false);

		final JPanel directoryContentAreaPanel = new JPanel();
		directoryContentAreaPanel.add(directoryContentAreaPlaceholder);
		directoryContentAreaPanel.setOpaque(true);

		/**
		 * This userSettingsPanel is an area that allows accessing the current user their settings. If an administrator is logged in, the department buttons will also appear; they are not accessable to normal users.
		 */
		final JPanel userSettingsPanel = new JPanel();
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
