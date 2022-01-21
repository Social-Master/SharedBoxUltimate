package models;

import java.io.File;
import java.util.HashSet;
import java.util.Set;

import sharedBoxUltimate.FirmenInitializer;

public class Mitarbeiter {
	private Set<Abteilung> abteilungen = new HashSet<Abteilung>();
	private String name;
	private String vorname;
	private String passwort;
	private int id;
	private String userPath;
	
	public Mitarbeiter(String name) {
		this.name = name;
	}
	
	public Mitarbeiter(int id, String name, String vorname, String passwort, String userPath, String abteilungenRaw) {
		this.id = id;
		this.name = name;
		this.vorname = vorname;
		this.passwort = passwort;
		this.userPath = userPath;
		try { //Evtl zum Konstruktoraufruf verlegen
			String[] abtArr = abteilungenRaw.split(";");
			if(!abtArr[0].equalsIgnoreCase("none")) {
				for(Firma a : FirmenInitializer.firmen.keySet()) {
					if(a.getName().equals(this.getFirma())) {
						for(int i = 0; i < abtArr.length; i++) {
							for(Abteilung b : a.getAbteilungSet()) {
								if(b.getName().equals(abtArr[i]));
							}
						}
					}
				}
			}
		}
		catch(Exception e) {
			
		}
	}
	public String getName() {
		return this.name;
	}
	public String getVorname() {
		return this.vorname;
	}
	public String getPasswort() {
		return this.passwort;
	}
	public int getId() {
		return this.id;
	}
	public String getFirma() {
		String dirtySplit[] = userPath.split("/"); //Disgusting aber sollte funktionieren
		return dirtySplit[1];
	}
	public String getUserPath() {
		return this.userPath;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	public void setVorname(String vorname) {
		this.vorname = vorname;
	}
	public void setPasswort(String passwort) {
		this.passwort = passwort;
	}
	public void addAbteilung(Abteilung in) {
		this.abteilungen.add(in);
	}
	public Set<Abteilung> getAbteilungen() {
		return this.abteilungen;
	}
}
