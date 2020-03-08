package edu.cuny.csi.csc330.lab1;


public class ChessBoard {
	
	//for empty square:
	static private  final char EMPTY = '\u25AD'; 
	
	private static final int ROWS = 8; 
	private static final int COLS = 8; 
		
	private static final String HEADING = 
			"-----------------------------------------\n"
			+ "        UNICODE SYMBOLS CHESSBOARD\n" 
			+ "-----------------------------------------\n";
	
	//create an array for chess board:
	private static final char boardArray[][] = { 
			{'\u2656','\u2658','\u2657','\u2655','\u2654','\u2657','\u2658', '\u2656'},
			{'\u2659','\u2659', '\u2659','\u2659','\u2659','\u2659','\u2659','\u2659'},
			{EMPTY,EMPTY,EMPTY,EMPTY,EMPTY,EMPTY,EMPTY,EMPTY},
			{EMPTY,EMPTY,EMPTY,EMPTY,EMPTY,EMPTY,EMPTY,EMPTY},
			{EMPTY,EMPTY,EMPTY,EMPTY,EMPTY,EMPTY,EMPTY,EMPTY},
			{EMPTY,EMPTY,EMPTY,EMPTY,EMPTY,EMPTY,EMPTY,EMPTY},
			{'\u265F','\u265F','\u265F','\u265F','\u265F','\u265F','\u265F','\u265F'},
			{'\u265C','\u265E','\u265D','\u265E','\u265B','\u265D','\u265E','\u265C'},				
	};
		
	static private void displayHeading() {
		System.out.print(HEADING);
	}
	
	private static void displayBoard() 
	{
		//to print chess board:
		for(int row = ROWS - 1 ; row >= 0  ; --row ) 
		{		
			
			//to go to next line after each row:
			System.out.print('\n');			
			System.out.print(row+1);		
			System.out.print("    ");
			
			for(int col = COLS - 1; col>=0; --col)
			{
				//to print chess pieces:
				System.out.printf("%C", boardArray[row][col]);
				System.out.print("     ");
			} 		 
		}		
	}
	
	// Only Public Method Used Directly By main() 
	static public void display() {
		displayHeading(); // display heading 
		displayBoard(); 
	}

	public static void main(String[] args) {
		// invoke display method 
		ChessBoard.display(); 		
	}
	
}