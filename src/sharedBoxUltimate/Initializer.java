package sharedBoxUltimate;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.BufferedReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

import controller.FirmaController;
import controller.MitarbeiterController;
import models.Abteilung;
import models.Firma;
import models.Mitarbeiter;

@SuppressWarnings("unused")
public class Initializer {
	
	public static HashMap<Firma, FirmaController> firmen = new HashMap<Firma, FirmaController>();
	
	public Initializer() {
		
	}
	
	public void readFirmen() {
		File[] dirs = new File("Server").listFiles(File::isDirectory);
		for (File datei : dirs) {
			Firma temp = new Firma(datei.getName());
			FirmaController tempcont = new FirmaController(temp);
			firmen.put(temp, tempcont);
			
			File[] abteilungDirs = new File("Server/" + datei.getName() + "/Abteilungen").listFiles(File::isDirectory);
			for(File abteilungFile : abteilungDirs) {
				Abteilung abt = new Abteilung(abteilungFile.getName());
				temp.addAbteilung(abt);
			}
			File[] mitarbeiterDirs = new File("Server/" + datei.getName() + "/Mitarbeiter").listFiles(File::isDirectory);
			for(File mitarbeiterFile : mitarbeiterDirs) {
				Mitarbeiter temp2;
				temp2 = parseMitarbeiterFile(new File(mitarbeiterFile.getPath() + "/userinfo.csv"));
				parseAbteilungFile(new File(mitarbeiterFile.getPath() + "/abteilung.csv"), temp2);
				temp.addUser(temp2);
			}
		}
	}
	private Mitarbeiter parseMitarbeiterFile(File datei) {
		BufferedReader reader;
		Mitarbeiter mit = null;
		try {
			reader = new BufferedReader(new FileReader(datei));
			String rawLine = reader.readLine();
			reader.close();
			String[] arr = rawLine.split(",");
			if(arr[6].equals("false")) {
				mit = new Mitarbeiter(Integer.parseInt(arr[0]),arr[1], arr[2], arr[3], arr[4], arr[5], false);
			}
			else if(arr[6].equals("true")) {
				mit = new Mitarbeiter(Integer.parseInt(arr[0]),arr[1], arr[2], arr[3], arr[4], arr[5], true);
			}
			else {
				mit = new Mitarbeiter(Integer.parseInt(arr[0]),arr[1], arr[2], arr[3], arr[4], arr[5], false);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return mit;
	}
	private void parseAbteilungFile(File datei, Mitarbeiter mit) {
		BufferedReader reader;
		try {
			reader = new BufferedReader(new FileReader(datei));
			String rawLine = reader.readLine();
			reader.close();
			String[] arr = rawLine.split(",");
			FirmaController f = Initializer.firmen.get(this.getFirmaByName(mit.getFirmaName()));
			MitarbeiterController c = new MitarbeiterController(mit);
			for(int i = 0; i < arr.length; i++) {
				if(!arr[i].equals("null")) {
					c.addAbteilung(f.getAbteilungByName(arr[i]));
				}
			}
		}
		catch(Exception e) {
			System.out.println("ERROR while parsing Abteilungen. Maybe this Firma has no Abteilungen?");
		}
		
	}
	public void printFirmen() {
		for(Firma a : firmen.keySet()) {
			System.out.println(a.getName());
		}
	}
	public static void createFirma(String name) {
		File firmaDir = new File("Server/" + name);
		if(!firmaDir.exists()) {
			firmaDir.mkdir();
			new File(firmaDir.getPath() + "/Mitarbeiter").mkdir();
			new File(firmaDir.getPath() + "/Abteilungen").mkdir();
			Firma neu = new Firma(name);
			firmen.put(neu, new FirmaController(neu));
		}
	}
	public static Firma getFirmaByName(String name) {
		Set<Firma> bla = Initializer.firmen.keySet();
		for(Firma blabla : bla) {
			if(blabla.getName().equalsIgnoreCase(name)) {
				return blabla;
			}
		}
		return null;
	}
	public static FirmaController getFirmaControllerByName(String name) {
		Set<Firma> bla = Initializer.firmen.keySet();
		for(Firma blabla : bla) {
			if(blabla.getName().equalsIgnoreCase(name)) {
				return Initializer.firmen.get(blabla);
			}
		}
		return null;
	}
}