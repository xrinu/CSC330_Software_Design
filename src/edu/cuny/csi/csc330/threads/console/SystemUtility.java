package edu.cuny.csi.csc330.threads.console;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

public class SystemUtility {

	private SystemUtility() { }
	
	public static void pause(int seconds) {
		try {
		    Thread.sleep(seconds * 1000); //  Thread.sleep works in milliseconds .... 
		} 
		catch(InterruptedException ex) {
		    ;
		}
	}
	
	
	public static String generateDateTime() {
		
		Date now = new Date(); 
		Locale locale = new Locale("en", "EN");
		DateFormat timeFormat = DateFormat.getTimeInstance(DateFormat.DEFAULT, locale);
		String time = timeFormat.format(now);
		DateFormat dateFormat = DateFormat.getDateInstance(DateFormat.DEFAULT, locale);
		String date = dateFormat.format(now);
		
		return date + " " + time;
	}
	
	public static void main(String[] args) {
		 System.out.println(generateDateTime() );
		 pause(2);
		 System.out.println(generateDateTime() );
		 
	}
	
		 

}
