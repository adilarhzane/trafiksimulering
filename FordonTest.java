import static org.junit.Assert.*;
import java.util.*;

import org.junit.Test;

public class FordonTest {
	Car car = new Car(1, 1);
	Bike bike = new Bike(2, 2);
	public ArrayList<Fordon> D1 = new ArrayList<Fordon>();

	// testing if an arraylist of type Fordon can contain both bikes and cars
	@Test
	public void testSubtype() {
		D1.add(car);
		D1.add(bike);
		assertEquals(D1.get(0), car);
		assertEquals(D1.get(1), bike);

	}

	@Test
	public void test_returnDest() {
		assertEquals(car.returnDest(), car.dest);
		assertEquals(bike.returnDest(), bike.dest);
	}

	@Test
	public void test_returnborntime() {
		assertEquals(car.return_bornTime(), car.bornTime);
		assertEquals(bike.return_bornTime(), bike.bornTime);
	}

}
