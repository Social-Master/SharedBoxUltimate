package sharedBoxUltimate;

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
	
}
