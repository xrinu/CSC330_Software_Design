/**
 *  This is yet another example of using Exceptions ... but this class:
 *  1) is quite functional/useful
 *  2) shows how a layers in a "method call stack" have a choice - 
 *                  catch/handle the Exception or throw the Exception to the calling method. 
 *  
 */

package edu.cuny.csi.csc330.net;

import java.io.*;
import java.net.*;
import java.util.*;

public class WebPageGetter {  
	 
	    /** This method does the actual GET
	     * @param theUrl The URL to retrieve
	     * @param fileName the local file to save to
	     * @exception IOException
	     */
	    public void getPage(String theUrl, String fileName) throws IOException
	    {
	    
	            URL gotoUrl = new URL(theUrl);
	            InputStreamReader isr = new InputStreamReader(gotoUrl.openStream());
	            BufferedReader inStream = new BufferedReader(isr);
	 
	            StringBuffer buffer = new StringBuffer();
	            String inputLine;
	           
	            //grab the contents at the URL
	            while ((inputLine = inStream.readLine()) != null){
	                buffer.append(inputLine   +  "\n");
	            }
	            //write it locally
	            createAFile(fileName, buffer.toString());
	            
	            System.out.printf("Wrote %d characters to %s\n", buffer.length(), fileName );
	            
	        
	    }
	 
	    //creates a local file
	    /** Writes web page / URL content to a local file 
	     *
	     * @param outfile the file to write to
	     * @param content the contents of the file
	     * @exception IOException
	     */
	    public static void createAFile(String outfile, String content) throws IOException {
	    	
	        FileOutputStream fileoutputstream = new FileOutputStream(outfile);
	        DataOutputStream dataoutputstream = new DataOutputStream(fileoutputstream);
	        dataoutputstream.writeBytes(content);
	        dataoutputstream.flush();
	        dataoutputstream.close();
	        
	    }
	 
	    /** The main method.
	     */
	    public static void main(String[] args)  {
	    	
	    	int exitCode = 0; 
	    	
	    	
	        if (args.length != 2) {
	        	
	            System.out.println("WebPageGetter Usage: java <full-package-name>.WebPageGetter URL localfilename");
	            System.out.println("Example: WebPageGetter http://www.google.com  C:/tmp/index.html");
	            exitCode = 1; 
	            
	        }
	        else {
		      
		        try {
		        	WebPageGetter httpGetter = new WebPageGetter();
		            httpGetter.getPage(args[0], args[1]);
		        }
		        catch (IOException ex) {
		            ex.printStackTrace();
		            exitCode = 2; 
		        }
		        catch (Exception ex) {
		            ex.printStackTrace();
		            exitCode = 9; 
		        }
		        
	        }
	        
	        System.exit(exitCode); 	        
	        
	 
	    }

}
