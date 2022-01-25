/**
 * This class is the view that appears when the user are logged in; it shows the directory contents and allows access to settings.
 */

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class Fileview {
	
	/**
	 * These are the main things that allow a window to appear.
	 */

	 JFrame frame = null;
	 FlowLayout topLayout = new FlowLayout();
	 JMenuBar menuBar;
	 
	 /**
	  * This method runs this view. Fileview is not only showing files in a selected directory but also allows acces to other views.
	  */

	 public void fileviewGo() {
		 
		 /**
		  * These set the properties of the window, i.e. the title, its default size and its default placement.
		  */
		  
		  frame = new JFrame("Shared-Box Ultimate (Firstname Lastname)");	// Creates the Fileview window, with the specified title in the brackets.
		  frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	// When the window is closed with the close button, the entire program will terminate.
		  frame.setSize(1000, 500);		// The window is 1000x500 pixels big.
		  frame.setLocation(300, 300);	// The window will open at location (300, 300).
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
		   * This directoryContentListPanel adds the directoryContentList from above to a panel.
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

		  menuBar = new JMenuBar();					// This creates the menu bar itself.
		  JMenu fileMenu = new JMenu("Datei");		// This creates a menu called "Datei".
		  JMenu directoryMenu = new JMenu("Verzeichnis");	// This creates a menu called "Verzeichnis".
		  menuBar.add(fileMenu);	// Both menus are then attatched to the menu bar.
		  menuBar.add(directoryMenu);

		  /**
		   * The following lines add the menu items that will be part of the fileMenu. The fileMenu includes all necessary operations to files and supports keyboard shortcuts for cutting, copying, pasting, renaming and moving.
		   */
		  
		  JMenuItem cutFileItem = new JMenuItem("Ausschneiden...", KeyEvent.VK_T);
		  cutFileItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X, ActionEvent.CTRL_MASK));		// Ctrl+X for cutting
		  JMenuItem copyFileItem = new JMenuItem("Kopieren...", KeyEvent.VK_T);
		  copyFileItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, ActionEvent.CTRL_MASK));	// Ctrl+C for copying
		  JMenuItem pasteFileItem = new JMenuItem("Einfügen...", KeyEvent.VK_T);
		  pasteFileItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_V, ActionEvent.CTRL_MASK));	// Ctrl+V for pasting
		  JMenuItem renameFileItem = new JMenuItem("Umbenennen...", KeyEvent.VK_T);
		  renameFileItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_1, ActionEvent.ALT_MASK));	// Alt+1 for renaming.
		  renameFileItem.addActionListener(new ActionListener() {
			  public void actionPerformed(ActionEvent e) {
				  dialogBoxRenameFile();				// Upon clicking the rename button, an input dialog will be opened, where a valid filename must be entered, which the selected file will then be renamed to.
			  }
		  });
		  JMenuItem moveFileItem = new JMenuItem("Verschieben...", KeyEvent.VK_T);
		  moveFileItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_2, ActionEvent.ALT_MASK));		// Alt+2 for moving
		  moveFileItem.addActionListener(new ActionListener() {
			  public void actionPerformed(ActionEvent e) {
				  dialogBoxMoveFile();		// The same kind of dialog opens when clicking the move button, however here a valid directory path must be entered.
			  }
		  });
		  JMenuItem deleteFileItem = new JMenuItem("Löschen...");
		  deleteFileItem.addActionListener(new ActionListener() {
			  public void actionPerformed(ActionEvent e) {
				  dialogBoxDeleteFile();		// When clicking the delete button, a confirmation dialog will be opened with the options "Yes" and "No". Clicking "Yes" will delete the selected file, clicking "No" will do nothing.
			  }
		  });
		  JMenuItem propertiesFileItem = new JMenuItem("Eigenschaften einsehen...");

		  /**
		   * The following lines add the items from above to the fileMenu.
		   */

		  fileMenu.add(cutFileItem);
		  fileMenu.add(copyFileItem);
		  fileMenu.add(pasteFileItem);
		  fileMenu.add(renameFileItem);
		  fileMenu.add(moveFileItem);
		  fileMenu.add(deleteFileItem);
		  fileMenu.add(propertiesFileItem);

		  /**
		   * The following lines add the menu items that will be part of the directoryMenu. The directoryMenu includes all necessary operations to directories and supports keyboard shortcuts for cutting, copying, pasting, renaming and moving.
		   * Additionally, other users within the same company can be "invited" to the current user's /user directory from here.
		   */

		  JMenuItem cutDirectoryItem = new JMenuItem("Ausschneiden...", KeyEvent.VK_T);
		  cutDirectoryItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X, ActionEvent.CTRL_MASK));	// Ctrl+X for cutting
		  JMenuItem copyDirectoryItem = new JMenuItem("Kopieren...", KeyEvent.VK_T);
		  copyDirectoryItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, ActionEvent.CTRL_MASK));	// Ctrl+C for copying
		  JMenuItem pasteDirectoryItem = new JMenuItem("Einfügen...", KeyEvent.VK_T);
		  pasteDirectoryItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_V, ActionEvent.CTRL_MASK));	// Ctrl+V for pasting
		  JMenuItem renameDirectoryItem = new JMenuItem("Umbenennen...", KeyEvent.VK_T);
		  renameDirectoryItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_3, ActionEvent.ALT_MASK));	// Alt+3 for renaming
		  renameDirectoryItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dialogBoxRenameDirectory();		// Upon clicking the rename button, an input dialog will be opened, where a valid directrory name must be entered, which the selected file will then be renamed to.
			}
		  });
		  JMenuItem moveDirectoryItem = new JMenuItem("Verschieben...", KeyEvent.VK_T);
		  moveDirectoryItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_4, ActionEvent.ALT_MASK));
		  moveDirectoryItem.addActionListener(new ActionListener() {
			  public void actionPerformed(ActionEvent e) {
				  dialogBoxMoveDirectory();		// The same kind of dialog opens when clicking the move button, however here a valid directory path must be entered.
			  }
		  });
		  JMenuItem deleteDirectoryItem = new JMenuItem("Löschen...");
		  deleteDirectoryItem.addActionListener(new ActionListener() {
			  public void actionPerformed(ActionEvent e) {
				  dialogBoxDeleteDirectory();	// When clicking the delete button, a confirmation dialog will be opened with the options "Yes" and "No". Clicking "Yes" will delete the selected directory and its contents, clicking "No" will do nothing.
			  }
		  });
		  JMenuItem inviteToHomeDirectoryItem = new JMenuItem("Zum Home-Verzeichnis einladen...");	// This is the menu item allowing access to the InviteToHomeDirectoryView.
		  inviteToHomeDirectoryItem.addActionListener(new ActionListener() {
			  public void actionPerformed(ActionEvent e) {
				InviteToHomeDirectoryView inviteToHomeDirectoryView = new InviteToHomeDirectoryView();	// The action associated with the button is: Creating a new InviteToHomeDirectoryView object...
				inviteToHomeDirectoryView.inviteToHomeDirectoryViewGo();	//... and then running its inviteToHomeDirectoryViewGo method, creating the appropriate window. More on that in InviteToHomeDirectoryView.java
			  }
		  });
		  JMenuItem propertiesDirectoryItem = new JMenuItem("Eigenschaften einsehen...");

		  /**
		   * The following lines add the items above to the directory menu.
		   */

		  directoryMenu.add(cutDirectoryItem);
		  directoryMenu.add(copyDirectoryItem);
		  directoryMenu.add(pasteDirectoryItem);
		  directoryMenu.add(renameDirectoryItem);
		  directoryMenu.add(moveDirectoryItem);
		  directoryMenu.add(deleteDirectoryItem);
		  directoryMenu.add(propertiesDirectoryItem);
		  directoryMenu.add(inviteToHomeDirectoryItem);

		  JButton moveUpButton = new JButton("Zum Oberverzeichnis");	// This button brings the current user to the top directory.
		  JLabel filePathLabel = new JLabel("/user");	// This should display the current name of the directory.
		  JButton reflectSelection = new JButton("Reflect Selection");
		  topPanel.add(filePathLabel);
		  topPanel.add(moveUpButton);
		  topPanel.add(reflectSelection);

		  /**
		   * This deals with the settings of the current user. If an admin are logged in, the department related buttons will also appear; they are invisible to a normal user.
		   */

		  /**
		   * The following lines deal with the user's ability to change their data, e.g. their first name, last name or emai address.
		   */

		   final JPanel userSettingsPanel = new JPanel();
		   JButton editProfileButton = new JButton("Profil bearbeiten");
		   editProfileButton.addActionListener(new ActionListener() {
			   public void actionPerformed(ActionEvent e) {
				   ProfileEditView profileEditView = new ProfileEditView();
				   profileEditView.profileEditViewGo();
			   }
		   });

		   /**
			* The following lines deal with the user's ability to delete their profile.
		    */

		   JButton deleteProfileButton = new JButton("Profil löschen");
		   deleteProfileButton.addActionListener(new ActionListener() {
			   public void actionPerformed(ActionEvent e) {
				   dialogBoxDeleteProfile();	// When the deletePrifuleButton is clicked, this Method will be called. See a couple of lines below for more details.
			   }
		   });
		   JButton adminSettingsButton = new JButton("Administrationsfunktionen");
		   adminSettingsButton.addActionListener(new ActionListener() {
			   public void actionPerformed(ActionEvent e) {
				String[] beispiel = {"Bei", "Spiel", "Abteilungen", "WOHER?"};
				Adminview adminview = new Adminview(beispiel);
			   }
		   });
		   JButton logoutButton = new JButton("Abmelden");
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

	 public int dialogBoxDeleteProfile() {
		 String[] options = {"Ja", "Nein"};
		 int deleteProfileValue = JOptionPane.showOptionDialog(null, "Sind Sie sicher, dass Sie Ihr Profil löschen möchten?", "Profil löschen", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[1]);
		 return deleteProfileValue;
	 }

	 public void dialogBoxLogout() {
		String[] options = {"Ja", "Nein"};
		int logoutValue = JOptionPane.showOptionDialog(null, "Sind Sie sicher, dass Sie sich abmelden möchten?", "Abmelden", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[1]);
		if (logoutValue == 0) {
			frame.dispose();
			Loginview loginview = new Loginview();
			loginview.loginviewGo();
		}
	 }

	 public String dialogBoxRenameFile() {
		 String newFileName = JOptionPane.showInputDialog(null, "Neuen Dateinamen eingeben", "Datei umbenennen...", 1);
		 return newFileName;
	 }

	 public String dialogBoxMoveFile() {
		 String destinationPathFile = JOptionPane.showInputDialog(null, "Zielverzeichnis eingeben", "Datei bewegen...", 1);
		 return destinationPathFile;
	 }

	 public int dialogBoxDeleteFile() {
		String[] options = {"Ja", "Nein"};
		int deleteFileValue = JOptionPane.showOptionDialog(null, "Sind Sie sicher, dass Sie diese Datei löschen möchten?", "Datei löschen...", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[1]);
		return deleteFileValue;
	 }

	 public String dialogBoxRenameDirectory() {
		String newDirectoryName = JOptionPane.showInputDialog(null, "Neuen Verzeichnisnamen eingeben", "Verzeichnis umbenennen...", 1);
		return newDirectoryName;
	 }

	 public String dialogBoxMoveDirectory() {
		String destinationPathDirectory = JOptionPane.showInputDialog(null, "Zielverzeichnis eingeben", "Verzeichnis verschieben...", 1);
		return destinationPathDirectory;
	 }

	 public int dialogBoxDeleteDirectory() {
		String[] options = {"Ja", "Nein"};
		int deleteDirectoryValue = JOptionPane.showOptionDialog(null, "Sind Sie sicher, dass Sie dieses Verzeichnis löschen wollen?", "Verzeichnis löschen...", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[1]);
		return deleteDirectoryValue;
	 }
}