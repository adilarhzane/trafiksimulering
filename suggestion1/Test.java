import static java.lang.System.*;
public class Test {
    public static void main(String [] args) {
	// Skapar ett TrafficSystem
	// Utför stegningen, anropar utskriftsmetoder
	Lane lan = new Lane(10);
	Car car = new Car(1, 1);
	lan.putLast(car);
	lan.step();
	lan.step();
	String s = lan.toString();
	System.out.println(s);
      
    }
}

