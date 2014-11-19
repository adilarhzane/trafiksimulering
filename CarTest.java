import static org.junit.Assert.*;

import org.junit.Test;

public class CarTest {
	Car testCar = new Car(40, 2);

	@Test
	public void TestReturnDest() {
		assertTrue(testCar.returnDest() == testCar.dest);

	}

	@Test
	public void TestReturn_BornTime() {
		assertTrue(testCar.return_bornTime() == testCar.bornTime);
	}

	@Test
	public void TestToString() {
		assertTrue(testCar.toString() == "O");
	}

}
