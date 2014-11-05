import static java.lang.System.*;
public class Test {
    public static void main(String [] args) {
	// Skapar ett TrafficSystem
	// Utför stegningen, anropar utskriftsmetoder
	
       	Trafficsystem s = new Trafficsystem(30, 10, 10, 6, 3);
	for(int i = 0; i<100;i++){
	    s.step();
	    s.print();
	}
	s.printStatistics();
    }
}

