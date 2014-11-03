import java.io.*;


public class ReadString {

    public static void main (String[] args){

	System.out.print("Enter your name: ");

	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	String userName = null;


	try{

	    userName = br.readLine();
	
	}catch (IOException ioe){
	    System.out.println("Error reading your name:");
	    System.exit(1);

	}
	
	System.out.println("Nice name: " + userName);
    }
    
}
