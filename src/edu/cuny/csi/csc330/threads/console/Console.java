package edu.cuny.csi.csc330.threads.console;

public class Console implements Runnable {

	private static final int LIMIT = 25;
	private static final int WAIT_STEP = 5;
	private static final String TIME_MESSAGE = "CURRENT_TIME: ";

	public Console() {
		  
	}

	@Override
	public void run() {
		int count = 1;
		while(count++ < LIMIT) { 
			System.out.println( TIME_MESSAGE + SystemUtility.generateDateTime() ); 
			SystemUtility.pause(5); 
		}
	}


}
