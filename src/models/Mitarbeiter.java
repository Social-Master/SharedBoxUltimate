package models;

import java.util.HashSet;
import java.util.Set;

public class Mitarbeiter {
	private Set<Abteilung> abteilungen = new HashSet<Abteilung>();
	private String name;
	private String email;
	private String passwort;
	private int id;
	private String userPath;
	private boolean op;
	
	public Mitarbeiter(String name) {
		this.name = name;
	}
	
	public Mitarbeiter(int id, String name, String email, String passwort, String userPath, boolean op) {
		this.id = id;
		this.name = name;
		this.email = email;
		this.passwort = passwort;
		this.userPath = userPath;
		this.op = op;
	}
	public String getName() {
		return this.name;
	}
	public String getEmail() {
		return this.email;
	}
	public String getPasswort() {
		return this.passwort;
	}
	public int getId() {
		return this.id;
	}
	public String getFirmaName() {
		String dirtySplit[] = userPath.split("/"); //Disgusting aber sollte funktionieren
		return dirtySplit[1];
	}
	public String getUserPath() {
		return this.userPath;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setEmail(String vorname) {
		this.email = vorname;
	}
	public void setPasswort(String passwort) {
		this.passwort = passwort;
	}
	public void setOp(boolean in) {
		this.op = in;
	}
	public void addAbteilung(Abteilung in) {
		this.abteilungen.add(in);
	}
	public Set<Abteilung> getAbteilungen() {
		return this.abteilungen;
	}
	public boolean isOp() {
		if(this.op == true) {
			return true;
		}
		else {
			return false;
		}
	}
}
