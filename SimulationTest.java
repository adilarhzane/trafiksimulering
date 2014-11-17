import static org.junit.Assert.*;
import org.junit.Test;
import java.io.*;
import java.util.Scanner;
import org.junit.rules.ExpectedException;

public class SimulationTest {

	@Test
	public void Test_readNumber() {
		ByteArrayInputStream in = new ByteArrayInputStream("100".getBytes());
		System.setIn(in);
		Scanner scanner = new Scanner(System.in);
		assertEquals("test: scanner = 100",
				(Simulation.readNumber(scanner, "")), 100);
	}

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
