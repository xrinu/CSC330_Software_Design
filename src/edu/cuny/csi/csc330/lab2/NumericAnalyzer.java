package edu.cuny.csi.csc330.lab2;

import java.util.Arrays;
import java.lang.Math;
	
	public class NumericAnalyzer {

		private int [] numbers; 
		private int size; 
		private int minimum; 
		private int maximum; 
		private int median; 
		private int mean; 
		private int sum; 
		private int range; 
		private int variance; 
		private double stdDeviation; 
		
		public NumericAnalyzer(int [] numbers) 
		{
			//sort the array:
			this.numbers = numbers; 
			Arrays.sort(this.numbers);
		}
			
		// return the size:
		public int sizeOf( ) 
		{			
			return size = numbers.length; 				
		}
		
		// return the smallest number
		public int minValue() 
		{			
			return numbers[0];			
		}
		
		// return the largest number
		public int maxValue() 
		{		
			return numbers[numbers.length-1];   
		}
		
		// return the sum:
		public int findSum() 
		{
			for(int i =0; i < numbers.length; i++) 
			{
				sum += numbers[i]; 
			}		
			return sum;
			
		}
		
		
		//find the mean of the array
		public int meanValue()
		{
			int sum = 0; 
		
				for (int i =0; i < numbers.length; i++) 
				{
					sum += numbers[i]; 
				}
			
				mean = sum / numbers.length; 
			
			return mean; 
			
		}
		
		
		//return the median:
		public int findMedian() 
		{
				
				int size = numbers.length; 
				size /= 2; 
				median =  numbers[size]; 
				
			return median;		
		}
			
		//return range:
		public int findRange() 
		{		
			range = maxValue() - minValue(); 		
			return range; 
		}
		
		//return variance:
		public int calcVariance() 
		{
						 
			  int result = 0;    
			 
			// find the distance from mean the for each number & ^2
				for (int i =0; i < numbers.length; i++) 
				{
					result += (int)Math.pow(numbers[i]-mean ,2 ); 
				}
				
			variance = result/size; 				
			return variance; 
			
		}
		
		//return standard deviation:
		public double findStdDeviation() 
		{
			stdDeviation = (int)Math.sqrt(variance);			
			return stdDeviation;
		}
		
		
		//function that calls every function to calculate each result:
		public void calculate() 
		{
			size = sizeOf();
			minimum = minValue(); 
			maximum = maxValue(); 	
			range = findRange();
			sum = findSum();
			mean = meanValue(); 
			median = findMedian(); 
			variance = calcVariance(); 
			stdDeviation = findStdDeviation(); 
			
		}
		
		//to display the result:
		public void display() 
		{
			System.out.println(" ");
			System.out.printf("%-20s%10d %n", "Size:", size);
			System.out.printf("%-20s%10d %n","Min:", minimum);
			System.out.printf("%-20s%10d %n","Max:" , maximum);
			System.out.printf("%-20s%10d %n","Range:",range);
			System.out.printf("%-20s%10d %n","Sum:",sum);
			System.out.printf("%-20s%10d %n","Mean:",mean);
			System.out.printf("%-20s%10d %n","Median:", median);
			System.out.printf("%-20s%10d %n","Variance:",variance);
			System.out.printf("%-20s%10.2f %n","Standard Deviation:",stdDeviation);
			
		}
		
		
		public static void main(String[] args) {
			
			// check to see if any arguments are passed in
			if (args.length==0) 
			{				
				System.err.println("Error! Please pass in one or more integer argument.");
				System.exit(1);
			} 
			
			//create an int array
			int [] numbers = new int [args.length];
			
			for (int i = 0; i < args.length; i++) {
				numbers[i] = Integer.parseInt(args[i]);
			}
		
			NumericAnalyzer  numAnalyzer = new NumericAnalyzer(numbers); 
			
			for (int i =0; i < args.length; i++) 
			{
				
				System.out.printf("%6d", numbers[i]);
			}			
			
			
			numAnalyzer.calculate();
			numAnalyzer.display();
			
			System.out.println("\nNumeric analysis completed!");
			
		}


	}

