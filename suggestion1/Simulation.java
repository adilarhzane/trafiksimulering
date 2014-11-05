import java.util.*;
import java.io.*;
public class Simulation {
  
    public static void main(String [] args) {
	// Skapar ett TrafficSystem
	// Utför stegningen, anropar utskriftsmetoder
	int intensity;
	int period;
	int greenTime;
	int r0;
	int r1;
	int r2;
	Scanner scanner = new Scanner(System.in);
	int i = 1;
	boolean j = true;
	
	while(j){
	    try{
		switch(i){
		
		case 1: 	    
		    System.out.println("Enter car spawn intensity: ");
		    intensity = Integer.parseInt(scanner.nextLine());
		    i++;
		case 2: 
		    System.out.println("Enter period: ");
		    period = Integer.parseInt(scanner.nextLine());
		    i++;
		
		case 3: 
		    System.out.println("Enter green time: ");
		    greenTime = Integer.parseInt(scanner.nextLine());
		    i++;
		case 4:
		    System.out.println("Enter the length of the whole road: ");
		    r0 = Integer.parseInt(scanner.nextLine());
		    i++;
		case 5:
		     System.out.println("Enter length of svängfil: ");
		     r2 = Integer.parseInt(scanner.nextLine());
		     i++;
	    }	
	/*
	


	   
	    r1 = r2;
	    r0 = r0-r2;
	*/
	
		}catch (NumberFormatException e){
		System.out.println("Try entering a number");
	       
	    }
	    
	}
    }
}
