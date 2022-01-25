///////////////////////////////////////////////////////////////////////
// Beim Implementieren der Actionlistener beachten:
// JList.getSelectedValue().toString() gibt null bei keiner Auswahl
// TODO separates Registrationsverwaltungsfenser
///////////////////////////////////////////////////////////////////////
package sharedBoxUltimate;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

/**
 * Adminview provides the graphical user interface that allows
 * access to administration functionality.
 */
public class Adminview {
		
		public JButton bCreateGroup;
		public JButton bDeleteGroup;
		// edit beschriftet mit "Umbenennen", weil alle andere Edit-
		// Funktionalität bereits vorhanden
		public JButton bEditGroup;
		public JButton bAddEmployee;
		public JButton bRMEmployee;
		// alle Dateien der Firma anzeigen, benötigt eigenes Fileview-
		// Fenster, deshalb nicht hier
		// falls wir es implementieren
		public JButton bShowCompany;
		// ebenso, aber neues Registrationsverwaltungsfenster...
		public JButton bRegister;
		public JButton bBack;
		
		// Liste der Abteilungsnamen der Firma zum Anzeigen
		// idealerweise auf Grundlage einer hashmap oder so...
		public JList groups;
		
		
	/**
	 * The Class Constructor
	 * 
	 * @param	abteilungen	Array of Strings containing the names of the groups
	 * @return	none
	 */
	Adminview(String[] abteilungen) {
		showAdminview(abteilungen);
	}
	
	
	/**
	 * Initializes and sets up the window.
	 * 
	 * @param	abteilungen	Array of Strings containing the names of the groups
	 * @return	none
	 */
	private void showAdminview(String[] abteilungen) {
		JFrame frame = new JFrame("Administrationsfunktionen");
		// look into EXIT_ON_CLOSE
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// Buttoninitialisierung
		bCreateGroup = new JButton("Abteilung erstellen");
		bDeleteGroup = new JButton("Abteilung löschen");
		bEditGroup = new JButton("Abteilung Umbenennen");
		bAddEmployee = new JButton("Mitarbeiter hinzufügen");
		bRMEmployee = new JButton("Mitarbeiter entfernen");
		bShowCompany = new JButton("Alle Dateien anzeigen");
		bRegister = new JButton("Registrationsverwaltung");
		bBack = new JButton("Zurück");
		
		// Panels und Layout
		JPanel panel1 = new JPanel();
		JPanel panel2 = new JPanel();
		JPanel panel3 = new JPanel();
		
		panel1.setLayout(new GridLayout(7, 1));
		panel2.setLayout(new GridLayout(2, 1));
		panel3.setLayout(new GridLayout(2, 1));
		
		JLabel gl = new JLabel("Abteilungen");
		panel2.add(gl);
		
		// Buttons (und JList) zu Panels
		panel1.add(bCreateGroup);
		panel1.add(bDeleteGroup);
		panel1.add(bEditGroup);
		panel1.add(bAddEmployee);
		panel1.add(bRMEmployee);
		panel1.add(bShowCompany);
		panel1.add(bBack); // Positionierung?
		
		groups = new JList(abteilungen);
		groups.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		panel2.add(groups);
		
		panel3.add(bRegister);
		
		// Panels der Frame hinzufügen
		frame.setLayout(new FlowLayout());
        frame.add(panel1);
        frame.add(panel2);
        frame.add(panel3);
        
        frame.pack();
        // Eventuell visible on off Schalter?
        frame.setVisible(true);
		
	}
	
	
	/**
	 * Shows the "Delete group"-dialog window.
	 * 
	 * @return	an integer indicating the chosen option, 0 yes, 1 no, -1 aborted
	 */
	public static int delGroupWindow() {
	
		return JOptionPane.showOptionDialog(null,
							"Wollen Sie die ausgewählte Gruppe wirklich löschen?",
							"Gruppe löschen",
							JOptionPane.YES_NO_OPTION,
							JOptionPane.QUESTION_MESSAGE,
							null, 
							new String[]{"Ja", "Nein"},
							"Nein");
	}
	
	
	/**
	 * Shows the "Create group"-dialog window.
	 * 
	 * @return	the String typed into the input
	 */
	public static String creGroupWindow() {
		
		return JOptionPane.showInputDialog(null, "Bitte geben Sie den Namen der Abteilung ein:");
	}
	
	
	/**
	 * Shows the "Rename group"-dialog window.
	 * 
	 * @return	the String typed into the input
	 */
	public static String editGroupWindow() {
		
		return JOptionPane.showInputDialog(null, "Bitte geben Sie den neuen Namen der Abteilung ein:");
	}
	
	
	/**
	 * Shows the "Add employee"-dialog window.
	 * 
	 * @return	the String typed into the input
	 */
	public static String addEmployeeWindow() {
		
		return JOptionPane.showInputDialog(null, "Bitte geben Sie den Namen des Mitarbeiters ein, der der Abteilung zugefügt werden soll:");
	}
	
	/**
	 * Shows the "Remove employee"-dialog window.
	 * 
	 * @return	the String typed into the input
	 */
	public static String RMEmployeeWindow() {
		
		return JOptionPane.showInputDialog(null, "Bitte geben Sie den Namen des Mitarbeiters ein, der aus der Abteilung entfernt werden soll:");
	}
	
	
	/*
	public static void main(String[] args) {
		String[] beispiel = {"Bei", "Spiel", "Abteilungen", "WOHER?"};
		Adminview AdminFenser = new Adminview(beispiel);
	}
	*/
}
