/**
 * This is the view, that appears, when the editProfileButton from the Fileview class is clicked. It allows the edit some data in their profile.
 */

import javax.swing.*;
import java.time.temporal.TemporalQueries;
import java.awt.event.*;
import java.awt.*;

public class ProfileEditView {

	/**
	* These set the properties of the window, i.e. the title, its default size and its default placement.
	*/

	JFrame frame = null;
	FlowLayout horizontalLayout = new FlowLayout();		// This is a layout, that arranges items horizontally. Supposed to be used as "rows".
	JTextArea setFirstnameTextArea = null;
	JTextArea setLastnameTextArea = null;
	JTextArea setEmailTextArea = null;
	JTextArea setPasswordTextArea = null;
	JTextArea confirmPasswordTextArea = null;

	/**
	* This method runs the view, that prompt the user to enter their credentials to create a new user account to login.
	*/

	public void profileEditViewGo() {

		frame = new JFrame("Profil bearbeiten");					// Creates the ProfileEditView window, with the title specified in the brackets.
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);	// When the close button is clicked, the window will disappear without closing the program.
		frame.setSize(450, 225);				// The window is 450x225 pixels big.
		frame.setLocation(300, 300);			// The window will open at location (300, 300).
		frame.getContentPane();


		/**
		 * This panel is spread across the entire window and makes sure the following panels are arranged vertically.
		 */
		final JPanel windowPanel = new JPanel();
		windowPanel.setLayout(new BoxLayout(windowPanel, BoxLayout.Y_AXIS));

		/**
		 * The following lines deal with the area where the user are expected to enter their new first name.
		 */

		final JPanel setFirstnamePanel = new JPanel();		// This panel holds the item necessary for the user to type in their first name (a text area) and an explanatory label next to it.
		setFirstnamePanel.setLayout(horizontalLayout);		// The items on the panel will be arranget horizontally according to the FlowLayout defined outside this method.
		setFirstnamePanel.setAlignmentX(FlowLayout.TRAILING);
		setFirstnamePanel.setOpaque(true);
		JLabel setFirstnameLabel = new JLabel("Neuer Vormane");		// Explanatory label
		setFirstnameTextArea = new JTextArea(1, 20);				// Text area for the user to type in their first name.
		setFirstnameTextArea.setEditable(true);
		setFirstnamePanel.add(setFirstnameLabel);					// Both are added to the panel.
		setFirstnamePanel.add(setFirstnameTextArea);
		windowPanel.add(setFirstnamePanel);							// The panel is added to the window panel from above.

		/**
		 * The following lines deal with the area where the user are expected to enter their new last name the same way as above with the new first name.
		 */

		final JPanel setLastnamePanel = new JPanel();
		setLastnamePanel.setLayout(horizontalLayout);
		setLastnamePanel.setAlignmentX(FlowLayout.TRAILING);
		setLastnamePanel.setOpaque(true);
		JLabel setLastnameLabel = new JLabel("Neuer Nachname");
		setLastnameTextArea = new JTextArea(1, 20);
		setLastnameTextArea.setEditable(true);
		setLastnamePanel.add(setLastnameLabel);
		setLastnamePanel.add(setLastnameTextArea);
		windowPanel.add(setLastnamePanel);

		/**
		 * The following lines deal with the area where the user are expected to enter their new e-mail address the same way as above.
		 */

		final JPanel setEmailPanel = new JPanel();
		setEmailPanel.setLayout(horizontalLayout);
		setEmailPanel.setAlignmentX(FlowLayout.TRAILING);
		setEmailPanel.setOpaque(true);
		JLabel setEmailLabel = new JLabel("Neue E-Mail-Adresse");
		setEmailTextArea = new JTextArea(1, 20);
		setEmailTextArea.setEditable(true);
		setEmailPanel.add(setEmailLabel);
		setEmailPanel.add(setEmailTextArea);
		windowPanel.add(setEmailPanel);

		/**
		 * The following lines deal with the area where the user are expected to enter their new password the same way as above.
		 */

		final JPanel setPasswordPanel = new JPanel();
		setPasswordPanel.setLayout(horizontalLayout);
		setPasswordPanel.setAlignmentX(FlowLayout.TRAILING);
		setPasswordPanel.setOpaque(true);
		JLabel setPasswordLabel = new JLabel("Neues Passwort");
		setPasswordTextArea = new JTextArea(1, 20);
		setPasswordTextArea.setEditable(true);
		setPasswordPanel.add(setPasswordLabel);
		setPasswordPanel.add(setPasswordTextArea);
		windowPanel.add(setPasswordPanel);

		/**
		 * The following lines deal with the area where the user are expected to reenter their new password to confirm it. Everything is arranged the same way as above.
		 */

		final JPanel confirmPasswordPanel = new JPanel();
		confirmPasswordPanel.setLayout(horizontalLayout);
		confirmPasswordPanel.setAlignmentX(FlowLayout.TRAILING);
		confirmPasswordPanel.setOpaque(true);
		JLabel confirmPasswordLabel = new JLabel("Neues Passwort bestätigen");
		confirmPasswordTextArea = new JTextArea(1, 20);
		confirmPasswordTextArea.setEditable(true);
		confirmPasswordPanel.add(confirmPasswordLabel);
		confirmPasswordPanel.add(confirmPasswordTextArea);
		windowPanel.add(confirmPasswordPanel);

		/**
		 * The following lines deal with the area where the buttons to save the new pieces of data or to cancel the process are placed.
		 */

		final JPanel buttonPanel = new JPanel();					// Panel to hold the buttons at the bottom of the window.
		buttonPanel.setLayout(horizontalLayout);					// The items in the panel are arranged horizontally.
		buttonPanel.setAlignmentX(FlowLayout.TRAILING);
		buttonPanel.setOpaque(true);
		JButton saveChangesButton = new JButton("Änderungen speichern");	// Save changes button
		JButton cancelButton = new JButton("Abbrechen");			// Cancel button
		cancelButton.addActionListener(new ActionListener() {		// Adds an action to the cancel button, which is executed when clicked on.
			public void actionPerformed(ActionEvent e) {
				frame.dispose();				// When the cancel button is clicked, the window will be disposed.
			}
		});
		buttonPanel.add(saveChangesButton);		// All buttons are added to the panel...
		buttonPanel.add(cancelButton);
		windowPanel.add(buttonPanel);			// ... and the panel with the buttons is added to the window panel.

		frame.getContentPane().add(BorderLayout.CENTER, windowPanel);	// The window panel is added to the frame itself and arranges everything vertically.

		frame.setVisible(true);
	}
}