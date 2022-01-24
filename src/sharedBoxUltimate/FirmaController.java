package sharedBoxUltimate;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import models.Abteilung;
import models.Firma;
import models.Mitarbeiter;

public class FirmaController {
	private Firma model;
	
	
	public FirmaController(Firma model) {
		this.model = model;
	}
	public void readFirmaData() {
		
	}
	public void createMitarbeiter(int id, String name, String vorname, String passwort) {
		File mitarbeiterDir = new File("Server/" + model.getName() + "/Mitarbeiter");
		if(!mitarbeiterDir.exists()) {
			mitarbeiterDir.mkdir();
		}
		File userDir = new File("Server/" + model.getName() + "/Mitarbeiter/" + name);
		if(!userDir.exists()) {
			userDir.mkdir();
			new File(userDir.getPath() + "/Files").mkdir();
			
			File userinfo = new File(userDir.getPath() + "/userinfo.csv");
			try {
				userinfo.createNewFile();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			try {
				FileWriter writer = new FileWriter(userDir.getPath() + "/userinfo.csv");
				new File(userDir.getPath() + "/abteilung.csv").createNewFile();
				writer.write(id + "," + name + "," + vorname + "," + passwort + "," + "Server/" + model.getName() + "/Mitarbeiter/" + name + "/Files" + ",false");
				writer.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			Mitarbeiter neu = new Mitarbeiter(id, name, vorname, passwort, "Server/" + model.getName() + "/Mitarbeiter/" + name + "/Files", false);
			model.addUser(neu);
		}
		
	}
	public void createAbteilung(String name) {
		File abteilungDir = new File("Server/" + model.getName() + "/Abteilungen");
		if(!abteilungDir.exists()) {
			abteilungDir.mkdir();
		}
		File groupDir = new File("Server/" + model.getName() + "/Abteilungen/" + name);
		if(!groupDir.exists()) {
			groupDir.mkdir();
			Abteilung neu = new Abteilung(name);
			model.addAbteilung(neu);
		}
	}
	public Mitarbeiter loginMitarbeiter(String name, String passwort) {
		for(Mitarbeiter m : model.getMitarbeiterSet()) {
			if(m.getName().equals(name)) {
				if(m.getPasswort().equals(passwort)) {
					return m;
				}
			}
		}
		return null;
	}
	public Abteilung getAbteilungByName(String name) {
		for(Abteilung x : model.getAbteilungSet()) {
			if(x.getName().equals(name)) {
				return x;
			}
		}
		return null;
	}
	public Firma getFirma() {
		return this.model;
	}
}
