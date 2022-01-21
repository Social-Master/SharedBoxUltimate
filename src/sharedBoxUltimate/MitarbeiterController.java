package sharedBoxUltimate;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

import models.Abteilung;
import models.Mitarbeiter;

public class MitarbeiterController {
	Mitarbeiter model;
	public MitarbeiterController(Mitarbeiter model) {
		this.model = model;
	}
	public Set<File> getUserFiles(String s) {
		File userDir = new File(model.getUserPath() + s);
		Set<File> out = new HashSet<File>();
		for(File f : userDir.listFiles()) {
			if(!f.isDirectory()) {
				out.add(f);
			}
		}
		return out;
	}
	public Set<File> getUserDirs(String s) {
		File userDir = new File(model.getUserPath() + s);
		Set<File> out = new HashSet<File>();
		for(File f : userDir.listFiles()) {
			if(f.isDirectory()) {
				out.add(f);
			}
		}
		return out;
	}
	public Set<File> getAbteilungFiles() {
		return null;
	}
	
	public String getUserFilesAsString(String s) {
		String out = "";
		File userDir = new File(model.getUserPath() + s);
		for(File f : userDir.listFiles()) {
			if(!f.isDirectory()) {
				out += f.getName() + " "; 
			}
		}
		return out;
	}
	public String getUserDirsAsString(String s) {
		String out = "";
		File userDir = new File(model.getUserPath() + s);
		for(File f : userDir.listFiles()) {
			if(f.isDirectory()) {
				out += f.getName() + " "; 
			}
		}
		return out;
	}
	public void addAbteilung(Abteilung in) {
		File config = new File("Server/" + model.getFirma() + "/Mitarbeiter/" + model.getName() + "/userinfo.csv"); //Hier gehts weiter
		BufferedWriter bw = null;
		BufferedReader reader = null;
		
		try {
			reader = new BufferedReader(new FileReader(config));
			String rawLine = reader.readLine();
			reader.close();
			String[] arr = rawLine.split(",");
			if(arr[5].equals("none")) {
				FileWriter fw = null;
				try {
					fw = new FileWriter(config);
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				bw = new BufferedWriter(fw);
				bw.write(model.getId() + "," + model.getName() + "," + model.getVorname() + "," + model.getPasswort() + "," + "Server/" + model.getName() + "/Mitarbeiter/" + model.getName() + "/Files" + "," + in.getName() + ";");
				bw.close();
			}
			else {
				String[] abtArr = arr[5].split(";");
				FileWriter fw = null;
				try {
					fw = new FileWriter(config);
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				bw = new BufferedWriter(fw);
				bw.write(model.getId() + "," + model.getName() + "," + model.getVorname() + "," + model.getPasswort() + "," + "Server/" + model.getName() + "/Mitarbeiter/" + model.getName() + "/Files" + "," + arr[5] + in.getName() + ";");
				bw.close();
				
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
