package edu.cuny.csi.csc330.examples2;

import java.io.IOException;;

public class ClearScreen {

	public ClearScreen() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) throws IOException {
		
		System.out.println("Bla bla bla ....!");

		// For Windows 
		Runtime.getRuntime().exec("cls");
		
		//  OR for Linux or Mac 
		Runtime.getRuntime().exec("clear");

	}

}
