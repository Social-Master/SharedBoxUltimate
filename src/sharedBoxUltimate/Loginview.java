/**
 * This class is the login window.
 */

import javax.swing.*;
import java.time.temporal.TemporalQueries;
import java.awt.event.*;
import java.awt.*;

public class Loginview {
	
	/**
	 * These are the main things that allow a window to appear.
	 */

	 JFrame frame = null;
	 JTextArea emailTextArea = null;
	 JTextArea passwordTextArea = null;
	 FlowLayout horizontalLayout = new FlowLayout();

	 public void loginviewGo() {

		/**
		 * These set the properties of the window, i.e. the title, its default size and its default placement.
		 */

		 frame = new JFrame("Shared-Box Ultimate Anmeldung");
		 frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		 frame.setSize(400, 150);
		 frame.setLocation(300, 300);
		 frame.getContentPane();
		 
		 /**
		  * These deal with the area, where the user are expected to type in their e-mail address.
		  */

		  final JPanel emailPanel = new JPanel();
		  emailPanel.setLayout(horizontalLayout);
		  emailPanel.setAlignmentX(FlowLayout.TRAILING);
		  emailPanel.setOpaque(true);
		  JLabel emailLabel = new JLabel("E-Mail");
		  emailTextArea = new JTextArea(1, 20);
		  emailTextArea.setEditable(true);
		  emailPanel.add(emailLabel);
		  emailPanel.add(emailTextArea);

		  /**
		   * These deal with the area, where the user are expected to type in their password.
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

		  /**
		   * These deal with the login and register buttons at the bottom of the window.
		   */

		   JButton loginButton = new JButton("Anmelden");
		   loginButton.addActionListener(new ActionListener() {
			   public void actionPerformed(ActionEvent e) {
				   frame.dispose();
				   Fileview fileview = new Fileview();
				   fileview.fileviewGo();
			   }
		   });
		   JButton registerButton = new JButton("Registrieren");
		   registerButton.addActionListener(new ActionListener() {
			   public void actionPerformed(ActionEvent e) {
				   frame.dispose();
				   Registerview registerview = new Registerview();
				   registerview.registerviewGo();
			   }
		   });
		   final JPanel buttonPanel = new JPanel();
		   buttonPanel.setLayout(horizontalLayout);
		   buttonPanel.setAlignmentX(FlowLayout.TRAILING);
		   buttonPanel.add(loginButton);
		   buttonPanel.add(registerButton);

		   frame.getContentPane().add(BorderLayout.NORTH, emailPanel);
		   frame.getContentPane().add(BorderLayout.CENTER, passwordPanel);
		   frame.getContentPane().add(BorderLayout.SOUTH, buttonPanel);

		   frame.setVisible(true);
	 }
}