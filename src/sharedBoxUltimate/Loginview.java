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
	 JTextArea textArea = null;
	 FlowLayout horizontalLayout = new FlowLayout();

	 public void loginviewGo() {

		/**
		 * These set the properties of the window, i.e. the title, its default size and its default placement.
		 */

		 frame = new JFrame("Shared-Box Ultimate Login");
		 frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		 frame.setSize(400, 150);
		 frame.setLocation(300, 300);
		 frame.getContentPane();

		 textArea = new JTextArea(1, 20);
		 textArea.setEditable(true);
		 
		 /**
		  * These deal with the area, where the user are expected to type in their e-mail address.
		  */

		  final JPanel emailPanel = new JPanel();
		  emailPanel.setLayout(horizontalLayout);
		  emailPanel.setAlignmentX(FlowLayout.TRAILING);
		  emailPanel.setOpaque(true);
		  JLabel emailLabel = new JLabel("E-Mail");
		  emailPanel.add(emailLabel);
		  emailPanel.add(textArea);

		  /**
		   * These deal with the area, where the user are expected to type in their password.
		   */
		  final JPanel passwordPanel = new JPanel();
		  passwordPanel.setLayout(horizontalLayout);
		  passwordPanel.setAlignmentX(FlowLayout.TRAILING);
		  passwordPanel.setOpaque(true);
		  JLabel passwordLabel = new JLabel("Password");
		  passwordPanel.add(passwordLabel);
		  passwordPanel.add(textArea);

		  /**
		   * These deal with the login and register buttons at the bottom of the window.
		   */

		   JButton loginButton = new JButton("Login");
		   JButton registerButton = new JButton("Register");
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