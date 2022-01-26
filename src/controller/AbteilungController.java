/**
 * This is the Main controller class for the Abteilung model. From here big modifications on the model will be executed. 
 */
package controller;

import java.io.File;
import java.io.IOException;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import javax.swing.JOptionPane;

import models.Abteilung;
import models.Mitarbeiter;
import sharedBoxUltimate.Logger;

public class AbteilungController {
	Abteilung model;
	Mitarbeiter mit;
	
	/**
	 * Just the basic references to work with.
	 */
	public AbteilungController(Abteilung model, Mitarbeiter mit) {
		this.model = model;
		this.mit = mit;
	}
	/**
	 * This function is the basic upload function. All files uploaded will uploaded straight to the Abteilung path plus the relative path given by the String dest
	 * @param in
	 * @param dest
	 */
	public void uploadFile(File in, String dest) {
		long fs = 0;
		try{
		fs = Files.size(in.toPath())/(1024*1024);
		} catch (IOException e) {
			e.printStackTrace();
		}
		if(fs > 5) {
			JOptionPane.showMessageDialog(null, "Die Datei überschreitet die Maximalgröße von 5 MB.", "Dateigröße Überschritten", JOptionPane.WARNING_MESSAGE);
			return;
		}
		if(countSize(Paths.get("Server/" + mit.getFirmaName() + "/Abteilungen/" + model.getName()))/(1024*1024) + fs > 25) {
			JOptionPane.showMessageDialog(null, "Der Upload würde die Speicherplatzbegrenzung von 25 MB überschreiten.", "Speicherplatzbegrenzung Überschritten", JOptionPane.WARNING_MESSAGE);
			return;
		}
	
		try {
			Files.copy(in.toPath(), new File("Server/" + mit.getFirmaName() + "/Abteilungen/" + model.getName() + "/" + dest + "/" + in.getName()).toPath(), StandardCopyOption.REPLACE_EXISTING);
			Logger.log(this.mit, "Uploaded " + in.getName(), new File("Server/" + mit.getFirmaName() + "/Abteilungen/" + model.getName() + "/" + dest));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * This function deletes the file at the given path at the current Abteilung path
	 * @param name
	 */
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
	/**
	 * This is the recursive function to delete a folder with all its contents
	 * @param folder
	 */
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
	/**
	 * Copies a file from the relative src path to the relative dest path. It is relative to the Abteilung path
	 * @param src
	 * @param dest
	 */
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
	/**
	 * Same as the copy function but it realizes a move
	 * @param src
	 * @param dest
	 */
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
	/**
	 * Renaming is just a fancy move
	 * @param src
	 * @param name
	 */
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
	/**
	 * Uploads a whole directory. For that it uses the Java.nio package and Files.walk.
	 * @param in
	 * @param dest
	 */
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
	
	/**
	* Returns the sum of the size of all Files in a given directory.
	* @param dir
	* @return s
	*/
	public long countSize(Path dir) {
		long s = 0;
		for(File i : dir.toFile().listFiles()) {
			if(Files.isRegularFile(i.toPath())) {
				try {
					s += Files.size(i.toPath());
				} catch (IOException e) {
					e.printStackTrace();
				}
			} 
			else if(Files.isDirectory(i.toPath())) {
				s += countSize(i.toPath());
			}
		}
		return s;
	}
}
