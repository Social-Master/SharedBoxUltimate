package models;

import java.io.File;
import java.util.Set;

public class Mitarbeiter {
	private Set<Abteilung> abteilungen;
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
}
