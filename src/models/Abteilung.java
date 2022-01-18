package models;

import java.util.HashSet;
import java.util.Set;

public class Abteilung {
	private Set<Mitarbeiter> mit = new HashSet();
	private String name;
	
	public void addUser(Mitarbeiter in) {
		mit.add(in);
	}
	public void deleteUser(Mitarbeiter in) {
		mit.remove(in);
	}
}
