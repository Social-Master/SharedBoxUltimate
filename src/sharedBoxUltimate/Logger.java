package sharedBoxUltimate;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Date;

import models.Mitarbeiter;

public class Logger {
	public static void log(Mitarbeiter mit, String operation, File path) {
		if(path.isDirectory()) {
			File logfile = new File(path.getPath() + "/" + path.getName() + ".log");
			String logText = "[" + new Date().toString() + "] User " + mit.getName() + "-> " + operation + "\n";
			if(logfile.exists()) {
				try {
				    Files.write(logfile.toPath(), logText.getBytes(), StandardOpenOption.APPEND);
				} catch (IOException e) {
				    System.out.println("LOGGING ERROR");
				}
			}
			else {
				try {
					Files.write(logfile.toPath(), logText.getBytes(), StandardOpenOption.CREATE_NEW);
				}
				catch (IOException e) {
					System.out.println("LOGGING ERROR");
				}
			}
		}
		
	}

}
