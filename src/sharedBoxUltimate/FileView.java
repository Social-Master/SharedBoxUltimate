package sharedBoxUltimate;
/**
 * This class is the view that appears when the user are logged in; it shows the directory contents and allows access to settings.
 */

import javax.swing.*;

import controller.FileViewController;
import controller.MitarbeiterController;

import java.awt.event.*;
import java.io.File;
import java.awt.*;

public class FileView {
	
	/**
	 * These are the main things that allow a window to appear.
	 */

	 JFrame frame = null;
	 FlowLayout topLayout = new FlowLayout();
	 JMenuBar menuBar;
	 public JPanel directoryContentListPanel = null;
	 public JMenuItem uploadFileItem = null;
	 public JMenuItem deleteFileItem = null;
	 public JMenuItem copyFileItem = null;
	 public JMenuItem pasteFileItem = null;
	 public JMenuItem cutFileItem = null;
	 public JMenuItem renameFileItem = null;
	 public JMenuItem mkdirFileItem = null;
	 public JMenuItem inviteToHomeDirectoryItem = null;
	 private FileViewController fvc = null;
	 public String currPath = "";
	 public JButton moveDownButton = null;
	 public JList<String> directoryContentList = null;
	 public JList<String> abteilungContentList = null;
	 public JLabel filePathLabel = null;
	 public JButton moveUpButton = null;
	 public JButton toDepartmentView = null;
	 public JButton toSharedView = null;
	 
	 public FileView() {
		 this.fvc = new FileViewController(this);
	 }
	 
	 public void fileviewGo() {
		 
		 /**
		  * These set the properties of the window, i.e. the title, its default size and its default placement.
		  */
		  
		  frame = new JFrame("Shared-Box Ultimate - " + Main.user.getName() + " " + Main.user.getVorname());
		  frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		  frame.setSize(1000, 500);
		  frame.setLocation(300, 300);
		  frame.getContentPane();
		  
		  /**
		   * This directoryContent compiles a list of the current directory's content. The directoryContentList reflects it to a graphical element on the frame.
		   */

		  DefaultListModel<String> directoryContent = new DefaultListModel<>();
		  MitarbeiterController x = new MitarbeiterController(Main.user);
		  for(File f : x.getUserFiles(currPath)) {
			  directoryContent.addElement(f.getName());
		  }
		  directoryContentList = new JList<>(directoryContent);
		  

		  /**
		   * This directoryContentListPanel adds the directoryContentList from above to a panel, which is not at all obvious. The panel is added to the frame a couple of lines below.
		   */

		  directoryContentListPanel = new JPanel();
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
		  JMenu fileMenu = new JMenu("Operationen");
		  menuBar.add(fileMenu);

		  /**
		   * These are the fileMenu bar items with which the before mentioned file operations can be executed.
		   */
		  uploadFileItem = new JMenuItem("Datei hochladen");
		  uploadFileItem.addActionListener(fvc);
		  cutFileItem = new JMenuItem("Ausschneiden", KeyEvent.VK_T);
		  cutFileItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X, ActionEvent.CTRL_MASK));
		  cutFileItem.addActionListener(fvc);
		  copyFileItem = new JMenuItem("Kopieren", KeyEvent.VK_T);
		  copyFileItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, ActionEvent.CTRL_MASK));
		  copyFileItem.addActionListener(fvc);
		  pasteFileItem = new JMenuItem("Einfügen", KeyEvent.VK_T);
		  pasteFileItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_V, ActionEvent.CTRL_MASK));
		  pasteFileItem.addActionListener(fvc);
		  renameFileItem = new JMenuItem("Umbenennen", KeyEvent.VK_T);
		  renameFileItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_1, ActionEvent.ALT_MASK));
		  renameFileItem.addActionListener(fvc);
		  deleteFileItem = new JMenuItem("Löschen");
		  deleteFileItem.addActionListener(fvc);
		  mkdirFileItem = new JMenuItem("Ordner erstellen");
		  mkdirFileItem.addActionListener(fvc);
		  inviteToHomeDirectoryItem = new JMenuItem("Zum Home-Verzeichnis einladen");
		  inviteToHomeDirectoryItem.addActionListener(fvc);
		  fileMenu.add(uploadFileItem);
		  fileMenu.add(cutFileItem);
		  fileMenu.add(copyFileItem);
		  fileMenu.add(pasteFileItem);
		  fileMenu.add(renameFileItem);
		  fileMenu.add(deleteFileItem);
		  fileMenu.add(mkdirFileItem);
		  fileMenu.add(inviteToHomeDirectoryItem);

		  /**
		   * These are the directoryMenu items with which the before mentioned directory operations can be executed, including giving other users read, write and execute rights within the /user directory.
		   * 
		   */

		  
		  

		  moveUpButton = new JButton("Zum Oberverzeichnis");
		  moveUpButton.addActionListener(fvc);
		  moveDownButton = new JButton("In das Verzeichnis gehen");
		  moveDownButton.addActionListener(fvc);
		  filePathLabel = new JLabel(currPath);	// This should display the current name of the directory.
		  topPanel.add(filePathLabel);
		  topPanel.add(moveUpButton);
		  topPanel.add(moveDownButton);

		  /**
		   * This deals with the settings of the current user. If an admin are logged in, the department related buttons will also appear; they are invisible to the user.
		   */

		   final JPanel userSettingsPanel = new JPanel();
		   JButton editProfileButton = new JButton("Profil bearbeiten");
		   editProfileButton.addActionListener(new ActionListener() {
			   public void actionPerformed(ActionEvent e) {
				   ProfileEditView profileEditView = new ProfileEditView();
				   profileEditView.profileEditViewGo();
			   }
		   });
		   JButton deleteProfileButton = new JButton("Profil löschen");
		   deleteProfileButton.addActionListener(new ActionListener() {
			   public void actionPerformed(ActionEvent e) {
				   dialogBoxDeleteProfile();	// When the deletePrifuleButton is clicked, this Method will be called. See a couple of lines below for a somewhat detailed description of what this method does and does not do.
			   }
		   });
		   JButton adminSettingsButton = new JButton("Administrationsfunktionen");
		   if(Main.user.isOp()) {
			   adminSettingsButton.addActionListener(new ActionListener() {
				   public void actionPerformed(ActionEvent e) {
					String[] beispiel = {"Bei", "Spiel", "Abteilungen", "WOHER?"};
					AdminView adminview = new AdminView(beispiel);
				   }
			   });
		   }
		   JButton logoutButton = new JButton("Abmelden");
		   logoutButton.addActionListener(new ActionListener() {
			   public void actionPerformed(ActionEvent e) {
				   dialogBoxLogout();
			   }
		   });
		   toDepartmentView = new JButton("Zum Abteilungsfilebrowser");
		   toDepartmentView.addActionListener(fvc);
		   toSharedView = new JButton("Zu den geteilten Home Verzeichnissen");
		   toSharedView.addActionListener(fvc);
		   userSettingsPanel.setLayout(new BoxLayout(userSettingsPanel, BoxLayout.PAGE_AXIS));
		   userSettingsPanel.add(toDepartmentView);
		   userSettingsPanel.add(toSharedView);
		   userSettingsPanel.add(editProfileButton);
		   userSettingsPanel.add(deleteProfileButton);
		   if(Main.user.isOp()) {
			   userSettingsPanel.add(adminSettingsButton);
		   }
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
			LoginView loginview = new LoginView();
			loginview.loginviewGo();
		}
	 }

}