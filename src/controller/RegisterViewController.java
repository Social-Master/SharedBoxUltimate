package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import models.Firma;
import sharedBoxUltimate.FileView;
import sharedBoxUltimate.Initializer;
import sharedBoxUltimate.Main;
import sharedBoxUltimate.RegisterView;

public class RegisterViewController implements ActionListener {
	
	private RegisterView view;
	
	public RegisterViewController(RegisterView view) {
		this.view = view;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == view.registerButton && view.firstnameTextArea.getText() != null && view.lastnameTextArea.getText() != null && view.emailTextArea.getText() != null && view.passwordTextArea.getText() != null) {
			for(Firma f : Initializer.firmen.keySet()) {
				if(f.getName().equals(view.cb.getSelectedItem().toString())) {
					FirmaController fc = Initializer.firmen.get(f);
					fc.createMitarbeiter(0, view.lastnameTextArea.getText(), view.firstnameTextArea.getText(), view.emailTextArea.getText(), view.passwordTextArea.getText());
					Main.user = fc.loginMitarbeiter(view.emailTextArea.getText(), view.passwordTextArea.getText());
					FileView fileview = new FileView();			// This creates a new object that opens the Fileview window. More on that in Fileview.java
					fileview.fileviewGo();
				}
			}
		}
		else {
			JOptionPane.showMessageDialog(null, "Bitte füllen sie alle Felder aus!");
		}
	}

}
