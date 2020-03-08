package edu.cuny.csi.csc330.regex;

public class Splitter{
	   public static void main(String args[]){
		String s = " ,ab;gh,bc;pq#kk$bb";
		String[] str = s.split("[,;#$]", 10);
			
		//Total how many substrings? The array length
		System.out.println("Number of substrings: "+str.length);
			
		for (int i=0; i < str.length; i++) {
			System.out.println("Str["+  i  +  "]:"+str[i]);
		}
	   }
	}