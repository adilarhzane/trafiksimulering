import static org.junit.Assert.*;

import org.junit.Test;

public class BikeTest {
	Bike testBike = new Bike(12, 1);

	@Test
	public void TestgetDest() {
		assertTrue(testBike.returnDest() == testBike.dest);

	}

	@Test
	public void TestgetBornTime() {
		assertTrue(testBike.return_bornTime() == testBike.bornTime);
	}

	@Test
	public void TestToString() {
		assertTrue(testBike.toString() == "B");
	}

}
