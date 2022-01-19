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

	public void registerviewGo() {
		frame = new JFrame("Shared-Box Ultimate Register");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(400, 150);
		frame.setLocation(300, 300);
		frame.getContentPane();

		frame.setVisible(true);
	}
}
