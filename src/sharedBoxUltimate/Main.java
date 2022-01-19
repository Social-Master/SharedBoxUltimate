package sharedBoxUltimate;

import java.io.File;
import java.util.Set;

import models.Firma;
import models.Mitarbeiter;

public class Main {
	public static void main(String[] args) {
		initFileStructure();
		
		FirmenInitializer b = new FirmenInitializer();
		b.readFirmen();

		b.createFirma("Twitter");
		b.createFirma("Reddit");
		
		FirmaController bla = b.getFirmaControllerByName("twitter");
		bla.createMitarbeiter(1, "Heimbrodt", "Sten", "passwort1");
		bla.createMitarbeiter(2, "Muhabbek", "Adam", "passwort2");
		bla.createAbteilung("Development");
		bla.createAbteilung("Research");
		
		Firma twitter = b.getFirmaByName("twitter");
		twitter.printMitarbeiter();
		twitter.printAbteilungen();
	}
	
	public static void initFileStructure() {
		File serverFolder = new File("Server");
		if(!serverFolder.exists()) {
			serverFolder.mkdir();
		}
	}
}
