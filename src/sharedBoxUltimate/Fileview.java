/**
 * This class is the view that appears when the user are logged in; it shows the directory contents and allows access to settings.
 */

import javax.swing.*;
import javax.swing.text.html.HTMLEditorKit;

import java.time.temporal.TemporalQueries;
import java.awt.event.*;
import java.awt.*;

public class Fileview {
	
	/**
	 * These are the main things that allow a window to appear.
	 */

	 JFrame frame = null;
	 FlowLayout topLayout = new FlowLayout();
	 JMenuBar menuBar;
	 
	 public void fileviewGo() {
		 
		 /**
		  * These set the properties of the window, i.e. the title, its default size and its default placement.
		  */
		  
		  frame = new JFrame("Shared-Box Ultimate (Firstname Lastname)");
		  frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		  frame.setSize(1000, 500);
		  frame.setLocation(300, 300);
		  frame.getContentPane();
		  
		  /**
		   * This directoryContent compiles a list of the current directory's content. The directoryContentList reflects it to a graphical element on the frame.
		   */

		  DefaultListModel<String> directoryContent = new DefaultListModel<>();
		  directoryContent.addElement("Item0");
		  directoryContent.addElement("Item1");
		  directoryContent.addElement("Item2");
		  directoryContent.addElement("Item3");
		  JList<String> directoryContentList = new JList<>(directoryContent);

		  /**
		   * This directoryContentListPanel adds the directoryContentList from above to a panel, which is not at all obvious. The panel is added to the frame a couple of lines below.
		   */

		  final JPanel directoryContentListPanel = new JPanel();
		  directoryContentListPanel.add(directoryContentList);
		  directoryContentListPanel.setOpaque(true);

		  /**
		   * This topPanel is a panel at the top of the window. It holds the filePathLabel and the moveUpButton
		   */

		  final JPanel topPanel = new JPanel();
		  topPanel.setLayout(topLayout);
		  topLayout.setAlignment(FlowLayout.TRAILING);

		  /**
		   * This is the menu bar at the very to of the window. It acts like the beautiful menubar at the top of the screen on macOS but with significantly less style and elegance.
		   * With the menu bar, the file and folder operations can be accessed via the appropriatly named menus.
		   */

		  menuBar = new JMenuBar();
		  JMenu fileMenu = new JMenu("File");
		  JMenu directoryMenu = new JMenu("Directory");
		  menuBar.add(fileMenu);
		  menuBar.add(directoryMenu);

		  /**
		   * These are the fileMenu bar items with which the before mentioned file operations can be executed.
		   */
		  
		  JMenuItem cutFileItem = new JMenuItem("Cut...", KeyEvent.VK_T);
		  cutFileItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X, ActionEvent.CTRL_MASK));
		  JMenuItem copyFileItem = new JMenuItem("Copy...", KeyEvent.VK_T);
		  copyFileItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, ActionEvent.CTRL_MASK));
		  JMenuItem pasteFileItem = new JMenuItem("Paste...", KeyEvent.VK_T);
		  pasteFileItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_V, ActionEvent.CTRL_MASK));
		  JMenuItem renameFileItem = new JMenuItem("Rename...", KeyEvent.VK_T);
		  renameFileItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_1, ActionEvent.ALT_MASK));
		  renameFileItem.addActionListener(new ActionListener() {
			  public void actionPerformed(ActionEvent e) {
				  dialogBoxRenameFile();
			  }
		  });
		  JMenuItem moveFileItem = new JMenuItem("Move...", KeyEvent.VK_T);
		  moveFileItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_2, ActionEvent.ALT_MASK));
		  moveFileItem.addActionListener(new ActionListener() {
			  public void actionPerformed(ActionEvent e) {
				  dialogBoxMoveFile();
			  }
		  });
		  JMenuItem deleteFileItem = new JMenuItem("Delete...");
		  deleteFileItem.addActionListener(new ActionListener() {
			  public void actionPerformed(ActionEvent e) {
				  dialogBoxDeleteFile();
			  }
		  });
		  JMenuItem propertiesFileItem = new JMenuItem("See properties...", KeyEvent.VK_T);
		  fileMenu.add(cutFileItem);
		  fileMenu.add(copyFileItem);
		  fileMenu.add(pasteFileItem);
		  fileMenu.add(renameFileItem);
		  fileMenu.add(moveFileItem);
		  fileMenu.add(deleteFileItem);
		  fileMenu.add(propertiesFileItem);

		  /**
		   * These are the directoryMenu items with which the before mentioned directory operations can be executed, including giving other users read, write and execute rights within the /user directory.
		   * 
		   */

		  JMenuItem cutDirectoryItem = new JMenuItem("Cut...", KeyEvent.VK_T);
		  cutDirectoryItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X, ActionEvent.CTRL_MASK));
		  JMenuItem copyDirectoryItem = new JMenuItem("Copy...", KeyEvent.VK_T);
		  copyDirectoryItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, ActionEvent.CTRL_MASK));
		  JMenuItem pasteDirectoryItem = new JMenuItem("Paste...", KeyEvent.VK_T);
		  pasteDirectoryItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_V, ActionEvent.CTRL_MASK));
		  JMenuItem renameDirectoryItem = new JMenuItem("Rename...", KeyEvent.VK_T);
		  renameDirectoryItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_3, ActionEvent.ALT_MASK));
		  /*renameDirectoryItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dialogBoxRenameDirectory();
			}
		  });*/
		  JMenuItem moveDirectoryItem = new JMenuItem("Move...", KeyEvent.VK_T);
		  moveDirectoryItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_4, ActionEvent.ALT_MASK));
		  /*moveDirectoryItem.addActionListener(new ActionListener() {
			  public void actionPerformed(ActionEvent e) {
				  dialogBoxMoveDirectory();
			  }
		  });*/
		  JMenuItem deleteDirectoryItem = new JMenuItem("Delete...");
		  /*deleteDirectoryItem.addActionListener(new ActionListener() {
			  public void actionPerformed(ActionEvent e) {
				  dialogBoxDeleteDirectory();
			  }
		  });*/
		  JMenuItem propertiesDirectoryItem = new JMenuItem("See properties...");
		  directoryMenu.add(cutDirectoryItem);
		  directoryMenu.add(copyDirectoryItem);
		  directoryMenu.add(pasteDirectoryItem);
		  directoryMenu.add(renameDirectoryItem);
		  directoryMenu.add(moveDirectoryItem);
		  directoryMenu.add(deleteDirectoryItem);
		  directoryMenu.add(propertiesDirectoryItem);

		  JButton moveUpButton = new JButton("Move Up Directory");
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
		   deleteProfileButton.addActionListener(new ActionListener() {
			   public void actionPerformed(ActionEvent e) {
				   dialogBoxDeleteProfile();	// When the deletePrifuleButton is clicked, this Method will be called. See a couple of lines below for a somewhat detailed description of what this method does and does not do.
			   }
		   });
		   JButton adminSettingsButton = new JButton("Admin Settings");
		   JButton logoutButton = new JButton("Logout");
		   logoutButton.addActionListener(new ActionListener() {
			   public void actionPerformed(ActionEvent e) {
				   dialogBoxLogout();
			   }
		   });
		   userSettingsPanel.setLayout(new BoxLayout(userSettingsPanel, BoxLayout.PAGE_AXIS));
		   userSettingsPanel.add(editProfileButton);
		   userSettingsPanel.add(deleteProfileButton);
		   userSettingsPanel.add(adminSettingsButton);
		   userSettingsPanel.add(logoutButton);

		   frame.getContentPane().add(BorderLayout.NORTH, topPanel);
		   frame.getContentPane().add(BorderLayout.CENTER, directoryContentListPanel);
		   frame.getContentPane().add(BorderLayout.LINE_START, userSettingsPanel);

		   frame.setJMenuBar(menuBar);

		   frame.setVisible(true);
	 }

	 /**
	  * This method is called, when the deleteProfileButton is clicked, as probably mentioned above. It opens a dialog box with the options "Yes" and "No".
	  * As one probably can guess, clicking "Yes", the logged in user's profile is gotten rid of from the appropriate database file and the user won't be able to log in
	  * to the service. The loginView should then pop uo automatically.
	  * Clicking "No", however, will not do anything apart from closing the dialog box.
	  */

	 public void dialogBoxDeleteProfile() {
		 JOptionPane.showOptionDialog(null, "Are you sure you want to delete this profile?", "Delete Profile", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, new String[] {"Yes", "No"}, "No");
	 }

	 public void dialogBoxLogout() {
		JOptionPane.showOptionDialog(null, "Are you sure you want to logout?", "Logout", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, new String[] {"Yes", "No"}, "No");
	 }

	 public void dialogBoxRenameFile() {
		 JOptionPane.showInputDialog(null, "Enter new file name", "Rename...", 1);
	 }

	 public void dialogBoxMoveFile() {
		 JOptionPane.showInputDialog(null, "Enter destination path", "Move...", 1);
	 }

	 public void dialogBoxDeleteFile() {
		JOptionPane.showOptionDialog(null, "Are you sure you want to delete this file?", "Delete...", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, new String[] {"Yes", "No"}, "No");
	 }
}