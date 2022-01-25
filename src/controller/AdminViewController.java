package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;

import models.Firma;
import models.Mitarbeiter;
import sharedBoxUltimate.AdminView;
import sharedBoxUltimate.Initializer;
import sharedBoxUltimate.Main;

public class AdminViewController implements ActionListener {
	AdminView view = null;
	Firma fir = null;
	FirmaController firC = null;
	
	
	public AdminViewController(AdminView view) {
		this.view = view;
		this.fir = Initializer.getFirmaByName(Main.user.getFirmaName());
		this.firC = Initializer.getFirmaControllerByName(Main.user.getFirmaName());
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == view.bCreateGroup) {
			String abteilungsName = AdminView.creGroupWindow();
			firC.createAbteilung(abteilungsName);
			updateView();
		}
		if(e.getSource() == view.bDeleteGroup) {
			String delName = view.groups.getSelectedValue();
			int delCert = AdminView.delGroupWindow();
			if(delCert == 0) {
				firC.deleteAbteilung(delName);
				updateView();
			}
		}
		if(e.getSource() == view.bAddEmployee) {
			String addName = view.groups.getSelectedValue();
			String username = JOptionPane.showInputDialog("Geben sie den Namen des Mitarbeiters an der zu " + addName + " hinzugefügt werden soll:");
			Mitarbeiter b = firC.getFirma().getMitarbeiterByName(username);
			MitarbeiterController c = new MitarbeiterController(b);
			c.addAbteilung(firC.getAbteilungByName(addName));
		}
		if(e.getSource() == view.bRMEmployee) {
			String remName = view.groups.getSelectedValue();
			String username = JOptionPane.showInputDialog("Geben sie den zu entfernenden Benutzer an:");
			
		}
	}
	public void updateView() {
		DefaultListModel<String> directoryContent = new DefaultListModel<>();
		for(File f : new File("Server/" + Main.user.getFirmaName() + "/Abteilungen/").listFiles()) {
			if(f.isDirectory()) {
				directoryContent.addElement(f.getName());
		
			}
		}
		view.groups.setModel(directoryContent);
	}
}
