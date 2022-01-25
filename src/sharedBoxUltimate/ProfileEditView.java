/**
 * This is the view, that appears, when the editProfileButton from the Fileview class is clicked. It allows the edit some data in their profile.
 */
package sharedBoxUltimate;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class ProfileEditView {
	JFrame frame = null;
	FlowLayout horizontalLayout = new FlowLayout();
	JTextArea setFirstnameTextArea = null;
	JTextArea setLastnameTextArea = null;
	JTextArea setEmailTextArea = null;
	JTextArea setPasswordTextArea = null;
	JTextArea confirmPasswordTextArea = null;

	public void profileEditViewGo() {

		frame = new JFrame("Profil bearbeiten");
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setSize(450, 225);
		frame.setLocation(300, 300);
		frame.getContentPane();

		final JPanel windowPanel = new JPanel();
		windowPanel.setLayout(new BoxLayout(windowPanel, BoxLayout.Y_AXIS));

		final JPanel setFirstnamePanel = new JPanel();
		setFirstnamePanel.setLayout(horizontalLayout);
		setFirstnamePanel.setAlignmentX(FlowLayout.TRAILING);
		setFirstnamePanel.setOpaque(true);
		JLabel setFirstnameLabel = new JLabel("Neuer Vormane");
		setFirstnameTextArea = new JTextArea(1, 20);
		setFirstnameTextArea.setEditable(true);
		setFirstnamePanel.add(setFirstnameLabel);
		setFirstnamePanel.add(setFirstnameTextArea);
		windowPanel.add(setFirstnamePanel);

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

		final JPanel buttonPanel = new JPanel();
		buttonPanel.setLayout(horizontalLayout);
		buttonPanel.setAlignmentX(FlowLayout.TRAILING);
		buttonPanel.setOpaque(true);
		JButton saveChangesButton = new JButton("Änderungen speichern");
		JButton cancelButton = new JButton("Abbrechen");
		cancelButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
			}
		});
		buttonPanel.add(saveChangesButton);
		buttonPanel.add(cancelButton);
		windowPanel.add(buttonPanel);

		frame.getContentPane().add(BorderLayout.CENTER, windowPanel);

		frame.setVisible(true);
	}
}