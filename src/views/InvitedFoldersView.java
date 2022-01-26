/**
 * This class allows the user access to their departments.
 */
package views;
import javax.swing.*;

import controller.InvitedFoldersViewController;
import controller.MitarbeiterController;
import models.Mitarbeiter;
import sharedBoxUltimate.Main;

import java.awt.event.*;
import java.io.File;
//import java.io.File;
import java.awt.*;

public class InvitedFoldersView {
	
	/**
	 * These are the main things, that allow a window to appear and all the items it will contain.
	 */

	public JFrame frame = null;
	public JMenuBar menuBar;
	public FlowLayout horizontalLayout = new FlowLayout();
	public JButton moveUpButton = null;
	public JButton moveDownButton = null;
	public JLabel pathLabel = null;
	public JList<String> contentList = null;
	public JMenuItem uploadFileItem = null;
	public JMenuItem deleteFileItem = null;
	public JMenuItem copyFileItem = null;
	public JMenuItem pasteFileItem = null;
	public JMenuItem cutFileItem = null;
	public JMenuItem renameFileItem = null;
	public JMenuItem mkdirFileItem = null;
	public String currPath = "";
	JMenu operationsMenu = null;
	JMenuItem inviteToHomeDirectoryItem = null;
	private InvitedFoldersViewController ifvc = null;
	public Mitarbeiter target;
	
	public InvitedFoldersView(Mitarbeiter target) {
		this.target = target;
		this.ifvc = new InvitedFoldersViewController(this);
	}

	public void invitedFoldersViewGo() {

		/**
		 * The following lines set up the window itself (e.g. its size etc.)
		 */

		frame = new JFrame("Kollegenordner - " + target.getName() + " " + target.getVorname());
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setSize(1000, 500);
		frame.setLocation(300, 300);
		frame.getContentPane();

		/**
		 * The following lines set up the menu and the menu bar at the top of the window.
		 */

		menuBar = new JMenuBar();
		operationsMenu = new JMenu("Operationen");
		menuBar.add(operationsMenu);

		/**
		 * The following lines set up the menu items, which are then added to the menu above.
		 */

		uploadFileItem = new JMenuItem("Datei hochladen");
		uploadFileItem.addActionListener(ifvc);
		
		cutFileItem = new JMenuItem("Ausschneiden", KeyEvent.VK_T);
		cutFileItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X, ActionEvent.CTRL_MASK));
		cutFileItem.addActionListener(ifvc);
		// cut ActionListener hier
		copyFileItem = new JMenuItem("Kopieren", KeyEvent.VK_T);
		copyFileItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, ActionEvent.CTRL_MASK));
		copyFileItem.addActionListener(ifvc);
		// copy ActionListener hier
		pasteFileItem = new JMenuItem("Einfügen", KeyEvent.VK_T);
		pasteFileItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_V, ActionEvent.CTRL_MASK));
		pasteFileItem.addActionListener(ifvc);
		// paste ActionListener hier
		renameFileItem = new JMenuItem("Umbenennen", KeyEvent.VK_T);
		renameFileItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_1, ActionEvent.ALT_MASK));
		renameFileItem.addActionListener(ifvc);
		// rename ActionListener hier
		deleteFileItem = new JMenuItem("Löschen");
		deleteFileItem.addActionListener(ifvc);
		mkdirFileItem = new JMenuItem("Ordner erstellen");
		mkdirFileItem.addActionListener(ifvc);
		// delete ActionListener hier
		// ActionListener hier
		operationsMenu.add(uploadFileItem);
		operationsMenu.add(cutFileItem);
		operationsMenu.add(copyFileItem);
		operationsMenu.add(pasteFileItem);
		operationsMenu.add(renameFileItem);
		operationsMenu.add(deleteFileItem);
		operationsMenu.add(mkdirFileItem);

		frame.setJMenuBar(menuBar);

		/**
		 * This sets up the panel at the to containing the moving up and down buttons and the file path label.
		 */

		final JPanel topPanel = new JPanel();
		topPanel.setLayout(horizontalLayout);
		topPanel.setAlignmentX(FlowLayout.RIGHT);

		/**
		 * This set up the moving up and down buttons and the file path label and then add these items to the panel created above.
		 */

		moveUpButton = new JButton("Zum Oberverzeichnis");
		moveUpButton.addActionListener(ifvc);
		moveDownButton = new JButton("In das Verzeichnis gehen");
		moveDownButton.addActionListener(ifvc);
		pathLabel = new JLabel("/");
		topPanel.add(pathLabel);
		topPanel.add(moveUpButton);
		topPanel.add(moveDownButton);

		/**
		 * The following lines create a panel for the list of the department's contents and the list itself. The list is then added to the panel.
		 */

		final JPanel listPanel = new JPanel();
		DefaultListModel<String> directoryContent = new DefaultListModel<>();
		MitarbeiterController x = new MitarbeiterController(this.target);
		for(File f : x.getUserFiles(currPath)) {
			directoryContent.addElement(f.getName());
		}
		contentList = new JList<>(directoryContent);
		listPanel.add(contentList);

		frame.getContentPane().add(BorderLayout.NORTH, topPanel);
		frame.getContentPane().add(BorderLayout.CENTER, listPanel);

		frame.setVisible(true);
	}
}