package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import models.Firma;
import sharedBoxUltimate.FileView;
import sharedBoxUltimate.Initializer;
import sharedBoxUltimate.LoginView;
import sharedBoxUltimate.Main;
import sharedBoxUltimate.Registerview;

public class LoginViewController implements ActionListener {
	
	private LoginView view = null;
	
	public LoginViewController(LoginView view) {
		this.view = view;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == view.loginButton) {
			boolean l = false;
			for(Firma f : Initializer.firmen.keySet()) {
				FirmaController fc = Initializer.firmen.get(f);
				if(fc.loginMitarbeiter(view.emailTextArea.getText(), view.passwordTextArea.getText()) != null) {
					Main.user = fc.loginMitarbeiter(view.emailTextArea.getText(), view.passwordTextArea.getText());
					System.out.println("Login erfolgreich!");
					FileView fileview = new FileView();			// This creates a new object that opens the Fileview window. More on that in Fileview.java
					fileview.fileviewGo();
					l = true;
					break;
				}
			}
			if(l == false) {
				JOptionPane.showMessageDialog(null, "Falsche Email oder falsches Passwort!");
			}
		}
		if(e.getSource() == view.registerButton) {
			Registerview reg = new Registerview();
			reg.registerviewGo();
		}
	}

}
