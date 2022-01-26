/**
 * The controller for the RegisterView.
 */
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import models.Firma;
import sharedBoxUltimate.Initializer;
import sharedBoxUltimate.Main;
import views.FileView;
import views.RegisterView;

public class RegisterViewController implements ActionListener {
	
	private RegisterView view;
	
	public RegisterViewController(RegisterView view) {
		this.view = view;
	}

	/**
	 * Checks if all the register conditions are checked. The form needs to filled the domain of the mail address needs to be correct and unique and the number of Mitarbeiter needs to be smaller than 10
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == view.registerButton && view.firstnameTextArea.getText() != null && view.lastnameTextArea.getText() != null && view.emailTextArea.getText() != null && view.passwordTextArea.getText() != null) {
			for(Firma f : Initializer.firmen.keySet()) {
				if(f.getName().equals(view.cb.getSelectedItem().toString())) {
					String[] arr = view.emailTextArea.getText().split("@");
					if(f.getDomain().equals(arr[1])) {
						FirmaController fc = Initializer.firmen.get(f);
						if(fc.isUniqueEmail(view.emailTextArea.getText())) {
							if(f.getNumMitarbeiter() <= 9) {
								fc.createMitarbeiter(0, view.lastnameTextArea.getText(), view.firstnameTextArea.getText(), view.emailTextArea.getText(), view.passwordTextArea.getText());
								Main.user = fc.loginMitarbeiter(view.emailTextArea.getText(), view.passwordTextArea.getText());
								FileView fileview = new FileView();			// This creates a new object that opens the Fileview window. More on that in Fileview.java
								fileview.fileviewGo();
							}
							else {
								JOptionPane.showMessageDialog(null, "Die maximale Anzahl an Mitarbeiter ist erreicht!");
							}
						}
						else {
							JOptionPane.showMessageDialog(null, "Email ist bereits vergeben!");
						}
					}
					else {
						JOptionPane.showMessageDialog(null, "Keine gültige Email-Adresse!");
					}
				}
			}
		}
		else {
			JOptionPane.showMessageDialog(null, "Bitte füllen sie alle Felder aus!");
		}
	}

}
