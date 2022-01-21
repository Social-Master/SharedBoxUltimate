/**
 * This is the view, that appears, when the editProfileButton from the Fileview class is clicked. It allows the edit some data in their profile.
 */

import javax.swing.*;
import java.time.temporal.TemporalQueries;
import java.awt.event.*;
import java.awt.*;

public class ProfileEditView {
	JFrame frame = null;
	FlowLayout horizontalLayout = new FlowLayout();
	JTextArea textArea = null;

	public void profileEditViewGo() {

		frame = new JFrame("Edit Profile");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(400, 150);
		frame.setLocation(300, 300);
		frame.getContentPane();

		textArea = new JTextArea(1, 20);

		frame.setVisible(true);
	}
}