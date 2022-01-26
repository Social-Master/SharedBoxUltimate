/**
 * This class allows the user access to their departments.
 */
package views;
import javax.swing.*;

import controller.AbteilungViewController;
import controller.MitarbeiterController;
import models.Abteilung;
import sharedBoxUltimate.Main;

import java.awt.event.*;
import java.io.File;
//import java.io.File;
import java.awt.*;

public class AbteilungView {
	
	/**
	 * These are the main things, that allow a window to appear and all the items it will contain.
	 */

	public JFrame frame = null;
	public JMenuBar menuBar;
	public FlowLayout horizontalLayout = new FlowLayout();
	public JButton moveUpButton = null;
	public JButton moveDownButton = null;
	public JLabel pathLabel = null;
	public JList<String> departmentContentList = null;
	public JMenuItem uploadFileItem = null;
	public JMenuItem deleteFileItem = null;
	public JMenuItem copyFileItem = null;
	public JMenuItem pasteFileItem = null;
	public JMenuItem cutFileItem = null;
	public JMenuItem renameFileItem = null;
	public String currPath = "";
	JMenu operationsMenu = null;
	private AbteilungViewController dvc = null;
	private Abteilung a = null;

	public AbteilungView(Abteilung a) {
		this.dvc = new AbteilungViewController(this, a);
		this.a = a;
	}
	
	public void departmentViewGo() {

		/**
		 * The following lines set up the window itself (e.g. its size etc.)
		 */

		frame = new JFrame("Shared-Box Ultimate - " + a.getName());
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
		uploadFileItem.addActionListener(dvc);
		cutFileItem = new JMenuItem("Ausschneiden", KeyEvent.VK_T);
		cutFileItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X, ActionEvent.CTRL_MASK));
		cutFileItem.addActionListener(dvc);
		copyFileItem = new JMenuItem("Kopieren", KeyEvent.VK_T);
		copyFileItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, ActionEvent.CTRL_MASK));
		copyFileItem.addActionListener(dvc);
		pasteFileItem = new JMenuItem("Einfügen", KeyEvent.VK_T);
		pasteFileItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_V, ActionEvent.CTRL_MASK));
		pasteFileItem.addActionListener(dvc);
		renameFileItem = new JMenuItem("Umbenennen", KeyEvent.VK_T);
		renameFileItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_1, ActionEvent.ALT_MASK));
		renameFileItem.addActionListener(dvc);
		deleteFileItem = new JMenuItem("Löschen");
		deleteFileItem.addActionListener(dvc);
		operationsMenu.add(uploadFileItem);
		operationsMenu.add(cutFileItem);
		operationsMenu.add(copyFileItem);
		operationsMenu.add(pasteFileItem);
		operationsMenu.add(renameFileItem);
		operationsMenu.add(deleteFileItem);
		operationsMenu.add(deleteFileItem);

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
		moveUpButton.addActionListener(dvc);
		moveDownButton = new JButton("In das Verzeichnis gehen");
		moveDownButton.addActionListener(dvc);
		pathLabel = new JLabel("/");
		topPanel.add(pathLabel);
		topPanel.add(moveUpButton);
		topPanel.add(moveDownButton);

		/**
		 * The following lines create a panel for the list of the department's contents and the list itself. The list is then added to the panel.
		 */

		
		
		DefaultListModel<String> directoryContent = new DefaultListModel<>();
		final JPanel listPanel = new JPanel();
		
		for(File f : new MitarbeiterController(Main.user).getAbteilungFiles(a, "")) {
			directoryContent.addElement(f.getName());
		}
		departmentContentList = new JList<>();
		departmentContentList.setModel(directoryContent);
		JScrollPane sp = new JScrollPane(departmentContentList);
		sp.setPreferredSize(new Dimension(500, 300));
		listPanel.add(sp);

		frame.getContentPane().add(BorderLayout.NORTH, topPanel);
		frame.getContentPane().add(BorderLayout.CENTER, listPanel);

		frame.setVisible(true);
	}
}