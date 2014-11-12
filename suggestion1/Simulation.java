import java.util.*;
import java.io.*;

/**
 * Simulation Runs the traffic simulation by taking inputs, creating a trafficsystem using the trafficsystem constructor.
 * Then it just runs the given amount of steps and prints the system after each step.
 */
public class Simulation {
    /**
     * shows a given message and returns user input
     * @param scanner By requiering a scanner parameter we do not need to create a new scanner every time we run the function.
     * @param message a string message that is meant to ask for a specific number input.
     * @return the int number given by the user.
     */
    public static int readNumber(Scanner scanner, String message){
	int a;
	while(true){
	    try{System.out.println(message);
		a = Integer.parseInt(scanner.nextLine());
		break;
	    }
	    catch (NumberFormatException e){
		System.out.println("Try entering a number");
		
	    }
	}
	return a;
    }
    /**
     * Lets the user enter 1 or 2, which represents what vehicle we want to run the simulation with.
     * @param scanner By requiering scanner as an input we do not need to create a new scanner every time.
     * @return int 1 or 2, where 1 = Car and 2 = Bike.
     */
      public static int  car_or_bike(Scanner scanner){
	  System.out.println("Cars(1) or Bikes(2)?");
	  int i = Integer.parseInt(scanner.nextLine());
	  while(true){
	      try{
		  if (i == 1 || i == 2){
		      return i;
		  }
		  else{
		      car_or_bike(scanner);
		      
		  }
		  break;
	      
	      }
	      catch (NumberFormatException e){
		  System.out.println("Try entering a number");
		  
	      }
	  }
	  
	  return i;
      }
    /**
     * The main function takes user input and uses the inputs to create a trafficsystem which is stepped as many times as the user wants.
     */
    public static void main(String [] args) {
	// Skapar ett TrafficSystem
	// Utför stegningen, anropar utskriftsmetoder
	int vehicle = 1;
	int intensity = 3;
	int period = 10;
	int greenTime = 6;
	int greenTime2 = 6;
	int r0 = 30;
	int r1 = 10;
	int r2 = 10;
	int cycles = 100;
	Scanner scanner = new Scanner(System.in);
	int i = 0;
	

	vehicle = car_or_bike(scanner);
	cycles = readNumber(scanner, "how many cycles?");
	intensity = readNumber(scanner, "intensity? (1 vehicle in every X second).");
	period = readNumber(scanner, "What period would you want to use?");
	greenTime = readNumber(scanner, "what green time would you want to use for the straight row?");
	greenTime2 = readNumber(scanner, "What green time would you like to use for the turn lane?");
	r0 = readNumber(scanner, "what length would you like for the runup road?");
	r2 = readNumber(scanner, "what length would you like for the turn lane?");
	r1 = r2;
	System.out.println("The simulation is starting");
		
        
	    
	    
	
	Trafficsystem s = new Trafficsystem(vehicle,r0, r1, period, greenTime, greenTime2, intensity);
	for(int o = 0;o<cycles;o++){
	    s.step();
	    s.print();
	    try
		{Thread.sleep(50);
		}catch (InterruptedException e)
		{
		    e.printStackTrace();
		}

	}
	
	s.printStatistics();
	
	
    }
}
