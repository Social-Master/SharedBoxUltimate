package sharedBoxUltimate;

import java.io.File;

import controller.AbteilungController;
import controller.FirmaController;
import controller.MitarbeiterController;
import models.Abteilung;
import models.Mitarbeiter;

@SuppressWarnings("unused")
public class Main {
	
	public static Mitarbeiter user;
	
	public static void main(String[] args) {
		initFileStructure();
		
		Initializer b = new Initializer();
		b.readFirmen();
		
		//irmaController bla = b.getFirmaControllerByName("twitter");
		//MitarbeiterController cont = new MitarbeiterController(bla.getFirma().getMitarbeiterByName("heimbrodt"));
		//MitarbeiterController cont2 = new MitarbeiterController(bla.getFirma().getMitarbeiterByName("muhabbek"));
		//cont.shareDirectory(bla.getFirma().getMitarbeiterByName("muhabbek"));
		//for(File f : cont2.getSharedFiles()) {
		//	System.out.println(f.getName());
		//}
		
		
		LoginView loginview = new LoginView();		// Creates a new Loginview window. More about this window, see the comments in Loginview.java
		loginview.loginviewGo();

		/*Initializer.createFirma("Twitter");
		Initializer.createFirma("Reddit");
		
		FirmaController bla = b.getFirmaControllerByName("twitter");
		bla.createMitarbeiter(1, "Heimbrodt", "Sten", "heimbrodt@uni-potsdam.de", "passwort1");
		bla.createMitarbeiter(2, "Muhabbek", "Adam", "muhabbek@uni-potsdam.de", "passwort2");
		bla.createAbteilung("Development");
		bla.createAbteilung("Research");
		bla.getFirma().printMitarbeiter();
		
		
		Mitarbeiter loggedin = bla.loginMitarbeiter("Heimbrodt", "passwort1");
		MitarbeiterController loggedincont = new MitarbeiterController(loggedin);
		loggedincont.addAbteilung(bla.getAbteilungByName("Research"));
		loggedincont.addAbteilung(bla.getAbteilungByName("Development"));
		loggedincont.setOp(true);
		loggedincont.uploadDir(new File("/Users/stenh/wildes"), "wildes");
		loggedincont.uploadFile(new File("/Users/stenh/x.pdf"), "");
		loggedincont.copyFileByName("x.pdf", "x1.pdf");
		loggedincont.moveFileByName("x1.pdf", "x2.pdf");
		//loggedincont.deleteFileByName("x.pdf");
		AbteilungController abtcont = new AbteilungController(loggedincont.getAbteilungByName("Research"), loggedin);
		abtcont.uploadFile(new File("/Users/stenh/x.pdf"));
		for(File f : loggedincont.getUserFiles("wildes")) {
			System.out.println(f.getName());
		}*/
	}
	
	public static void initFileStructure() {
		File serverFolder = new File("Server");
		if(!serverFolder.exists()) {
			serverFolder.mkdir();
		}
	}
}
