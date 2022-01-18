package sharedBoxUltimate;

import java.io.File;
import java.util.HashSet;
import java.util.Set;

public class FirmenInitializer {
	
	public static Set<Firma> firmen = new HashSet<Firma>();
	
	public FirmenInitializer() {
		
	}
	
	public void readFirmen() {
		File[] dirs = new File("/Users/stenh/eclipse-workspace/SharedBoxUltimate/bin/sharedBoxUltimate/Server").listFiles(File::isDirectory);
		for (File datei : dirs) {
			//System.out.println(datei.getName());
			Firma temp = new Firma(datei.getName());
			FirmaController tempcont = new FirmaController(temp);
			firmen.add(temp);
		}
	}
	public void printFirmen() {
		for(Firma a : firmen) {
			System.out.println(a.getName());
		}
	}
}