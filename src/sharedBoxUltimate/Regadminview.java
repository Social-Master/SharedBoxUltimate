import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

/**
 * Regadminview provides the graphical user interface that allows
 * the administration of registration-requests.
 */
public class Regadminview {
		
		public JButton bAccept;
		public JButton bDeny;
		public JButton bShowMore;
		
		public JList requests;
		
		
	/**
	 * The Class Constructor
	 * 
	 * @param	req	Array of Strings containing the names of the people requesting registration
	 * @return	none
	 */
	Regadminview(String[] req) {
		showRegview(req);
	}
	
	
	/**
	 * Initializes and sets up the window.
	 * 
	 * @param	req	Array of Strings containing the names of the people requesting registration
	 * @return	none
	 */
	private void showRegview(String[] req) {
		JFrame frame = new JFrame("Registrationsverwaltung");
		// look into EXIT_ON_CLOSE
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// Buttoninitialisierung
		bAccept = new JButton("Anfrage akzeptieren");
		bDeny = new JButton("Anfrage ablehnen");
		bShowMore = new JButton("Details");
		
		// Panels und Layout
		JPanel panel1 = new JPanel();
		JPanel panel2 = new JPanel();
		
		panel1.setLayout(new GridLayout(3, 1));
		panel2.setLayout(new GridLayout(2, 1));
		
		JLabel gl = new JLabel("Anfragen");
		panel2.add(gl);
		
		// Buttons (und JList) zu Panels
		panel1.add(bAccept);
		panel1.add(bDeny);
		panel1.add(bShowMore);
		
		requests = new JList(req);
		requests.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		panel2.add(requests);
		
		//panel3.add(bRegister);
		
		// Panels der Frame hinzufügen
		frame.setLayout(new FlowLayout());
        frame.add(panel1);
        frame.add(panel2);
        
        frame.pack();
        frame.setVisible(true);
		
	}
	
	
	/**
	 * Shows the "Accept Request?"-dialog window.
	 * 
	 * @return	an integer indicating the chosen option, 0 yes, 1 no, -1 aborted
	 */
	public static int acceptReq() {
	
		return JOptionPane.showOptionDialog(null,
											"Wollen Sie die ausgewählte Registrierungsanfrage wirklich akzeptieren?",
											"Anfrage Akzeptieren",
											JOptionPane.YES_NO_OPTION,
											JOptionPane.QUESTION_MESSAGE,
											null, 
											new String[]{"Ja", "Nein"},
											"Nein");
	}
	
	
	/**
	 * Shows the "Accept Request?"-dialog window.
	 * 
	 * @return	an integer indicating the chosen option, 0 yes, 1 no, -1 aborted
	 */
	public static int denyReq() {
	
		return JOptionPane.showOptionDialog(null,
											"Wollen Sie die ausgewählte Registrierungsanfrage wirklich ablehnen?",
											"Anfrage Ablehnen",
											JOptionPane.YES_NO_OPTION,
											JOptionPane.QUESTION_MESSAGE,
											null, 
											new String[]{"Ja", "Nein"},
											"Nein");
	}
	
	
	/**
	 * Shows the Details-dialog window.
	 * 
	 * @param	text	a String containing the text shown
	 * @return	none
	 */
	public static void showMore(String text) {
		JOptionPane.showMessageDialog(null, text, "Details", JOptionPane.PLAIN_MESSAGE);
	}
	
	
	/*
	public static void main(String[] args) {
		String[] beispiel = {"Bei", "Spiel", "Anfragen", "lalala"};
		Regadminview AdminFenser = new Regadminview(beispiel);
	}
	*/
}
