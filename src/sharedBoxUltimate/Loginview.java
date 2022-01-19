/**
 * This class is the view that appears when the program is first started. It allows logging in existing users and registering new users.
 */

import javax.swing.*;
import java.time.temporal.TemporalQueries;
import java.awt.*;

public class Loginview {

	JFrame frame = null;
	JTextArea emailTextArea = null;
	JTextArea passwordTextArea = null;
	FlowLayout horizontalLayout = new FlowLayout();


	public void loginviewGo() {
		frame = new JFrame("Shared-Box Ultimate Login");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(400,150);
        frame.setLocation(300,300);
        frame.getContentPane();

		final JPanel emailPanel = new JPanel();
		emailPanel.setLayout(horizontalLayout);
		emailPanel.setAlignmentX(FlowLayout.TRAILING);
		emailPanel.setOpaque(true);
		JLabel emailLabel = new JLabel("E-Mail");
		emailPanel.add(emailLabel);

		emailTextArea = new JTextArea(1, 20);
		emailTextArea.setEditable(true);
		emailPanel.add(emailTextArea);

		final JPanel passwordPanel = new JPanel();
		passwordPanel.setLayout(horizontalLayout);
		passwordPanel.setAlignmentX(FlowLayout.TRAILING);
		passwordPanel.setOpaque(true);
		JLabel passwordLabel = new JLabel("Password");
		passwordPanel.add(passwordLabel);

		passwordTextArea = new JTextArea(1, 20);
		passwordTextArea.setEditable(true);
		passwordPanel.add(passwordTextArea);

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
