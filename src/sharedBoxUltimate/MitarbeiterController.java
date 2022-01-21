package sharedBoxUltimate;

import java.io.File;
import java.util.HashSet;
import java.util.Set;

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
}
