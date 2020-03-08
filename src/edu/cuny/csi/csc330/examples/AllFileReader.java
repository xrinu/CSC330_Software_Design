package edu.cuny.csi.csc330.examples;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class AllFileReader {

	protected static String readFileAsString(String fileName) {
		
		String text = "";
		try {
			text = new String(Files.readAllBytes(Paths.get(fileName)));
		} catch (IOException e) {
			e.printStackTrace();
		}

		return text;
	}
	
	protected  static StringBuffer readFileAsStringBuffer(String fileName) {
		StringBuffer buffer = new StringBuffer(); 
		buffer.append( readFileAsString(fileName) );
		return buffer; 
	}


	public static void main(String[] args) {
		StringBuffer content = readFileAsStringBuffer("C://tmp//AntAction.txt"); 
		System.out.println(content.length());
		
		String data = readFileAsString("C://tmp//AntAction.txt"); 
		String [] records = data.split("\n");
		System.out.printf("Read %d Records%n", records.length);
		
		int maxFields = 0;
		String biggest = "";
		for(String record : records ) {
			String [] fields = record.split(" ");
			if(maxFields < fields.length) {
				biggest = record; 
				maxFields = fields.length; 
			}
			
		}
		
		System.out.printf("Records with most amount (%d) of fields\n", maxFields);
		System.out.println(biggest);
	}

}
