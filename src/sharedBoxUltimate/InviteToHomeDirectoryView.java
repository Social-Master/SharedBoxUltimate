package sharedBoxUltimate;
/**

 * This is the class providing the view for the JMenuItem inviteToHomeDirectoryItem from Fileview.java. 
 */

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class InviteToHomeDirectoryView {
	JFrame frame = null;
	FlowLayout horizontalLayout = new FlowLayout();

	public void inviteToHomeDirectoryViewGo() {
		frame = new JFrame("Zum Home-Verzeichnis einladen");
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setSize(300, 200);
		frame.setLocation(300, 300);
		frame.getContentPane();

		final JPanel buttonPanel = new JPanel();
		buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.Y_AXIS));

		final JPanel usersListPanel = new JPanel();

		DefaultListModel<String> users = new DefaultListModel<>();
		users.addElement("User0");
		users.addElement("User1");
		users.addElement("User2");
		users.addElement("User3");
		JList<String> usersList = new JList<>(users);

		usersListPanel.add(usersList);

		final JPanel windowPanel = new JPanel();
		windowPanel.setLayout(horizontalLayout);
		windowPanel.setAlignmentX(FlowLayout.TRAILING);
		windowPanel.setOpaque(true);

		JButton inviteUserButton = new JButton("Benutzer einladen");
		JButton cancelButton = new JButton("Abbrechen");
		cancelButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
			}
		});
		buttonPanel.add(inviteUserButton);
		buttonPanel.add(cancelButton);

		windowPanel.add(usersList);
		windowPanel.add(buttonPanel);

		frame.getContentPane().add(windowPanel);

		frame.setVisible(true);
	}
}
