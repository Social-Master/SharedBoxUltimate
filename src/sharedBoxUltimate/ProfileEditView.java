/**
 * This is the view, that appears, when the editProfileButton from the Fileview class is clicked. It allows the edit some data in their profile.
 */

import javax.swing.*;
import java.time.temporal.TemporalQueries;
import java.awt.event.*;
import java.awt.*;

public class ProfileEditView {
	JFrame profileEditViewFrame = null;
	FlowLayout horizontalLayout = new FlowLayout();
	JTextArea setFirstnameTextArea = null;
	JTextArea setLastnameTextArea = null;
	JTextArea setEmailTextArea = null;
	JTextArea setPasswordTextArea = null;
	JTextArea confirmPasswordTextArea = null;

	public void profileEditViewGo() {

		profileEditViewFrame = new JFrame("Edit Profile");
		profileEditViewFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		profileEditViewFrame.setSize(450, 225);
		profileEditViewFrame.setLocation(300, 300);
		profileEditViewFrame.getContentPane();

		final JPanel windowPanel = new JPanel();
		windowPanel.setLayout(new BoxLayout(windowPanel, BoxLayout.Y_AXIS));

		final JPanel setFirstnamePanel = new JPanel();
		setFirstnamePanel.setLayout(horizontalLayout);
		setFirstnamePanel.setAlignmentX(FlowLayout.TRAILING);
		setFirstnamePanel.setOpaque(true);
		JLabel setFirstnameLabel = new JLabel("Set new firstname");
		setFirstnameTextArea = new JTextArea(1, 20);
		setFirstnameTextArea.setEditable(true);
		setFirstnamePanel.add(setFirstnameLabel);
		setFirstnamePanel.add(setFirstnameTextArea);
		windowPanel.add(setFirstnamePanel);

		final JPanel setLastnamePanel = new JPanel();
		setLastnamePanel.setLayout(horizontalLayout);
		setLastnamePanel.setAlignmentX(FlowLayout.TRAILING);
		setLastnamePanel.setOpaque(true);
		JLabel setLastnameLabel = new JLabel("Set new lastname");
		setLastnameTextArea = new JTextArea(1, 20);
		setLastnameTextArea.setEditable(true);
		setLastnamePanel.add(setLastnameLabel);
		setLastnamePanel.add(setLastnameTextArea);
		windowPanel.add(setLastnamePanel);

		final JPanel setEmailPanel = new JPanel();
		setEmailPanel.setLayout(horizontalLayout);
		setEmailPanel.setAlignmentX(FlowLayout.TRAILING);
		setEmailPanel.setOpaque(true);
		JLabel setEmailLabel = new JLabel("Set new e-mail address");
		setEmailTextArea = new JTextArea(1, 20);
		setEmailTextArea.setEditable(true);
		setEmailPanel.add(setEmailLabel);
		setEmailPanel.add(setEmailTextArea);
		windowPanel.add(setEmailPanel);

		final JPanel setPasswordPanel = new JPanel();
		setPasswordPanel.setLayout(horizontalLayout);
		setPasswordPanel.setAlignmentX(FlowLayout.TRAILING);
		setPasswordPanel.setOpaque(true);
		JLabel setPasswordLabel = new JLabel("Set new password");
		setPasswordTextArea = new JTextArea(1, 20);
		setPasswordTextArea.setEditable(true);
		setPasswordPanel.add(setPasswordLabel);
		setPasswordPanel.add(setPasswordTextArea);
		windowPanel.add(setPasswordPanel);

		final JPanel confirmPasswordPanel = new JPanel();
		confirmPasswordPanel.setLayout(horizontalLayout);
		confirmPasswordPanel.setAlignmentX(FlowLayout.TRAILING);
		confirmPasswordPanel.setOpaque(true);
		JLabel confirmPasswordLabel = new JLabel("Confirm new password");
		confirmPasswordTextArea = new JTextArea(1, 20);
		confirmPasswordTextArea.setEditable(true);
		confirmPasswordPanel.add(confirmPasswordLabel);
		confirmPasswordPanel.add(confirmPasswordTextArea);
		windowPanel.add(confirmPasswordPanel);

		final JPanel buttonPanel = new JPanel();
		buttonPanel.setLayout(horizontalLayout);
		buttonPanel.setAlignmentX(FlowLayout.TRAILING);
		buttonPanel.setOpaque(true);
		JButton saveChangesButton = new JButton("Save Changes");
		JButton cancelButton = new JButton("Cancel");
		cancelButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				profileEditViewFrame.dispose();
			}
		});
		buttonPanel.add(saveChangesButton);
		buttonPanel.add(cancelButton);
		windowPanel.add(buttonPanel);

		profileEditViewFrame.getContentPane().add(BorderLayout.CENTER, windowPanel);

		profileEditViewFrame.setVisible(true);
	}
}