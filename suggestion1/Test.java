import static java.lang.System.*;
public class Test {
    public static void main(String [] args) {
	// Skapar ett TrafficSystem
	// Utför stegningen, anropar utskriftsmetoder
	Lane lan = new Lane(10);
	Light light = new Light(8, 4);
	Car car = new Car(1, 1);
	lan.putLast(car);
	lan.step();
	light.step();
	lan.step();
	light.step();
	lan.step();
	light.step();
	lan.step();
	light.step();
	lan.step();
	light.step();
	lan.step();
	light.step();
	lan.step();
	light.step();
	System.out.println(car.toString());
	System.out.println(light.toString());
	
	if(light.isGreen()){
	    System.out.println("\n Traffic light is green");
	}
	String s = lan.toString();
	System.out.println(s);
      
    }
}

