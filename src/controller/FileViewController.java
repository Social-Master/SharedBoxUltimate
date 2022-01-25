package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JOptionPane;

import sharedBoxUltimate.FileView;
import sharedBoxUltimate.Main;

public class FileViewController implements ActionListener {
	
	private FileView view = null;
	
	public FileViewController(FileView view) {
		this.view = view;
	}
	private void updateFileView() {
		DefaultListModel<String> dC = new DefaultListModel<>();
		MitarbeiterController x = new MitarbeiterController(Main.user);
		for(File f : x.getUserFiles(view.currPath)) {
			dC.addElement(f.getName());
		}
		view.directoryContentList.setModel(dC);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == view.uploadFileItem) {
			MitarbeiterController c = new MitarbeiterController(Main.user);
			String srcPath = JOptionPane.showInputDialog("Geben sie den Pfad der hochzuladenden Datei ein:");
			File upload = new File(srcPath);
			if(upload.isDirectory()) {
				c.uploadDir(upload, view.currPath);
			}
			else {
				c.uploadFile(upload, view.currPath);
			}
			updateFileView();
		}
		if(e.getSource() == view.moveDownButton) {
			String target = view.directoryContentList.getSelectedValue();
			if(new File(Main.user.getUserPath() + "/" + view.currPath + target + "/").isDirectory()) {
				view.currPath += target + "/";
				view.filePathLabel.setText(view.currPath);
				updateFileView();
			}
			else {
				JOptionPane.showMessageDialog(null, "Die ausgewählte Datei ist kein Ordner!");
			}
		}
		if(e.getSource() == view.moveUpButton) {
			String[] arr = view.currPath.split("/");
			String neu = "";
			for(int i = 0; i < arr.length - 1; i++) {
				neu += arr[i] + "/";
			}
			view.currPath = neu;
			view.filePathLabel.setText(neu);
			updateFileView();
		}
		if(e.getSource() == view.deleteFileItem) {
			MitarbeiterController c = new MitarbeiterController(Main.user);
			String target = view.directoryContentList.getSelectedValue();
			c.deleteFileByName(view.currPath + target);
			updateFileView();
		}
	}

}
