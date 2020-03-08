/**
 * Overall task: read in a very large text file 
 * and track certain detail/statistics about the content of that file ... 
 * 
 * CONSIDER THE FOLLOWING: 
 * break up the job into two fundamental steps: 
 *   1) reading content from the file 
 *   2) parse content [from a buffer] and derive detail info 
 */
package edu.cuny.csi.csc330.threads.bq;

import java.util.Date;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class TextFileAnalyzer {
	
	protected final static String DEFAULT_FILE_NAME = "C://tmp//CSC330//Beatles.txt";
	
	// data members 
	private BlockingQueue<String> queue;
	private Producer producer;
	private Consumer consumer;


	public TextFileAnalyzer() {
		init(); 
	}

	/**
	 * create critical structure 
	 * - shared queue 
	 * - producer comp 
	 * - consumer comp 
	 */
	private void init() {
		queue = new LinkedBlockingQueue<String>();
		producer = new Producer(DEFAULT_FILE_NAME, queue); 
		consumer = new Consumer(queue); 
	}
	
	
	private void reset() {
		queue.clear(); // should already be empty if job terminated correctly 
		consumer.reset();
	}


	/**
	 * perform main job with multiple threads  ... 
	 */
	private void analyze() {	
		System.out.println("Threaded Starting Work: " + new Date() );
		Thread pthread = new Thread(producer);
		Thread cthread = new Thread(consumer);
		
		pthread.start();
		cthread.start(); 
		
		// Block further execution until both consumer and producer are done ... 
		try { 
			pthread.join();
			cthread.join();
		}
		catch(InterruptedException ex) {
			System.err.println(ex);
		}
		
		displayStats();
		System.out.println("Finished Work: " + new Date() + "\n");
	}
	
	/**
	 * perform main job WITHOUT threads  ... 
	 */
	private void analyzeNoThread() {
		System.out.println("Non Threaded - Starting Work: " + new Date() );
		producer.run();
		consumer.run();
		displayStats();
		System.out.println("Finished Work: " + new Date() + "\n");
		
	}

	/**
	 * Unformatted report - use Consumer's toString ... 
	 */
	private void displayStats() {
		 System.out.println("Consumer State: " + consumer);
	}

	/**
	 * Kick off Producer and Consumer processing that 
	 * each share the BlockingQueue ... 
	 * @param args
	 */
	public static void main(String[] args) {
		 
		TextFileAnalyzer tester = new TextFileAnalyzer(); 
		
		tester.analyzeNoThread();
		tester.reset();
		tester.analyze(); 

	}




}
