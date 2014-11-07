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
    public static void main(String [] args) {
	// Skapar ett TrafficSystem
	// Utför stegningen, anropar utskriftsmetoder
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
	

		
	cycles = readNumber(scanner, "how many cycles?");
	intensity = readNumber(scanner, "intensity?");
	period = readNumber(scanner, "What period would you want to use?");
	greenTime = readNumber(scanner, "what green time would you want to use for the straight row?");
	greenTime2 = readNumber(scanner, "What green time would you like to use for the turn lane?");
	r0 = readNumber(scanner, "what length would you like for the runup road?");
	r2 = readNumber(scanner, "what length would you like for the turn lane?");
	r1 = r2;
	System.out.println("The simulation is starting");
		
        
	    
	    
	
	Trafficsystem s = new Trafficsystem(r0, r1, period, greenTime, greenTime2, intensity);
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
