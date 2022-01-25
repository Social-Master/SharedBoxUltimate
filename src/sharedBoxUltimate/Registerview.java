/**
 * This class is providing a view to allow the registration of new users.
 */
package sharedBoxUltimate;
import javax.swing.*;

import controller.RegisterViewController;
import models.Firma;

import java.awt.event.*;
import java.awt.*;

public class Registerview {
	private RegisterViewController controller = null;

	/**
	* These set the properties of the window, i.e. the title, its default size and its default placement.
	*/

	JFrame frame = null;
	public JTextArea firstnameTextArea = null;
	public JTextArea lastnameTextArea = null;
	public JTextArea emailTextArea = null;
	public JTextArea passwordTextArea = null;
	public JButton registerButton = new JButton("Registrieren");
	public JButton cancelButton = new JButton("Abbrechen");
	public JComboBox<String> cb;
	JTextArea confirmPasswordTextArea = null;
	FlowLayout horizontalLayout = new FlowLayout();

	/**
	* This method runs the view, that allows prompt the user to enter their credentials to create a new user account to login.
	*/
	
	public Registerview() {
		controller = new RegisterViewController(this);
	}
	
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

		final JPanel firmaPanel = new JPanel();
		firmaPanel.setLayout(horizontalLayout);
		firmaPanel.setAlignmentX(FlowLayout.TRAILING);
		firmaPanel.setOpaque(true);
		JLabel firmaLabel = new JLabel("Firma");
		cb = new JComboBox<String>();
		for(Firma f : Initializer.firmen.keySet()) {
			cb.addItem(f.getName());
		}
		firmaPanel.add(firmaLabel);
		firmaPanel.add(cb);
		windowPanel.add(firmaPanel);
		
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
		 * These deal with with the area where the buttons to register or to cancel the registration process are placed.
		 */

		final JPanel buttonPanel = new JPanel();
		buttonPanel.setLayout(horizontalLayout);
		buttonPanel.setAlignmentX(FlowLayout.TRAILING);
		buttonPanel.setOpaque(true);
		registerButton = new JButton("Registrieren");
		registerButton.addActionListener(controller);
		cancelButton = new JButton("Abbrechen");
		cancelButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				LoginView loginview = new LoginView();
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