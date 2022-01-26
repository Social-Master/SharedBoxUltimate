package controller;

import java.io.File;
import java.io.IOException;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import models.Abteilung;
import models.Mitarbeiter;
import sharedBoxUltimate.Logger;

public class AbteilungController {
	Abteilung model;
	Mitarbeiter mit;
	
	public AbteilungController(Abteilung model, Mitarbeiter mit) {
		this.model = model;
		this.mit = mit;
	}

	public void uploadFile(File in, String dest) {
		try {
			Files.copy(in.toPath(), new File("Server/" + mit.getFirmaName() + "/Abteilungen/" + model.getName() + "/" + dest + "/" + in.getName()).toPath(), StandardCopyOption.REPLACE_EXISTING);
			Logger.log(this.mit, "Uploaded " + in.getName(), new File("Server/" + mit.getFirmaName() + "/Abteilungen/" + model.getName() + "/" + dest));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public void deleteFileByName(String name) {
		File del = new File("Server/" + mit.getFirmaName() + "/Abteilungen/" + model.getName() + "/" + name);
		if(del.isDirectory()) {
			deleteFolder(del);
			Logger.log(this.mit, "Deleted " + name, new File("Server/" + mit.getFirmaName() + "/Abteilungen/" + model.getName() + "/" + name));
		}
		else {
			del.delete();
			Logger.log(this.mit, "Deleted " + name, new File("Server/" + mit.getFirmaName() + "/Abteilungen/" + model.getName() + "/" + name));
	
		}
	}
	public void deleteFolder(File folder) {
	    File[] files = folder.listFiles();
	    if(files != null) {
	        for(File f: files) {
	            if(f.isDirectory()) {
	                deleteFolder(f);
	            } else {
	                f.delete();
	            }
	        }
	    }
	    folder.delete();
	}
	public void copyFileByName(String src, String dest) {
		File srcFile = new File("Server/" + mit.getFirmaName() + "/Abteilungen/" + model.getName() + "/" + src);
		File destFile = new File("Server/" + mit.getFirmaName() + "/Abteilungen/" + model.getName() + "/" + dest);
		try {
			if(srcFile.isDirectory()) {
				Files.copy(srcFile.toPath(), destFile.toPath());
				for(File f : srcFile.listFiles()) {
					Files.copy(f.toPath(), new File("Server/" + mit.getFirmaName() + "/Abteilungen/" + model.getName() + "/" + dest + "/" + f.getName()).toPath());
					Logger.log(this.mit, "Copied " + srcFile.getPath() + " to " + destFile.getPath(), new File(destFile.getParent()));
				}
			}
			else {
				Files.copy(srcFile.toPath(), destFile.toPath());
				Logger.log(this.mit, "Copied " + srcFile.getPath() + " to " + destFile.getPath(), new File(destFile.getParent()));
			}
		} catch (FileAlreadyExistsException e) {
			System.out.println("Die Datei existiert bereits! Überspringe...");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public void moveFileByName(String src, String dest) {
		File srcFile = new File("Server/" + mit.getFirmaName() + "/Abteilungen/" + model.getName() + "/" + src);
		File destFile = new File("Server/" + mit.getFirmaName() + "/Abteilungen/" + model.getName() + "/" + dest);
		try {
			Files.move(srcFile.toPath(), destFile.toPath());
			Logger.log(this.mit, "Copied " + srcFile.getPath() + " to " + destFile.getPath(), new File(destFile.getParent()));
		} catch (FileAlreadyExistsException e) {
			System.out.println("Die Datei existiert bereits! Überspringe...");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public void renameFile(String src, String name) {
		File srcFile = new File("Server/" + mit.getFirmaName() + "/Abteilungen/" + model.getName() + "/" + src);
		File destFile = new File(srcFile.getParent() + "/" + name);
		try {
			Files.move(srcFile.toPath(), destFile.toPath());
			Logger.log(this.mit, "Copied " + srcFile.getPath() + " to " + destFile.getPath(), new File(destFile.getParent()));
		} catch (FileAlreadyExistsException e) {
			System.out.println("Die Datei existiert bereits! Überspringe...");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public void uploadDir(File in, String dest) {
		try {
			Files.walk(Paths.get(in.getAbsolutePath())).forEach(source -> { Path destination = Paths.get("Server/" + mit.getFirmaName() + "/Abteilungen/" + model.getName() + "/" + dest + "/" + in.getName(), source.toString().substring(in.getAbsolutePath().length()));
				try {
					Files.copy(source, destination);
					Logger.log(this.mit, "Uploaded " + source.toFile().getAbsolutePath() + " to " + destination.toFile().getAbsolutePath(), new File("Server/" + mit.getFirmaName() + "/Abteilungen/" + model.getName() + "/" + dest));
				} catch(FileAlreadyExistsException e) {
					System.out.println("Dieser Ordner existiert bereits!");
				} catch(IOException e) {
					e.printStackTrace();
				} 
			});
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
