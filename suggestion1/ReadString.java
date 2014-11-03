import java.io.*;

public class ReadString {

    public static void main (String[] args){

	System.out.print("Enter arrival intensity: ");
	BufferedReader intensity = new BufferedReader(new InputStreamReader(System.in));
	int intensity = 0;

	System.out.print("Enter period time: ");
	BufferedReader period = new BufferReader(new InputStreamReader(System.in));
	int period = 0;
    
	System.out.print("Enter green light time: ");
	BufferedReader greenTime = new BufferReader(new InputStreamReader(System.in));
	int greenTime = 0;

	System.out.print("Enter length of big road: ");
	BufferedReader r0 = new BufferReader(new InputStreamReader(System.in));
	int r0 = 0;

	System.out.print("Enter length of turn road ");
	BufferedReader r2 = new BufferReader(new InputStreamReader(System.in));
	int r2 = 0;

	try{

	    intensity = intensity.readLine();
	    period = period.readLine();
	    greenTime = greenTime.readLine();
	    r0 = r0.readLine();
	    r2 = r2.readLine();
	   
	}catch (IOException ioe){

	    System.out.println("Error reading value");
	}catch (NumberFormatException e){
	    
	    System.out.println("Not a digit");
	
	}
    }

    /*
    public static Boolean convert(String con){

	for(int i = 0; i < con.length(); i++){
	    
	    char s = con.charAt(0);
	    if (!Character.isLetter(s)){
		return false;
	    }
	    
	}
	return true;
	}  */
  
}
