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
	int cycles = 100;
	Scanner scanner = new Scanner(System.in);
	int i = 0;
	boolean j = true;
	
	while(j){
	    loop:
	    try{
		switch(i){
		case 0: System.out.println("How many seconds would you like to run the simulation?");
		    cycles = Integer.parseInt(scanner.nextLine());
		    i++;
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
		    System.out.println("The simulation is starting in:");
		    System.out.println("\n      3");
		    System.out.println("\n      2");
		    System.out.println("\n      1");
		    break loop;
		    
		}	
	
	


	   
	   
	
	
		}catch (NumberFormatException e){
		System.out.println("Try entering a number");
	       
	    }

	    j=false;;
	}
	Trafficsystem s = new Trafficsystem(r0, r1, period, greenTime, intensity);
	for(int o = 0;o<cycles;o++){
	    s.step();
	    s.print();

	}
	s.printStatistics();
	
	
    }
}
