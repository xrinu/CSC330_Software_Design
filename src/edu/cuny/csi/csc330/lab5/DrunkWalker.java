package edu.cuny.csi.csc330.lab5;

import java.math.*;
import java.util.*;


public class DrunkWalker {
	
	private Intersection startIntersection;
	private Intersection currentIntersection;

	
	// !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!  
	// add other data members here including Collection instances that you will use to 
	//  to track history and statistics ... 

	private DrunkWalker() {
		init();
	}
	
	/**
	 * 
	 * @param avenue
	 * @param street
	 */
	public DrunkWalker(int avenue, int street) {	
		init();
	}
	
	private void init() {
		// What should be do here to initialize an instance?? 
	}
	
	/**
	 * step in a random direction 
	 */
	public void step() {
		
		takeAStep(); 
		
		/**  !!!!!!!!!!!!!!!!!!!!!!!!!!!
		 * Now, update the Collections that manage the following:
		 * 
		 *  1) add this next step/intersection to a "history" List that will contain the sequence of all 
		 *  steps taken by this DrunkWalker instance 
		 *  
		 *  2) add this next step to a Intersection -> Counter Map ... The Map 
		 *  Collection can and should be of Generics "Type" <Intersection, Integer> 
		 *  key = Intersection 
		 *  value = Count Value  
		 *  Need to do something like this: 
		 *  if intersection is not saved in Map yet as a key yet, add a key->value pair of Intersection->1 
		 *  else if intersection value is there, the existing key->value pair need to be replaced as 
		 *   Intersection->existing_count+1 
		 *   
		 */
	}
	
	
	private void takeAStep() {
		Direction dir = Direction.NONE.getNextRandom(); 
		
		/** !!!!!!!!!!!!!!!!!!!!!!!!!!!!!
		 * now what do we do based on the random Direction created? 
		 * How do we go about updating the "currentIntersection" instance to reflect the 
		 * direction/step that was just selected? 
		 */
		
		
	}


	/** !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
	 * toString() 
	 * @return
	 */
	



	/**
	 * generate string that contains current intersection/location info 
	 */
	public String getLocation() {
		// !!!!!!!!!!!!!!!!!  
		/**
		return String.format("Current location: DrunkWalker [avenue=%d, street=%d]", 
				currentIntersection.getAvenue(), currentIntersection.getStreet() );
		*/
		return  null;  
	}

	/**
	 * Take N number of steps 
	 * @param steps
	 */
	public void fastForward(int steps ) {
		// Considering that we already have a step() method, how would we 
		//  implement this method?  Uhh, think reuse!  
	}
	
	/**
	 * Display information about this current walker instance 
	 */
	public void displayWalkDetails() {
		/**
		 * This method needs to display the following information in a neat, readable format 
		 * using calls to System.out.println() or System.out.printf()
		 * 
		 * 1 - starting location 
		 * 2 - current/ending location 
		 * 3 - distance (value returned by howFar() ) 
		 * 4 - number of steps taken - which collection would be able to provide that information, and how?  
		 * 5 - number of unique intersections visited - 
		 * 		which collection would be able to provide that information, and how? 
		 * 6 - Intersections visited more than once 
		 * 
		 */
		
		
		
		
		
	}
	
	/**
	 * X Y Coordinate distance formula 
	 *  |x1 - x2| + |y1 - y2|   
	 * @return
	 */
	public int howFar() {
		/** |x1 - x2| + |y1 - y2|.
		startAvenue = x1 
		avenue = x2 
		startStreet = y1 
		street = y2 
	 
		return (Math.abs(startAvenue - avenue) ) + (Math.abs(startStreet - street)); 
		 * 
		 */
		
		return 0; 
	}


	public static void main(String[] args) {
		
		// create Drunkard with initial position (ave,str)
		DrunkWalker billy = new DrunkWalker(6,23);
		
		for(int i = 1 ; i <= 3 ; ++i ) {
			billy.step(); 
			System.out.printf("billy's location after %d steps: %s\n",
					i, billy.getLocation() );
		}
			
		
		// get his current location
		String location = billy.getLocation();
		// get distance from start
		int distance = billy.howFar();
		System.out.println("Current location after fastForward(): " + location);
		System.out.println("That's " + distance + " blocks from start.");
		

		// have him move 25  random intersections
		billy.fastForward(25);
		billy.displayWalkDetails();

	}

}
