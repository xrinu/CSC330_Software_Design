package edu.cuny.csi.csc330.examples2;

import java.io.File;
import java.io.IOException;

public class FilePathTester {

	public static void main(String[] args) {
		File file = new File("./poke.gif"); 
		
		System.out.printf("Path = %s\n" ,file.getPath());
		System.out.printf("Absolute Path = %s\n" ,file.getAbsolutePath());
		try {
			System.out.printf("Canoical Path = %s\n" , file.getCanonicalPath());
		}
		catch(IOException ioex) {
			System.err.println(ioex);
		}
		
	}

}
