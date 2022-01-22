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
		   * These are the menu bar items with which the before mentioned file and folder operations can be executed.
		   */
		  
		  JMenuItem cutItem = new JMenuItem("Cut...", KeyEvent.VK_T);
		  cutItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X, ActionEvent.CTRL_MASK));
		  JMenuItem copyItem = new JMenuItem("Copy...", KeyEvent.VK_T);
		  copyItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, ActionEvent.CTRL_MASK));
		  JMenuItem pasteItem = new JMenuItem("Paste...", KeyEvent.VK_T);
		  pasteItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_V, ActionEvent.CTRL_MASK));
		  JMenuItem renameItem = new JMenuItem("Rename...", KeyEvent.VK_T);
		  renameItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_1, ActionEvent.ALT_MASK));
		  renameItem.addActionListener(new ActionListener() {
			  public void actionPerformed(ActionEvent e) {
				  dialogBoxRename();
			  }
		  });
		  JMenuItem moveItem = new JMenuItem("Move...", KeyEvent.VK_T);
		  moveItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_2, ActionEvent.ALT_MASK));
		  moveItem.addActionListener(new ActionListener() {
			  public void actionPerformed(ActionEvent e) {
				  dialogBoxMove();
			  }
		  });
		  JMenuItem deleteItem = new JMenuItem("Delete...");
		  deleteItem.addActionListener(new ActionListener() {
			  public void actionPerformed(ActionEvent e) {
				  dialogBoxDelete();
			  }
		  });
		  JMenuItem propertiesMenuItem = new JMenuItem("See properties...", KeyEvent.VK_T);
		  fileMenu.add(cutItem);
		  fileMenu.add(copyItem);
		  fileMenu.add(pasteItem);
		  fileMenu.add(renameItem);
		  fileMenu.add(moveItem);
		  fileMenu.add(deleteItem);
		  fileMenu.add(propertiesMenuItem);

		  JButton moveUpButton = new JButton("Move up directory");	// Move up a directory.
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

	 public void dialogBoxRename() {
		 JOptionPane.showInputDialog(null, "Enter new file name", "Rename...", 1);
	 }

	 public void dialogBoxMove() {
		 JOptionPane.showInputDialog(null, "Enter destination path", "Move...", 1);
	 }

	 public void dialogBoxDelete() {
		JOptionPane.showOptionDialog(null, "Are you sure you want to delete this file?", "Delete...", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, new String[] {"Yes", "No"}, "No");
	 }
}