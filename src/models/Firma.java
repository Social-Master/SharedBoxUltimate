package models;

import java.util.HashSet;
import java.util.Set;

public class Firma {
	private Set<Mitarbeiter> mit = new HashSet();
	private Set<Abteilung> abt = new HashSet();
	private String name;
	
	
	public Firma(String name) {
		this.name = name;
	}
	
	public void addUser(Mitarbeiter in) {
		mit.add(in);
	}
	public void deleteUser(Mitarbeiter in) {
		mit.remove(in);
	}
	public void addAbteilung(Abteilung in) {
		abt.add(in);
	}
	public void deleteAbteilung(Abteilung in) {
		abt.remove(in);
	}
	public String getName() {
		return this.name;
	}
	public Set<Mitarbeiter> getMitarbeiterSet() {
		return this.mit;
	}
	public void printMitarbeiter() {
		for(Mitarbeiter a : this.mit) {
			System.out.println(a.getId() + " " + a.getName() + " " + a.getVorname() + " " + a.getPasswort());
		}
	}
	public void printAbteilungen() {
		for(Abteilung a : this.abt) {
			System.out.println(a.getName());
		}
	}
	
}
