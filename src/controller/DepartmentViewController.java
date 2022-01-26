package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.DefaultListModel;
import javax.swing.JFileChooser;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import models.Abteilung;
import sharedBoxUltimate.DepartmentView;
import sharedBoxUltimate.Main;

public class DepartmentViewController implements ActionListener {
	
	private DepartmentView view = null;
	private File src = null;
	private Abteilung a = null;
	private AbteilungController ac = null;
	private int cop = 0;
	
	
	public DepartmentViewController(DepartmentView view, Abteilung a) {
		this.view = view;
		this.a = a;
		this.ac = new AbteilungController(a, Main.user);
	}
	private void updateFileView() {
		DefaultListModel<String> directoryContent = new DefaultListModel<>();
		final JPanel listPanel = new JPanel();
		
		for(File f : new MitarbeiterController(Main.user).getAbteilungFiles(a, view.currPath)) {
			directoryContent.addElement(f.getName());
		}
		view.departmentContentList.setModel(directoryContent);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == view.moveDownButton) {
			String target = view.departmentContentList.getSelectedValue();
			if(new File("Server/" + Main.user.getFirmaName() + "/Abteilungen/" + a.getName() + "/" + view.currPath + target).isDirectory()) {
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
			//view.depPathLabel.setText(neu);
			updateFileView();
		}
		if(e.getSource() == view.uploadFileItem) {
			File upload = null;
			JFileChooser chooser = new JFileChooser();
			chooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
			
		    int returnVal = chooser.showOpenDialog(null);
		    if(returnVal == JFileChooser.APPROVE_OPTION) {
		       upload = chooser.getSelectedFile();
		       if(upload.isDirectory()) {
					ac.uploadDir(upload, view.currPath);
				}
				else {
					ac.uploadFile(upload, view.currPath);
				}
		    }
			updateFileView();
		}
		if(e.getSource() == view.deleteFileItem) {
			String target = view.departmentContentList.getSelectedValue();
			System.out.println(view.currPath + target);
			ac.deleteFileByName(view.currPath + target);
			updateFileView();
		}
		if(e.getSource() == view.copyFileItem) {
			src = new File(view.currPath + view.departmentContentList.getSelectedValue());
			cop = 1;
		}
		if(e.getSource() == view.pasteFileItem) {
			MitarbeiterController c = new MitarbeiterController(Main.user);
			if(cop == 1) {
				c.copyFileByName(src.getPath(), view.currPath + src.getName());
			}
			else if(cop == 2) {
				c.moveFileByName(src.getPath(), view.currPath + src.getName());
			}
			updateFileView();
		}
		if(e.getSource() == view.cutFileItem) {
			src = new File(view.currPath + view.departmentContentList.getSelectedValue());
			cop = 2;
		}
		if(e.getSource() == view.renameFileItem) {
			MitarbeiterController c = new MitarbeiterController(Main.user);
			String target = view.departmentContentList.getSelectedValue();
			String name = JOptionPane.showInputDialog("Geben sie den neuen Dateinamen an:");
			c.renameFile(view.currPath + target, name);
			updateFileView();
		}
		
	}

}
