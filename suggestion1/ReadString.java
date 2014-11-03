import java.io.*;
import java.util.*;

public class ReadString {

    int intensity;
    int period;
    int greenTime;
    int r0;
    int r1;
    int r2;
    public ReadString(){
	Scanner scanner = new Scanner(System.in);
	try {
	    System.out.println("Enter car spawn intensity: ");
	    intensity = scanner.nextInt();
	    System.out.println("Enter period: ");
	    period = scanner.nextInt();
	    System.out.println("Enter green time: ");
	    greenTime = scanner.nextInt();
	    System.out.println("Enter the length of the whole road: ");
	    r0 = scanner.nextInt();
	    System.out.println("Enter length of svängfil: ");
	    r2 = scanner.nextInt();
	    r1 = r2;
	    r0 = r0-r2;
	
	}catch(InputMismatchException e){
	    System.out.println("\ntry entering a Digit");
	}
    }
	
    public int getIntensity(){
	return intensity;
    }
    
    public int getPeriod(){
	return period;
    }
    public int getGreenTime(){
	return greenTime;
    }
	
    public int getR0(){
	return r0;
    }

    public int getR1(){
	return r1;
    }

    public int getR2(){
	return r2;
    }
    	
	
    /*
      System.out.print("Enter arrival intensity: ");
      BufferedReader intensity = new BufferedReader(new InputStreamReader(System.in));
      int intensity2 = 0;

      System.out.print("Enter period time: ");
      BufferedReader period = new BufferReader(new InputStreamReader(System.in));
      int period2 = 0;
    
      System.out.print("Enter green light time: ");
      BufferedReader greenTime = new BufferReader(new InputStreamReader(System.in));
      int greenTime2 = 0;

      System.out.print("Enter length of big road: ");
      BufferedReader r0 = new BufferReader(new InputStreamReader(System.in));
      int r02 = 0;

      System.out.print("Enter length of turn road ");
      BufferedReader r2 = new BufferReader(new InputStreamReader(System.in));
      int r2 = 0;
	
      try{

      // intensity2 = Integer.parseInt();
      // period2 = Integer.parseInt(period.toString());
      //greenTime2 = Integer.parseInt(greenTime.toString());
      //r02 = Integer.parseInt(r0.toString());
      //r22 = Integer.parseInt(r2.toString());
	   
      }catch (IOException ioe){

      System.out.println("Error reading value");
      }catch (NumberFormatException e){
	    
      System.out.println("Not a digit");
	
      }*/


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
