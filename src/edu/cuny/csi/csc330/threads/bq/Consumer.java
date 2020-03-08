package edu.cuny.csi.csc330.threads.bq;

import java.util.Set;
import java.util.TreeSet;
import java.util.concurrent.BlockingQueue;

/**
 * Reads from queue and performs "data analysis" 
 * @author lji
 *
 */
public class Consumer implements Runnable {
	
	private BlockingQueue<String> queue;
	
	private Set<String> uniqueWords; 
	private int wordCount;
	private int smallestWordSize;  
	private int largestWordSize; 
	private String smallestWord;
	private String largestWord;
	
	private int debug; 
	

	public Consumer(BlockingQueue queue) {
		this.queue = queue;
		init(); 
	}

	private void init() {
		uniqueWords = new TreeSet<String>(); 
		smallestWordSize = Integer.MAX_VALUE; 
		largestWordSize = Integer.MIN_VALUE; 
		
		debug = 0;
		String debugFlag = System.getProperty("DEBUG");
		if("yes".equalsIgnoreCase(debugFlag))
			debug = 1;
		
	}

	@Override
	public void run() {
		 try {
			 parse(); 
		 }
		 catch(InterruptedException ex) {
			 System.err.println(ex);
		 }

	}

	// parse line 
	private void parse() throws InterruptedException { 
		String line; 
		while((line = queue.take()) != Producer.END_OF_FILE) {
			String[] words = line.split("\\s+");
			for(String word : words) {
				if(debug == 1 && this.wordCount < 200)
					System.out.println("Consumer: " + this.wordCount);
				parse(word);
			}
		}
	}

	// parse word 
	private void parse(String word) {
		int len = word.length(); 
		wordCount++; 
		uniqueWords.add(word); 
		if(len > largestWordSize ) {
			largestWordSize = len;
			largestWord = word; 
		}
		if(len < smallestWordSize ) {
			smallestWordSize = len; 
			smallestWord = word; 
		}	
		
	}

	public Set<String> getUniqueWords() {
		return uniqueWords;
	}

	@Override
	public String toString() {
		return "Consumer [queue=" + queue + ", wordCount=" + wordCount
				+ ", smallestWordSize=" + smallestWordSize
				+ ", largestWordSize=" + largestWordSize + ", smallestWord="
				+ smallestWord + ", largestWord=" + largestWord
				+ ", getUniqueWordCount()=" + getUniqueWordCount() + "]";
	}

	public void setUniqueWords(Set<String> uniqueWords) {
		this.uniqueWords = uniqueWords;
	}

	public int getWordCount() {
		return wordCount;
	}

	public void setWordCount(int wordCount) {
		this.wordCount = wordCount;
	}

	public int getSmallestWordSize() {
		return smallestWordSize;
	}

	public void setSmallestWordSize(int smallestWordSize) {
		this.smallestWordSize = smallestWordSize;
	}

	public int getLargestWordSize() {
		return largestWordSize;
	}

	public void setLargestWordSize(int largestWordSize) {
		this.largestWordSize = largestWordSize;
	}

	public String getSmallestWord() {
		return smallestWord;
	}

	public void setSmallestWord(String smallestWord) {
		this.smallestWord = smallestWord;
	}

	public String getLargestWord() {
		return largestWord;
	}

	public void setLargestWord(String largestWord) {
		this.largestWord = largestWord;
	}

	public BlockingQueue<String> getQueue() {
		return queue;
	}
	
	public int getUniqueWordCount() {
		return  uniqueWords.size();
	}

	public void reset() {
		uniqueWords.clear();
		wordCount = 0;
		smallestWordSize = Integer.MAX_VALUE; 
		largestWordSize = Integer.MIN_VALUE; 
		smallestWord = "";
		largestWord = ""; 
		
	}

}
