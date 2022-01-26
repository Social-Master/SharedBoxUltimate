/**
 * one of the most important controller classes. From here Mitarbeiter or Abteilungen can be created and the corrosponding filestructure gets generated.
 */
package controller;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import models.Abteilung;
import models.Firma;
import models.Mitarbeiter;

public class FirmaController {
	private Firma model;
	
	/*
	 * The controller needs the reference to to Firma class instance
	 */
	public FirmaController(Firma model) {
		this.model = model;
	}
	public void readFirmaData() {
		
	}
	/**
	 * given the parameters the Mitarbeiter gets created and all its files for the file structure. Also the Mitarbeiter will be added to the Firma instance
	 * @param id
	 * @param name
	 * @param vorname
	 * @param email
	 * @param passwort
	 */
	public void createMitarbeiter(int id, String name, String vorname, String email, String passwort) {
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
				new File(userDir.getPath() + "/geteilte.txt").createNewFile();
				writer.write(id + "," + name + "," + vorname + "," + email + "," + passwort + "," + "Server/" + model.getName() + "/Mitarbeiter/" + name + "/Files" + ",false");
				writer.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			Mitarbeiter neu = new Mitarbeiter(id, name, vorname, email, passwort, "Server/" + model.getName() + "/Mitarbeiter/" + name + "/Files", false);
			model.addUser(neu);
		}
		
	}
	/**
	 * Same for the Abteilung as for the Mitarbeiter. It creates the Abteilung file structure and adds the newly created instance to the Firma instance Abteilung set
	 */
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
	/**
	 * Deletes an Abteilung from the Firma instance Abteilung set and delets the folder structure. CARE: If a Abteilung is deleted the reference remains in the abteilung.csv of each user.
	 * This needs to be fixed so that every entry of that Abteilung gets deleted.
	 * @param name
	 */
	public void deleteAbteilung(String name) {
		for(Abteilung x : model.getAbteilungSet()) {
			try {
				if(name.equalsIgnoreCase(x.getName())) {
					model.deleteAbteilung(x);
					deleteFolder(new File("Server/" + model.getName() + "/Abteilungen/" + name));
				}
			} 
			catch(Exception e) {
				
			}
		}
	}
	/**
	 * Recursively deletes a folder and all its subfolders.
	 * @param folder The folder that is supposed to be deleted
	 */
	public void deleteFolder(File folder) {
	    File[] files = folder.listFiles();
	    if(files != null) {
	        for(File f: files) {
	            if(f.isDirectory()) {
	                deleteFolder(f);
	            } else {
	                f.delete();
	            }
	        }
	    }
	    folder.delete();
	}
	/**
	 * The basic login function. Returns Mitarbeiter if login is correct. If the Mitarbeiter is not found then it returns null
	 * @param name
	 * @param passwort
	 * @return returns the instance of the logged in Mitarbeiter
	 */
	public Mitarbeiter loginMitarbeiter(String name, String passwort) {
		for(Mitarbeiter m : model.getMitarbeiterSet()) {
			if(m.getEmail().equals(name)) {
				if(m.getPasswort().equals(passwort)) {
					return m;
				}
			}
		}
		return null;
	}
	/**
	 * returns Abteilung by given string. Care this function is case sensitive
	 * @param name
	 * @return returns Abteilung if found otherwise returns null
	 */
	public Abteilung getAbteilungByName(String name) {
		for(Abteilung x : model.getAbteilungSet()) {
			if(x.getName().equals(name)) {
				return x;
			}
		}
		return null;
	}
	/**
	 * returns Firma instance
	 * @return
	 */
	public Firma getFirma() {
		return this.model;
	}
	/**
	 * checks if given Email is unique
	 * @param email
	 * @return true if email string is unique otherwise returns false
	 */
	public boolean isUniqueEmail(String email) {
		for(Mitarbeiter m : this.model.getMitarbeiterSet()) {
			if(m.getEmail().equalsIgnoreCase(email)) {
				return false;
			}
		}
		return true;
	}
}
