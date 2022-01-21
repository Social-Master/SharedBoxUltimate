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
	JTextArea textArea = null;
	FlowLayout horizontalLayout = new FlowLayout();

	public void registerviewGo() {

		/**
		 * These set the properties of the window, i.e. the title, its default size and its default placement.
		 */

		frame = new JFrame("Shared-Box Ultimate Register");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(500, 300);
		frame.setLocation(300, 300);
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
		JLabel firstnameLabel = new JLabel("First Name");
		textArea = new JTextArea(1, 20);
		textArea.setEditable(true);
		firstnamePanel.add(firstnameLabel);
		firstnamePanel.add(textArea);
		windowPanel.add(firstnamePanel);

		/**
		 * These deal with with the area where the user are expected to enter their last name.
		 */

		final JPanel lastnamePanel = new JPanel();
		lastnamePanel.setLayout(horizontalLayout);
		lastnamePanel.setAlignmentX(FlowLayout.TRAILING);
		lastnamePanel.setOpaque(true);
		JLabel lastnameLabel = new JLabel("Last Name");
		textArea = new JTextArea(1, 20);
		textArea.setEditable(true);
		lastnamePanel.add(lastnameLabel);
		lastnamePanel.add(textArea);
		windowPanel.add(lastnamePanel);

		/**
		 * These deal with with the area where the user are expected to enter their e-mail address.
		 */

		final JPanel emailPanel = new JPanel();
		emailPanel.setLayout(horizontalLayout);
		emailPanel.setAlignmentX(FlowLayout.TRAILING);
		emailPanel.setOpaque(true);
		JLabel emailLabel = new JLabel("E-Mail address");
		textArea = new JTextArea(1, 20);
		textArea.setEditable(true);
		emailPanel.add(emailLabel);
		emailPanel.add(textArea);
		windowPanel.add(emailPanel);

		/**
		 * These deal with with the area where the user are expected to enter their new password.
		 */

		final JPanel passwordPanel = new JPanel();
		passwordPanel.setLayout(horizontalLayout);
		passwordPanel.setAlignmentX(FlowLayout.TRAILING);
		passwordPanel.setOpaque(true);
		JLabel passwordLabel = new JLabel("Password");
		textArea = new JTextArea(1, 20);
		passwordPanel.add(passwordLabel);
		passwordPanel.add(textArea);
		windowPanel.add(passwordPanel);

		/**
		 * These deal with with the area where the user are expected to reenter their new password to confirm it.
		 */

		final JPanel confirmPasswordPanel = new JPanel();
		confirmPasswordPanel.setLayout(horizontalLayout);
		confirmPasswordPanel.setAlignmentX(FlowLayout.TRAILING);
		confirmPasswordPanel.setOpaque(true);
		JLabel confirmPasswordLabel = new JLabel("Confirm Password");
		textArea = new JTextArea(1, 20);
		confirmPasswordPanel.add(confirmPasswordLabel);
		confirmPasswordPanel.add(textArea);
		windowPanel.add(confirmPasswordPanel);

		/**
		 * These deal with with the area where the buttons to register or to cancel the registration process are placed.
		 */

		final JPanel buttonPanel = new JPanel();
		buttonPanel.setLayout(horizontalLayout);
		buttonPanel.setAlignmentX(FlowLayout.TRAILING);
		buttonPanel.setOpaque(true);
		JButton registerButton = new JButton("Register");
		JButton cancelButton = new JButton("Cancel");
		buttonPanel.add(registerButton);
		buttonPanel.add(cancelButton);
		windowPanel.add(buttonPanel);

		frame.getContentPane().add(BorderLayout.CENTER, windowPanel);

		frame.setVisible(true);
	}
}