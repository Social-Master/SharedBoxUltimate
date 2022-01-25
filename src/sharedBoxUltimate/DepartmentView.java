/**
 * This class allows the user access to their departments.
 */

 import javax.swing.*;
import java.awt.event.*;
//import java.io.File;
import java.awt.*;

public class DepartmentView {
	
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
	JMenuItem inviteToHomeDirectoryItem = null;

	public void DepartmentViewGo() {

		/**
		 * The following lines set up the window itself (e.g. its size etc.)
		 */

		frame = new JFrame("Shared-Box Ultimate - Department");
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

		cutFileItem = new JMenuItem("Ausschneiden...", KeyEvent.VK_T);
		cutFileItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X, ActionEvent.CTRL_MASK));
		// cut ActionListener hier
		copyFileItem = new JMenuItem("Kopieren", KeyEvent.VK_T);
		copyFileItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, ActionEvent.CTRL_MASK));
		// copy ActionListener hier
		pasteFileItem = new JMenuItem("Einfügen", KeyEvent.VK_T);
		pasteFileItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_V, ActionEvent.CTRL_MASK));
		// paste ActionListener hier
		renameFileItem = new JMenuItem("Umbenennen", KeyEvent.VK_T);
		renameFileItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_1, ActionEvent.ALT_MASK));
		// rename ActionListener hier
		deleteFileItem = new JMenuItem("Löschen");
		// delete ActionListener hier
		inviteToHomeDirectoryItem = new JMenuItem("Zum Home-Verzeichnis einladen...");
		// ActionListener hier
		operationsMenu.add(cutFileItem);
		operationsMenu.add(copyFileItem);
		operationsMenu.add(pasteFileItem);
		operationsMenu.add(renameFileItem);
		operationsMenu.add(deleteFileItem);
		operationsMenu.add(deleteFileItem);
		operationsMenu.add(inviteToHomeDirectoryItem);

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
		moveDownButton = new JButton("In das Verzeichnis gehen");
		pathLabel = new JLabel("/user");
		topPanel.add(pathLabel);
		topPanel.add(moveUpButton);
		topPanel.add(moveDownButton);

		/**
		 * The following lines create a panel for the list of the department's contents and the list itself. The list is then added to the panel.
		 */

		final JPanel listPanel = new JPanel();
		departmentContentList = new JList<>();
		listPanel.add(departmentContentList);

		frame.getContentPane().add(BorderLayout.NORTH, topPanel);
		frame.getContentPane().add(BorderLayout.CENTER, listPanel);

		frame.setVisible(true);
	}

	public static void main(String[] args) {
		DepartmentView departmentView = new DepartmentView();
		departmentView.DepartmentViewGo();
	}
}