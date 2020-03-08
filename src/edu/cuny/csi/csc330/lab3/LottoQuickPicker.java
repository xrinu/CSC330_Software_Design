/**
 * LAB 3 -  Lotto QuickPicker Game 
 */
package edu.cuny.csi.csc330.lab3;

import java.util.*;

import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter.DEFAULT;

import edu.cuny.csi.csc330.util.Randomizer;

public class LottoQuickPicker {
	
	// constants  specific to current game - BUT NOT ALL GAMES 
	public final static int DEFAULT_GAME_COUNT = 1; 
	private final static String GAME_NAME = "LOTTO"; 
	private final static int SELECTION_POOL_SIZE = 59; 
	private final static int SELECTION_COUNT = 6; 
    private int [][] lotoTicket;
    private int games;
    public static final String STORE_NAME = "ISLAND DELI";
   
    
	public LottoQuickPicker() {
		init(DEFAULT_GAME_COUNT); 
	}
	
	public LottoQuickPicker(int games) {
		init(games); 
	}
  

	private void init(int games) {
		
		
		this.games = games;
		
	}
	
	
	
public void generateInt()
{
	
	//array to hold random numbers:
	lotoTicket = new int [games][SELECTION_COUNT];
	int randomNumber=0;
	boolean match = false;
	
	//generate six random numbers:
	
	for(int i =0; i < games; i++)
	{
		for(int j= 0; j < SELECTION_COUNT; j++)
		{
			randomNumber = Randomizer.generateInt(1, SELECTION_POOL_SIZE);
		
		//check if random number is in array already
		for(int k =0; k< SELECTION_COUNT; k++)
		{
			if(randomNumber == lotoTicket[i][k])
			{
				match = true;				
			}
			else
			{
				match = false;
			}
			
			//if new random number isn't in array, put number in array
			if(match != true)
			{
				lotoTicket[i][j] = randomNumber;
				
			}
				
		}
	}
		Arrays.sort(lotoTicket[i]);
}
	
}

	/**
	 * 
	 */
	public void displayTicket() {
		
		/**
		 * display heading 
		 * 
		 * for i in gameCount 
		 * 		generate selectionCount number of unique random selections in ascending order 
		 * 
		 * display footer 
		 */
		
			
		// display ticket heading 
		displayHeading(); 
		
		
		
		/**
		 * Display selected numbers 
		 */
		for(int i = 0; i < lotoTicket.length; i++)
		{
			//display number of games
			System.out.printf("(%2d)" , i+1);
					
			for(int j = 0; j< SELECTION_COUNT; j++)
			{
				
				System.out.printf(" %02d ", lotoTicket[i][j]);						
			}
			
			System.out.println();
		}
		
	
		// display ticket footer 
		displayFooter(); 
		
		return;
	}
	
	protected void displayHeading() {
		
		System.out.println("----------------------------");
		System.out.println("-----------" + GAME_NAME + "------------");
		Date currentDate = new Date();
		
		System.out.println(currentDate);
		System.out.println();
				
	}
	
	protected void displayFooter() {
		System.out.println();
		 System.out.println("------ (C)" + STORE_NAME + "------");
		 System.out.println("----------------------------");
		 
		
	}
		
	/**
	 * 
	 * @return
	 */
	/**private long calculateOdds() {
 
		
		return 0;
	}*/
  

	/**
	 * @param args 
	 */
	public static void main(String[] args) {
		// takes an optional command line parameter specifying number of QP games to be generated
		//  By default, generate 1  
		int numberOfGames  = DEFAULT_GAME_COUNT; 
		
		if(args.length > 0) {  // if user provided an arg, assume it to be a game count
			numberOfGames = Integer.parseInt(args[0]);  // [0] is the 1st element!
		}
		
		LottoQuickPicker lotto = new LottoQuickPicker(numberOfGames);
		// now what 
		
		lotto.init(7);
		lotto.generateInt();
	
		 
		lotto.displayTicket(); 
		
		// COMMENT THIS OUT WHEN YOU'RE DONE ... 
		//System.out.println("Leaving ...");

	}

}
