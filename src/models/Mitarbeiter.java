package models;

public class Mitarbeiter {
	private String name;
	private String vorname;
	private String passwort;
	private int id;
	private String[] abteilungen; //Durch HashMap mit (id, Abteilung) ersetzen
	
	public Mitarbeiter(String name) {
		this.name = name;
	}
	
	public Mitarbeiter(int id, String name, String vorname, String passwort) {
		this.id = id;
		this.name = name;
		this.vorname = vorname;
		this.passwort = passwort;
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
}
