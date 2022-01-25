/**
 * This is the view, that appears, when the editProfileButton from the Fileview class is clicked. It allows the edit some data in their profile.
 */
package sharedBoxUltimate;
import javax.swing.*;

import controller.ProfileEditViewController;

import java.awt.event.*;
import java.awt.*;

public class ProfileEditView {
	JFrame frame = null;
	FlowLayout horizontalLayout = new FlowLayout();
	public JTextArea firstnameTextArea = null;
	public JTextArea lastnameTextArea = null;
	public JTextArea emailTextArea = null;
	public JTextArea passwordTextArea = null;
	public JTextArea confirmPasswordTextArea = null;
	public JButton saveChangesButton = null;
	public JButton cancelButton = null;
	private ProfileEditViewController pevc = new ProfileEditViewController(this);

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
		firstnameTextArea = new JTextArea(1, 20);
		firstnameTextArea.setEditable(true);
		setFirstnamePanel.add(setFirstnameLabel);
		setFirstnamePanel.add(firstnameTextArea);
		windowPanel.add(setFirstnamePanel);

		final JPanel setLastnamePanel = new JPanel();
		setLastnamePanel.setLayout(horizontalLayout);
		setLastnamePanel.setAlignmentX(FlowLayout.TRAILING);
		setLastnamePanel.setOpaque(true);
		JLabel setLastnameLabel = new JLabel("Neuer Nachname");
		lastnameTextArea = new JTextArea(1, 20);
		lastnameTextArea.setEditable(true);
		setLastnamePanel.add(setLastnameLabel);
		setLastnamePanel.add(lastnameTextArea);
		windowPanel.add(setLastnamePanel);

		final JPanel setEmailPanel = new JPanel();
		setEmailPanel.setLayout(horizontalLayout);
		setEmailPanel.setAlignmentX(FlowLayout.TRAILING);
		setEmailPanel.setOpaque(true);
		JLabel setEmailLabel = new JLabel("Neue E-Mail-Adresse");
		emailTextArea = new JTextArea(1, 20);
		emailTextArea.setEditable(true);
		setEmailPanel.add(setEmailLabel);
		setEmailPanel.add(emailTextArea);
		windowPanel.add(setEmailPanel);

		final JPanel setPasswordPanel = new JPanel();
		setPasswordPanel.setLayout(horizontalLayout);
		setPasswordPanel.setAlignmentX(FlowLayout.TRAILING);
		setPasswordPanel.setOpaque(true);
		JLabel setPasswordLabel = new JLabel("Neues Passwort");
		passwordTextArea = new JTextArea(1, 20);
		passwordTextArea.setEditable(true);
		setPasswordPanel.add(setPasswordLabel);
		setPasswordPanel.add(passwordTextArea);
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
		saveChangesButton = new JButton("Änderungen speichern");
		saveChangesButton.addActionListener(pevc);
		cancelButton = new JButton("Abbrechen");
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