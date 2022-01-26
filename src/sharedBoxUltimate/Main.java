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
		
		Initializer.createFirma("Twitter", "twitter.com");
		Initializer.createFirma("Reddit", "reddit.com");
		
		FirmaController bla = Initializer.getFirmaControllerByName("twitter");
		bla.createMitarbeiter(1, "Heimbrodt", "Sten", "heimbrodt@twitter.com", "passwort1");
		bla.createMitarbeiter(2, "Muhabbek", "Adam", "muhabbek@twitter.com", "passwort2");
		bla.createMitarbeiter(3, "Alex", "Muster", "alex.muster@twitter.com", "1234");
		bla.createMitarbeiter(4, "Kim", "Beispiel", "kbeispiel@twitter.com", "1111");
		bla.createMitarbeiter(5, "Sam", "Noel", "noel_sam@twitter.com", "kekse");
		bla.createAbteilung("Development");
		bla.createAbteilung("Research");
		//bla.getFirma().printMitarbeiter();
		
		Initializer.getFirmaByName("twitter").getMitarbeiterByName("Heimbrodt").setOp(true);
		LoginView loginview = new LoginView();		// Creates a new Loginview window. More about this window, see the comments in Loginview.java
		loginview.loginviewGo();
		
		
		
	}
	
	public static void initFileStructure() {
		File serverFolder = new File("Server");
		if(!serverFolder.exists()) {
			serverFolder.mkdir();
		}
	}
}
