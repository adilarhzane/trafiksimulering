import static org.junit.Assert.*;
import org.junit.Test;
import java.io.*;
import java.util.Scanner;

public class SimulationTest {

	@Test
	public void Test_readNumber(){
		ByteArrayInputStream in = new ByteArrayInputStream("100".getBytes());
		System.setIn(in);
		Scanner scanner = new Scanner(System.in);
		assertEquals("test: scanner = 100", (Simulation.readNumber(scanner, "test1")), 100);
	}
	@Test
	public void Test_car_or_bike(){
		ByteArrayInputStream in = new ByteArrayInputStream("1".getBytes());	
		ByteArrayInputStream in2 = new ByteArrayInputStream("2".getBytes());	
		ByteArrayInputStream in3 = new ByteArrayInputStream("3".getBytes());	
		System.setIn(in);
		Scanner scanner = new Scanner(System.in);
		assertEquals("input = 1", (Simulation.car_or_bike(scanner) ), 1);
		System.setIn(in2);
		Scanner scanner2 = new Scanner(System.in);
		assertEquals("input = 2", (Simulation.car_or_bike(scanner2)), 2);

	}
	

}


