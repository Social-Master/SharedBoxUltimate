package models;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

public class Mitarbeiter {
	private Set<Abteilung> abteilungen = new HashSet<Abteilung>();
	private String name;
	private String vorname;
	private String email;
	private String passwort;
	private int id;
	private String userPath;
	private boolean op;
	
	public Mitarbeiter(String name) {
		this.name = name;
	}
	
	public Mitarbeiter(int id, String name, String vorname, String email, String passwort, String userPath, boolean op) {
		this.id = id;
		this.name = name;
		this.vorname = vorname;
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
	public String getVorname() {
		return this.vorname;
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
	public void setVorname(String vorname) {
		this.vorname = vorname;
	}
	public void setEmail(String email) {
		this.email = email;
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
	public void removeAbteilung(Abteilung in) {
		this.abteilungen.remove(in);
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
	public boolean isInAbteilung(String name) {
		for(Abteilung a : abteilungen) {
			if(a.getName().equals(name)) {
				return true;
			}
		}
		return false;
	}
	public boolean sharesWith(String name) {
		BufferedReader reader;
		try {
			reader = new BufferedReader(new FileReader(new File("Server/" + this.getFirmaName() + "/Mitarbeiter/" + this.getName() + "/geteilte.txt")));
			String currentLine;
		    while((currentLine = reader.readLine()) != null) {
		    	String[] arr = currentLine.split("/");
		    	System.out.println(arr[3]);
		    	if(arr[3].equals(name)) {
		    		reader.close();
		    		return true;
		    	}
		    }
		    reader.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
	    } catch (IOException e) {
			e.printStackTrace();
		}
		return false;
	}
}
