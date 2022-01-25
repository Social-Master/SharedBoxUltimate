package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import sharedBoxUltimate.Registerview;

public class RegisterViewController implements ActionListener {
	
	private Registerview view;
	
	public RegisterViewController(Registerview view) {
		this.view = view;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == view.registerButton) {
			
		}
		
	}

}
