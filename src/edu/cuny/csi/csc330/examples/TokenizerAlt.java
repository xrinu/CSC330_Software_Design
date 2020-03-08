package edu.cuny.csi.csc330.examples;

public class TokenizerAlt {

	public TokenizerAlt() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		String record = "smith,john,M,819-18-1178,02/17/1985"; 
		
		if(args.length > 0 ) {
			record = args[0];
		}
		
		String [] fields = record.split(","); 
		
		for(String field : fields) {
			System.out.println(field);
		}

	}

}
