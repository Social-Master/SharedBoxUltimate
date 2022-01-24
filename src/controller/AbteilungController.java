package controller;

import java.io.File;
import java.io.IOException;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
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

	public void uploadFile(File in) {
		try {
			Files.copy(in.toPath(), new File("Server/" + mit.getFirmaName() + "/Abteilungen/" + model.getName() + "/" + in.getName()).toPath(), StandardCopyOption.REPLACE_EXISTING);
			Logger.log(mit, "Uploaded " + in.getName(), new File("Server/" + mit.getFirmaName() + "/Abteilungen/" + model.getName()));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public void deleteFileByName(String name) {
		File del = new File("Server/" + mit.getFirmaName() + "/Abteilungen/" + model.getName() + "/" + name);
		del.delete();
		Logger.log(mit, "Deleted " + name, new File("Server/" + mit.getFirmaName() + "/Abteilungen/" + model.getName()));
	}
	public void copyFileByName(String src, String dest) {
		File srcFile = new File("Server/" + mit.getFirmaName() + "/Abteilungen/" + model.getName() + "/" + src);
		File destFile = new File("Server/" + mit.getFirmaName() + "/Abteilungen/" + model.getName() + "/" + dest);
		try {
			Files.copy(srcFile.toPath(), destFile.toPath());
			Logger.log(mit, "Copied " + srcFile.getPath() + " to " + destFile.getPath(), new File(destFile.getParent()));
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
			Logger.log(mit, "Moved " + srcFile.getPath() + " to " + destFile.getPath(), new File(destFile.getParent()));
		} catch (FileAlreadyExistsException e) {
			System.out.println("Die Datei existiert bereits! Überspringe...");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
