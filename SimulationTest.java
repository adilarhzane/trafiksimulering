import static org.junit.Assert.*;
import org.junit.Test;
import java.io.*;
import java.util.Scanner;


public class SimulationTest {
	//this function allows any number input, character input is take care of by asking the user to try again, which is hard to test.
	@Test
	public void Test_readNumber() {
		ByteArrayInputStream in = new ByteArrayInputStream("100".getBytes());
		System.setIn(in);
		Scanner scanner = new Scanner(System.in);
		assertEquals("test: scanner = 100",
				(Simulation.readNumber(scanner, "")), 100);
	}
	//the cases where we get other inputs are handeled the way that you get to try again, that is hard to test.	
	@Test
	public void Test_choose_1or2() {
		ByteArrayInputStream in = new ByteArrayInputStream("1".getBytes());
		ByteArrayInputStream in2 = new ByteArrayInputStream("2".getBytes());

		System.setIn(in);
		Scanner scanner = new Scanner(System.in);
		assertEquals("input = 1", (Simulation.choose_1or2(scanner)), 1);
		System.setIn(in2);
		Scanner scanner2 = new Scanner(System.in);
		assertEquals("input = 2", (Simulation.choose_1or2(scanner2)), 2);

	}

}
