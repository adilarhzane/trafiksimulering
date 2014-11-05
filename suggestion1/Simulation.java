import java.util.*;
import java.io.*;
public class Simulation {
  
    public static void main(String [] args) {
	// Skapar ett TrafficSystem
	// Utför stegningen, anropar utskriftsmetoder
	int intensity = 3;
	int period = 10;
	int greenTime = 6;
	int r0 = 30;
	int r1 = 10;
	int r2 = 10;
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
		    System.out.println("Enter the length of the runup road: ");
		    r0 = Integer.parseInt(scanner.nextLine());
		    i++;
		case 5:
		    System.out.println("Enter length of svängfil: ");
		    r2 = Integer.parseInt(scanner.nextLine());
		    r1 = r2;
		    return;
		
	    }	
	
	


	   
	   
	
	
		}catch (NumberFormatException e){
		System.out.println("Try entering a number");
	       
	    }

	    
	}
	Trafficsystem s = new Trafficsystem(r0, r1, period, greenTime, intensity);

	
	
    }
}
