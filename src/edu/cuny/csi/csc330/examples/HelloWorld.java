/**
 * THIS IS A COMMENT BLOCK
 * CUNY/CSI CSC 330 WEEK 1 - EXAMPLE 1
 */

// ALWAYS INCLUDE A PACKAGE DESIGNATION 
package edu.cuny.csi.csc330.examples;  // Naming convention ....

// Required Classes Used by  HelloWorld that are Outside current package 
import java.util.Date;

// DEFINE A CLASS - ONE PER FILE 
public class HelloWorld {  // Naming Convention - 'Pascal Case' 

	/**
	 * main() is always the entry point of a program ... 
	 * Can't run class as stand-alone program without it 
	 */
	public static void main(String[] args) {
		// Date Class/Object - current date/time
		Date today = new Date(); 
		// Display a message to standard output 
		System.out.println("Hello, World! Today is: " + today); 
	
	} // END OF MAIN 

}  // END OF CLASS DEFINITION 
