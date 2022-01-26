/**
 * Controller for the ProfileEditView class. It implements updating of the Mitarbeiter
 */
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import sharedBoxUltimate.Main;
import views.ProfileEditView;

public class ProfileEditViewController implements ActionListener {
	private ProfileEditView view = null;
	private MitarbeiterController cont = new MitarbeiterController(Main.user);
	
	public ProfileEditViewController(ProfileEditView view) {
		this.view = view;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == view.saveChangesButton) {
			cont.setName(view.lastnameTextArea.getText());
			cont.setVorname(view.firstnameTextArea.getText());
			cont.setEmail(view.emailTextArea.getText());
			cont.setPasswort(view.passwordTextArea.getText());
			JOptionPane.showMessageDialog(null, "Daten wurden geändert!");
			view.frame.dispose();
		}	
	}
}
