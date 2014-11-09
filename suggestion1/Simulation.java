import java.util.*;
import java.io.*;
public class Simulation {
    //GET REKT
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
	intensity = readNumber(scanner, "intensity? (1 car in every X second).");
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
