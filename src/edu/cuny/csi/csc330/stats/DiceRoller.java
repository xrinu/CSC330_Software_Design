/**
 * This class models the act of rolling a pair of 6-sided dice. 
 * Goal:  demonstrate that when rolling fair dice, 
 * the most likely sum  is 7 - since 7 has the most number of die value
 * combinations that add to 7 (six!)  6/36 = 1/6 = 16.6% 
 * There's also a 1/6 chance that we roll double values.  
 * 1,1 2,2 3,3 4,4 5,5 6,6  
 * 
 * Hypothesis: show that increasingly larger samples of 
 * Dice rolls will show a more consistent % of 7-sum and doubles outcomes,
 * that is, very close to 16.6%  
 * 
 * Sample sets 10, 50, 100, 500, 1000, 5000, 10000, 50000, 100000, 500000 ...
 * perform each sample set multiple times ... 
 */
package edu.cuny.csi.csc330.stats;

public class DiceRoller {
	
	private static final int LARGEST_SAMPLE = 500000;
	private static final int SAMPLE_SET_TESTS = 3;
	
	private Die [] dice; 
	private Thread [] rollThreads; 
	
	private int [] counts; 
	private int count;
	
	private void init() {
		counts = new int[13]; 
		
		dice = new Die[2]; 
		rollThreads = new Thread[2]; 
		
		dice[0] = new Die();
		dice[1] = new Die();

	}
	
	private void reset() { 
		count = 0;
		for(int i = 0 ; i < counts.length ; ++i )
			counts[i] = 0;
	}

	public DiceRoller() {
		init();
	}
	
	public void roll() {
		
		rollThreads[0] = new Thread(dice[0]);
		rollThreads[1] = new Thread(dice[1]);
		
		rollThreads[0].start();
		rollThreads[1].start();
		
		try {
			rollThreads[0].join();
			rollThreads[1].join();
		} 
		catch(InterruptedException ex) {
			System.err.println(ex);
		}
		
		capture();
	}
	
	private void capture() {
		int sum = dice[0].getRoll() + dice[1].getRoll();
		counts[sum]++;
		
		if(dice[0].getRoll() == dice[1].getRoll()) {
			counts[0]++;
		}
		else {
			counts[1]++;
		}
		++count;
		
	}

	private void show() {
		 System.out.printf("[%d] [%d]\n", dice[0].getRoll(), dice[1].getRoll() );
	}
	

	private void sample(int samples) {
		reset();
		//System.out.println("In sample()");
		for(int i = 0 ; i < samples ; ++i) {
			roll(); 
		}
		
	}
	
	private void displayReport() {
		
		String fmt = "[[%2d]]\t%,7d\t%7.2f%%\n";
		
		System.out.printf("============ %,d DICE ROLLS ======================\n", count);
		
		for(int i = 2 ; i < counts.length ; ++i)  {
			System.out.printf(fmt, i, counts[i], (float) ((float)counts[i]/count)*100);
		}
		System.out.printf("\n[[%s]]\t%,7d\t%7.2f%%\n", "DOUBLE", counts[0], 
				(float) ((float)counts[0]/count)*100);
		
		System.out.printf("\n[[%s]]\t%,7d\t%7.2f%%\n", "SINGULAR", counts[1], 
				(float) ((float)counts[1]/count)*100);
		
		System.out.printf("===================================================\n\n");
		
		System.out.flush();
		
	}

	public static void main(String[] args) {
		DiceRoller roller = new DiceRoller();
		
		/*
			roller.roll();  
			roller.show();
			
			roller.roll();  
			roller.show();
		*/
			
		for(int i = 10,  j = 1; i <= LARGEST_SAMPLE ;  j++) {	
			for(int k = 0 ; k < SAMPLE_SET_TESTS ; ++k) {
				roller.sample(i);
				roller.displayReport();
			}

			if(j % 2 == 1) 
				i *= 5;
			else 
				i *= 2;
		}
		
		System.out.println("Exiting ...");
	}

}
