package arcane.sunku.engine.utilities;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.URISyntaxException;
import java.util.Scanner;

public class Files {
	
	public static File loadFile(String fileName) {
		try {
			return new File(Files.class.getResource("/assets/" + fileName).toURI());
		} catch (URISyntaxException e) {
			System.err.printf("Util::ERR Couldn't load file \"%s\"\n", fileName);
			return null;
		}
	}
	
	@SuppressWarnings("resource")
	public static void readFile(String file) {
		try {
			Scanner sc = new Scanner(loadFile(file));
			
			while(sc.hasNextLine()) {
				System.out.println(sc.next());
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

}
