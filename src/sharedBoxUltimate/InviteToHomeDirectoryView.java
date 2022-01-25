/**
 * This is the class providing the view for the JMenuItem inviteToHomeDirectoryItem from Fileview.java. 
 */

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class InviteToHomeDirectoryView {

	/**
	* These set the properties of the window, i.e. the title, its default size and its default placement.
	*/

	JFrame frame = null;
	FlowLayout horizontalLayout = new FlowLayout();

	/**
	 * This method runs the view, that allow the user to "invite other users to their directory", that is, the user give other users read, write and execute rights within their home directory "/user".
	 */

	public void inviteToHomeDirectoryViewGo() {
		frame = new JFrame("Zum Home-Verzeichnis einladen");		// Creates the InviteToHomeDirectoryView window, with the title specified in the brackets.
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);	// When the close button is clicked, the window will disappear without closing the program.
		frame.setSize(300, 200);			// The window is 300x200 pixels big.
		frame.setLocation(300, 300);		// The window will open at location (300, 300).
		frame.getContentPane();

		/**
		 * This panel is spread across the entire window and makes sure the following panels are arranged vertically.
		 */

		final JPanel buttonPanel = new JPanel();
		buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.Y_AXIS));

		/**
		 * This panel contains the compiled JList of other users of the service within a company.
		 */

		final JPanel usersListPanel = new JPanel();

		DefaultListModel<String> users = new DefaultListModel<>();	// This is the actual list of users.
		users.addElement("User0");
		users.addElement("User1");
		users.addElement("User2");
		users.addElement("User3");
		JList<String> usersList = new JList<>(users);			// This JList creates a graphical version of the list to put on a window.

		usersListPanel.add(usersList);	// The JList is then added to the panel

		/**
		 * The following lines deal with the layout of the entire window. It arranges all the elements horizontally across the window.
		 */

		final JPanel windowPanel = new JPanel();	// This creates the panel.
		windowPanel.setLayout(horizontalLayout);	// This sets it to a horizontal FlowLayout.
		windowPanel.setAlignmentX(FlowLayout.TRAILING);
		windowPanel.setOpaque(true);

		/**
		 * The following lines deal with the buttons
		 */

		JButton inviteUserButton = new JButton("Benutzer einladen");	// This creates a button for allowing a user access to the own /user directory.
		JButton cancelButton = new JButton("Abbrechen");		// This button is for cancelling the operation.
		cancelButton.addActionListener(new ActionListener() {	// This is the action associated with the cancel button.
			public void actionPerformed(ActionEvent e) {
				frame.dispose();				// Upon clicking the cancel button, this window will dispose without closing the program.
			}
		});

		/**
		 * The following lines add the buttons to the button panel
		 */
		buttonPanel.add(inviteUserButton);
		buttonPanel.add(cancelButton);

		/**
		 * The button panel and the JList containing the other users are then added to the window panel.
		 */

		windowPanel.add(usersList);
		windowPanel.add(buttonPanel);

		/**
		 * The window panel is then added to the window itself.
		 */

		frame.getContentPane().add(windowPanel);

		frame.setVisible(true);
	}
}
