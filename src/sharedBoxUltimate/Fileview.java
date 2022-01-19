/**
 * This class is the view that appears when the user are logged in; it shows the directory contents and allows access to settings.
 */

import javax.swing.*;
import java.time.temporal.TemporalQueries;
import java.awt.event.*;
import java.awt.*;

public class Fileview implements ActionListener {
	
	/**
	 * These are the main things that allow a window to appear.
	 */

	 JFrame frame = null;
	 FlowLayout topLayout = new FlowLayout();
	 JTextArea textArea = null;		// Placeholder for the real thing that views directory content.

	 public void fileviewGo() {

		/**
		 * These set the properties of the window, i.e. the title, its default size and its default placement.
		 */

		 frame = new JFrame("Shared-Box Ultimate");
		 frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		 frame.setSize(1000, 500);
		 frame.setLocation(300, 300);
		 frame.getContentPane();

		 /**
		  * This JTextArea is just a placeholder and will be replaced by a proper directory view
		  */

		  textArea = new JTextArea(25, 65);
		  textArea.append("Placeholder for directory content");
		  textArea.setEditable(false);
		  final JPanel textAreaPanel = new JPanel();
		  textAreaPanel.add(textArea);
		  textAreaPanel.setOpaque(true);

		  final JPanel topPanel = new JPanel();
		  topPanel.setLayout(topLayout);
		  topLayout.setAlignment(FlowLayout.TRAILING);

		  JButton moveUpButton = new JButton("Move up directory");
		  JLabel filePathLabel = new JLabel("/user");	// This should display the current name of the directory.

		  /**
		   * This deals with the settings of the current user. If an admin are logged in, the department related buttons will also appear; they are invisible to the user.
		   */

		   final JPanel userSettingsPanel = new JPanel();
		   JButton editProfileButton = new JButton("Edit Profile");
		   JButton deleteProfileButton = new JButton("Delete Profile");
		   JButton createDepartmentButton = new JButton("Create Department");
		   JButton editDepartmentsButton = new JButton("Edit Departments");
		   JButton deleteDepartmentsButton = new JButton("Delete Departments");
		   JButton logoutButton = new JButton("Logout");
		   logoutButton.addActionListener(this);
		   userSettingsPanel.setLayout(new BoxLayout(userSettingsPanel, BoxLayout.PAGE_AXIS));
		   userSettingsPanel.add(editProfileButton);
		   userSettingsPanel.add(deleteProfileButton);
		   userSettingsPanel.add(createDepartmentButton);
		   userSettingsPanel.add(editDepartmentsButton);
		   userSettingsPanel.add(deleteDepartmentsButton);
		   userSettingsPanel.add(logoutButton);

		   frame.getContentPane().add(BorderLayout.NORTH, topPanel);
		   frame.getContentPane().add(BorderLayout.LINE_END, textAreaPanel);
		   frame.getContentPane().add(BorderLayout.LINE_START, userSettingsPanel);

		   frame.setVisible(true);
	 }

	 public void actionPerformed(ActionEvent e) {
		 Loginview loginview = new Loginview();
		 loginview.loginviewGo();
		 frame.dispose();
	 }
}
