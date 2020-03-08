package edu.cuny.csi.csc330.scratch;

public class CharCounter {



	// Using functional paradigm 
	public static void main(String[] args) {
		String myString = "a.b.c.d.e.f.g";
		long count = myString.chars().filter(charCount -> charCount == '.').count();
		System.out.printf("'.' Count: %d%n", count);
	}

}
