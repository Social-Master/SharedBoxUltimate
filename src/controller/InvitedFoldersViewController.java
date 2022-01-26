package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.DefaultListModel;
import javax.swing.JFileChooser;
import javax.swing.JList;
import javax.swing.JOptionPane;

import models.Abteilung;
import models.Firma;
import models.Mitarbeiter;
import sharedBoxUltimate.Initializer;
import sharedBoxUltimate.Main;
import views.AbteilungView;
import views.InvitedFoldersView;

public class InvitedFoldersViewController implements ActionListener {
	private InvitedFoldersView view = null;
	private File src = null;
	private int cop = 0;
	
	public InvitedFoldersViewController(InvitedFoldersView view) {
		this.view = view;
	}
	private void updateFileView() {
		DefaultListModel<String> dC = new DefaultListModel<>();
		MitarbeiterController x = new MitarbeiterController(view.target);
		for(File f : x.getUserFiles(view.currPath)) {
			dC.addElement(f.getName());
		}
		view.contentList.setModel(dC);
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == view.uploadFileItem) {
			MitarbeiterController c = new MitarbeiterController(view.target);
			File upload = null;
			JFileChooser chooser = new JFileChooser();
			chooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
			
		    int returnVal = chooser.showOpenDialog(null);
		    if(returnVal == JFileChooser.APPROVE_OPTION) {
		       upload = chooser.getSelectedFile();
		       if(upload.isDirectory()) {
					c.uploadDir(upload, view.currPath);
				}
				else {
					c.uploadFile(upload, view.currPath);
				}
		    }
			
			updateFileView();
		}
		if(e.getSource() == view.moveDownButton) {
			String target = view.contentList.getSelectedValue();
			if(new File(view.target.getUserPath() + "/" + view.currPath + target + "/").isDirectory()) {
				view.currPath += target + "/";
				view.pathLabel.setText(view.currPath);
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
			view.pathLabel.setText(neu);
			updateFileView();
		}
		if(e.getSource() == view.deleteFileItem) {
			MitarbeiterController c = new MitarbeiterController(view.target);
			String target = view.contentList.getSelectedValue();
			c.deleteFileByName(view.currPath + target);
			updateFileView();
		}
		if(e.getSource() == view.copyFileItem) {
			src = new File(view.currPath + view.contentList.getSelectedValue());
			cop = 1;
		}
		if(e.getSource() == view.pasteFileItem) {
			MitarbeiterController c = new MitarbeiterController(view.target);
			if(cop == 1) {
				c.copyFileByName(src.getPath(), view.currPath + src.getName());
			}
			else if(cop == 2) {
				c.moveFileByName(src.getPath(), view.currPath + src.getName());
			}
			updateFileView();
		}
		if(e.getSource() == view.cutFileItem) {
			src = new File(view.currPath + view.contentList.getSelectedValue());
			cop = 2;
		}
		if(e.getSource() == view.renameFileItem) {
			MitarbeiterController c = new MitarbeiterController(view.target);
			String target = view.contentList.getSelectedValue();
			String name = JOptionPane.showInputDialog("Geben sie den neuen Dateinamen an:");
			c.renameFile(view.currPath + target, name);
			updateFileView();
		}
		if(e.getSource() == view.mkdirFileItem) {
			MitarbeiterController c = new MitarbeiterController(view.target);
			String name = JOptionPane.showInputDialog("Geben sie den Namen des Ordners an:");
			c.mkdir(view.currPath + "/" + name);
			updateFileView();
		}
	}

}
