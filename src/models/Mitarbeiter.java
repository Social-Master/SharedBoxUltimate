package models;

public class Mitarbeiter {
	private String name;
	private String vorname;
	private String passwort;
	private int id;
	private String[] abteilungen; //Durch HashMap mit (id, Abteilung) ersetzen
	
	public Mitarbeiter(int id, String name, String vorname, String passwort) {
		this.id = id;
		this.name = name;
		this.vorname = vorname;
		this.passwort = passwort;
	}
}
