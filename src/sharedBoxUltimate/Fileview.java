/**
 * This class is the view that appears when the user are logged in; it shows the directory contents and allows access to settings.
 */

import javax.swing.*;
import java.time.temporal.TemporalQueries;
import java.awt.event.*;
import java.awt.*;

public class Fileview {
	
	/**
	 * These are the main things that allow a window to appear.
	 */

	 JFrame frame = null;
	 FlowLayout topLayout = new FlowLayout();
	 /*JTextArea textArea = null;		// Placeholder for the real thing that views directory content. */
	 JMenuBar menuBar;
	 JMenu menu;
	 JMenuItem menuItem;
	 
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
		  
		  DefaultListModel<String> directoryContent = new DefaultListModel<>();
		  directoryContent.addElement("Item0");
		  directoryContent.addElement("Item1");
		  directoryContent.addElement("Item2");
		  directoryContent.addElement("Item3");
		  JList<String> directoryContentList = new JList<>(directoryContent);

		  //textArea = new JTextArea(25, 65);
		  //textArea.append("Placeholder for directory content");
		  //textArea.setEditable(false);
		  final JPanel rightPanel = new JPanel();
		  rightPanel.add(directoryContentList);
		  rightPanel.setOpaque(true);

		  final JPanel topPanel = new JPanel();
		  topPanel.setLayout(topLayout);
		  topLayout.setAlignment(FlowLayout.TRAILING);

		  menuBar = new JMenuBar();
		  menu = new JMenu("File");
		  menu.setMnemonic(KeyEvent.VK_A);
		  menuBar.add(menu);
		  menuItem = new JMenuItem("See properties...", KeyEvent.VK_T);
		  menuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_1, ActionEvent.ALT_MASK));
		  menu.add(menuItem);

		  JButton moveUpButton = new JButton("Move up directory");
		  JLabel filePathLabel = new JLabel("/user");	// This should display the current name of the directory.
		  JButton reflectSelection = new JButton("Reflect Selection");
		  topPanel.add(filePathLabel);
		  topPanel.add(moveUpButton);
		  topPanel.add(reflectSelection);

		  /**
		   * This deals with the settings of the current user. If an admin are logged in, the department related buttons will also appear; they are invisible to the user.
		   */

		   final JPanel userSettingsPanel = new JPanel();
		   JButton editProfileButton = new JButton("Edit Profile");
		   JButton deleteProfileButton = new JButton("Delete Profile");
		   JButton adminSettingsButton = new JButton("Admin Settings");
		   JButton logoutButton = new JButton("Logout");
		   userSettingsPanel.setLayout(new BoxLayout(userSettingsPanel, BoxLayout.PAGE_AXIS));
		   userSettingsPanel.add(editProfileButton);
		   userSettingsPanel.add(deleteProfileButton);
		   userSettingsPanel.add(adminSettingsButton);
		   userSettingsPanel.add(logoutButton);

		   frame.getContentPane().add(BorderLayout.NORTH, topPanel);
		   frame.getContentPane().add(BorderLayout.CENTER, rightPanel);
		   frame.getContentPane().add(BorderLayout.LINE_START, userSettingsPanel);

		   frame.setJMenuBar(menuBar);

		   frame.setVisible(true);
	 }

}
