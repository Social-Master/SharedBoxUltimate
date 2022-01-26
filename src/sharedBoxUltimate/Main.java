/**
 * This is the starting class. From here everything begins and gets Initialized
 */
package sharedBoxUltimate;

import java.io.File;

import controller.AbteilungController;
import controller.FirmaController;
import controller.MitarbeiterController;
import models.Abteilung;
import models.Mitarbeiter;
import views.LoginView;

@SuppressWarnings("unused")
public class Main {
	
	public static Mitarbeiter user;
	
	public static void main(String[] args) {
		initFileStructure();
		
		Initializer b = new Initializer();
		b.readFirmen();
		Initializer.getFirmaByName("twitter").getMitarbeiterByName("Heimbrodt").setOp(true);
		LoginView loginview = new LoginView();		// Creates a new Loginview window. More about this window, see the comments in Loginview.java
		loginview.loginviewGo();
		
		/*Initializer.createFirma("Twitter", "twitter.com");
		Initializer.createFirma("Reddit", "reddit.com");
		
		FirmaController bla = b.getFirmaControllerByName("twitter");
		bla.createMitarbeiter(1, "Heimbrodt", "Sten", "heimbrodt@twitter.com", "passwort1");
		bla.createMitarbeiter(2, "Muhabbek", "Adam", "muhabbek@twitter.com", "passwort2");
		bla.createAbteilung("Development");
		bla.createAbteilung("Research");
		bla.getFirma().printMitarbeiter();
		*/
	}
	
	public static void initFileStructure() {
		File serverFolder = new File("Server");
		if(!serverFolder.exists()) {
			serverFolder.mkdir();
		}
	}
}
