/**
 * This class is the login window.
 */
package sharedBoxUltimate;
import javax.swing.*;

import controller.LoginViewController;

import java.awt.event.*;
import java.awt.*;

public class LoginView {
	
	/**
	 * These are the main things that allow a window to appear.
	 */
	 LoginViewController lvc = new LoginViewController(this);
	 public JFrame frame = null;
	 public JTextArea emailTextArea = null;
	 public JTextArea passwordTextArea = null;
	 public JButton loginButton = null;
	 public JButton registerButton = null;
	 FlowLayout horizontalLayout = new FlowLayout();	// This is a layout, that arranges items horizontally. Supposed to be used as "rows".

	 /**
	  * This method runs the view, that allows a user to login or register.
	  */

	 public void loginviewGo() {

		/**
		 * These set the properties of the window, i.e. the title, its default size and its default placement.
		 */

		 frame = new JFrame("Shared-Box Ultimate Anmeldung");		// Creates the Loginview window, with the title specified in the brackets
		 frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);		// When the close button is clicked, the program will terminate.
		 frame.setSize(400, 150);									// The window is 400x150 pixels big.
		 frame.setLocation(300, 300);								// The window will open in the location (300, 300).
		 frame.getContentPane();
		 
		 /**
		  * These deal with the area, where the user are expected to type in their e-mail address.
		  */

		  final JPanel emailPanel = new JPanel();					// This panel holds the items necessary for the user to type in their email and an explanatory label next to it
		  emailPanel.setLayout(horizontalLayout);					// The items on the panel will be arranget horizontally.
		  emailPanel.setAlignmentX(FlowLayout.TRAILING);
		  emailPanel.setOpaque(true);
		  JLabel emailLabel = new JLabel("E-Mail");					// Explanatory label
		  emailTextArea = new JTextArea(1, 20);						// Text area for the user to type in their email address.
		  emailTextArea.setEditable(true);
		  emailPanel.add(emailLabel);								// Both are added to the panel.
		  emailPanel.add(emailTextArea);

		  /**
		   * These deal with the area, where the user are expected to type in their password.
		   */
		  final JPanel passwordPanel = new JPanel();				// The same as above but with password instead of email address
		  passwordPanel.setLayout(horizontalLayout);
		  passwordPanel.setAlignmentX(FlowLayout.TRAILING);
		  passwordPanel.setOpaque(true);
		  JLabel passwordLabel = new JLabel("Passwort");
		  passwordTextArea = new JTextArea(1, 20);
		  passwordTextArea.setEditable(true);
		  passwordPanel.add(passwordLabel);
		  passwordPanel.add(passwordTextArea);

		  /**
		   * These deal with the login and register buttons at the bottom of the window.
		   */

		   loginButton = new JButton("Anmelden");		// Creates the "Sign in" button
		   loginButton.addActionListener(lvc);
		   registerButton = new JButton("Registrieren");	// The same as with the "Sign in" button above but with "Register"
		   registerButton.addActionListener(lvc);
		   final JPanel buttonPanel = new JPanel();	// Panel to hold the buttons
		   buttonPanel.setLayout(horizontalLayout);	// Arranges buttons horizontally
		   buttonPanel.setAlignmentX(FlowLayout.TRAILING);
		   buttonPanel.add(loginButton);	// Buttons are added to the panel.
		   buttonPanel.add(registerButton);

		   frame.getContentPane().add(BorderLayout.NORTH, emailPanel);			// Puts the panel with the email text area at the top of the window.
		   frame.getContentPane().add(BorderLayout.CENTER, passwordPanel);		// Puts the panel with the password text area in the center of the window
		   frame.getContentPane().add(BorderLayout.SOUTH, buttonPanel);			// Puts the area with the buttons at the buttom of the window.

		   frame.setVisible(true);			// Makes the window visible
	 }
}