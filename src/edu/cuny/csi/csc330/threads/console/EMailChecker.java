package edu.cuny.csi.csc330.threads.console;

import java.util.Random;


public class EMailChecker implements Runnable {

	private static final int LIMIT = 16;
	private static final int WAIT_STEP = 8;
	private static final String YOUVE_GOT_MAIL = "You've got mail!";
	private static final String NO_MAIL = "Empty Inbox";
	
	private Random random; 


	public EMailChecker() {
		random = new Random(); 
	}
	

	@Override
	public void run() {
		int count = 1;
		while(count++ < LIMIT) { 
			System.out.printf( "%50s %s%n", " ", getEmailStatus()  ); 
			SystemUtility.pause(WAIT_STEP); 
		}
	}


	private String getEmailStatus() {
		String timestamp = SystemUtility.generateDateTime();
		int rand = random.nextInt(); 
		return (rand % 2) == 0 ? timestamp + ": " + YOUVE_GOT_MAIL : timestamp + ": " + NO_MAIL; 
	}


}
