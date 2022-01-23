//package ???

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

/**
 * The Class Adminview provides the graphical user interface that allows
 * access to administration functionality.
 * 
 * Attributes
 * Methods ...
 */
public class Adminview {
		
		public JButton bCreateGroup;
		public JButton bDeleteGroup;
		public JButton bEditGroup;
		public JButton bAddEmployee;
		public JButton bRMEmployee;
		public JButton bShowCompany;
		
		public JList groups;
		public String[] names;
		
		public JOptionPane delDialog;
		
	/**
	 * The Constructor
	 */
	Adminview(String[] abteilungen) {
		showAdminview(abteilungen);
	}
	
	
	/**
	 * showAdminview initializes the window, sets up the buttons etc...
	 */
	private void showAdminview(String[] abteilungen) {
		JFrame frame = new JFrame("Administrationsfunktionen");
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		names = abteilungen;
		
		// Knöpfe zur Abteilungsverwaltung, benötigen jeweils ein eigenes Popup...
		// vllt bDeleteGroup rauslassen -> sollte auch in edit sein
		bCreateGroup = new JButton("Gruppe erstellen");
		bDeleteGroup = new JButton("Gruppe löschen");
		bEditGroup = new JButton("Gruppe Umbenennen");
		bAddEmployee = new JButton("Mitarbeiter hinzufügen"); // Titel?? muss Dialog auslösen, falls bereits zu Abteilung gehört...
		bRMEmployee = new JButton("Mitarbeiter entfernen");
		bShowCompany = new JButton("Alle Dateien anzeigen"); // alle Dateien der Firma anzeigen
		
		JPanel panel1 = new JPanel();
		JPanel panel2 = new JPanel();
		
		panel1.setLayout(new GridLayout(6, 1));
		panel2.setLayout(new GridLayout(2, 1));
		
		JLabel gl = new JLabel("Abteilungen");
		panel2.add(gl);
		
		panel1.add(bCreateGroup);
		panel1.add(bDeleteGroup);
		panel1.add(bEditGroup);
		panel1.add(bAddEmployee);
		panel1.add(bRMEmployee);
		panel1.add(bShowCompany);
		
		groups = new JList(names);
		groups.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		panel2.add(groups);
		
		// actionlistener für die Knöpfe
		// auslagern!
		/*
		bDeleteGroup.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            delGroupWindow(groups.getSelectedValue().toString());
             }
            });
		*/
		
		frame.setLayout(new FlowLayout());
        frame.add(panel1);
        frame.add(panel2);
        
        frame.pack();
        frame.setVisible(true);
		
	}
	
	// return int...
	public static void delGroupWindow(String group) {
	
		JOptionPane.showOptionDialog(null, "Wollen Sie die ausgewählte Gruppe wirklich löschen?", "Gruppe löschen",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE, null, 
                new String[]{"Ja", "Nein"}, "Nein");
	}
	
	
	public static String creGroupWindow() {
		
		return JOptionPane.showInputDialog(null, "Bitte geben Sie den Namen der Abteilung ein:");
	}
	
	
	public static String editGroupWindow() {
		
		return JOptionPane.showInputDialog(null, "Bitte geben Sie den neuen Namen der Abteilung ein:");
	}
	
	
	public static String addEmployeeWindow() {
		
		return JOptionPane.showInputDialog(null, "Bitte geben Sie den Namen des Mitarbeiters ein, der der Abteilung zugefügt werden soll:");
	}
	
	
	public static String RMEmployeeWindow() {
		
		return JOptionPane.showInputDialog(null, "Bitte geben Sie den Namen des Mitarbeiters ein, der aus der Abteilung entfernt werden soll:");
	}
	
	// TODO
	public static void showCompanyWindow() {
	}
	
	
	/*public static void main(String[] args) {
		String[] beispiel = {"Bei", "Spiel", "Abteilungen", "WOHER?"};
		Adminview adminview = new Adminview(beispiel);
	}*/
	
}
