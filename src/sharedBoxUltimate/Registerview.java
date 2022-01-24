/**
 * This class is providing a view to allow the registration of new users.
 */

import javax.swing.*;
import java.time.temporal.TemporalQueries;
import java.awt.event.*;
import java.awt.*;

public class Registerview {

	/**
	* These set the properties of the window, i.e. the title, its default size and its default placement.
	*/

	JFrame frame = null;
	JTextArea firstnameTextArea = null;
	JTextArea lastnameTextArea = null;
	JTextArea emailTextArea = null;
	JTextArea passwordTextArea = null;
	JTextArea confirmPasswordTextArea = null;
	FlowLayout horizontalLayout = new FlowLayout();

	/**
	* This method runs the view, that allows prompt the user to enter their credentials to create a new user account to login.
	*/

	public void registerviewGo() {

		/**
		 * These set the properties of the window, i.e. the title, its default size and its default placement.
		 */

		frame = new JFrame("Shared-Box Ultimate Registrierung");		// Creates the Registerview window, with the title specified in the brackets
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);			// When the close button is clicked, the program will terminate.
		frame.setSize(500, 300);										// The window is 500x300 pixels big
		frame.setLocation(300, 300);									// 
		frame.getContentPane();

		/**
		 * This panel is spread across the entire window and makes sure the following panels are arranged on top of each other
		 */

		final JPanel windowPanel = new JPanel();
		windowPanel.setLayout(new BoxLayout(windowPanel, BoxLayout.Y_AXIS));
		
		/**
		 * These deal with with the area where the user are expected to enter their first name.
		 */

		final JPanel firstnamePanel = new JPanel();
		firstnamePanel.setLayout(horizontalLayout);
		firstnamePanel.setAlignmentX(FlowLayout.TRAILING);
		firstnamePanel.setOpaque(true);
		JLabel firstnameLabel = new JLabel("Vorname");
		firstnameTextArea = new JTextArea(1, 20);
		firstnameTextArea.setEditable(true);
		firstnamePanel.add(firstnameLabel);
		firstnamePanel.add(firstnameTextArea);
		windowPanel.add(firstnamePanel);

		/**
		 * These deal with with the area where the user are expected to enter their last name.
		 */

		final JPanel lastnamePanel = new JPanel();
		lastnamePanel.setLayout(horizontalLayout);
		lastnamePanel.setAlignmentX(FlowLayout.TRAILING);
		lastnamePanel.setOpaque(true);
		JLabel lastnameLabel = new JLabel("Nachname");
		lastnameTextArea = new JTextArea(1, 20);
		lastnameTextArea.setEditable(true);
		lastnamePanel.add(lastnameLabel);
		lastnamePanel.add(lastnameTextArea);
		windowPanel.add(lastnamePanel);

		/**
		 * These deal with with the area where the user are expected to enter their e-mail address.
		 */

		final JPanel emailPanel = new JPanel();
		emailPanel.setLayout(horizontalLayout);
		emailPanel.setAlignmentX(FlowLayout.TRAILING);
		emailPanel.setOpaque(true);
		JLabel emailLabel = new JLabel("E-Mail-Adresse");
		emailTextArea = new JTextArea(1, 20);
		emailTextArea.setEditable(true);
		emailPanel.add(emailLabel);
		emailPanel.add(emailTextArea);
		windowPanel.add(emailPanel);

		/**
		 * These deal with with the area where the user are expected to enter their new password.
		 */

		final JPanel passwordPanel = new JPanel();
		passwordPanel.setLayout(horizontalLayout);
		passwordPanel.setAlignmentX(FlowLayout.TRAILING);
		passwordPanel.setOpaque(true);
		JLabel passwordLabel = new JLabel("Passwort");
		passwordTextArea = new JTextArea(1, 20);
		passwordTextArea.setEditable(true);
		passwordPanel.add(passwordLabel);
		passwordPanel.add(passwordTextArea);
		windowPanel.add(passwordPanel);

		/**
		 * These deal with with the area where the user are expected to reenter their new password to confirm it.
		 */

		final JPanel confirmPasswordPanel = new JPanel();
		confirmPasswordPanel.setLayout(horizontalLayout);
		confirmPasswordPanel.setAlignmentX(FlowLayout.TRAILING);
		confirmPasswordPanel.setOpaque(true);
		JLabel confirmPasswordLabel = new JLabel("Passwort bestätigen");
		confirmPasswordTextArea = new JTextArea(1, 20);
		confirmPasswordTextArea.setEditable(true);
		confirmPasswordPanel.add(confirmPasswordLabel);
		confirmPasswordPanel.add(confirmPasswordTextArea);
		windowPanel.add(confirmPasswordPanel);

		/**
		 * These deal with with the area where the buttons to register or to cancel the registration process are placed.
		 */

		final JPanel buttonPanel = new JPanel();
		buttonPanel.setLayout(horizontalLayout);
		buttonPanel.setAlignmentX(FlowLayout.TRAILING);
		buttonPanel.setOpaque(true);
		JButton registerButton = new JButton("Registrieren");
		JButton cancelButton = new JButton("Abbrechen");
		cancelButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				Loginview loginview = new Loginview();
				loginview.loginviewGo();
			}
		});
		buttonPanel.add(registerButton);
		buttonPanel.add(cancelButton);
		windowPanel.add(buttonPanel);

		frame.getContentPane().add(BorderLayout.CENTER, windowPanel);

		frame.setVisible(true);
	}
}