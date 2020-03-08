package edu.cuny.csi.csc330.threads.bq;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.concurrent.BlockingQueue;

/**
 * Reads from file, parsing line-by-line - each line becomes entry in the Queue
 * 
 * @author lji
 *
 */
public class Producer implements Runnable {
	
	public static final String END_OF_FILE = "_END_OF_FILE_";

	private BlockingQueue<String> queue;
	private String fileName;

	private int debug;

	public Producer(String fileName, BlockingQueue queue) {
		this.fileName = fileName; 
		this.queue = queue;
		init();
	}


	private void init() {
		debug = 0;
		String debugFlag = System.getProperty("DEBUG");
		if("yes".equalsIgnoreCase(debugFlag))
			debug = 1;
	}


	public void fetchData() {

		try {
			FileReader fileReader = new FileReader(fileName);
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			String line;
			int count = 0;
			while ((line = bufferedReader.readLine()) != null) {
				if(debug == 1 && count < 200)
					System.out.println("Producer: " + count++);
				queue.put(line);
			}
			
			queue.put(END_OF_FILE);
			
			fileReader.close();

		} 
		catch (IOException ex) {
			System.err.println(ex);
		}
		catch (InterruptedException ex) {
			System.err.println(ex);
		}

		return;
	}


	@Override
	public void run() {
		fetchData(); 
	}

}
