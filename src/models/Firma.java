/**
 * basic Firma model. Contains the core information of the model
 */
package models;

import java.util.HashSet;
import java.util.Set;

public class Firma {
	private Set<Mitarbeiter> mit = new HashSet<Mitarbeiter>();
	private Set<Abteilung> abt = new HashSet<Abteilung>();
	private String name;
	private String domain;
	
	
	public Firma(String name, String domain) {
		this.name = name;
		this.domain = domain;
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
	public String getDomain() {
		return this.domain;
	}
	public String getName() {
		return this.name;
	}
	public Set<Mitarbeiter> getMitarbeiterSet() {
		return this.mit;
	}
	public Set<Abteilung> getAbteilungSet() {
		return this.abt;
	}
	public int getNumMitarbeiter() {
		return this.mit.size();
	}
	public int getNumAbteilungen() {
		return this.abt.size();
	}
	public Mitarbeiter getMitarbeiterByName(String name) {
		for(Mitarbeiter a : this.mit) {
			if(a.getName().equalsIgnoreCase(name)) {
				return a;
			}
		}
		return null;
	}
	public void printMitarbeiter() {
		for(Mitarbeiter a : this.mit) {
			System.out.println(a.getId() + " " + a.getName() + " " + a.getEmail() + " " + a.getPasswort());
		}
	}
	public void printAbteilungen() {
		for(Abteilung a : this.abt) {
			System.out.println(a.getName());
		}
	}
	
}
