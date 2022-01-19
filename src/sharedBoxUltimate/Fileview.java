/**
 * This class is the View class; it views the data, e.g. Files and Directories
 */

//package sharedBoxUltimate;

import javax.swing.*;
import java.time.temporal.TemporalQueries;
import java.awt.*;

public class Fileview extends JFrame {

	JFrame frame = null;
	FlowLayout topLayout = new FlowLayout();
	JTextArea directoryListingArea = null;

	public void go() {
		frame = new JFrame("Shared-Box Ultimate");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(1000,500);
        frame.setLocation(300,300);
        frame.getContentPane();

		frame.setVisible(true);
	}
}
