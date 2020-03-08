package edu.cuny.csi.csc330.stats;

import edu.cuny.csi.csc330.util.Randomizer;

public class Die  implements Runnable {
	protected static final int SIDES = 6; 
	protected int roll;

	@Override
	public void run() {
		// TODO Auto-generated method stub
		roll = Randomizer.generateInt(1, SIDES);
	}

	public int getRoll() {
		return roll;
	} 
	
	
	
}