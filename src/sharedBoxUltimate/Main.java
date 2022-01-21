package sharedBoxUltimate;

import java.io.File;

import models.Abteilung;
import models.Mitarbeiter;

public class Main {
	public static void main(String[] args) {
		initFileStructure();
		
		FirmenInitializer b = new FirmenInitializer();
		b.readFirmen();

		FirmenInitializer.createFirma("Twitter");
		FirmenInitializer.createFirma("Reddit");
		
		FirmaController bla = b.getFirmaControllerByName("twitter");
		bla.createMitarbeiter(1, "Heimbrodt", "Sten", "passwort1");
		bla.createMitarbeiter(2, "Muhabbek", "Adam", "passwort2");
		bla.createAbteilung("Development");
		bla.createAbteilung("Research");
		
		
		Mitarbeiter loggedin = bla.loginMitarbeiter("Heimbrodt", "passwort1");
		MitarbeiterController loggedincont = new MitarbeiterController(loggedin);
		loggedincont.addAbteilung(bla.getAbteilungByName("Research"));
		loggedincont.addAbteilung(bla.getAbteilungByName("Development"));
		
	}
	
	public static void initFileStructure() {
		File serverFolder = new File("Server");
		if(!serverFolder.exists()) {
			serverFolder.mkdir();
		}
	}
}
